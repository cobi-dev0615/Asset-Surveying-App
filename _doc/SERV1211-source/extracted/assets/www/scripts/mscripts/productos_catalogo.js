//var modo_prueba = obtener_parametros_url('modo_prueba');
var urlPrevia = 'inicio.html';

var codigo_1_seleccionado = '';
var codigo_2_seleccionado = '';
var codigo_3_seleccionado = '';
var descripcion_seleccionado = '';
var modelo_seleccionado = '';
var marca_seleccionado = '';
var precio_seleccionado = '';
//
//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {
    if ($('#modalAlertaCatalogo').hasClass('show')) {
        $('#modalAlertaCatalogo').modal('hide');
        return;
    }
    $(location).attr('href', urlPrevia);
}

function consulta_lista_0(lectura) {

    try {
        MuestraLoader('');
        var query = 'SELECT * FROM catalogos ORDER BY id_producto ASC LIMIT 100';
        if (lectura !== '') {
            query = "SELECT * FROM catalogos WHERE codigo_1='" + lectura + "' OR codigo_2='" + lectura + "' OR codigo_3='" + lectura + "' OR descripcion LIKE '%" + lectura + "%';";
        }

        var lista = $('#lista_0');
        //lista.empty().listview('refresh');
        lista.empty();

        ////#####SQLite
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //var dt = resultSet.rows.length;
                    //alert(JSON.stringify(dt));
                    for (var i = 0; i < resultSet.rows.length; i++) {

                        var id_producto = resultSet.rows.item(i).id_producto;
                        var codigo_1 = resultSet.rows.item(i).codigo_1;
                        var codigo_2 = resultSet.rows.item(i).codigo_2;
                        var codigo_3 = resultSet.rows.item(i).codigo_3;
                        var descripcion = resultSet.rows.item(i).descripcion || '';
                        var precio_venta = resultSet.rows.item(i).precio_venta || 0;
                        var unidad_medida = resultSet.rows.item(i).unidad_medida || '';
                        precio_venta = Number(precio_venta).toFixed(3).toLocaleString();
                        var factor = resultSet.rows.item(i).factor || 0;
                        var cantidad_teorica = resultSet.rows.item(i).cantidad_teorica || 0;

                        var fila = '<li class="list-group-item card mt-1" id="' + id_producto + '"> '
                            + '<div class="card-body card-body-cascade text-center m-0">';

                        if (codigo_2 !== '' && codigo_2 !== null) {
                            fila += '<label class="m-0">'
                                + 'SKU: <span class="font-weight-bold h6">' + codigo_2 + '</span>'
                                + '</label><br />';
                        }

                        fila += '<label class="m-0">'
                            + 'CÓDIGO: <span class="font-weight-bold h6">' + codigo_1 + '</span></label><br />'
                            + '<h6 class="font-weight-bold indigo-text p-0">' + descripcion + '</h6>'
                            + '<p class="card-text m-0">';

                        // fila += '<label class="m-0">ID: ' + id_producto + '</label><br />';

                        if (codigo_3 !== '' && codigo_3 !== null) {
                            fila += '<label class="m-0">'
                                + 'CÓDIGO 3: <span class="font-weight-bold">' + codigo_3 + '</span>'
                                + '</label><br />';
                        }
                        if (unidad_medida !== '' && unidad_medida !== null) {
                            fila += '<label class="m-0">'
                                + 'UNIDAD DE MEDIDA: <span class="font-weight-bold">' + unidad_medida + '</span>'
                                + '</label><br />';
                        }

                        //mostramos el factor
                        fila += '<label class="m-0">'
                            + 'FACTOR: <span class="font-weight-bold">' + factor.toLocaleString() + '</span>'
                            + '</label><br />';


                        fila += '<label class="m-0">'
                            + 'PRECIO DE VENTA: <span class="font-weight-bold">' + precio_venta.toLocaleString() + '</span>'
                            + '</label><br />'
                            + '</p>'
                            + '<hr class="m-0"> '
                            + '<a class="btn-floating btn-md btn-secondary" onclick="consulta_info_local(' + id_producto + ');"><i class="fas fa-print"></i></a> '
                            + '<a class="btn-floating btn-md btn-primary" onclick="consultaInfo(' + id_producto + ');"><i class="fas fa-edit"></i></a> '
                            + '<a class="btn-floating btn-md btn-danger" onclick="eliminar_producto(' + id_producto + ');"><i class="fas fa-trash-alt"></i></a> '
                            + '</div>'
                            + '</li >';

                        lista.append(fila);
                    }
                    //lista.listview('refresh');
                    OcultaLoader();
                });
        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });

        calcula_totales(lectura);
        ////ocultamos el loader

        $('#txt_lectura').val('').focus();
    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }

}

