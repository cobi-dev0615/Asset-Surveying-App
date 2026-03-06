var urlPrevia = 'inicio.html';
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
    $(location).attr('href', urlPrevia);
}

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

//escaneamos los códigos de barra
function scan() {
    var mensaje_prompt = "Capture el código.";
    cordova.plugins.barcodeScanner.scan(
        function (result) {
            //escaneamos el código de barras
            var lectura = result.text;
            if (lectura === '') {
                MuestraAlerta3('Debe capturar el código QR para continuar.', 'warning');
                $('#txtIPServidor').val('');
                $('#txtIPServidor').focus();
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
    var servidor = $('#txtIPServidor').val().trim();
    if (servidor.length === 0) {
        //vibraAlerta(500);
        suenaError();
        MuestraAlerta3('Captura la dirección IP del servidor.', 'warning');
        $('#txtIPServidor').val('').focus();
        return;
    }
    northwind.update('configuraciones', { ID: 1 }, function (fila) {
        fila.nombre_servidor = servidor;
        fila.ip_servidor = servidor;
        return fila;
    });
    northwind.commit();

    MuestraAlerta3('Datos guardados', 'success');
    $(location).attr('href', urlPrevia);

});

function validaConexion() {
    var servidor = $('#txtIPServidor').val().trim();
    var inventario = '';
    if (servidor.length === 0) {
        //vibraAlerta(500);
        suenaError();
        MuestraAlerta3('Captura la dirección IP del servidor.', 'warning');
        $('#txtIPServidor').val('').focus();
        return;
    }
    if (inventario.length === 0) {
        //vibraAlerta(500);
        suenaError();
        MuestraAlerta3('Captura el ID del inventario a consultar.', 'warning');
        $('#txtIDInventario').val('').focus();
        return;
    }
    consultaServidor(servidor + "%" + inventario);
}

function consultaServidor(lectura) {
    try {
        var cadena = lectura.split('%');
        if (cadena.length !== 2) {
            //vibraAlerta(500);
            suenaError();
            MuestraAlerta3('El código es incorrecto.', 'error');
            return;
        }
        var servidor = cadena[0] || '';
        var inventario = cadena[1] || '';
        if (servidor === '' || inventario === '') {
            //vibraAlerta(500);
            suenaError();
            MuestraAlerta3('El código es incorrecto.', 'error');
            return;
        }
        $('#txtIPServidor').val(servidor);
        //$('#txtIDInventario').val(inventario);

        GuardaDatosConexion(0, servidor, servidor);


        var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
        MuestraLoader('');
        var php_consulta = ruta_php + 'productosCatalogo.php';
        console.log('Servidor: ' + php_consulta);
        var datos = 'id_inventario=' + inventario;
        //alert(php_consulta);
        //alert(datos);
        //MuestraAlerta3('Conectando con el servidor...', 'warning');
        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            success: function (respuesta) {
                //alert(respuesta);
                //console.log('Respuesta del servidor: ' + respuesta);
                $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
                //exceljson = JSON.parse(respuesta);
                exceljson = respuesta;
                nRegistros = exceljson.length;
                calcula_totales(nRegistros);

                if (nRegistros === 0) {
                    OcultaLoader();
                    MuestraAlerta3('El inventario consultado no tiene datos para importar.', 'error');
                    MuestraAlerta1('El inventario consultado no tiene datos para importar.');
                    return;
                }

                OcultaLoader();
                $('#modalInventario').modal('show');
                //MuestraAlerta3('Datos encontrados.', 'success');

            },
            error: function (respuesta) {
                //vibraAlerta(500);
                suenaAlerta();
                OcultaLoader();
                var mensaje = 'No pude acceder al servidor deseado, verifíca que los datos de conexión sean correctos y que este dispositivo esté en la misma red que el servidor. Si el problema persiste comunícate con nuestro equipo de soporte técnico.';
                MuestraAlerta1(JSON.stringify(respuesta));
            }
            //, timeout: 5000 // establecenes un timeout de 5 segundos
        });

        MuestraAlerta3('Consultando información del inventario, este proceso puede tardar varios minutos, espere por favor...', 'warning_long');
    }
    catch (err) {
        alert(err.message);
    }
}

