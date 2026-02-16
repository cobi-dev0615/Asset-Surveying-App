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



var ubicacionSeleccioanda = obtener_parametros_url('ubicacion');
var n_conteo = obtener_parametros_url('n_conteo');

var codigo_forzado = 0;
var index_t_series = 0;

var urlPrevia = 'inventario_ubicacion_cruzado.html';

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);
function onBackKeyDown() {
    if ($('#modalEliminaUbicacion').hasClass('show')) {
        $('#modalEliminaUbicacion').modal('hide');
        return;
    }
    if ($('#modalOpcionesLectura').hasClass('show')) {
        $('#modalOpcionesLectura').modal('hide');
        return;
    }
    if ($('#modalOpciones').hasClass('show')) {
        $('#modalOpciones').modal('hide');
        return;
    }
   
    
}

$('#btnModalSalir').on('click', function () {
    $(location).attr('href', urlPrevia);
});

$("#modalSalir").on('hidden.bs.modal', function () {
    //$('#txt_lectura').val('').focus();
    posiciona_focus();
});

function salir() {

    var n_filas = tabla.rows().count();
    if (n_filas > 0) {
        suenaError();
        //var dialog = confirm("¿Desea salir del conteo de inventario?");
        //if (modo_online === 0) {

        //    if (dialog === false) {
        //        $('#txt_lectura').val('').focus();
        //        return;
        //    }
        //}
        //else {
        //    //dialog = confirm("¿Desea salir del conteo de inventario?");
        //    if (dialog === false) {
        //        $('#txt_lectura').val('').focus();
        //        return;
        //    }
        //}
        $('#modalSalir').modal('show');

    }
    else {
        $(location).attr('href', urlPrevia);
    }
   

}

function limpia_campos() {
    try {
        //$('#txt_ubicacion').val('');
        index_t_series = 0;
        datos_producto = '';
        lectura = '';
        $('#tabla_n_series tbody tr').remove();
        $('#lbl_total_n_series').text('0');
        $('#txt_lote').val('');
        $('#txt_fecha_caducidad').val('');
        $('#txt_lectura').val('');
        $('#txt_cantidad').val('');
        if ($('#txt_cantidad').is('[readonly]')) {
            $('#txt_cantidad').val('1');
        }
        $('#inventory_id').val('');
        $('#id_producto').val('');
        $('#seccionDescripcion').hide();
        $('#lbl_descripcion').text('');
        $('#txt_sn').val('');
        //$('#txt_ubicacion').focus();
        posiciona_focus();
    }
    catch (err) { alert(err.message); }
}

//escaneamos los códigos de barra
function scan(valor) {
    try {
        var mensaje_prompt = "Capture el código del producto.";
        if (valor === 0) {
            mensaje_prompt = "Capture la ubicación del producto.";
        }
        else if (valor === 2) {
            mensaje_prompt = "Capture el número de lote.";
        }
        else if (valor === 3) {
            mensaje_prompt = "Capture el número de serie.";
        }
        else if (valor === 4) {
            mensaje_prompt = "Capture el número de serie.";
        }
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                if (valor === 0) {
                    //escaneamos la ubicación
                    $('#txt_ubicacion').val(result.text);
                    consulta_inventario_local();
                }
                if (valor === 1) {
                    //escaneamos y consultamos el código del producto
                    $('#txt_lectura').val(result.text);
                    consulta_producto_local(result.text);
                }
                else if (valor === 2) {
                    //escanemos el número de lote del producto
                    $('#txt_lote').val(result.text);
                    if (!$('#txt_fecha_caducidad').is('[readonly]')) {
                        $('#txt_fecha_caducidad').focus();
                        return;
                    }
                    if (!$('#txt_cantidad').is('[readonly]')) {
                        $('#txt_cantidad').val('').focus();
                        return;
                    }

                    inserta_fila_local(1);
                }
                else if (valor === 3) {
                    //escanemos el número de serie del producto
                    $('#txt_sn').val(result.text);
                    inserta_n_serie();
                }
                else if (valor === 4) {
                    //escanemos el número de serie del producto
                    $('#txtUbicacionEliminar').val(result.text);
                    consultaUbicacionEliminar();
                }
            },
            function (error) {
                MuestraAlerta3("Error de lectura: " + error, 'error');
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
            }
        );
    }
    catch (err) {
        alert(err.message);
    }
}

//function valida_ubicacion() {
//    consulta_inventario_local();
    
//}


$('#txt_ubicacion').on('keydown', function (e) {
    
    if (e.keyCode === 13) {
        e.preventDefault();
        consulta_inventario_local();
    }
});

$('#txt_ubicacion').focusout(function () {
    //consulta_inventario_local();
});

$('#btn_buscar_0').on('click', function () {
    consulta_inventario_local();
});

$('#txt_lectura').on('keydown', function (e) {
    if (e.keyCode === 13) {
        var lectura = $('#txt_lectura').val().trim();
        //if (lectura !== '') {
            consulta_producto_local(lectura);
        //}
        
        
    }
});

$('#btn_buscar_1').on('click', function () {
    var lectura = $('#txt_lectura').val().trim();
    //if (lectura !== '') {
        consulta_producto_local(lectura);
    //}
});

$('#txt_lectura').focusout(function () {

    //var lectura = $('#txt_lectura').val().trim();
    //if(lectura != ''){
    //    consulta_producto_local(lectura);
    //}

});

function inserta_n_serie() {
    var lectura_serie = String($('#txt_sn').val().trim());
    if (lectura_serie === '') {
        $('#txt_sn').val('');
        $('#txt_sn').focus();
        return;
    }
    //index_t_series++;
    var fila = "<tr>"
        + "<td style='font-size:11px;'>" + lectura_serie + "</td>"
        + "<td style='font-size:11px;'><input type='button' name='' value='&#10006;' onclick='elimina_registro_serie(this)'></td>"
        + "</tr>";
    $('#tabla_n_series tbody').prepend(fila);
    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    $('#lbl_total_n_series').text(n_filas_series);
    $('#txt_sn').val('');
    $('#txt_sn').focus();
}

$('#txt_sn').on('keydown', function (e) {
    if (e.keyCode === 13) {
        inserta_n_serie();
    }
});

function elimina_registro_serie(r) {

    var dialog = confirm('¿Desea eliminar el número de serie seleccionado?');
    if (dialog === false) {
        $('#txt_sn').val('');
        $('#txt_sn').focus();
        return;
    }
    MuestraLoader('');
    //$('#' + lectura_serie + '').remove();
    //document.getElementById("tabla_n_series").deleteRow(index_t_series);

    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("tabla_n_series").deleteRow(i);

    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    $('#lbl_total_n_series').text(n_filas_series);
    OcultaLoader();
    $('#txt_sn').val('');
    $('#txt_sn').focus();


}

