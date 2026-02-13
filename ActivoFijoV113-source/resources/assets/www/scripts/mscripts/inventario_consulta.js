//var modo_prueba = obtener_parametros_url('modo_prueba');
var url_previa = 'inicio.html';

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
    $(location).attr('href', url_previa);
}
    
function consulta_lista_0(lectura) {

    try {
        MuestraLoader('');
        var datos_tabla = northwind.queryAll('registros');
        var x = datos_tabla.length;
        //alert(JSON.stringify(datos_tabla));
        if (x === 0) {
            calcula_totales(lectura);
            OcultaLoader();
            //muestraAlerta3('No hay registros capturados.', 'warning');
            $('#txt_lectura').val('').focus();
            return;
        }

        MuestraLoader('');
        datos_tabla = alasql("SELECT SUM(cantidad*100)/100 AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, SUM(cantidad)*precio_venta AS importe, nombre_almacen, ubicacion FROM ? WHERE (codigo_1='" + lectura + "' OR codigo_2='" + lectura + "' OR codigo_3='" + lectura + "' OR descripcion LIKE '%" + lectura + "%') GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, importe, nombre_almacen, ubicacion", [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));
        x = datos_tabla.length;
        if (x === 0) {
            calcula_totales(lectura);
            OcultaLoader();
            //muestraAlerta3('No hay registros capturados.', 'warning');
            $('#txt_lectura').val('').focus();
            return;
        }

        var lista = $('#lista_0');
        //lista.empty().listview('refresh');
        lista.empty();
        
        $.each(datos_tabla, function (index, dato_tabla) {

            var id = dato_tabla.ID || 0; //esto está mal
            var cantidad = dato_tabla.cantidad || 0;
            var codigo_1 = dato_tabla.codigo_1;
            var codigo_2 = dato_tabla.codigo_2;
            var codigo_3 = dato_tabla.codigo_3;
            var descripcion = dato_tabla.descripcion || '';
            var precio_venta = dato_tabla.precio_venta || 0;
            //precio_venta = Number(precio_venta).toLocaleString();
            var importe = dato_tabla.importe || 0;
            var nombre_almacen = dato_tabla.nombre_almacen || '';
            var ubicacion = dato_tabla.ubicacion || '';

            var fila = '<li class="list-group-item card mt-1 waves-effect" id="' + id + '"> '
                + '<div class="card-body card-body-cascade text-center m-0">'

                + '<h5 class="card-title m-0"><strong>' + codigo_1 + '</strong></h5>'
                + '<h6 class="font-weight-bold indigo-text p-0">' + descripcion + '</h6>'
                + '<p class="card-text m-0">';

            if (codigo_2 !== '' && codigo_2 !== null) {
                fila += '<label class="m-0">'
                    + 'CÓDIGO 2: <span class="font-weight-bold">' + codigo_2 + '</span>'
                    + '</label><br />';
            }

            if (codigo_3 !== '' && codigo_3 !== null) {
                fila += '<label class="m-0">'
                    + 'CÓDIGO 3: <span class="font-weight-bold">' + codigo_3 + '</span>'
                    + '</label><br />';
            }

            fila += '<hr class="m-0">';
            
            fila += '<label class="m-0 text-danger">'
                + 'CANTIDAD: <span class="font-weight-bold">' + cantidad + '</span>'
                + '</label><br />';
                
            fila += '<label class="m-0 text-primary">'
                + 'UBICACIÓN: <span class="font-weight-bold">' + ubicacion + '</span>'
                + '</label><br />';

            fila += '<label class="m-0 text-primary">'
                + 'ALMACÉN: <span class="font-weight-bold">' + nombre_almacen + '</span>'
                + '</label><br />';


            fila += '<label class="m-0">'
                + 'PRECIO DE VENTA: <span class="font-weight-bold">' + precio_venta.toLocaleString() + '</span>'
                + '</label><br />';
           
            fila += '</p>'
                //+ '<hr class="m-0"> '
                //+ '<a class="btn-floating btn-md btn-danger" onclick="eliminar_producto(' + id + ');"><i class="fas fa-trash-alt"></i></a> '
                + '</div>'
                + '</li>';

            lista.append(fila);
        });

        OcultaLoader();
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
        var mensaje_prompt = "captura el código del producto.";
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                //escaneamos el código de barras
                var lectura = result.text;
                $('#txt_lectura').val(lectura);
                if (lectura === '') {
                    $('#txt_lectura').val('');
                    $('#txt_lectura').focus();
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
    var n = $('#lista_0 li').length;
    var mensaje = lectura + '<br />' + n + ' registros encontrados';
    if (n === 1) {
        mensaje = lectura + '<br />1 registro encontrado';
    }
    $('#lbl_total').html(mensaje);
}



function eliminar_producto(id_seleccionado) {

    //vibraAlerta(500);
    var dialog = confirm('¿Desea eliminar el registro seleccionado? Esta acción no se podrá deshacer.');
    if (dialog === false) {
        return;
    }
    try {
        //eliminamos el registro de la base de datos 
        //var id_producto = $('#lbl_id').text();
        northwind.deleteRows('registros', { ID: id_seleccionado });
        northwind.commit();


        suenaExito();
        muestraAlerta3('Registro eliminado exitosamente.', 'success');
        //consulta_lista_0('');
        $('#' + id_seleccionado).remove();
        //var n = $('#lista_0 li').length;
        $('#lbl_total').html('');



    }
    catch (err) {
        alert(err.message);
    }
}

function consultaInfo(id_seleccionado) {
    try {
        $(location).attr('href', 'productos_nuevo.html?id=' + id_seleccionado);
    }
    catch (err) {
        muestraAlerta1(err.message);
    }
}


function consulta_info_local(id_seleccionado) {
    try {

        MuestraLoader('');
        var query = 'SELECT * FROM catalogos WHERE id_producto=' + id_seleccionado;
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //alert(query);
                    //alert(JSON.stringify(resultSet.rows));
                    var dt = resultSet.rows.length;
                    if (dt === 0) {
                        OcultaLoader();
                        muestraAlerta1('Registro no encontrado');
                        $('#txt_lectura').val('').focus();
                        return;
                    }
                    //var id_producto = '';
                    var codigo_1 = resultSet.rows.item(0).codigo_1;
                    var codigo_2 = resultSet.rows.item(0).codigo_2;
                    var codigo_3 = resultSet.rows.item(0).codigo_3;
                    var descripcion = normalizaStr(resultSet.rows.item(0).descripcion);
                    var modelo = resultSet.rows.item(0).modelo;
                    var marca = resultSet.rows.item(0).marca;
                    var precio_venta = Number(resultSet.rows.item(0).precio_venta).toFixed(3) || 0;
                    precio_venta = precio_venta.toLocaleString();
                    OcultaLoader();
                    //$('#dialogo_0').popup('open');
                    imprime(codigo_1, descripcion, modelo, marca, precio_venta);

                });

        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });

   
    }
    catch (err) {
        OcultaLoader();
        muestraAlerta1(err.message);
    }
}


