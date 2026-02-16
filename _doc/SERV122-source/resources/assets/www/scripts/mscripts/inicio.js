var urlPrevia = 'index.html';

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {
    OcultaLoader(); //en caso de que esté visible
    if ($('#modal_info').hasClass('show')) {
        $('#modal_info').modal('hide');
        return;
    }

    if ($('#modalSalir').hasClass('show')) {
        $('#modalSalir').modal('hide');
        return;
    }

    if ($('#modal_impresoras').hasClass('show')) {
        $('#modal_impresoras').modal('hide');
        return;
    }

    if ($('#modalImportacion').hasClass('show')) {
        $('#modalImportacion').modal('hide');
        return;
    }
    // if (n_usuarios() > 0) {
    //     $(location).attr('href', 'index.html');
    //     return;
    // }
    preguntaCerrarSesion();
}

function preguntaCerrarSesion() {
    swal({
        // title: '¿Desea cerrar su sesión?',
        text: '¿Desea cerrar su sesión?',
        icon: 'warning',
        closeOnClickOutside: false,
        closeOnEsc: false,
        dangerMode: true,
        buttons: {
            no: {
                text: 'No',
                value: 'No',
                visible: true,
                className: 'btn btn-light',
                closeModal: true,
            },
            si: {
                text: 'Si',
                value: 'Si',
                visible: true,
                className: 'btn btn-dark',
                closeModal: true
            }
        }
    }).then(function (value) {
        switch (value) {
            case 'No':
                break;
            case 'Si':
                navigator.app.exitApp();
                break;
        }
    });
}


//botones
$('#btn_inventario').on('click', function () {
    $(location).attr('href', 'inventario_ubicacion.html');
});

$('#btnInventarioCruzado').on('click', function () {
    $(location).attr('href', 'inventario_ubicacion_cruzado.html');
});

$('#btn_catalogo').on('click', function () {
    $(location).attr('href', 'productos_catalogo.html');
});

$('#btn_configuraciones').on('click', function () {
    $(location).attr('href', 'panel_menu.html');
});

$('#btn_resumen').on('click', function () {
    $(location).attr('href', 'inventario_reporte.html');
});

$('#btnConsulta').on('click', function () {
    $(location).attr('href', 'inventario_consulta.html');
});

$('#btnCompartir').on('click', function () {
    try {
        console.log(cordova.file.externalRootDirectory + 'Simple Stock Mobile/Reportes Exportados/ConteoPorProducto 2020-08-18.csv');
        window.plugins.socialsharing.share(null, null, cordova.file.externalRootDirectory + 'Simple Stock Mobile/Reportes Exportados/ConteoPorProducto 2020-08-18.csv');
    } catch (err) {
        alert(err.message);
    }
});

$('#btnCompartirWA').on('click', function () {
    try {
        window.plugins.socialsharing.shareViaWhatsApp('Message via WhatsApp', cordova.file.externalRootDirectory + 'Simple Stock Mobile/Reportes Exportados/ConteoPorProducto 2020-08-18.csv', null, function () { console.log('share ok'); }, function (errormsg) { alert(errormsg); });
    } catch (err) {
        alert(err.message);
    }
});

$('#btnCompartirEmail').on('click', function () {
    try {
        window.plugins.socialsharing.shareViaEmail(
            'Reporte por producto', // can contain HTML tags, but support on Android is rather limited:  http://stackoverflow.com/questions/15136480/how-to-send-html-content-with-image-through-android-default-email-client
            'Aquí va tu reporte',
            ['marcxploit@gmail.com'], // TO: must be null or an array
            null, // CC: must be null or an array
            null, // BCC: must be null or an array
            [cordova.file.externalRootDirectory + 'Simple Stock Mobile/Reportes Exportados/ConteoPorProducto 2020-08-18.csv'], // FILES: can be null, a string, or an array
            function () {
                alert('share ok');
            },
            function (errormsg) {
                alert(errormsg);
            }
        );
    } catch (err) {
        alert(err.message);
    }
});

$('#btnDatosPagos').on('click', function () {
    consultaDatosPago(false); //consultamos los datos del pago
});

$('#btnCreaBD').on('click', function () {
    //alert('Ahí va!');
    validaBDLocal();
    //creaBDPrueba();
    /// creaBDSQLite();
});



