var url_previa = 'productos_catalogo.html';
var exceljson = [];
var nRegistros = 0;
var z = 0;
var porcentajeImportacion = 0;

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    //eliminaBannerAd();
    if ($('#modalInventario').hasClass('show')) {
        $('#modalInventario').modal('hide');
        return;
    }
    $(location).attr('href', url_previa);
}

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

//escaneamos los códigos de barra
function scan() {
    var mensaje_prompt = "captura el código.";
    cordova.plugins.barcodeScanner.scan(
        function (result) {
            //escaneamos el código de barras
            var lectura = result.text;
            if (lectura === '') {
                muestraAlerta3('Debe capturar el código QR para continuar.', 'warning');
                $('#txtIPServidor').val('').focus();
                return;
            }
            //consultamos los datos de la lectura tomada
            consultaServidor(lectura);
        },
        function (error) {
            alert("Error de lectura: " + error);
        },
        {
            preferFrontCamera: false, // iOS and Android
            showFlipCameraButton: false, // iOS and Android - permite seleccionar la camara frontal o trasera
            showTorchButton: true, // iOS and Android - muestra el botón de lampara
            torchOn: false, // Android - lanza el flash de la camara automaticamente
            prompt: mensaje_prompt, // Android
            resultDisplayDuration: 1500, // Android, display scanned text for X ms. 0 suppresses it entirely, default 1500
            //formats: "CODE_128,EAN_13,QR_CODE", // default: all but PDF_417 and RSS_EXPANDED
            //orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
            disableAnimations: false, // iOS
            disableSuccessBeep: false // iOS
        });
}

$('#btn_camara').on('click', function () {
    scan();
});

$('#txtIPServidor').on('keyup', function (e) {
    if (e.keyCode === 13) {
        $('#txtIDInventario').val('').focus();
    }
});

$('#txtIDInventario').on('keyup', function (e) {
    if (e.keyCode === 13) {
        validaConexion();
    }
});

$('#btnAceptar').on('click', function () {
    validaConexion();
});

function validaConexion() {
    var servidor = $('#txtIPServidor').val().trim();
    var inventario = $('#txtIDInventario').val().trim();
    if (servidor.length === 0) {
        //vibraAlerta(500);
        suenaError();
        muestraAlerta3('Captura la dirección IP del servidor.', 'warning');
        $('#txtIPServidor').val('').focus();
        return;
    }
    if (inventario.length === 0) {
        //vibraAlerta(500);
        suenaError();
        muestraAlerta3('Captura el ID del inventario a consultar.', 'warning');
        $('#txtIDInventario').val('').focus();
        return;
    }
    guardaDatosConexion(0, servidor, servidor); //guardamos los datos de conexión 
    // consultaServidor(servidor + "%" + inventario);
    NProductosServidor(servidor, inventario);
}

var CantidadRegistros = 0;
var NConsultas = 1; //indica el número de consultas que haremos hasta terminar la importación de todos los registros
var IConsulta = 0; //indica el número de consulta que se está ejecutando actualmente
var CantidadPorConsulta = 5000; //indica el número de registros que solicitaremos en cada consulta
var InicioConsulta = 0; //indica desde que número de registro en la bd iniciamos la consulta

