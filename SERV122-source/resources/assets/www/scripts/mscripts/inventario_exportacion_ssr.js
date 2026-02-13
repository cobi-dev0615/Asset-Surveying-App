//obtenemos las variables de la url y las mostramos en la página
function obtener_parametros_url(parametro) {
    var url_pagina = decodeURI(window.location.search.substring(1));
    var url_variables = url_pagina.split('&');
    for (var i = 0; i < url_variables.length; i++) {
        var nombre_parametro = url_variables[i].split('=');
        if (nombre_parametro[0] === parametro) {
            return nombre_parametro[1];
        }
    }
}


var urlPrevia = 'inventario_reporte.html';

if (obtener_parametros_url('url') === 'inventario') {
    urlPrevia = 'inventario_captura.html';
}
var nRegistros = 0;
var z = 0;
var porcentajeImportacion = 0;

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    //eliminaBannerAd();
    $(location).attr('href', urlPrevia);
}

$('input[name="tipo_conexion"]').on('change', function () {
    var tipo_conexion = $(this).val();
    console.log('tipo_conexion: ' + tipo_conexion);
    if (tipo_conexion == 2) {
        $('#txtIPServidor').val('seretail.com.mx').prop('disabled', true).focus();

    } else {
        $('#txtIPServidor').val('').prop('disabled', false).focus();
    }
});

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

//escaneamos los códigos de barra
function scan() {
    try {

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
    } catch (err) {
        MuestraAlerta3(err.message, 'error');
    }
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
        //validaConexion();
    }
});

$('#btnAceptar').on('click', function () {
    var dialog = confirm("El proceso puede tardar varios minutos.\n¿Deseas continuar?");
    if (dialog === false) {
        return;
    }
    validaConexion();
});

function validaConexion() {
    var servidor = $('#txtIPServidor').val().trim();
    var inventario = $('#txtIDInventario').val().trim();
    if (servidor.length === 0) {
        suenaError();
        MuestraAlerta3('Captura la dirección IP del servidor.', 'warning');
        $('#txtIPServidor').val('').focus();
        return;
    }
    if (inventario.length === 0) {
        suenaError();
        MuestraAlerta3('Captura el ID del inventario a consultar.', 'warning');
        $('#txtIDInventario').val('').focus();
        return;
    }

    consultaServidor(servidor + "%" + inventario);
}


//var arrRespuesta;