function deshabilita_controles() {
    $('#btn_inventario').prop('disabled', true);
    $('#btn_catalogo').prop('disabled', true);
    $('#btn_resumen').prop('disabled', true);
    $('#btn_configuraciones').prop('disabled', true);
}

function validaConexion() {
    if (id_activacion === 0) {
        var tipo_conexion = consultaInfoConexion();
        if (tipo_conexion === 'NoNetwork' || tipo_conexion === 'Unknown') {
            vibraAlerta(500);
            deshabilita_controles();
            MuestraAlerta1('Para continuar en el modo de demostración verifíque que su dispositivo se encuentre conectado a Internet e inicie nuevamente la aplicación.');
            return;
        }
    }
}

//pruebas
//comentar y descomentar cuando se necesite 
//consigueArrayDatos();

var arrDatos = [];
var z = 0;
var nRegistros = 0;

function consigueArrayDatos() {
    $.ajax({
        async: true,
        dataType: 'json',
        encode: true,
        url: 'json/datosInventario2290.json',
        success: function (respuesta) {
            arrDatos = respuesta;
            nRegistros = arrDatos.length;
            //alert(nRegistros + ' registros encontrados');
            $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
        }
    });
}

function importaRegistrosPrueba() {
    try {
        //var filas = arrDatos.length;
        //alert(nRegistros);
        if (nRegistros === 0) {
            var n = northwind.rowCount('registros');
            //console.log(n); // solo para confirmar que ya no hay datos en la tabla
            //console.log(JSON.stringify(datos_tabla));
            alert('Datos guardados exitosamente.');
            return;
        }

        var cantidadLote = 100;

        $.each(arrDatos, function (i, dato_tabla) {

            //setTimeout(function () {

            northwind.insert('registros', {

                'inventario': dato_tabla.inventario,
                'id_producto': dato_tabla.id_producto,
                'codigo_1': dato_tabla.codigo_1,
                'codigo_2': dato_tabla.codigo_2,
                'codigo_3': dato_tabla.codigo_3,
                'precio_venta': dato_tabla.precio_venta,
                'almacen': dato_tabla.almacen,
                'nombre_almacen': dato_tabla.nombre_almacen,
                'ubicacion': dato_tabla.ubicacion,
                'cantidad': dato_tabla.cantidad,
                'descripcion': dato_tabla.descripcion,
                'lote': dato_tabla.lote,
                'n_serie': dato_tabla.n_serie,
                'fecha_caducidad': dato_tabla.fecha_caducidad,
                'fecha_captura': dato_tabla.fecha_captura,
                'hora_captura': dato_tabla.hora_captura,
                'usuario': dato_tabla.usuario,
                'nombre_usuario': dato_tabla.nombre_usuario,
                'cantidad_teorica': dato_tabla.cantidad_teorica,
                'forzado': dato_tabla.forzado,
                'sincronizado': dato_tabla.sincronizado,
                'eliminado': dato_tabla.eliminado

            });
            //}, 1000);
            updateProgress(z);
            z++;
            return i < cantidadLote;
        });


        northwind.commit();

        arrDatos.splice(0, cantidadLote + 1); //elimina n elementos a partir del index cero
        //console.log(arrDatos.length);
        //exceljson.shift(); //elimina el primer elemento del JSON

        importaRegistrosPrueba();

    }
    catch (err) {
        console.log(err.message);
    }

}

function updateProgress(n) {
    var avance = (n / nRegistros) * 100;
    //console.log(avance + '%');
    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);
}

function calculaTotales() {
    $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);
    var n = northwind.rowCount('registros');

}

$('#btnImportacionPrueba').on('click', function () {
    var dialog = confirm("¿Estás loco?");
    if (dialog === false) {
        return;
    }
    importaRegistrosPrueba();
});


//IMPRESIÓN
$('#btn_guardar_impresora').click(guarda_datos_impresora);