function remueveDuplicadosArray() {
    var obj = {};
    for (var i = 0, len = exceljson.length; i < len; i++) {
        if (!obj[exceljson[i]['codigo_1']]) obj[exceljson[i]['codigo_1']] = exceljson[i];
    }
    var newArr = [];
    for (var key in obj) newArr.push(obj[key]);
    return newArr;
}


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

$('#btn_importar').on('click', function () {
    //validamos si ya fue cargado el archivo de excel en la tabla
    if (nRegistros === 0) {
        //OcultaLoader();
        //vibraAlerta(500);
        MuestraAlerta3('No hay datos para importar.');
        return;
    }

    var dialog = confirm("El catálogo anterior será eliminado y se importará el nuevo.\n¿Desea continuar?");
    if (dialog === false) {
        //OcultaLoader();
        return;
    }
    //eliminamos los datos de la tabla
    elimina_productos();
    insertaJSONDespuesDeDelay();

});


function datosGuardados() {

    calcula_totales(0);
    $('#txt_archivo').prop('disabled', false);
    $('#btn_importar').prop('disabled', false);
    // 
    MuestraAlerta3('El catálogo fue importado exitosamente, se importaron ' + nRegistros + ' registros.', 'success');

    MuestraAlerta1('El catálogo fue importado exitosamente, se importaron ' + nRegistros + ' registros.');
    $('#modalInventario').modal('hide');
    OcultaLoader();
    $(location).attr('href', 'productos_catalogo.html');

}



function insertaJSONDespuesDeDelay() {

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

        var filas = exceljson.length || 0;

        if (filas === 0) {
            //OcultaLoader();
            datosGuardados();
            return;
        }

        MuestraLoader('El proceso puede tardar varios minutos, espere por favor...');

        MuestraAlerta3('Faltan ' + filas + ' registros...', 'warning');

        base_datos.transaction(function (ts) {

            $.each(exceljson, function (i, dato_tabla) {

                id_producto = dato_tabla.codigo_1 || z;
                codigo_1 = dato_tabla.codigo_1 || 'error';
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

                updateProgress(z);
                z++;

                return i < cantidadLote;

            });
        }, function (error) {
            OcultaLoader();

            $('#txt_archivo').prop('disabled', false);
            $('#btn_importar').prop('disabled', false);
            tabla.clear().draw();
            $('#txt_archivo').val('');
            calcula_totales(0);

            //vibraAlerta(500);
            suenaAlerta();
            alert(error.message);


        }, function () {

            //exceljson.slice(0, 5000); devuelve un JSON con N elementos de otro JSON 
            exceljson.splice(0, cantidadLote + 1); //elimina n elementos a partir del index cero
            //exceljson.shift(); //elimina el primer elemento del JSON
            insertaJSONDespuesDeDelay();
            OcultaLoader();

        });

        //});
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


function updateProgress(n) {

    var avance = (n / nRegistros) * 100;

    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);

    ////if (percentage > 100) { percentage = 100; }
    //$('#barra_progreso').css('width', percentage + '%');
    //$('#barra_progreso').html(percentage + '%');
}


$('#lbl_tutorial').on('click', function () {
    abreUrlLocal('tutorial/index.html#catalogo');
});


function calcula_totales(n_registros) {
    if (n_registros > 0) {
        MuestraAlerta3('Encontré ' + n_registros + ' productos en el catálogo.', 'success');
    }
    $('#lbl_total').html('Encontré <strong>' + n_registros + '</strong> productos en el catálogo.');
}




function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
   
    AbreConexionBD();
    consultaDatosServidor();
    $('#txtIPServidor').focus().val(ip_servidor);

});