//escaneamos los códigos de barra
function scan() {
    try {
        var mensaje_prompt = "Capture el código del producto.";
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                //escaneamos el código de barras
                var lectura = result.text;
                $('#txt_lectura').val(lectura);
                if (lectura === '') {
                    $('#txt_lectura').val('').focus();
                    return;
                }
                //consultamos los datos de la lectura tomada
                consulta_lista_0(lectura);
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
        alert(err.message);
    }
}

$('#btn_camara').on('click', function () {
    scan();
});

function calcula_totales(lectura) {

    base_datos.transaction(function (ts) {
        var n = $('#lista_0 li').length.toLocaleString();
        var mensaje = lectura + '<br />' + n + ' coincidencias';
        if (n === 1) {
            mensaje = lectura + '<br />1 coincidencia';
        }
        //var query = 'CREATE TABLE IF NOT EXISTS catalogos (inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado);';
        //ts.executeSql(query);
        ts.executeSql('SELECT COUNT(id_producto) AS n_registros FROM catalogos', [],
            function (ignored, resultSet) {
                var n_productos = resultSet.rows.item(0).n_registros;
                if (lectura === '') {
                    mensaje = 'Mostrando primeros ' + n + ' productos de ' + n_productos.toLocaleString();
                }
                $('#lbl_total').html(mensaje);
            });
    }, function (error) {
        $('#lbl_total').html('0 coincidencias');
        alert(error.message);
    });

}

function eliminar_producto(id_seleccionado) {
    var dialog = confirm('¿Desea eliminar el registro seleccionado? Esta acción no se podrá deshacer.');
    if (dialog === false) {
        return;
    }
    try {
        base_datos.transaction(function (ts) {
            var query = "DELETE FROM catalogos WHERE id_producto='" + id_seleccionado + "';";
            console.log('query: ' + query);
            ts.executeSql(query, [], function (ignored, resultSet) {
                console.log('Registro seleccionado: ' + id_seleccionado);
                console.log('Registros eliminados: ' + resultSet.rowsAffected);
            });
        }, function (error) {
            alert(error.message);
        }, function () {
            // suenaExito();
            MuestraAlerta3('Registro eliminado exitosamente.', 'success');
            //consulta_lista_0('');
            $('#' + id_seleccionado).remove();
            //var n = $('#lista_0 li').length;
            $('#lbl_total').html('');

        });
    }
    catch (err) {
        alert(err.message);
    }
}

function consultaInfo(id_seleccionado) {
    try {
        console.log('id_seleccionado: ' + id_seleccionado);
        $(location).attr('href', 'productos_nuevo.html?id=' + id_seleccionado);
    }
    catch (err) {
        MuestraAlerta1(err.message);
    }
}

var codigo1Etiqueta = '';
var codigo2Etiqueta = '';
var codigo3Etiqueta = '';
var descripcionEtiqueta = '';
var modeloEtiqueta = '';
var marcaEtiqueta = '';
var precioVentaEtiqueta = 0;