$('#btn_imprimir_prueba').on('click', function () {

    MuestraLoader('');

    var ticket_cf = '\x1b\x21\x01La impresora fue configurada exitosamente.\r\n\x1b\x21\x00' + strFecha(0) + ' ' + strHora() + '\r\n\r\n\r\n\r\n';

    var ticket_zebra = '! 0 384 180 250 1\r\n'
        + 'PAGE-WIDTH 400\r\n'
        + 'CENTER\r\n'
        + 'T 0 2 25 25 Impresora configurada exitosamente\r\n'
        + 'COUNT 1\r\n'
        + 'COUNT -10\r\n'
        //BARCODE128 grosorCb x alturaCB x posy
        + 'BARCODE 128 1 0 50 0 65 01234567890\r\n'
        //+ 'COUNT -10\r\n'
        + 'T 7 0 0 120 ' + strFecha(0) + ' ' + strHora() + '\r\n'
        //+ 'FORM\r\n'
        //+ '! UTILITIES\r\n'
        //+ 'GAP-SENSE\r\n' //GAP-SENSE BLACK-MARK JOURNAL
        //+ 'SET-TOF 0\r\n'
        + 'PRINT\r\n';

    if (marca_impresora_0 === 'CF') {
        imprimeBluetooth(mac_impresora_0, ticket_cf);
    }
    else if (marca_impresora_0 === 'Zebra') {
        imprimeBluetooth(mac_impresora_0, ticket_zebra);
    }
    else {
        vibraAlerta(500);
        OcultaLoader();
        MuestraAlerta3('Impresora no compatible, verifíque los modelos compatibles en las configuraciones de la aplicación', 'error');
    }
});

$('#btn_imprimir_etiqueta').on('click', function () {

    MuestraLoader('');

    var ticket_cf = '\x1b\x21\x01La impresora fue configurada exitosamente.\r\n\x1b\x21\x00' + strFecha(0) + ' ' + strHora() + '\r\n\r\n\r\n\r\n';

    var ticket_zebra = '! 0 384 180 250 1\r\n'
        + 'PAGE-WIDTH 400\r\n'
        + 'CENTER\r\n'
        + 'T 0 2 25 25 Impresora configurada exitosamente\r\n'
        + 'COUNT 1\r\n'
        + 'COUNT -10\r\n'
        //BARCODE128 grosorCb x alturaCB x posy
        + 'BARCODE 128 1 0 50 0 65 01234567890\r\n'
        //+ 'COUNT -10\r\n'
        + 'T 7 0 0 120 ' + strFecha(0) + ' ' + strHora() + '\r\n'
        + 'FORM\r\n'
        + '! UTILITIES\r\n'
        //+ 'GAP-SENSE\r\n' //GAP-SENSE BLACK-MARK JOURNAL
        + 'SET-TOF 0\r\n'
        + 'PRINT\r\n';


    imprimeBluetooth(mac_impresora_1, ticket_zebra);

});

$('#btn_impresoras').on('click', function () {
    //$('#modal_impresoras').modal('show');
});

$("#modal_impresoras").on('shown.bs.modal', function () {
    consulta_dispositivos_bluetooth();
});

$('#combo_dispositivos_bluetooth_0').change(function () {
    guarda_datos_impresora();
});

$('#combo_dispositivos_bluetooth_1').change(function () {
    guarda_datos_impresora();
});

$('#combo_marca_impresora').change(function () {
    var marca = $('#combo_marca_impresora').val();
    if (marca === 'CF') {
        $('#lbl_mensaje_impresora_0').html('<i class="fa fa-warning"></i> Compatible con impresoras térmicas Bluetooth <strong>ESC/POS</strong> de 2 pulgadas.<br />¡Importante consultar con el proveedor de su impresora para saber si es compatible con el lenguaje ESC/POS!');
    }
    else if (marca === 'Zebra') {
        $('#lbl_mensaje_impresora_0').html('<i class="fa fa-warning"></i> Modelos compatibles: <strong>MZ220, iMZ220, RW220, QLn220</strong><br />No se garantiza la compatibilidad con otros modelos.');
    }
    guarda_datos_impresora();
});