function limpia_campos() {
    codigo_1_seleccionado = '';
    codigo_2_seleccionado = '';
    codigo_3_seleccionado = '';
    descripcion_seleccionado = '';
    modelo_seleccionado = '';
    marca_seleccionado = '';
    precio_seleccionado = '';
}


function imprime(codigo_1, descripcion, modelo, marca, precio_venta) {

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
    var etiqueta = '! 0 384 180 250 1\r\n'
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

    //alert(etiqueta);

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
    //    muestraAlerta3('Impresora no compatible, verifíca los modelos compatibles en las configuraciones de la aplicación', 'error');
    //}

    //window.cordova.plugins.zbtprinter.print(mac_impresora_1, etiqueta,
    //    function (success) {
    //        OcultaLoader();
    //        
    //        //creaInterAd();

    //    }, function (fail) {
    //        OcultaLoader();
    //        vibraAlerta(1000);
    //        muestraAlerta1("Error: " + fail + '\n' + mac_impresora_1);
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

$('#btn_imprimir').click(imprime);

$('#btn_eliminar').click(eliminar_producto);

$('#btn_agregar_producto').on('click', function () {
    $(location).attr('href', 'productos_nuevo.html?id=');
});

function consultaNProductos() {
    //MuestraLoader('');
    var total = northwind.rowCount('registros');
    if (total > 0) {
        $('#txt_lectura').focus();
    }
    else {
        //$('#modalAlertaCatalogo').modal('show');
        muestraAlerta3('No hay registros capturados aún.', 'warning');
    }
}

$('#btnModalImportar').on('click', function () {
    $(location).attr('href', 'productos_importacion.html');
});

//$('#modalAlertaCatalogo').modal('show');

//---
document.addEventListener('deviceready', function () {
//$(document).ready(function () {
  
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consulta_lista_impresoras();
    consultaDatosServidor();
    consulta_lista_0('');
    consultaNProductos();
    $('#txt_lectura').val('').focus();
});