//

var datos_producto;
var id_seleccionado = 0;
var codigo_2_seleccionado = '';
var codigo_3_seleccionado = '';
var lectura = '';
var precio_venta = 0;
var cantidad_teorica = 0;

function consulta_producto_local(lectura) {
    try {

        if (lectura.length === 0) {
            suenaAlerta();
            vibraAlerta(500);
            MuestraAlerta3('Capture el código del producto para continuar', 'warning');
            limpia_campos();
            $('#txt_lectura').val('').focus();
            return;
        }
        //MuestraLoader('Consultado, espere por favor.');
        //deshabilitamos el campo de lectura temporalmente para evitar lecturas duplicadas durante la consulta de los datos
        $('#txt_lectura').prop('disabled', true);

        MuestraLoader('');
        var query = "SELECT * FROM catalogos WHERE codigo_1='" + lectura + "' OR codigo_2='" + lectura + "' OR codigo_3='" + lectura + "'";
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {

                    //habilitamos nuevamente el campo de lectura 
                    habilita_campo_lectura();
                    OcultaLoader();

                    var dt = resultSet.rows.length;
                    if (dt === 0) {
                        id_seleccionado = 0;
                        precio_venta = 0;
                        cantidad_teorica = 0;
                        codigo_2_seleccionado = '';
                        codigo_3_seleccionado = '';
                        MuestraAlerta3('El código ' + lectura + ' no fue encontrado en el catálogo.', 'error');
                        suenaAlerta();
                        vibraAlerta(1000);
                        
                        $('#lbl_descripcion').text('Producto no encontrado');
                        $('#seccionDescripcion').show();
                        //$('#txt_lectura').val('');
                        $('#txt_lote').val('');
                        $('#txt_fecha_caducidad').val('');
                        if (!$('#txt_cantidad').is('[readonly]')) {
                            $('#txt_cantidad').val('');
                        }

                        //si la opción de permitir códigos forzados está activa
                        if ($('#chk_forzados').is(':checked')) {
                            $('#modal_forzado').modal('show');
                            //$('#txt_lectura_forzado').val('').focus();
                            return;
                        }

                        codigo_forzado = 0;
                        limpia_campos();
                        posiciona_focus();

                        return;
                    }
                    id_seleccionado = resultSet.rows.item(0).id_producto;
                    var codigo_1 = resultSet.rows.item(0).codigo_1;
                    codigo_2_seleccionado = resultSet.rows.item(0).codigo_2 || '';
                    codigo_3_seleccionado = resultSet.rows.item(0).codigo_3 || '';
                    var descripcion = resultSet.rows.item(0).descripcion;
                    //var modelo = resultSet.rows.item(0).modelo;
                    //var marca = resultSet.rows.item(0).marca;
                    precio_venta = Number(resultSet.rows.item(0).precio_venta) || 0;
                    cantidad_teorica = Number(resultSet.rows.item(0).cantidad_teorica) || 0;

                    codigo_forzado = 0;

                    $('#txt_lectura').val(codigo_1);
                    $('#lbl_descripcion').text(descripcion);
                    $('#seccionDescripcion').show();
                    //MuestraAlerta3(descripcion, 'success_s');

                    if (!$('#txt_lote').is('[readonly]')) {
                        $('#txt_lote').val('').focus();
                        return;
                    }
                    if ($('#chk_caducidad').is(':checked')) {
                        $('#txt_fecha_caducidad').val('').focus();
                        return;
                    }
                    if ($('#chk_n_series').is(':checked')) {
                        $('#modal_n_series').modal('show');
                        $('#txt_sn').val('').focus();
                        return;
                    }

                    if (!$('#txt_cantidad').is('[readonly]')) {
                        $('#txt_cantidad').val('').focus();
                        return;
                    }

                    inserta_fila_local(1);

                });

        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });


    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function inserta_fila_local(cantidad) {
    try {
        cantidad = Number(cantidad) || 0;
        var cantidad_minima = 0;

        if (!$('#chk_cant_cero').is(':checked')) {

            if (cantidad === 0) {
                vibraAlerta(500);
                suenaAlerta();
                MuestraAlerta3('Capture la cantidad para continuar', 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }
        }

        if (!$('#chk_cant_negativa').is(':checked')) {
            if (cantidad < 0) {
                vibraAlerta(500);
                suenaAlerta();
                MuestraAlerta3('La cantidad deben ser mayor a cero', 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }


        }
        else {
            cantidad_minima = -999999;
            if (cantidad < -999999) {
                vibraAlerta(500);
                suenaAlerta();
                MuestraAlerta3('La cantidad no puede ser menor a ' + cantidad_minima, 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }
        }

        if (cantidad > 999999) {
            vibraAlerta(500);
            suenaAlerta();
            MuestraAlerta3('La cantidad no puede ser mayor a 999999', 'warning');
            $('#txt_cantidad').val('').focus();
            return;
        }

        if ($('#lbl_descripcion').text() === '') {
            vibraAlerta(500);
            MuestraAlerta3('Capture el código del producto para continuar', 'warning');
            limpia_campos();
            $('#txt_lectura').val('');
            $('#txt_lectura').focus();
            return;
        }


        var n_filas = tabla.rows().count();
        //var n_columnas = tabla.columns(':visible').count();

        var id_producto = id_seleccionado;
        var codigo_1 = $('#txt_lectura').val();
        var codigo_2 = codigo_2_seleccionado;
        var codigo_3 = codigo_3_seleccionado;
        var descripcion = $('#lbl_descripcion').text();
        var importe = (Number(cantidad) * Number(precio_venta)).toFixed(3);
        //var precio_venta = 0;

        var ubicacion = $('#txt_ubicacion').val();
        //var cantidad = cantidad;
        var lote = $('#txt_lote').val();
        var n_serie = '';

        var fecha_caducidad = $('#txt_fecha_caducidad').val();
        var fecha_captura = strFecha(0);
        var hora_captura = strHora();

        if (codigo_forzado === 1) {
            try {


                base_datos.transaction(function (ts) {

                    //autoincrementamos la variable para generar un ID consecutivo
                    //n_productos++;
                    var id_producto = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');

                    ts.executeSql('INSERT INTO catalogos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                        [id_inventario, Number(id_producto), codigo_1, '', '', descripcion, 0, '', '', '', '', 0, '', '', 0, 1, 0, 0, 0]);


                }, function (error) {
                    alert(error.message);
                }, function () {

                });

            }
            catch (err) {
                alert(err.message);
            }
        }

        var id = 0;
        var datosFila = [];

        if ($('#chk_n_series').is(':checked')) {
            var n_series = [];
            var tabla_n_series = document.getElementById("tabla_n_series");
            for (var n = 1; tabla_n_series.rows[n]; n++) {
                //n_series[n_series.length] = tabla_n_series.rows[i].cells[0].innerText;
                n_filas++;
                n_serie = tabla_n_series.rows[n].cells[0].innerText;

                datosFila = {

                    'inventario': id_inventario,
                    'id_producto': id_producto,
                    'codigo_1': codigo_1,
                    'codigo_2': codigo_2,
                    'codigo_3': codigo_3,
                    'precio_venta': precio_venta,
                    'almacen': id_almacen,
                    'nombre_almacen': nombre_almacen,
                    'n_conteo': n_conteo, 
                    'ubicacion': ubicacion,
                    'cantidad': cantidad,
                    'descripcion': descripcion,
                    'lote': lote,
                    'n_serie': n_serie,
                    'fecha_caducidad': fecha_caducidad,
                    'fecha_captura': fecha_captura,
                    'hora_captura': hora_captura,
                    'usuario': id_usuario_logueado,
                    'nombre_usuario': usuario_conteo,
                    'cantidad_teorica': cantidad_teorica,
                    'latitud': latitud_actual, 
                    'longitud': longitud_actual, 
                    'forzado': codigo_forzado,
                    'sincronizado': 0,
                    'eliminado': 0

                };

                id = northwind.insert('registros_cruzados', datosFila);
                northwind.commit();

                //consulta_inventario_local();
                datosFila["importe"] = importe;
                datosFila["ID"] = id;

                //alert(JSON.stringify(datosFila));
                tabla.row.add(datosFila).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
                MuestraAlerta3(descripcion + '\nSN.: ' + n_serie, 'success_s');
            }

           

        } else {
            n_filas++;
            datosFila = {

                'inventario': id_inventario,
                'id_producto': id_producto,
                'codigo_1': codigo_1,
                'codigo_2': codigo_2,
                'codigo_3': codigo_3,
                'precio_venta': precio_venta,
                'almacen': id_almacen,
                'nombre_almacen': nombre_almacen, 
                'n_conteo': n_conteo, 
                'ubicacion': ubicacion,
                'cantidad': cantidad,
                'descripcion': descripcion,
                'lote': lote,
                'n_serie': n_serie,
                'fecha_caducidad': fecha_caducidad,
                'fecha_captura': fecha_captura,
                'hora_captura': hora_captura,
                'usuario': id_usuario_logueado,
                'nombre_usuario': usuario_conteo,
                'cantidad_teorica': cantidad_teorica,
                'latitud': latitud_actual,
                'longitud': longitud_actual, 
                'forzado': codigo_forzado,
                'sincronizado': 0,
                'eliminado': 0

            };

            id = northwind.insert('registros_cruzados', datosFila);

            northwind.commit();
            
            //consulta_inventario_local();
            datosFila["importe"] = importe;
            datosFila["ID"] = id;

            //alert(JSON.stringify(datosFila));
            tabla.row.add(datosFila).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
            MuestraAlerta3(descripcion + '\nCant.: ' + cantidad, 'success');

            //tabla.row.add(
            //    [
            //        cantidad,
            //        codigo_1,
            //        descripcion,
            //        codigo_2,
            //        codigo_3,
            //        lote,
            //        n_serie,
            //        fecha_caducidad,
            //        fecha_captura,
            //        hora_captura,
            //        precio_venta,
            //        importe,
            //        id
            //        // datos_producto[i].acciones
            //    ]
            //).draw();

            //Insertamos la numeración de las filas de las tablas.

            //tabla.on( 'order.dt search.dt', function () {
            //  tabla.column(10, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            //      cell.innerText = i+1;
            //  } );
            //} ).draw();
        }

        tabla.order([12, 'desc']).draw();
        //tabla.columns.adjust().draw();// adjustamos el tamaño de las columnas y redibujamos
       
        calcula_totales();

        OcultaLoader();
        limpia_campos();

        $('#txt_lectura').focus();
    } catch (err) {
        alert(err.message);
    }
}

function habilita_campo_lectura() {
    //habilitamos nuevamente el campo de lectura 
    $('#txt_lectura').prop('disabled', false);
}

$('#btnAceptarForzado').on('click', function () {
    codigo_forzado = 1;
    $('#modal_forzado').modal('hide');
});

$('#txt_lectura_forzado').on('keydown', function (e) {
    if (e.keyCode === 13) {
        //codigo_forzado = 1;
        //$('#modal_forzado').modal('hide');
    }
});

function consulta_inventario_local() {

    try {

        //var datos_tabla = northwind.queryAll('registros_cruzados');
        var almacen = nombre_almacen;
        //if (almacen.length === 0) {
        //    almacen = 'Cuarto Frío';
        //}
        var ubicacion = $('#txt_ubicacion').val().trim();
        if (ubicacion.length === 0) {
            suenaError();
            MuestraAlerta3('Capture una ubicación para continuar.', 'warning');
            $('#txt_ubicacion').val('').focus();
            return;
        }
        MuestraLoader('');

        MuestraAlerta3('Consultando ubicación...', 'success_s');

        setTimeout(function () {

            var datos_tabla = northwind.queryAll('registros_cruzados', {
                query: { ubicacion: ubicacion, nombre_almacen: almacen, n_conteo: n_conteo }
            });

            //console.log(JSON.stringify(datos_tabla));

            datos_tabla = alasql('SELECT ID, cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, ROUND(cantidad*precio_venta, 3) AS importe, lote, fecha_caducidad, n_serie, fecha_captura, hora_captura FROM ?', [datos_tabla]);

            var x = datos_tabla.length;

            //console.log(x);
            tabla.clear().draw(); //clear() limpia las filas existentes de la tabla
            if (x === 0) {
                calcula_totales();
                OcultaLoader();
                $('#txt_lectura').val('').focus();
                return;
            }

            tabla.rows.add(datos_tabla).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
            tabla.columns.adjust();

            calcula_totales();
            OcultaLoader();
            posiciona_focus();



        }, 100);

    }
    catch (err) {
        OcultaLoader();
        MuestraAlerta3(err.message, 'error');
    }


}




//cambiamos el tipo de conteo
$('input[type=checkbox][name=chk_tipo_conteo]').change(function() {
//$('#chk_tipo_conteo').change(function () {
    //if (this.value === 'si') {
    if ($('#chk_tipo_conteo').is(':checked')) {
        MuestraAlerta3('Conteo por unidad activado', 'success');
        limpia_campos();
        $('#txt_cantidad').val('1');
        $('#txt_cantidad').prop('readonly', true).css("background-color", "#CCC");
        $('#fila_cantidad').hide();
        if ($('#txt_ubicacion').val().trim() === '') {
            $('#txt_ubicacion').focus();
            return;
        }
        $('#txt_lectura').focus();
    }
    //else if (this.value === 'no') {
    else {
        MuestraAlerta3('Conteo por cantidad activado', 'success');
        limpia_campos();
        $('#txt_cantidad').val('');
        $('#txt_cantidad').prop('readonly', false).css("background-color", "#FFF");
        $('#fila_cantidad').show();
        if ($('#txt_ubicacion').val().trim() === '') {
            $('#txt_ubicacion').focus();
            return;
        }
        $('#txt_lectura').focus();
    }

});

$('#txt_fecha_caducidad').on('keydown', function (e) {
    if (e.keyCode === 13) {

        //Si la opción de productos con número de serie está activada
        if ($('#chk_n_series').is(':checked')) {
            $('#modal_n_series').modal('show');
            
            return;
        }

        //if ($('#chk_tipo_conteo').val() === 'no') {
        if (!$('#chk_tipo_conteo').is(':checked')) {
            $('#txt_cantidad').val('').focus();
            return;
        }

        inserta_fila_local(1);
    }
});


$('#btn_buscar_3').on('click', function () {
     //Si la opción de productos con número de serie está activada
     if ($('#chk_n_series').is(':checked')) {
        $('#modal_n_series').modal('show');
        
        return;
    }

    //if ($('#chk_tipo_conteo').val() === 'no') {
    if (!$('#chk_tipo_conteo').is(':checked')) {
        $('#txt_cantidad').val('').focus();
        return;
    }

    inserta_fila_local(1);
});

//
function calcula_totales() {

    var n_filas = tabla.rows().count();
    var conteo_total = tabla.column(0).data().sum();
    var valor_inventario = tabla.column(11).data().sum();

    $('#lbl_conteo_total').html('Conteo total: <strong>' + conteo_total.toLocaleString() + '</strong>');
    $('#lbl_n_filas').html('Registros: <strong>' + n_filas.toLocaleString() + '</strong>');
    $('#lbl_importe_total').html('Valor de inventario: <strong>' + valor_inventario.toLocaleString() + '</strong>');

    //si el total es mayor a cero y además es módulo de 50
    if (conteo_total > 0 && conteo_total % 50 === 0) {
        
        ////
        //
    }

}



function imprime() {
    try {
        var n_filas = tabla.rows().count();

        if (n_filas === 0) {
            suenaError();
            vibraAlerta(500);
            MuestraAlerta3('No hay inventario para imprimir', 'error');
            return;
        }

        MuestraLoader('Conectando a ' + nombre_impresora_0 + '\n' + mac_impresora_0);

        var fecha_captura = strFecha(0);
        var cantidad = '';
        var codigo_1 = '';
        var ubicacion_reporte = $('#txt_ubicacion').val();
        var descripcion = '';
        var datos_reporte = '';
        var conteo_total = $('#lbl_conteo_total').text();

        //var datos_tabla = [];
        var datos_tabla = northwind.queryAll('registros_cruzados');
        datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, descripcion, precio_venta, ROUND(SUM(cantidad)*precio_venta, 2) AS importe, nombre_almacen, ubicacion FROM ? WHERE ubicacion="' + ubicacion_reporte + '" AND nombre_almacen="' + nombre_almacen + '" GROUP BY codigo_1, codigo_2, descripcion, precio_venta, importe, nombre_almacen, ubicacion', [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));
  
        //agrupamos los datos del arreglo para sumar las cantidades 
        //var resultado = [];
        //datos_tabla.reduce(function (res, value) {
        //    if (!res[value.codigo_1]) {
        //        res[value.codigo_1] = {
        //            cantidad: 0,
        //            codigo_1: value.codigo_1,
        //            descripcion: value.descripcion
        //        };
        //        resultado.push(res[value.codigo_1])
        //    }
        //    var n = res[value.codigo_1].cantidad;
        //    var x = parseFloat(n);
        //    var m = parseFloat(value.cantidad);
        //    x += m;
        //    res[value.codigo_1].cantidad = x;
        //    return res;
        //}, {});

        //alert(JSON.stringify(resultado));
        var il = 305;
        var datos_ticket_zebra = '';
        var datos_ticket_cf = '';
        var n_registro = 0;
        var x = datos_tabla.length;

        $.each(datos_tabla, function (index, dato_tabla) {
            cantidad = dato_tabla.cantidad;
            codigo_1 = dato_tabla.codigo_1;
            descripcion = dato_tabla.descripcion;
            //datos_reporte += cantidad + '             ' + codigo_1 + '\r\n' + descripcion + '\r\n';
            if (marca_impresora_0 === 'Zebra') {               
                datos_ticket_zebra += 'T 7 0 25 ' + il.toString() + ' ' + descripcion.substring(0, 30) + '\r\n';
                il += 20;

                datos_ticket_zebra += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 5) + '    ' + codigo_1 + '\r\n';
                il += 25;
            }
            else if (marca_impresora_0 === 'CF') {
                datos_ticket_cf += '\x1B!\x01'; //Font B
                datos_ticket_cf += descripcion.substring(0, 30) + ' \r\n';

                datos_ticket_cf += '\x1B!\x08'; //Emphasis
                datos_ticket_cf += padRight(cantidad.toString(), 9) + codigo_1.substring(0, 20) + '\r\n';              
            }
        });

        datos_ticket_zebra += 'T 7 0 25 ' + il.toString() + ' __\r\n';
        il += 100;

        //setTimeout(function () {

            var ticket_zebra = '! U1 setvar "device.languages" "cpcl"\r\n'
                + '! 0 200 200 ' + il.toString() + ' 1\r\n'
                //+ 'LEFT\r\n'
                + 'T 5 0 25 25 REPORTE DE INVENTARIO\r\n'
                + 'T 7 0 25 50 FECHA: ' + fecha_captura + '\r\n'
                + 'T 7 0 25 75 USUARIO: ' + usuario_conteo.substring(0, 30) + '\r\n'
                + 'T 7 0 25 100 ALMACÉN: ' + nombre_almacen.substring(0, 30) + '\r\n'
                + 'T 7 0 25 125 UBICACIÓN: ' + ubicacion_reporte + '\r\n'
                + 'T 7 0 25 150' + $('#lbl_conteo_total').text().toUpperCase() + '\r\n'
                + 'T 7 0 25 175' + $('#lbl_importe_total').text().toUpperCase() + '\r\n'
                + 'T 5 0 25 200 ***************************\r\n'
                + 'T 5 0 25 225 DESCRIPCIÓN\r\n'
                + 'T 5 0 25 255 CANT     CÓDIGO\r\n'
                + 'T 5 0 25 280 ***************************\r\n'
                + datos_ticket_zebra
                + 'PRINT\r\n';

            ticket_zebra = normalizaStr(ticket_zebra);

            //ticket ESC/POS
            var esc = '\x1B'; //ESC byte in hex notation
            var newLine = '\x0A'; //LF byte in hex notation
            var ticket_cf = esc + '!\x10'; //Double-height + Double-width mode ESC ! 10 + 20
            ticket_cf += esc + '\x61\x01'; //Align center
            //ticket_cf += btoa(logo_empresa);
            ticket_cf += 'REPORTE DE INVENTARIO\r\n';
            ticket_cf += esc + '!\x00'; //Font A
            ticket_cf += esc + '\x61\x00';  //Align left
            //ticket_cf += esc + '!\x21!\x00'; //Font A
            ticket_cf += strFecha(0) + ' ' + strHora() + '\r\n';
            ticket_cf += usuario_conteo.substring(0, 30).toUpperCase() + '\r\n';
            ticket_cf += '\x1B!\x08'; //Emphasis
            ticket_cf += 'ALMACÉN: ' + nombre_almacen.substring(0, 30).toUpperCase() + '\r\n';
            ticket_cf += 'UBICACIÓN: ' + ubicacion_reporte + '\r\n';
            ticket_cf += $('#lbl_conteo_total').text().toUpperCase() + '\r\n';
            //ticket_cf += $('#lbl_n_filas').text() + '\r\n';
            ticket_cf += $('#lbl_importe_total').text().toUpperCase() + '\r\n';
            ticket_cf += esc + '!\x00'; //Font A
            ticket_cf += '********************************\r\n';
            ticket_cf += esc + '!\x08'; //Emphasis
            ticket_cf += 'DESCRIPCIÓN\r\n';
            ticket_cf += 'CANT         CÓDIGO\r\n';
            ticket_cf += esc + '!\x00'; //Font A
            ticket_cf += '********************************\r\n';
            ////ticket_cf += esc + '!\x01'; //Font B
            ticket_cf += datos_ticket_cf;
            //ticket_cf += esc + '!\x45!\x01\r\n' + mensajes_pie_ticket + esc + '!\x45!\x00\r\n';
            ticket_cf += esc + '!\x00'; //Font A
            ticket_cf += '\r\n';
            ticket_cf += '\r\n\r\n';
            ticket_cf += esc + '!\x08'; //Emphasis
            ticket_cf += esc + '\x61\x01'; //Align center
            ticket_cf += '\r\n';
            ticket_cf += '____________________________\r\n';
            ticket_cf += 'FIRMA DEL RESPONSABLE\r\n';
            ticket_cf += '\r\n';
            ticket_cf += '\r\n\r\n';

            ticket_cf = normalizaStr(ticket_cf);

            //
            if (marca_impresora_0 === 'CF') {
                imprimeBluetooth(mac_impresora_0, ticket_cf);
            }
            else if (marca_impresora_0 === 'Zebra') {
                imprimeBluetooth(mac_impresora_0, ticket_zebra);
            }
            else {
                vibraAlerta(500);
                OcultaLoader();
                MuestraAlerta3('Impresora no compatible, verifíque los modelos compatibles en las configuraciones de la aplicación.', 'error');
            }

        //}, 4000);


     
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }

}




$('#modal_n_series').on('hidden.bs.modal', function () {
    limpia_campos();
    posiciona_focus();
});

$('#modal_forzado').on('hidden.bs.modal', function () {
    if (codigo_forzado === 0) {
        limpia_campos();
        posiciona_focus();
    }
    else {

        //var lectura = $('#txt_lectura').val();
        var descripcion_codigo_forzado = $('#txt_lectura_forzado').val().trim();
        if (descripcion_codigo_forzado === '') {
            descripcion_codigo_forzado = 'Código forzado';
        }
        $('#lbl_descripcion').html(descripcion_codigo_forzado);
        $('#seccionDescripcion').show();

        if ($('#chk_lotes').is(':checked')) {
            $('#txt_lote').val('').focus();
            return;
        }
        if ($('#chk_caducidad').is(':checked')) {
            $('#txt_fecha_caducidad').val('').focus();
            return;
        }
        if ($('#chk_n_series').is(':checked')) {
            $('#modal_n_series').modal('show');
            $('#txt_sn').val('').focus();
            return;
        }
        //if ($('#chk_tipo_conteo').val() === 'no') {
        if (!$('#chk_tipo_conteo').is(':checked')) {
            $('#txt_cantidad').val('').focus();
            return;           
        }
        inserta_fila_local(1);
    }
});

$('#modal_forzado').on('shown.bs.modal', function () {
    $('#txt_lectura_forzado').val('').focus();
});

$('#modal_n_series').on('shown.bs.modal', function () {
    $('#txt_sn').val('').focus();
});


$('#modalOpciones').on('hidden.bs.modal', function () {
    limpia_campos();
    setTimeout(function () {
        posiciona_focus();
    }, 100);
   
});

$('#btnOpcionesCaptura').on('click', function () {
    $('#modalOpcionesLectura').modal('show');
});


//$('#btnAceptarOpcionesLectura').on('click', function () {
    //$('#modalOpcionesLectura').modal('hide');
//});

//$('#modalOpcionesLectura').on('shown.bs.modal', function () {
    
//});


$('#modalOpcionesLectura').on('hidden.bs.modal', function () {
    configuraOpcionesLectura();
});

function configuraOpcionesLectura() {
    if ($('#chk_n_series').is(':checked')) {
        $('#fila_cantidad').hide();
        $('#td_lbl_tipo_conteo').hide();
        $('#td_chk_tipo_conteo').hide();
    }
    else {
        //if (!$('#chk_tipo_conteo').is(':checked')) {
        $('#fila_cantidad').show();
        $('#td_lbl_tipo_conteo').show();
        $('#td_chk_tipo_conteo').show();
        //}
    }
    if ($('#chk_lotes').is(':checked')) {
        //$('#fila_lote').css('display', 'inherit');
        $('#fila_lote').show();
        $('#txt_lote').val('');
        $('#txt_lote').prop('readonly', false);
    }
    else {
        $('#fila_lote').hide();
        //$('#fila_lote').css('display', 'none');
        $('#txt_lote').val('');
        $('#txt_lote').prop('readonly', true);
    }
    if ($('#chk_caducidad').is(':checked')) {
        //$('#fila_caducidad').css('display', 'inherit');
        $('#fila_caducidad').show();
        $('#txt_fecha_caducidad').val('');
        $('#txt_fecha_caducidad').prop('readonly', false);
    }
    else {
        $('#fila_caducidad').hide();
        //$('#fila_lote').css('display', 'none');
        $('#txt_fecha_caducidad').val('');
        $('#txt_fecha_caducidad').prop('readonly', true);
    }
    //if ($('#chk_tipo_conteo').val() === 'si') {
    if ($('#chk_tipo_conteo').is(':checked')) {
        $('#fila_cantidad').hide();
    }
    if ($('#chkGPS').is(':checked')) {
        actualizaPosicionActual();
    }
    else {
        detenerPosicionGPS();
    }
   

    $('#modalOpciones').modal('hide');
   
}


function posiciona_focus() {
    if ($('#txt_ubicacion').val().trim().length === 0) {
        $('#txt_ubicacion').val('').focus();
        return;
    }
    $('#txt_lectura').val('').focus();
    
}

function elimina_seleccionado_local() {
    var n_filas = tabla.rows().count();
    if (n_filas === 0) {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('No hay registros para eliminar', 'error');
        $('#modalOpciones').modal('hide');
        posiciona_focus();
        return;
    }
    //suenaAlerta();
    var n_seleccionados = tabla.rows('.selected').count();
    if (n_seleccionados === 0) {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('Seleccione el registro a eliminar', 'warning');
        $('#modalOpciones').modal('hide');
        posiciona_focus();
        return;
    }
    //vibraAlerta(500);
    var dialog = confirm('¿Desea eliminar el registro seleccionado?');
    if (dialog === false) {
        $('#modalOpciones').modal('hide');
        $('#txt_lectura').val('').focus();
        return;
    }
    //eliminamos el registro de la base de datos 
    //northwind.deleteRows('registros_cruzados', { cantidad: cantidad_seleccionada, codigo_1: codigo_seleccioando, n_serie: n_serie_seleccionado, fecha_captura: fecha_seleccionada, hora_captura: hora_seleccionada });
    northwind.deleteRows('registros_cruzados', { ID: id_seleccionado });
    northwind.commit();
    suenaExito();
    $('#modalOpciones').modal('hide');
    //eliminamos el registro seleccionado de la tabla
    tabla.row('.selected').remove().draw(false);

    MuestraAlerta3('Registro eliminado exitosamente', 'success');
    tabla.columns.adjust().draw(false);
    calcula_totales();
    limpia_campos();
    posiciona_focus();

}

///botones
$("#btn_salir").on('click', function () {
    salir();
});

$("#btn_camara_0").on('click', function () {
    scan(0);
});

$("#btn_camara_1").on('click', function () {
    scan(1);
});

$("#btn_camara_2").on('click', function () {
    scan(2);
});

$("#btn_camara_3").on('click', function () {
    scan(3);
});

$("#btnCamaraUbicacionEliminar").on('click', function () {
    scan(4);
});

$("#btnCancelarForzado").on('click', function () {
    codigo_forzado = 0;
});

$("#btn_insertar").on('click', function () {
    var cantidad = $('#txt_cantidad').val();
    inserta_fila_local(cantidad);

});

$('#btn_imprimir').on('click', function () {
    var filas = $('#tablaDatos tbody').children('tr').length;

    if (filas === 0) {
        vibraAlerta(500);
        MuestraAlerta3('Capture almenos un registro para imprimir el reporte', 'warning');
        return;
    }
    $('#modalOpciones').modal('hide');
    imprime();
});

//
$('#btn_opciones').on('click', function () {
    //$('#modalOpcionesLectura').modal('show');
});

$('#btn_aceptar_n_series').on('click', function () {
    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    if (n_filas_series === 0) {
        $('#txt_sn').val('').focus();
        return;
    }
    inserta_fila_local(1);
    $('#modal_n_series').modal('hide');

});


$('#btn_cancelar_n_series').on('click', function () {
    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    if (n_filas_series > 0) {
        var dialog = confirm('¿Desea cancelar la captura de los números de serie capturados?');
        if (dialog === false) {
            $('#txt_sn').val('').focus();
            return;
        }
    }
    $('#modal_n_series').modal('hide');
});

$('#btn_eliminar').on('click', function () {
    elimina_seleccionado_local();
});


$('#txt_lote').on('keydown', function (e) {
    if (e.keyCode === 13) {

        if (!$('#txt_fecha_caducidad').is('[readonly]')) {
            $('#txt_fecha_caducidad').val('').focus();
            return;
        }

        //Si la opción de productos con número de serie está activada
        if ($('#chk_n_series').is(':checked')) {
            $('#modal_n_series').modal('show');
            $('#txt_sn').val('').focus();
            return;
        }
        if (!$('#txt_cantidad').is('[readonly]')) {
            $('#txt_cantidad').val('').focus();
            return;
        }
        var cantidad = $('#txt_cantidad').val();
        inserta_fila_local(cantidad);
    }
});

$('#btn_buscar_2').on('click', function () {

    if (!$('#txt_fecha_caducidad').is('[readonly]')) {
        $('#txt_fecha_caducidad').val('').focus();
        return;
    }

    //Si la opción de productos con número de serie está activada
    if ($('#chk_n_series').is(':checked')) {
        $('#modal_n_series').modal('show');
        $('#txt_sn').val('').focus();
        return;
    }
    if (!$('#txt_cantidad').is('[readonly]')) {
        $('#txt_cantidad').val('').focus();
        return;
    }
    var cantidad = $('#txt_cantidad').val();
    inserta_fila_local(cantidad);
});

$('#txt_cantidad').on('keydown', function (e) {
    if (e.keyCode === 13 || e.keyCode === 9) {
        e.preventDefault();
        var cantidad = $('#txt_cantidad').val();
        inserta_fila_local(cantidad);
    }
});


/**
    Eliminar ubicación
**/
$('#modalEliminaUbicacion').on('shown.bs.modal', function () {
    $('#modalOpciones').modal('hide');
    $('#lblNombreAlmacen').text(nombre_almacen);
    $('#txtUbicacionEliminar').val('').focus();
});

$('#modalEliminaUbicacion').on('hidden.bs.modal', function () {
    //$('#modalOpciones').modal('hide');
    //$('#txtUbicacionEliminar').val('');
    $('#txtUbicacionEliminar').val('');
    $('#seccionTxtUbicacionEliminar').css('display', 'block');
    $('#seccionBtnConsultaUbicacionEliminar').css('display', 'block');

    $('#seccionTotalUbicacion').css('display', 'none');

    $('#footerUbicacionEliminar').css('visibility', 'hidden');
    posiciona_focus();
});

$('#btnConsultaUbicacionEliminar').on('click', function () {
    consultaUbicacionEliminar();
});

$('#txtUbicacionEliminar').on('keydown', function (e) {
    if (e.keyCode === 13 || e.keyCode === 9) {
        //e.preventDefault();
        consultaUbicacionEliminar();
    }
});

function consultaUbicacionEliminar() {
    try {

        var almacen = nombre_almacen;
        var ubicacion = $('#txtUbicacionEliminar').val().trim();
        //if (ubicacion.length === 0) {
        //    suenaError();
        //    vibraAlerta();
        //    MuestraAlerta3('Capture la ubicación deseada para continuar.', 'warning');
        //    $('#txtUbicacionEliminar').val('').focus();
        //    return;
        //}
        MuestraLoader('');
        //MuestraAlerta3('Consultando ubicación...', 'success_s');

        var datos_tabla = northwind.queryAll('registros_cruzados', {
            query: { ubicacion: ubicacion, nombre_almacen: almacen }
        });

        //creaDirectoriosExtras('datosUbicacion.txt', JSON.stringify(datos_tabla));

        var x = datos_tabla.length;
        if (x > 0) {
            if (ubicacion.length === 0) {
                ubicacion = '""';
            }
            $('#lblTotalUbicacion').html('Encontré <strong>' + x + '</strong> registros en la ubicación <strong>' + ubicacion + '</strong> del almacén <strong>' + almacen + '</strong>, si elimina la ubicación se eliminarán los registros capturados en ella y esta acción no se podrá deshacer.<br /><h6>¿Desea continuar?</h6>');
            
            $('#seccionTxtUbicacionEliminar').css('display', 'none');
            $('#seccionBtnConsultaUbicacionEliminar').css('display', 'none');
    
            $('#seccionTotalUbicacion').css('display', 'block');
            $('#footerUbicacionEliminar').css('visibility', 'visible');

        }
        else {
            if (ubicacion.length === 0) {
                ubicacion = '""';
            }
            suenaError();
            vibraAlerta(500);
            //$('#modalEliminaUbicacion').modal('hide');
            
            MuestraAlerta3('No hay registros en la ubicación ' + ubicacion + ' del almacén ' + almacen, 'error');
            $('#txtUbicacionEliminar').val('').focus();
        }
        OcultaLoader();
    }
    catch (err) {
        OcultaLoader();
        MuestraAlerta3(err.message, 'error');
    }
}


$('#btnCancelarEliminarUbicacion').on('click', function () {
    $('#modalEliminaUbicacion').modal('hide');
});


$('#btnEliminarUbicacion').on('click', function () {
    try {
        MuestraLoader('');
        var almacen = nombre_almacen;
        var ubicacion = $('#txtUbicacionEliminar').val().trim();
        northwind.deleteRows('registros_cruzados', { ubicacion: ubicacion, nombre_almacen: almacen });
        northwind.commit();

        var ubicacionActual = $('#txt_ubicacion').val().trim();
        if (ubicacion === ubicacionActual) {
            $('#txt_ubicacion').val('');
            tabla.clear().draw();
            calcula_totales();
        }
        suenaExito();
        $('#modalEliminaUbicacion').modal('hide');
        MuestraAlerta3('La ubicación ' + ubicacion + ' del almacén ' + almacen + ' fue eliminada exitosamente', 'success');
        OcultaLoader();
    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
});

$('#btnOpcionEliminarUbicacion').on('click', function () {
    $('#modalOpciones').modal('hide');
    $('#modalEliminaUbicacion').modal('show');
});

/**
 * Opciones de lectura
 */


function cargaConfiguracionesLectura() {

    var arrDatos = consultaConfiguracionesLectura();

    var ubicacion_obligatoria = arrDatos[0].ubicacion_obligatoria;
    var validar_catalogo = arrDatos[0].validar_catalogo;
    var codigos_forzados = arrDatos[0].codigos_forzados;
    var descripcion_codigo_forzado = arrDatos[0].descripcion_codigo_forzado;
    var lotes = arrDatos[0].lotes;
    var n_series = arrDatos[0].n_series;
    var fecha_caducidad = arrDatos[0].fecha_caducidad;
    var fecha_fabricacion = arrDatos[0].fecha_fabricacion;
    var cantidad_cero = arrDatos[0].cantidad_cero;
    var cantidades_negativas = arrDatos[0].cantidades_negativas;
    var coordenadas = arrDatos[0].coordenadas;

    if (codigos_forzados === 1) {
        $('#chk_forzados').click();
        //$('#chk_forzados').attr('checked', true); //cambia el estado del Checkbox 
    }
    if (lotes === 1) {
        $('#chk_lotes').click();
    }
    if (n_series === 1) {
        $('#chk_n_series').click();
    }
    if (fecha_caducidad === 1) {
        $('#chk_caducidad').click();
    }
    if (cantidad_cero === 1) {
        $('#chk_cant_cero').click();
    }
    if (cantidades_negativas === 1) {
        $('#chk_cant_negativa').click();
    }
    if (coordenadas === 1) {
        $('#chkGPS').click();
    }

    configuraOpcionesLectura();

}



//actualizamos las opciones de lectura 
$('input[type=checkbox][name=chk_forzados]').change(function () {
    try {
        var valor = 0;
        if ($('#chk_forzados').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.codigos_forzados = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});

$('input[type=checkbox][name=chkGPS]').change(function () {
    try {
        var valor = 0;
        if ($('#chkGPS').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.coordenadas = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});

$('input[type=checkbox][name=chk_lotes]').change(function () {
    try {
        var valor = 0;
        if ($('#chk_lotes').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.lotes = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});


$('#chk_n_series').change(function () {
    try {
        var valor = 0;
        if ($('#chk_n_series').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.n_series = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});

$('#chk_caducidad').change(function () {
    try {
        var valor = 0;
        if ($('#chk_caducidad').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.fecha_caducidad = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});

$('#chk_cant_cero').change(function () {
    try {
        var valor = 0;
        if ($('#chk_cant_cero').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.cantidad_cero = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});

$('#chk_cant_negativa').change(function () {
    try {
        var valor = 0;
        if ($('#chk_cant_negativa').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.cantidades_negativas = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});


$('#chkGPS').change(function () {
    try {
        var valor = 0;
        if ($('#chkGPS').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.coordenadas = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});
/**
 * Terminan las configuraciones de lectura
 */

var n_productos = 0;

function consulta_n_productos() {
    base_datos.transaction(function (ts) {

        ts.executeSql('SELECT COUNT(id_producto) AS n_registros FROM catalogos', [],
            function (ignored, resultSet) {
                n_productos = resultSet.rows.item(0).n_registros;
            });

    }, function (error) {
        //alert(error.message);
    });
}

//
var altoPantalla = screen.height;
var anchoPantalla = screen.width;
console.log(anchoPantalla + ' * ' + altoPantalla);
var altoTabla = '730px';
if (altoPantalla <= 1024) {
    altoTabla = '690px';
}
if (altoPantalla <= 1140) {
    altoTabla = '330px';
}
if (altoPantalla <= 992) {
    altoTabla = '390px';
}
if (altoPantalla <= 864) { //laptop ASUS
    altoTabla = '370px';
}
if (altoPantalla <= 768) { 
    altoTabla = '300px';
}
if (altoPantalla <= 640) { //HTC One M8
    altoTabla = '250px';
}
if (altoPantalla <= 576) {
    altoTabla = '200px';
}
if (altoPantalla <= 534) { //Speedata
    altoTabla = '155px';
}

var tabla = $('#tablaDatos').DataTable({
    select: {
        style: 'single'
    },
    order: [[12, 'desc']],
    //"bFilter": true,
    info: false,
    //LengthChange: true,
    paging: true,
    pageLength: 30, 
    pagingType: 'numbers',
    dom: '<"top"pt>', 
    scrollY: altoTabla,
    scrollX: true,
    scrollCollapse: false,
    searching: false,
    autoWidth: true,
    responsive: false,
    fixedColumns: {
        leftColumns: 1,
        rightColumns: 0
    },
    columnDefs: [ /*{ className: "bg-white font-weight-bold text-danger", "targets": [0] }, { className: "bg-white", "targets": [1] },*/],
    //language: {
    //    'decimal': '.',
    //    'thousands': ','
    //}, 
    data: [], 
    columns: [
        { title: 'Cant.', data: 'cantidad', visible: true, searchable: true, width: '1%' },
        { title: 'Código 1', data: 'codigo_1', visible: true, searchable: true },
        { title: 'Descripción', data: 'descripcion', visible: true, searchable: true },
        { title: 'SKU', data: 'codigo_2', visible: true, searchable: true },
        { title: 'Código 3', data: 'codigo_3' },
        { title: 'Lote', data: 'lote' },
        { title: 'Número Serie', data: 'n_serie', visible: true, searchable: true },
        { title: 'Fecha Caducidad', data: 'fecha_caducidad' },
        { title: 'Fecha', data: 'fecha_captura' },
        { title: 'Hora', data: 'hora_captura' },
        {
            //className asigna la clase a toda la columna incluyendo la cabecera
            title: 'PU', data: 'precio_venta', className: '', width: '5%', render: function (data, type, row) {
                return Number(data).toLocaleString();
            }
        },
        {
            title: 'Importe', data: 'importe', className: '', width: '5%', render: function (data, type, row) {
                return Number(data).toLocaleString();
            }
        },
        { title: 'ID', data: 'ID', visible: false, searchable: false }

    ], 
    createdRow: function (row, data, index) {
        //personalizamos las columnas deseadas
        $('td', row).eq(0).addClass('text-danger text-right font-weight-bold');
        $('td', row).eq(2).addClass('small');
        $('td', row).eq(9).addClass('text-right');
        $('td', row).eq(10).addClass('text-right font-weight-bold');
        $('td', row).eq(11).addClass('text-info text-right font-weight-bold');
        

    }

});


//var tabla2 = $('#tablaDatos').DataTable({
//    select: {
//        style: 'single'
//    }, 
//    order: [[12, 'desc']],
//    //"bFilter": true,
//    info: false,
//    //LengthChange: true,
//    paging: false,
//    scrollY: altoTabla,
//    scrollX: true, 
//    scrollCollapse: false, 
//    searching: false,
//    autoWidth: true,
//    responsive: false, 
//    fixedColumns: {
//        leftColumns: 1,
//        rightColumns: 0
//    },
//    columnDefs: [ /*{ className: "bg-white font-weight-bold text-danger", "targets": [0] }, { className: "bg-white", "targets": [1] },*/ ], 

//    createdRow: function (row, data, index) {
//        //personalizamos las columnas deseadas
//        $('td', row).eq(0).addClass('text-danger text-right font-weight-bold');
//        $('td', row).eq(2).addClass('small');
//        $('td', row).eq(10).addClass('text-right');
//        $('td', row).eq(11).addClass('text-right');
//    } 
   
//});

var id_producto_seleccionado = 0;
var index_seleccionado = -1;
var cantidad_seleccionada = '';
var codigo_seleccioando = '';
var n_serie_seleccionado = '';
var fecha_seleccionada = '';
var hora_seleccionada = '';

$('#tablaDatos tbody').on('click', 'tr', function () {
    //alert( tabla.row( this ).data() ); //muestra los datos de toda la fila separados por coma
    index_seleccionado = this;
    id_seleccionado = tabla.cell(index_seleccionado, 12).data(); //conseguimos el valor de la fila y celda deseada
    //alert(id_seleccionado);

    cantidad_seleccionada = tabla.cell(index_seleccionado, 0).data();
    codigo_seleccioando = tabla.cell(index_seleccionado, 1).data();
    n_serie_seleccionado = tabla.cell(index_seleccionado, 6).data();
    fecha_seleccionada = tabla.cell(index_seleccionado, 8).data();
    hora_seleccionada = tabla.cell(index_seleccionado, 9).data();

    //alert(cantidad_seleccionada + '\n' + codigo_seleccioando + '\n' + fecha_seleccionada + '\n' + hora_seleccionada);


});


consulta_almacenes();

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    MuestraLoader('');
    //$('#tablaTotales').hide();
    $('#fila_ubicacion').hide();
    $('#fila_codigo').hide();
    //$('#fila_lote').hide();
    //$('#fila_caducidad').hide();
    $('#fila_cantidad').hide();
    $('#seccionDescripcion').hide();
    
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
   
    consulta_lista_impresoras();
    consultaDatosServidor();
    //consulta_almacenes();
    consulta_datos_sesiones();
    AbreConexionBD();
            
    $('#fila_ubicacion').show();
    $('#fila_codigo').show();
    $('#fila_cantidad').show();
    limpia_campos();
    cargaConfiguracionesLectura();
    OcultaLoader();
    
    var strUbicacion = 'Almacén: ' + nombre_almacen + '\nUsuario: ' + usuario_conteo + '\nNúmero conteo: ' + n_conteo;
    if (ubicacionSeleccioanda.length > 0) {
        $('#txt_ubicacion').val(ubicacionSeleccioanda);
        strUbicacion = 'Almacén: ' + nombre_almacen + '\nUbicación: ' + ubicacionSeleccioanda + '\nUsuario: ' + usuario_conteo + '\nNúmero conteo: ' + n_conteo;
        consulta_inventario_local();
    }
    
    MuestraAlerta3(strUbicacion, 'success');
    //$('#txt_ubicacion').focus();

    
 
});