//consultamos los dispositivos bluetooth conectados al teléfono y los mostramos en las listas
function consulta_dispositivos_bluetooth() {
    try {
        var combo_dispositivos_bluetooth_0 = $('#combo_dispositivos_bluetooth_0');
        var combo_dispositivos_bluetooth_1 = $('#combo_dispositivos_bluetooth_1');
        combo_dispositivos_bluetooth_0.empty();
        combo_dispositivos_bluetooth_1.empty();

        bluetoothSerial.list(function (devices) {

            if (devices.length === 0) {
                //vibraAlerta(500);
                //$('#modal_impresoras').modal('hide');
                MuestraAlerta1('No se encontraron impresoras emparejadas con este dispositivo, empareje al menos una impresora para continuar.');
                mostrarConfiguracionesBluetooth();

                return;
            }

            devices.forEach(function (device) {

                //alert('Bluetooth device.class: ' + device.class);
                //$('#combo_dispositivos_bluetooth_0').append(new Option(device.name, device.address, true, true));
                //$('#combo_dispositivos_bluetooth_1').append(new Option(device.name, device.address, true, true));
                if (device.class === 1664 || device.class === 7936 || device.class === 1536) { //si son solamente impresoras los agregamos a la lista
                    $('<option/>', {
                        value: device.address,
                        html: device.name
                    }).appendTo('#combo_dispositivos_bluetooth_0');

                    $('<option/>', {
                        value: device.address,
                        html: device.name
                    }).appendTo('#combo_dispositivos_bluetooth_1');
                }
            })
        }, errorListaBluetooth);

        combo_dispositivos_bluetooth_0[0].selectedIndex = -1; //-1 para no seleccionar ninguna opción
        combo_dispositivos_bluetooth_1[0].selectedIndex = -1; //-1 para no seleccionar ninguna opción
        /*
        if ($('#combo_dispositivos_bluetooth_0 option').length === 0) {
            vibraAlerta(500);
            //$('#modal_impresoras').modal('hide');
            MuestraAlerta1('No se encontraron impresoras sincronizadas con este dispositivo, empareje al menos una impresora para continuar.');
            consulta_dispositivos_bluetooth();
            return;
            //window.history.back(); //regresamos a la pantalla anterior
        }
        */
        selecciona_impresoras_predeterminadas();


    }
    catch (error) {
        alert(error.message);
    }

}

function errorListaBluetooth() {
    suenaError();
    vibraAlerta(500);
    MuestraAlerta1('No se encontraron dispositivos conectados, enciende el bluetooth e intenta nuevamente.');
}

function selecciona_impresoras_predeterminadas() {
    try {
        var lista_dispositivos_0 = $('#combo_dispositivos_bluetooth_0');
        //lista_dispositivos_0[0].selectedIndex = 3; //seleccionamos el index deseado
        lista_dispositivos_0.val(mac_impresora_0);
        $('#combo_marca_impresora').val(marca_impresora_0);
        if (marca_impresora_0 === 'Zebra') {
            $('#lbl_mensaje_impresora').html('<i class="fa fa-warning"></i> Modelos compatibles: <strong>Zebra MZ220, iMZ220 y RW220</strong><br />No se garantiza la compatibilidad con otros modelos.');
        }

        var lista_dispositivos_1 = $('#combo_dispositivos_bluetooth_1');
        lista_dispositivos_1.val(mac_impresora_1);
    }
    catch (error) {
        alert(error.message);
    }
}

function guarda_datos_impresora() {
    try {
        var marca_impresora_0 = $('#combo_marca_impresora').val();
        var mac_impresora_0 = $('#combo_dispositivos_bluetooth_0').val();
        var nombre_impresora_0 = $('#combo_dispositivos_bluetooth_0 option:selected').text();
        var mac_impresora_1 = $('#combo_dispositivos_bluetooth_1').val();
        var nombre_impresora_1 = $('#combo_dispositivos_bluetooth_1 option:selected').text();

        northwind.update('configuraciones', { ID: 1 }, function (fila) {
            fila.mac_impresora_0 = mac_impresora_0;
            fila.nombre_impresora_0 = nombre_impresora_0;
            fila.mac_impresora_1 = mac_impresora_1;
            fila.nombre_impresora_1 = nombre_impresora_1;
            fila.marca_impresora_0 = marca_impresora_0;
            return fila;
        });
        northwind.commit();
        //MuestraAlerta3('Datos guardados exitosamente', 'success');
        consultaDatosServidor();
    }
    catch (error) {
        alert(error.message);
    }
}

//licencia
$('#btn_licencia').on('click', function () {
    consulta_permisos_uso();
    if (status_licencia === 'vigente') {
        if (id_activacion === 0) {
            $(location).attr('href', 'panel_activacion.html');
            return;
        }
        else {
            $(location).attr('href', 'panel_licencia_activa.html?cliente_activacion=' + cliente_activacion + '&id_activacion=' + id_activacion + '&fecha_fin=' + fecha_fin_activacion);

        }
    }
});

