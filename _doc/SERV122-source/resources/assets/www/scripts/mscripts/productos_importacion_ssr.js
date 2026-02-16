var urlPrevia = 'productos_catalogo.html';
var exceljson = [];
var nRegistros = 0;
var z = 0;
var porcentajeImportacion = 0;
var CantidadRegistros = 0;
var NumeroConsultas = 1; //indica el número de consultas que haremos hasta terminar la importación de todos los registros
var NumeroConsultasLotes = 1; //indica el número de consultas que haremos hasta terminar la importación de todos los registros de los lotes y caducidades
var ConsultaActual = 0; //indica el número de consulta que se está ejecutando actualmente
var CantidadPorConsulta = 5000; //indica el número de registros que solicitaremos en cada consulta
var InicioConsulta = 0; //indica desde que número de registro en la bd iniciamos la consulta
var totalLotes = 0;

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


$('input[name="tipo_conexion"]').on('change', function () {
    var tipo_conexion = $(this).val();
    console.log('tipo_conexion: ' + tipo_conexion);
    if (tipo_conexion == 2) {
        $('#txtIPServidor').val('seretail.com.mx').prop('disabled', true).focus();

    } else {
        $('#txtIPServidor').val('').prop('disabled', false).focus();

    }
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
    GuardaDatosConexion(0, servidor, servidor); //guardamos los datos de conexión 
    // consultaServidor(servidor + "%" + inventario);
    NProductosServidor(servidor, inventario);
}

function NProductosServidor(servidor, inventario) {
    try {

        var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
        if (servidor == 'seretail.com.mx') {
            ruta_php = 'https://ssr.seretail.com.mx/InventariosAPIV3/';
        }

        MuestraLoader('');

        //consultamos el número de productos del catálogo
        var php_consulta = ruta_php + 'ProductosCantidad.php';
        var datos = 'id_inventario=' + inventario;

        console.log('php_consulta: ' + php_consulta);
        console.log('datos: ' + datos);
        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            async: false,
            dataType: 'json',
            encode: true,
            timeout: 10000,
            success: function (respuesta) {

                console.log('Respuesta del servidor: ' + JSON.stringify(respuesta));

                var status = respuesta.status;
                var mensaje = respuesta.mensaje;
                var datos = respuesta.datos;

                switch (status) {
                    case 'success':
                        var nLotes = 0;
                        //convertimos la respuesta en array en caso de que no hayan errores
                        CantidadRegistros = Number(datos.cantidadProductos);
                        totalLotes = Number(datos.totalLotes);
                        OcultaLoader();

                        if (CantidadRegistros === 0) {
                            //MuestraAlerta3('Encontré ' + n_registros + ' productos en el catálogo.', 'success');
                            suenaError();
                            MuestraAlerta3('No hay productos en el catálogo seleccionado para importar', 'error');
                            return;
                        }

                        console.log('Total de registros a importar: ' + CantidadRegistros);


                        InicioConsulta = 0; //indica desde que número de registro en la bd iniciamos la consulta
                        //var FinConsulta = CantidadPorConsulta; //indica desde que número de registro en la bd finalizamos la consulta
                        NumeroConsultas = 1; //indica el número de consultas que haremos hasta terminar la importación de todos los registros
                        ConsultaActual = 0;

                        if (CantidadRegistros > CantidadPorConsulta) {
                            //si la cantidad por lote es menos al total de registros encontrados en la bd definiremos el número de consultas que se realizarán, vamos a redondear la cantidad al siguiente número entero en caso de que el resultado sea decimal
                            NumeroConsultas = Math.ceil(CantidadRegistros / CantidadPorConsulta);
                        }
                        if (totalLotes > CantidadPorConsulta) {
                            NumeroConsultasLotes = Math.ceil(totalLotes / CantidadPorConsulta);
                        }
                        console.log('Haremos ' + NumeroConsultas + ' consultas para importar los datos');
                        $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);

                        $('#lbl_total').html('Encontré <strong>' + CantidadRegistros.toLocaleString() + '</strong> productos en el catálogo.');
                        $('#modalInventario').modal('show');

                        break;
                    default:
                        suenaAlerta();
                        $('#resultado').addClass('text-danger');
                        $('#resultado').text(mensaje);
                        OcultaLoader();
                        MuestraAlerta3(mensaje, 'error');
                        MuestraAlerta1(mensaje);
                        break;

                }
            },
            error: function (respuesta) {
                //vibraAlerta(500);
                suenaAlerta();
                OcultaLoader();
                var mensaje = 'No pude acceder al servidor deseado, verifíca que los datos de conexión sean correctos y que este dispositivo esté en la misma red que el servidor. Si el problema persiste comunícate con nuestro equipo de soporte técnico.';
                MuestraAlerta1(JSON.stringify(respuesta));
            }
        });
    } catch (err) {
        OcultaLoader();
        alert('Error NProductosServidor: ' + err.message);
    }

}