function NProductosServidor(servidor, inventario) {

    //guardaDatosConexion(0, servidor, servidor); //guardamos los datos de conexión 
    var ruta_php = 'http://' + servidor + '/myAssets/api/web/V1.0.0/';
    MuestraLoader('');

    //consultamos el número de productos del catálogo
    var php_consulta = ruta_php + 'ProductosCantidad.php';

    console.log('Servidor: ' + php_consulta);
    var datos = 'id_inventario=' + inventario;
    //muestraAlerta3('Consultando información del inventario, este proceso puede tardar varios minutos, espere por favor...', 'warning_long');

    $.ajax({
        type: 'POST',
        url: encodeURI(php_consulta),
        data: datos,
        crossDomain: true,
        cache: false,
        async: false,
        dataType: 'json',
        encode: true,
        success: function (respuesta) {

            if (JSON.stringify(respuesta).includes('status')) {

                //respuesta = JSON.parse(respuesta);
                var status = respuesta[0].status || '';
                var mensaje = respuesta[0].mensaje || '';
                var bd = respuesta[0].bd || '';
                var tabla = respuesta[0].tabla || '';

                suenaAlerta();
                $('#resultado').addClass('text-danger');
                mensaje = 'Error: ' + mensaje + '\n Tbl: ' + tabla;
                $('#resultado').text(mensaje);
                OcultaLoader();
                muestraAlerta3(mensaje, 'error');
                muestraAlerta1(mensaje);
                return;
            }
            else {
                //convertimos la respuesta en array en caso de que no hayan errores
                CantidadRegistros = Number(respuesta[0].cantidad);
                
                OcultaLoader();

                if (CantidadRegistros <= 0) {
                    //muestraAlerta3('Encontré ' + n_registros + ' productos en el catálogo.', 'success');
                    suenaError();
                    muestraAlerta3('No hay productos en el catálogo seleccionado para importar', 'error');
                    return;
                }

                console.log('Total de registros a importar: ' + CantidadRegistros);

                CantidadPorConsulta = 5000; //indica el número de registros que solicitaremos en cada consulta
                InicioConsulta = 0; //indica desde que número de registro en la bd iniciamos la consulta
                //var FinConsulta = CantidadPorConsulta; //indica desde que número de registro en la bd finalizamos la consulta
                NConsultas = 1; //indica el número de consultas que haremos hasta terminar la importación de todos los registros
                IConsulta = 0;
        
                if (CantidadRegistros > CantidadPorConsulta) {
                    //si la cantidad por lote es menos al total de registros encontrados en la bd definiremos el número de consultas que se realizarán, vamos a redondear la cantidad al siguiente número entero en caso de que el resultado sea decimal
                    NConsultas = Math.ceil(CantidadRegistros / CantidadPorConsulta);
                }
                console.log('Haremos ' + NConsultas + ' consultas para importar los datos');
                $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
        

                $('#lbl_total').html('Encontré <strong>' + CantidadRegistros.toLocaleString() + '</strong> productos en el catálogo.');
                $('#modalInventario').modal('show');
            }

        },
        error: function (respuesta) {
            //vibraAlerta(500);
            suenaAlerta();
            OcultaLoader();
            var mensaje = 'No pude acceder al servidor deseado, verifíca que los datos de conexión sean correctos y que este dispositivo esté en la misma red que el servidor. Si el problema persiste comunícate con nuestro equipo de soporte técnico.';
            muestraAlerta1(JSON.stringify(respuesta));
        }
        //, timeout: 5000 // establecenes un timeout de 5 segundos
    });

}

window.ConsultaRegistros = function() {
    try {

        if(IConsulta === NConsultas){
            //console.log('Importación finalizada');
            datosGuardados();
            OcultaLoader();
            return;
        }

        var servidor = $('#txtIPServidor').val().trim();
        var inventario = $('#txtIDInventario').val().trim();

        var ruta_php = 'http://' + servidor + '/myAssets/api/web/V1.0.0/';
        MuestraLoader('');

        var php_consulta = ruta_php + 'ProductosCatalogoImportacion.php';
        //alert('Servidor: ' + ruta_php);
               
        //setTimeout se usa unicamente para que aparezca el loader XD
        setTimeout(function () {
            //for (var i = 0; i < NConsultas; i++) {

                var datos = 'IDInventario=' + inventario
                    + '&InicioConsulta=' + InicioConsulta
                    + '&CantidadPorConsulta=' + CantidadPorConsulta;

                $.ajax({
                    type: 'POST',
                    url: encodeURI(php_consulta),
                    data: datos,
                    crossDomain: true,
                    cache: false,
                    async: true,
                    dataType: 'json',
                    //ajaxI: i,
                    success: function (respuesta) {

                        console.log('Respuesta del servidor: ' + JSON.stringify(respuesta));
                        //i = this.ajaxI;
                        
                        InsertaJSONBD(respuesta); //insertamos los registros en la BD

                        
                        //$('#modalInventario').modal('show');
                        //muestraAlerta3('Datos encontrados.', 'success');

                    },
                    error: function (respuesta) {
                        //vibraAlerta(500);
                        suenaAlerta();
                        OcultaLoader();
                        var mensaje = 'No pude acceder al servidor deseado, verifíca que los datos de conexión sean correctos y que este dispositivo esté en la misma red que el servidor. Si el problema persiste comunícate con nuestro equipo de soporte técnico.';
                        muestraAlerta1(JSON.stringify(respuesta));
                    }
                    //, timeout: 5000 // establecenes un timeout de 5 segundos
                });
      //      }
        }, 100);
      
    }
    catch (err) {
        alert(err.message);
    }
}