$('#btnImportacionSSR').on('click', function () {
    $(location).attr('href', 'productos_importacion_ssr.html');
});

function creaGraficas() {
    var datosCantidadReal = northwind.queryAll('registros');

    datosCantidadReal = alasql('SELECT SUM(cantidad*100)/100 AS cantidad FROM ? ', [datosCantidadReal]);
    console.log(JSON.stringify(datosCantidadReal));

    var cantidadTeo = 0;
    var query = 'SELECT SUM(cantidad_teorica) AS CT FROM catalogos';
    base_datos.transaction(function (ts) {
        ts.executeSql(query, [],
            function (ignored, resultSet) {
                //var dt = resultSet.rows.length;
                //alert(JSON.stringify(dt));
                for (var i = 0; i < resultSet.rows.length; i++) {
                    cantidadTeo = resultSet.rows.item(i).CT || 0;
                    console.log(cantidadTeo);
                }
                try {
                    var chart = c3.generate({
                        bindto: '#doughnutChart',
                        size: {
                            height: 140
                        },
                        data: {
                            columns: [
                                ['Teórico', cantidadTeo],
                                ['Real', datosCantidadReal[0].cantidad]
                            ],
                            type: 'bar'
                        },
                        bar: {
                            title: 'Avance de inventario',
                            width: {
                                ratio: 0.5 // this makes bar width 50% of length between ticks
                            }
                            // or
                            //width: 100 // this makes bar width 100px
                        },
                        axis: {
                            rotated: true
                        },
                        color:
                        {
                            pattern: ["#4285F4", "#FF5252", "#29b6f6", "#FF5252"]
                        }
                    });




                } catch (err) {
                    alert('Error: ' + err.message);
                }

            });
    }, function (error) {
        OcultaLoader();
        alert(error.message);
    });




}

function ConsultaLotesYCaducidades() {
    var query = 'SELECT id, codigo2, lote, fechaCaducidad FROM lotes_caducidades';
    base_datos.transaction(function (ts) {
        ts.executeSql(query, [],
            function (ignored, resultSet) {
                //var dt = resultSet.rows.length;
                //alert(JSON.stringify(dt));
                for (var i = 0; i < resultSet.rows.length; i++) {
                    console.log(
                        resultSet.rows.item(i).id + ' ' +
                        resultSet.rows.item(i).codigo2 + ' ' +
                        resultSet.rows.item(i).lote + ' ' +
                        resultSet.rows.item(i).fechaCaducidad
                    );
                }
            });
    }, function (error) {
        OcultaLoader();
        alert(error.message);
    });
}

document.addEventListener('deviceready', function () {

    // eliminaBDLocal();
    validaBDLocal();

    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consultaDatosServidor(); //consultamos los datos de conexión del servidor
    consulta_datos_sesiones(); //consultamos los datos del último usuario logueado en la aplicación y la fecha del último acceso
    if (!version_dispositivo.includes('5.')) {
        consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación
    }
    /*
    Comparamos la fecha de la última sesión contra la fecha en que inició el periodo de la licencia, si se detecta un intento de trampa
    se cierra la aplicación
    */

    if (fechaUltimoAcceso > strFecha(0)) {
        MuestraAlerta3('Su último acceso fue en: ' + fechaUltimoAcceso, 'error');
        vibraAlerta(500);
        alert('Para poder usar la aplicación es necesario que la fecha y hora del dispositivo sean correctos.');
        navigator.app.exitApp();
    } else {
        ////si todo sale bien guardamos la fecha del último acceso
        actualizaFechaSesion(strFecha(0));
    }

    ConsultaActualizacionApp(); //consultamos si hay una actualización de la aplicación disponible

    if (!version_dispositivo.includes('5.')) {
        activacionSilenciosaLicencia(); //medidas drásticas
    }

    //la validación de la licencia ya no es funcional en android 5 por lo que he eliminado la validación de la misma solamente en estos equipos
    if (version_dispositivo.includes('5.')) {
        if (strFecha(0) < '2024-09-25' || strFecha(0) > '2026-09-25') {
            alert('Esta versión ya no es funcional, solicite la versión liberada');
            navigator.app.exitApp();
        }

    }
    // creaGraficas();


});