function consultaServidor(lectura) {
    try {
        var cadena = lectura.split('%');
        if (cadena.length !== 2) {
            MuestraAlerta3('El código es incorrecto.', 'error');
            return;
        }
        var servidor = cadena[0] || '';
        var inventario = cadena[1] || '';
        if (servidor === '' || inventario === '') {
            MuestraAlerta3('El código es incorrecto.', 'error');
            return;
        }

        $('#txtIPServidor').val(servidor); //si la lectura es con la cámara
        $('#txtIDInventario').val(inventario);

        GuardaDatosConexion(0, servidor, servidor);
        $('#btnAceptar').prop('disabled', true);
        MuestraLoader('');

        //setTimeout se usa unicamente para que aparezca el loader XD
        setTimeout(function () {

            var ruta_php = 'http://' + servidor + '/SER/InventariosAPIV3/';
            if (servidor == 'seretail.com.mx') {
                ruta_php = 'https://ssr.seretail.com.mx/InventariosAPIV3/';
            }

            var php_consulta = ruta_php + 'inventarioInsertar.php';

            ////Consultamos los datos del inventario
            var datos_tabla = northwind.queryAll('registros', { limit: 20 }); //realizamos la exportación de datos en lotes de 20 para evitar errores lo más posible
            //console.log(JSON.stringify(datos_tabla));

            var filas = datos_tabla.length;
            //sino hay registros guardados pasamos a la siguiente tarea
            if (filas === 0) {
                northwind.truncate('registros'); //para resetear los ID's de la tabla a cero
                northwind.commit();
                suenaExito();
                OcultaLoader();
                $('#btnAceptar').prop('disabled', false);
                ImportaUsuarios(servidor);

                return;
            }

            var datos = 'inventario=' + inventario +
                '&id_dispositivo=' + id_dispositivo +
                '&n_serie_dispositivo=' + serie_dispositivo +
                '&marca_dispositivo=' + fabricante_dispositivo +
                '&modelo_dispositivo=' + modelo_dispositivo +
                '&versionApp=' + version_producto +
                '&datos=' + encodeURIComponent(JSON.stringify(datos_tabla));

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
                timeout: 10000, // establecenes un timeout de 10 segundos
                success: function (respuesta) {

                    console.log('Respuesta del servidor: ' + JSON.stringify(respuesta));

                    var status = respuesta.status;
                    var mensaje = respuesta.mensaje;
                    var datos = respuesta.datos;

                    switch (status) {
                        case 'success':

                            z += datos.length;

                            datos.forEach(function (item, index) {
                                console.log(index + ":" + item);
                                //res += index + ":" + item + "\n";
                                northwind.deleteRows('registros', { ID: item });//elimina el registro de la BD
                                //z++; //consume más memoria
                            });
                            northwind.commit();

                            //volvemos a empezar el proceso por si aún hay registros pendientes por exportar
                            setTimeout(function () {

                                updateProgress(z);
                                validaConexion();
                            }, 1000);

                            break;
                        default:
                            suenaAlerta();
                            $('#resultado').addClass('text-danger');
                            $('#resultado').text(mensaje);
                            OcultaLoader();
                            $('#btnAceptar').prop('disabled', false);
                            MuestraAlerta3(mensaje, 'error');
                            MuestraAlerta1(mensaje);
                            break;
                    }



                },
                error: function (respuesta) {
                    $('#btnAceptar').prop('disabled', false);
                    suenaAlerta();
                    OcultaLoader();
                    MuestraAlerta1('Error: ' + respuesta.statusText);
                    //MuestraAlerta1(JSON.stringify(respuesta));
                    //console.log(JSON.stringify(respuesta));
                }
            });

        }, 100);

    } catch (err) {
        OcultaLoader();
        alert("Error consultaServidor: " + err.message);
    }

}

function eliminaRegistros(arrayDatos) {
    z += arrayDatos.length; //consume menos memoria que incremetar uno a uno
    arrayDatos.forEach(function (item, index) {
        //console.log(index + ":" + item);
        //res += index + ":" + item + "\n";
        northwind.deleteRows('registros', { ID: item });//elimina el registro de la BD
        //z++; //consume más memoria
    });
    northwind.commit();

    //volvemos a empezar el proceso por si aún hay registros pendientes por exportar
    setTimeout(function () {
        updateProgress(z);
        validaConexion();
    }, 1000);
}

function eliminaInventario() {
    try {
        northwind.truncate('registros');
        northwind.commit();

    } catch (err) {
        alert(err.message);
    }
}


////////
function updateProgress(n) {

    var avance = (n / nRegistros) * 100;
    if (avance > 100) {
        avance = 100;
    }
    //console.log(avance + '%');
    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);
    $('#resultado').addClass('text-info');
    $('#resultado').text('Avance ' + Math.floor(avance) + '%');
}

function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}

function calculaTotales() {
    $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
    nRegistros = northwind.rowCount('registros');

    $('#resultado').text('Encontré ' + nRegistros + ' registros para exportar.');
}

function ImportaUsuarios(servidor) {
    try {
        var mensaje = 'Importando datos de los usuarios';
        console.log(mensaje);
        MuestraLoader(mensaje);


        var servidor = $('#txtIPServidor').val().trim();

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
                MuestraAlerta1('Datos sincronizados exitosamente.');
                MuestraAlerta3('Datos sincronizados exitosamente.', 'success');
                $(location).attr('href', 'index.html');

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

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)

    AbreConexionBD();
    consultaDatosServidor();
    // $('#txtIPServidor').val(ip_servidor);
    calculaTotales();
    // $('#txtIDInventario').focus();



});