function consulta_info_local(id) {
    try {
        MuestraLoader('');
        var query = "SELECT * FROM catalogos WHERE id_producto='" + id + "'";
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {

                    var dt = resultSet.rows.length;
                    if (dt === 0) {
                        OcultaLoader();
                        MuestraAlerta1('Registro no encontrado');
                        $('#txt_lectura').val('').focus();
                        return;
                    }
                    codigo1Etiqueta = resultSet.rows.item(0).codigo_1;
                    codigo2Etiqueta = resultSet.rows.item(0).codigo_2;
                    codigo3Etiqueta = resultSet.rows.item(0).codigo_3;
                    descripcionEtiqueta = normalizaStr(resultSet.rows.item(0).descripcion);
                    modeloEtiqueta = resultSet.rows.item(0).modelo;
                    marcaEtiqueta = resultSet.rows.item(0).marca;
                    precioVentaEtiqueta = Number(resultSet.rows.item(0).precio_venta).toLocaleString() || 0;
                    OcultaLoader();
                    $('#modalEtiquetas').modal('show');


                });

        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });
    }
    catch (err) {
        OcultaLoader();
        MuestraAlerta1(err.message);
    }
}

$("#modalEtiquetas").on('shown.bs.modal', function () {
    //$('#txtCantidadEtiquetas').focus();
});

$('#btnImprimeEtiqueta').on('click', function () {
    var cantidad = Number($('#txtCantidadEtiquetas').val());
    if (cantidad < 1 || cantidad > 50 || cantidad === '') {
        suenaError();
        MuestraAlerta3('La cantidad debe ser mayor a cero y menor a 50', 'warning');
        $('#txtCantidadEtiquetas').focus();
        return;
    }
    imprime(codigo1Etiqueta, descripcionEtiqueta, modeloEtiqueta, marcaEtiqueta, precioVentaEtiqueta, cantidad);
    $('#modalEtiquetas').modal('hide');
});

$("#modalEtiquetas").on('hidden.bs.modal', function () {
    codigo1Etiqueta = '';
    codigo2Etiqueta = '';
    codigo3Etiqueta = '';
    descripcionEtiqueta = '';
    modeloEtiqueta = '';
    marcaEtiqueta = '';
    precioVentaEtiqueta = 0;
    $('#txt_lectura').val('').focus();
});

function limpia_campos() {
    codigo_1_seleccionado = '';
    codigo_2_seleccionado = '';
    codigo_3_seleccionado = '';
    descripcion_seleccionado = '';
    modelo_seleccionado = '';
    marca_seleccionado = '';
    precio_seleccionado = '';
}


function imprime(codigo_1, descripcion, modelo, marca, precio_venta, cantidad) {

    MuestraLoader('Conectando a ' + nombre_impresora_1 + '\n' + mac_impresora_1);
    //var codigo_1 = $('#lbl_codigo_1').text();
    var desc_1 = descripcion;
    var desc_2 = '';
    if (desc_1.length > 30) {
        desc_1 = desc_1.substring(0, 29);
        desc_2 = descripcion.substring(29, descripcion.length);
    }
    var grosor_cb = 1;
    if (codigo_1.length > 15) {
        grosor_cb = 0;
    }
    //alert(datos_reporte);
    var etiqueta = '! 0 384 180 250 ' + cantidad + '\r\n'
        + 'PAGE-WIDTH 400\r\n'
        + 'CENTER\r\n'
        + 'TEXT 7 0 0 30 ' + codigo_1 + '\r\n'
        + 'COUNT 1\r\n'
        + 'COUNT -10\r\n'
        + 'BARCODE 128 ' + grosor_cb + ' 0 50 0 60 ' + codigo_1 + '\r\n' //BARCODE128 grosorCb x alturaCB x posy
        + 'COUNT -10\r\n'
        + 'TEXT 7 0 0 115 ' + desc_1 + '\r\n'
        + 'TEXT 7 0 0 135 ' + desc_2 + '\r\n'
        + 'TEXT 5 0 0 160 PRECIO: ' + precio_venta + '\r\n'
        + 'FORM\r\n'
        + '! UTILITIES\r\n'
        //+ 'GAP-SENSE\r\n' //GAP-SENSE BLACK-MARK JOURNAL
        + 'SET-TOF 0\r\n'
        + 'PRINT\r\n';

    etiqueta = normalizaStr(etiqueta);

    //if (marca_impresora_0 === 'CF' && nombre_impresora_0 === 'CF-PR20') {
    //    imprimeBluetooth(mac_impresora_0, ticket_cf);
    //}
    //else if (marca_impresora_0 === 'Zebra') {
    imprimeBluetooth(mac_impresora_1, etiqueta);
    //imprimeZebraBluetooth(mac_impresora_0, ticket_zebra);
    //}
    //else {
    //    vibraAlerta(1000);
    //    OcultaLoader();
    //    MuestraAlerta3('Impresora no compatible, verifíque los modelos compatibles en las configuraciones de la aplicación', 'error');
    //}

    //window.cordova.plugins.zbtprinter.print(mac_impresora_1, etiqueta,
    //    function (success) {
    //        OcultaLoader();
    //        
    //        

    //    }, function (fail) {
    //        OcultaLoader();
    //        vibraAlerta(1000);
    //        MuestraAlerta1("Error: " + fail + '\n' + mac_impresora_1);
    //        deferred.reject(fail);
    //    }
    //);


}