function InsertaJSONBD(JSONDatos) {

    try {

        $('#txt_archivo').prop('disabled', true);
        $('#btn_importar').prop('disabled', true);

        var barra_progreso = $('#barra_progreso');
        //barra_progreso.attr('aria-valuenow', 0);
        //barra_progreso.attr('aria-valuemax', filas);
        var id_producto = 0;
        var codigo_1 = '';
        var codigo_2 = '';
        var codigo_3 = '';
        var descripcion = '';
        var precio_venta = 0;
        var cantidad_teorica = 0;
        var cantidad_real = 0;

        var cantidadLote = 5000;

        var filas = JSONDatos.length || 0;


        //MuestraLoader('El proceso puede tardar varios minutos, espere por favor...');

        //muestraAlerta3('Faltan ' + filas + ' registros...', 'warning');

        base_datos.transaction(function (ts) {

            $.each(JSONDatos, function (i, dato_tabla) {

                id_producto = dato_tabla.id_producto || z;
                codigo_1 = dato_tabla.codigo_1 || '';
                codigo_1 = codigo_1.toString().trim();
                codigo_2 = dato_tabla.codigo_2 || '';
                codigo_2 = codigo_2.toString().trim();

                codigo_3 = dato_tabla.codigo_3 || '';
                codigo_3 = codigo_3.toString().trim();

                descripcion = dato_tabla.descripcion || 'Producto sin descripción';
                descripcion = descripcion.toString().trim().replace(/'/g, '');

                precio_venta = dato_tabla.precio_venta || dato_tabla.precio || 0;

                cantidad_teorica = dato_tabla.cantidad_teorica || 0;

                ts.executeSql('INSERT INTO catalogos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                    [id_inventario, z, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, '', '', '', '', '', '', '', cantidad_teorica, 0, 0, 0, cantidad_real]);

                ActualizaBarraProgreso(z);
                z++;

                //return i < cantidadLote;

            });
        }, function (error) {
            OcultaLoader();

            $('#txt_archivo').prop('disabled', false);
            $('#btn_importar').prop('disabled', false);
            tabla.clear().draw();
            $('#txt_archivo').val('');
           
            //vibraAlerta(500);
            suenaAlerta();
            alert(error.message);


        }, function () { //si las transacciones fueron exitosas
            console.log('InicioConsulta: ' + InicioConsulta);
            console.log('IConsulta:' + IConsulta);

            InicioConsulta += CantidadPorConsulta;
            IConsulta++;
            
            //ActualizaBarraProgreso(IConsulta);
            //i++;
            

            ConsultaRegistros();

            //OcultaLoader();

        });

        //});
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

$('#btn_importar').on('click', function () {

   

    var dialog = confirm("El catálogo anterior será eliminado y se importará el nuevo.\n¿Desea continuar?");
    if (dialog === false) {
        OcultaLoader();
        return;
    }
    //eliminamos los datos de la tabla
    elimina_productos();
    ConsultaRegistros();

});

function elimina_productos() {
    try {
        base_datos.transaction(function (ts) {
            ts.executeSql('DELETE FROM catalogos;');
        }, function (error) {
            alert(error.message);
        });
    } catch (err) {
        alert(err.message);
    }
}

function datosGuardados() {

 
    $('#txt_archivo').prop('disabled', false);
    $('#btn_importar').prop('disabled', false);
    // 
    muestraAlerta3('El catálogo fue importado exitosamente, se importaron ' + CantidadRegistros + ' registros.', 'success');

    muestraAlerta1('El catálogo fue importado exitosamente, se importaron ' + CantidadRegistros + ' registros.');

    $('#modalInventario').modal('hide');
    OcultaLoader();
    $(location).attr('href', 'productos_catalogo.html');

}






function ActualizaBarraProgreso(n) {

    var avance = (n / CantidadRegistros) * 100;

    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);

    ////if (percentage > 100) { percentage = 100; }
    //$('#barra_progreso').css('width', percentage + '%');
    //$('#barra_progreso').html(percentage + '%');
}


$('#lbl_tutorial').on('click', function () {
    abreUrlLocal('tutorial/index.html#catalogo');
});







function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    ////consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación
    abre_conexion_bd();
    consultaDatosServidor();
    $('#txtIPServidor').val(ip_servidor);
    $('#txtIDInventario').focus();

});