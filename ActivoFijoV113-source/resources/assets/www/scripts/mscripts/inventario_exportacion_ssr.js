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


var url_previa = 'inventario_reporte.html';

if (obtener_parametros_url('url') === 'inventario') {
    url_previa = 'inventario_captura.html';
}
var nRegistros = 0;
var z = 0;
var porcentajeImportacion = 0;

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    //eliminaBannerAd();
    $(location).attr('href', url_previa);
}

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

//escaneamos los códigos de barra
function scan() {
    try {

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
    } catch (err) {
        muestraAlerta3(err.message, 'error');
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
        muestraAlerta3('Captura la dirección IP del servidor.', 'warning');
        $('#txtIPServidor').val('').focus();
        return;
    }
    if (inventario.length === 0) {
        suenaError();
        muestraAlerta3('Captura el ID del inventario a consultar.', 'warning');
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
            muestraAlerta3('El código es incorrecto.', 'error');
            return;
        }
        var servidor = cadena[0] || '';
        var inventario = cadena[1] || '';
        if (servidor === '' || inventario === '') {
            muestraAlerta3('El código es incorrecto.', 'error');
            return;
        }

        $('#txtIPServidor').val(servidor); //si la lectura es con la cámara
        $('#txtIDInventario').val(inventario);

        guardaDatosConexion(0, servidor, servidor);
        $('#btnAceptar').prop('disabled', true);
        MuestraLoader('');

        //setTimeout se usa unicamente para que aparezca el loader XD
        setTimeout(function () {

            var ruta_php = 'http://' + servidor + '/myAssets/api/web/V1.0.0/';

            var php_consulta = ruta_php + 'inventarioInsertarV2.php';

            ////Consultamos los datos del inventario
            var datos_tabla = northwind.queryAll('registros', { limit: 20 }); //realizamos la exportación de datos en lotes de 20 para evitar errores lo más posible
            //console.log(JSON.stringify(datos_tabla));
            //$.getJSON('datosInventario.json', function (datos_tabla) {

            //creaDirectoriosExtras('datosInventario.json', datos_tabla);
            //alert(JSON.stringify(datos_tabla));

            var filas = datos_tabla.length;

            //sino hay registros guardados pasamos a la siguiente tarea
            if (filas === 0) {
                northwind.truncate('registros'); //para resetear los ID's de la tabla a cero
                northwind.commit();
                suenaExito();
                OcultaLoader();
                $('#btnAceptar').prop('disabled', false);
                muestraAlerta1('Datos exportados exitosamente.');
                muestraAlerta3('Datos exportados exitosamente.', 'success');
                $(location).attr('href', url_previa);
                return;
            }

            //
            // var id_dispositivo = 'ABCDEF';
            var datos = 'datos=' + JSON.stringify(datos_tabla) +
                '&inventario=' + inventario +
                '&id_dispositivo=' + id_dispositivo +
                '&n_serie_dispositivo=' + serie_dispositivo +
                '&marca_dispositivo=' + fabricante_dispositivo +
                '&modelo_dispositivo=' + modelo_dispositivo;

            //alert('datos: ' + datos);

            $.ajax({
                type: 'POST',
                url: encodeURI(php_consulta),
                data: datos,
                crossDomain: true,
                cache: false,
                //async: false,
                //dataType: 'json',  
                //encode : true, 
                success: function (respuesta) {
                    //alert(respuesta);
                    //si la respuesta con tiene la palabra status la convertimos en un Json para ver el error 
                    if (respuesta.includes('status')) {

                        respuesta = JSON.parse(respuesta);
                        var status = respuesta[0].status || '';
                        var mensaje = respuesta[0].mensaje || '';
                        var bd = respuesta[0].bd || '';
                        var tabla = respuesta[0].tabla || '';

                        suenaAlerta();
                        $('#resultado').addClass('text-danger');
                        mensaje = 'Error: ' + mensaje + '\n Tbl: ' + tabla;
                        $('#resultado').text(mensaje);
                        OcultaLoader();
                        $('#btnAceptar').prop('disabled', false);
                        muestraAlerta3(mensaje, 'error');
                        muestraAlerta1(mensaje);

                        return;
                    }
                    else {
                        //convertimos la respuesta en array en caso de que no hayan errores
                        var arrRespuesta = respuesta.split('|');
                        //alert(arrRespuesta);
                        //eliminaRegistros(arrRespuesta.split('|'));

                        z += arrRespuesta.length; //consume menos memoria que incremetar uno a uno
                        arrRespuesta.forEach(function (item, index) {
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

                },
                error: function (respuesta) {
                    $('#btnAceptar').prop('disabled', false);
                    suenaAlerta();
                    OcultaLoader();
                    muestraAlerta1('Error: ' + respuesta.statusText);
                    //muestraAlerta1(JSON.stringify(respuesta));
                    //console.log(JSON.stringify(respuesta));
                },
                timeout: 7000 // establecenes un timeout
            });

        }, 100);

    } catch (err) {
        OcultaLoader();
        alert(err.message);
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


document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    //consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación

    abre_conexion_bd();
    consultaDatosServidor();
    $('#txtIPServidor').val(ip_servidor);
    calculaTotales();
    $('#txtIDInventario').focus();

    //creaInterAd();

});