window.ConsultaRegistros = function () {
    try {
        console.log('ConsultaActual: ' + ConsultaActual + ' NumeroConsultas: ' + NumeroConsultas);
        if (ConsultaActual === NumeroConsultas) {
            console.warn('Iniciando la consulta de lotes...');
            ConsultaActual = 0;
            InicioConsulta = 0;
            z = 0;
            $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
            OcultaLoader();
            ConsultaLotesCaducidades();
            return;
        }
        MuestraLoader('');

        var servidor = $('#txtIPServidor').val().trim();
        var inventario = $('#txtIDInventario').val().trim();
        var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
        if (servidor == 'seretail.com.mx') {
            ruta_php = 'https://ssr.seretail.com.mx/InventariosAPIV3/';
        }
        var php_consulta = ruta_php + 'ProductosCatalogoImportacion.php';

        //setTimeout se usa unicamente para que aparezca el loader XD
        setTimeout(function () {

            var datos = 'IDInventario=' + inventario
                + '&InicioConsulta=' + InicioConsulta
                + '&CantidadPorConsulta=' + CantidadPorConsulta;

            console.log('php_consulta: ' + php_consulta);
            console.log('datos: ' + datos);

            $.ajax({
                type: 'POST',
                url: encodeURI(php_consulta),
                data: datos,
                crossDomain: true,
                cache: false,
                async: true,
                dataType: 'json',
                success: function (respuesta) {

                    console.log('Respuesta del servidor: ' + JSON.stringify(respuesta));

                    InsertaJSONBD(respuesta); //insertamos los registros en la BD

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
            //      }
        }, 100);

    }
    catch (err) {
        alert(err.message);
    }
}

function InsertaJSONBD(JSONDatos) {
    try {
        base_datos.transaction(function (ts) {
            $.each(JSONDatos, function (i, dato_tabla) {
                var inventario = dato_tabla.inventario || 0;
                var id_producto = dato_tabla.id_producto;
                var codigo_1 = (dato_tabla.codigo_1 || '').toString().trim();
                var codigo_2 = (dato_tabla.codigo_2 || '').toString().trim();
                var codigo_3 = (dato_tabla.codigo_3 || '').toString().trim();
                var descripcion = (dato_tabla.descripcion || 'Producto sin descripción').toString().trim().replace(/'/g, '');
                var precio_venta = dato_tabla.precio_venta || dato_tabla.precio || 0;
                var cantidad_teorica = dato_tabla.cantidad_teorica || 0;
                var factor = dato_tabla.factor || 1;

                var insertQuery = 'INSERT INTO catalogos (inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad_teorica, factor) VALUES (?,?,?,?,?,?,?,?,?);';
                ts.executeSql(insertQuery, [inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad_teorica, factor]);

                ActualizaBarraProgreso(z);
                z++;
            });
        }, function (error) {
            OcultaLoader();
            suenaAlerta();
            alert(error.message);
        }, function () {
            console.log('InicioConsulta: ' + InicioConsulta + ' ConsultaActual: ' + ConsultaActual);
            InicioConsulta += CantidadPorConsulta;
            ConsultaActual++;
            ConsultaRegistros();
        });
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


window.ConsultaLotesCaducidades = function () {
    try {
        MuestraLoader('');
        console.log('ConsultaActual: ' + ConsultaActual + ' NumeroConsultasLotes: ' + NumeroConsultasLotes);
        if (ConsultaActual === NumeroConsultasLotes) {
            // datosGuardados();
            ImportaUsuarios();
            OcultaLoader();
            return;
        }
        MuestraLoader('');

        var servidor = $('#txtIPServidor').val().trim();
        var inventario = $('#txtIDInventario').val().trim();
        var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
        if (servidor == 'seretail.com.mx') {
            ruta_php = 'https://ssr.seretail.com.mx/InventariosAPIV3/';
        }
        var php_consulta = ruta_php + 'LotesCatalogoImportacion.php';

        //setTimeout se usa unicamente para que aparezca el loader XD
        setTimeout(function () {

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
                success: function (respuesta) {

                    console.log('Respuesta del servidor: ' + JSON.stringify(respuesta));

                    InsertaJSONBDLotes(respuesta); //insertamos los registros en la BD

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
            //      }
        }, 100);

    }
    catch (err) {
        alert(err.message);
    }
}


function InsertaJSONBDLotes(JSONDatos) {
    try {
        base_datos.transaction(function (ts) {
            $.each(JSONDatos, function (i, dato_tabla) {
                var inventario = dato_tabla.inventario || 0;
                var cantidad = dato_tabla.cantidad || 0;
                var codigo1 = (dato_tabla.codigo1 || '').toString().trim();
                var codigo2 = (dato_tabla.codigo2 || '').toString().trim();
                var lote = dato_tabla.lote || '';
                var fechaCaducidad = dato_tabla.fechaCaducidad || '';

                var insertQuery = 'INSERT INTO lotes_caducidades (inventario, cantidad, codigo1, codigo2, lote, fechaCaducidad) VALUES (?,?,?,?,?,?);';
                ts.executeSql(insertQuery, [inventario, cantidad, codigo1, codigo2, lote, fechaCaducidad]);
                ActualizaBarraProgreso(z);
                z++;
            });
        }, function (error) {
            OcultaLoader();
            suenaAlerta();
            alert(error.message);
        }, function () {
            console.log('InicioConsulta: ' + InicioConsulta + ' ConsultaActual: ' + ConsultaActual);
            InicioConsulta += CantidadPorConsulta;
            ConsultaActual++;
            ConsultaLotesCaducidades();
        });
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
    EliminaProductos();
    ConsultaRegistros();
});



function EliminaProductos() {
    try {
        base_datos.transaction(function (ts) {
            ts.executeSql('DELETE FROM catalogos;');
        }, function (error) {
            alert(error.message);
        });

        base_datos.transaction(function (ts) {
            ts.executeSql('DELETE FROM lotes_caducidades;');
        }, function (error) {
            alert(error.message);
        });
    } catch (err) {
        alert(err.message);
    }
}


//sincronizamos los usuarios desde el servidor
function ImportaUsuarios(servidor) {
    try {
        var mensaje = 'Importando datos de los usuarios';
        console.log(mensaje);
        MuestraLoader(mensaje);


        var servidor = $('#txtIPServidor').val().trim();
        var inventario = $('#txtIDInventario').val().trim();
        var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
        if (servidor == 'seretail.com.mx') {
            ruta_php = 'https://ssr.seretail.com.mx/InventariosAPIV3/';
        }
        var php_consulta = ruta_php + 'UsuariosCatalogo.php';

        var datos = '';


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
                // OcultaLoader();
                console.log("Tabla usuarios servidor: " + JSON.stringify(respuesta));

                var status = respuesta.status;
                var mensaje = respuesta.mensaje;
                var datosRespuesta = respuesta.datos;
                //eliminamos los datos de la tabla
                northwind.truncate('usuarios');
                northwind.commit();
                datosRespuesta.forEach(function (element, index) {
                    northwind.insert('usuarios', {
                        'id_usuario': element.id_usuario,
                        'nombre_usuario': element.nombres,
                        'usuario': element.usuario,
                        'password': element.password,
                        'rol': element.rol,
                        'expiracion_sesion': element.expiracion_sesion,
                        'acceso_app': element.acceso_app,
                        'eliminado': 0
                    });
                });
                northwind.commit();
                OcultaLoader();
                datosGuardados();
            },
            error: function (respuesta) {
                vibraAlerta(500);
                //habilita_controles();
                OcultaLoader();
                var mensaje = 'El servidor no se encuentra accesible en estos momentos, verifíque que la configuración de la red sea correcta y si el problema persiste comuníquese con el administrador.';
                MuestraAlerta1(JSON.stringify(respuesta));
                //return false;
            }
        });
    }
    catch (err) {
        //habilita_controles();
        OcultaLoader();
        MuestraAlerta1(err.message);
        //return false;
    }
}


function datosGuardados() {

    // 
    MuestraAlerta3('Datos sincronizados exitosamente.', 'success');

    MuestraAlerta1('Datos sincronizados exitosamente.');

    $('#modalInventario').modal('hide');
    OcultaLoader();
    $(location).attr('href', 'index.html');


}

function ActualizaBarraProgreso(n) {
    var avance = (n / CantidadRegistros) * 100;
    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);
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

    AbreConexionBD();
    consultaDatosServidor();
    // $('#txtIPServidor').val(ip_servidor);
    // $('#txtIDInventario').focus();

});