//botones
$('#txt_lectura').on('keyup', function (e) {
    if (e.keyCode === 13) {
        var lectura = $('#txt_lectura').val().trim();
        consulta_lista_0(lectura);
    }
});

$('#btn_buscar').on('click', function () {
    var lectura = $('#txt_lectura').val().trim();
    consulta_lista_0(lectura);
});


$('#btn_agregar_producto').on('click', function () {
    $(location).attr('href', 'productos_nuevo.html?id=');
});

function consultaNProductos() {
    MuestraLoader('');

    var query = "SELECT COUNT(*) AS total FROM catalogos";
    base_datos.transaction(function (ts) {
        ts.executeSql(query, [],
            function (ignored, resultSet) {
                OcultaLoader();
                var nRegistros = resultSet.rows.length;
                var total = resultSet.rows.item(0).total;
                console.log(total);
                if (total > 0) {
                    $('#txt_lectura').focus();
                }
                else {
                    $('#modalAlertaCatalogo').modal('show');
                }
            });

    }, function (error) {
        OcultaLoader();
        alert(error.message);
    });
}

$('#btnOpciones').mouseover(function () {
    setTimeout(function () {
        $('#btnImportacionSSR').tooltip('show');
        $('#btnImportar').tooltip('show');
        $('#btn_agregar_producto').tooltip('show');
    }, 500);
    // }
});

$('#btnOpciones').mouseout(function () {
    // $('#btnImportacionSSR').tooltip('hide');
    // $('#btnImportar').tooltip('hide');
    // $('#btn_agregar_producto').tooltip('hide');
});

var statusClickMenu = false;
$('#btnOpciones').on('click', function () {
    statusClickMenu = !statusClickMenu;
    if (statusClickMenu) {
        setTimeout(function () {
            $('#btnImportacionSSR').tooltip('show');
            $('#btnImportar').tooltip('show');
            $('#btn_agregar_producto').tooltip('show');
        }, 500);
    } else {
        $('#btnImportacionSSR').tooltip('hide');
        $('#btnImportar').tooltip('hide');
        $('#btn_agregar_producto').tooltip('hide');
    }
});

$('#btnModalImportar').on('click', function () {
    $(location).attr('href', 'productos_importacion.html');
});

$('#btnImportar').on('click', function () {
    $(location).attr('href', 'productos_importacion.html');
});

$('#btnImportacionSSR').on('click', function () {
    $(location).attr('href', 'productos_importacion_ssr.html');
});

//$('#modalAlertaCatalogo').modal('show');

//---
document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    //$('#fila_codigo').hide();
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
   
    consulta_lista_impresoras();
    consultaDatosServidor();

    AbreConexionBD();
    consulta_lista_0('');
    //$('#fila_codigo').show();

    //consultaNProductos();


});