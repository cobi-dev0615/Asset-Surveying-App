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
var nConteo = obtener_parametros_url('nConteo');

var codigo_forzado = 0;
var index_t_series = 0;

var urlPrevia = 'inventario_ubicacion.html';
//alert(urlPrevia);

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
    if ($('#ModalCatalogoProductos').hasClass('show')) {
        $('#ModalCatalogoProductos').modal('hide');
        return;
    }
    preguntaSalir();
}

function preguntaSalir() {
    var n_filas = tabla.rows().count();
    if (n_filas === 0) {
        $(location).attr('href', urlPrevia);
        return;
    }
    suenaError();
    swal({
        // title: '¿Desea cerrar su sesión?',
        text: '¿Desea salir del conteo de inventario?',
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
                PosicionaFoco();
                break;
            case 'Si':
                window.location.href = urlPrevia;
                // $(location).attr('href', urlPrevia);
                break;
        }
    });
}

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

//
$('#btn_opciones').on('click', function () {
    //$('#modalOpcionesLectura').modal('show');
});

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
                    if (!$('#txtFactor').is('[readonly]')) {
                        $('#txtFactor').val('').focus();
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
            });
    }
    catch (err) {
        alert(err.message);
    }
}

function salir() {

    var n_filas = tabla.rows().count();
    if (n_filas > 0) {

        preguntaSalir();

    }
    else {
        //StatusBar.prop('hidden', false);
        //NavigationBar.prop('hidden', false);

        $(location).attr('href', urlPrevia);
    }


}

///botones
$("#btn_salir").on('click', function () {
    salir();
});


function limpia_campos() {
    try {
        cantidadFactorSeleccionado = 1;
        fechaElaboracionSeleccionado = '';
        totalFactorSeleccionado = 0;
        index_t_series = 0;
        datos_producto = '';
        lectura = '';
        $('#tabla_n_series tbody tr').remove();
        $('#lbl_total_n_series').text('0');
        $('#txt_lote').empty().val(null).trigger('change');
        $('#txt_fecha_caducidad').empty().val(null).trigger('change');
        $('#txt_lectura').val('');
        $('#txt_cantidad').val('');
        if (!$('#txtFactor').is('[readonly]')) {
            $('#txtFactor').val('');
        }
        if ($('#txt_cantidad').is('[readonly]')) {
            $('#txt_cantidad').val('1');
        }
        $('#lbl_descripcion').text('');
        $('#seccionDescripcion').prop('hidden', true);
        $('#txt_sn').val('');
        $('#txtCodigo1Forzado').val('');
        $('#txtCodigo2Forzado').val('');
        $('#txtFactorForzado').val('');
        $('#txt_lectura_forzado').val('');
        // PosicionaFoco();
    }
    catch (err) { alert(err.message); }
}

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

$("#btn_insertar").on('click', function () {
    var cantidad = $('#txt_cantidad').val();
    inserta_fila_local(cantidad);

});

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
        console.log('Lectura: ' + lectura);
        if (lectura.includes('')) {
            //remplazamos el caracter de control por un |
            lectura = lectura.replace(//g, '|');
        }

        if (lectura.includes('|')) {
            consultaArrayDatos(lectura);
        } else {
            consulta_producto_local(lectura);
        }
    }
});

$('#btn_buscar_1').on('click', function () {
    var lectura = $('#txt_lectura').val().trim();
    console.log('Lectura: ' + lectura);
    if (lectura.includes('')) {
        //remplazamos el caracter de control por un |
        lectura = lectura.replace(//g, '|');
    }
    if (lectura.includes('|') || lectura.includes('')) {
        consultaArrayDatos(lectura);
    } else {
        consulta_producto_local(lectura);
    }


});

$('#txt_lectura').focusin(function () {

});

$('#txt_sn').on('keydown', function (e) {
    if (e.keyCode === 13) {
        inserta_n_serie();
    }
});

$('#btnAceptarSerie').click(inserta_n_serie);

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
var unidadMedidaSeleccionado = '';
var cantidadFactorSeleccionado = 1;
var totalFactorSeleccionado = 0;
var fechaElaboracionSeleccionado = '';
var lecturaArray = '';

function consulta_producto_local(lectura) {
    try {
        if (!$('#chkValidarCatalogo').is(':checked')) {
            id_seleccionado = 0;
            precio_venta = 0;
            cantidad_teorica = 0;
            codigo_2_seleccionado = '';
            codigo_3_seleccionado = '';
            unidadMedidaSeleccionado = '';
            cantidadFactorSeleccionado = 1;
            totalFactorSeleccionado = 0;
            fechaElaboracionSeleccionado = '';
            $('#lbl_descripcion').text('Código forzado');
            codigo_forzado = 1;
            if (!$('#txtFactor').is('[readonly]')) {
                $('#txtFactor').val('').focus();
                return;
            }
            if (!$('#txt_cantidad').is('[readonly]')) {
                $('#txt_cantidad').val('').focus();
                return;
            }
            inserta_fila_local(1);
        }
        else {
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
            var query = "SELECT * FROM catalogos WHERE codigo_1=? OR codigo_2=? OR codigo_3=?";
            base_datos.transaction(function (ts) {
                ts.executeSql(query, [lectura, lectura, lectura],
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
                            unidadMedidaSeleccionado = '';
                            cantidadFactorSeleccionado = 1;
                            totalFactorSeleccionado = 0;
                            fechaElaboracionSeleccionado = '';

                            MuestraAlerta3('El código ' + lectura + ' no fue encontrado en el catálogo.', 'error');
                            suenaAlerta();
                            vibraAlerta(1000);

                            $('#lbl_descripcion').text('Producto no encontrado');
                            $('#seccionDescripcion').prop('hidden', false);
                            //$('#txt_lectura').val('');
                            $('#txt_lote').val('');
                            $('#txt_fecha_caducidad').val('');

                            //si la opción de permitir códigos forzados está activa
                            if ($('#chk_forzados').is(':checked')) {
                                $('#modal_forzado').modal('show');
                                return;
                            }
                            if (!$('#txtFactor').is('[readonly]')) {
                                $('#txtFactor').val('').focus();
                                return;
                            }
                            if (!$('#txt_cantidad').is('[readonly]')) {
                                $('#txt_cantidad').val('');
                            }

                            codigo_forzado = 0;
                            limpia_campos();
                            PosicionaFoco();

                            return;
                        }


                        id_seleccionado = resultSet.rows.item(0).id_producto;
                        var codigo_1 = resultSet.rows.item(0).codigo_1;
                        codigo_2_seleccionado = resultSet.rows.item(0).codigo_2 || '';
                        codigo_3_seleccionado = resultSet.rows.item(0).codigo_3 || '';
                        var descripcion = resultSet.rows.item(0).descripcion;
                        unidadMedidaSeleccionado = resultSet.rows.item(0).unidad_medida;
                        //var modelo = resultSet.rows.item(0).modelo;
                        //var marca = resultSet.rows.item(0).marca;
                        precio_venta = Number(resultSet.rows.item(0).precio_venta) || 0;
                        cantidad_teorica = Number(resultSet.rows.item(0).cantidad_teorica) || 0;
                        cantidadFactorSeleccionado = Number(resultSet.rows.item(0).factor) || 1;
                        codigo_forzado = 0;

                        $('#txt_lectura').val(codigo_1);
                        $('#lbl_descripcion').text(descripcion);
                        $('#seccionDescripcion').prop('hidden', false);

                        //hacemos la búsqueda de los lotes
                        $('#txt_lote').val('');
                        $('#txt_fecha_caducidad').val('');

                        if ($('#chk_lotes').is(':checked')) {
                            ConsultaLotes(codigo_2_seleccionado);
                            return;
                        }
                        if ($('#chk_n_series').is(':checked')) {
                            $('#modal_n_series').modal('show');
                            $('#txt_sn').val('').focus();
                            return;
                        }
                        if (!$('#txtFactor').is('[readonly]')) {
                            $('#txtFactor').val('').focus();
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
    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function ConsultaLotes(codigo_2_seleccionado) {
    base_datos.transaction(function (ts) {
        //consultamos los lotes y caducidades
        var listaLotes = [];

        var query = "SELECT lote FROM lotes_caducidades WHERE codigo2=?";

        ts.executeSql(query, [codigo_2_seleccionado],
            function (ignored, resultSet) {
                console.log('Lotes econtrados: ' + resultSet.rows.length);
                for (var i = 0; i < resultSet.rows.length; i++) {
                    var lote = resultSet.rows.item(i).lote;
                    listaLotes.push({ id: lote, text: lote });
                }

                $('#txt_lote').empty().select2({
                    placeholder: 'Lote',
                    allowClear: true,
                    data: listaLotes,
                    tags: true,
                    insertTag: function (data, tag) {
                        // Insertamos el tag al final de los resultados
                        data.push(tag);
                    },
                    dropdownCssClass: 'font-weight-bold',
                    theme: 'bootstrap'
                }).val(null).trigger('change').focus();

                if (listaLotes.length === 0) {
                    $('#txt_lote').val('').trigger('change').focus();
                    return;
                }
                else if (listaLotes.length === 1) {
                    $('#txt_lote').val(listaLotes[0].id).trigger('change');
                    $('#txt_fecha_caducidad').val('').trigger().focus();
                    return;
                }

            },
            function (ignored, error) {
                alert(error.message);
            });
    });

}

$('#txt_lote').on('change', function (e) {
    var lote = $('#txt_lote').val();
    ConsultaCaducidades(lote);
});

function ConsultaCaducidades(lote) {
    base_datos.transaction(function (ts) {

        //consultamos los lotes y caducidades
        var listaCaducidades = [];

        var query = "SELECT fechaCaducidad FROM lotes_caducidades WHERE codigo2=? AND lote=?";

        ts.executeSql(query, [codigo_2_seleccionado, lote],
            function (ignored, resultSet) {

                console.log('Caducidades encontradas: ' + resultSet.rows.length);
                for (var i = 0; i < resultSet.rows.length; i++) {
                    var fechaCaducidad = resultSet.rows.item(i).fechaCaducidad;
                    console.log('Fecha de caducidad: ' + fechaCaducidad);
                    if (listaCaducidades.indexOf(fechaCaducidad) === -1) { //si no existe en el array lo agregamos
                        listaCaducidades.push({ id: fechaCaducidad, text: fechaCaducidad });
                    }
                }

                $('#txt_fecha_caducidad').empty().select2({
                    placeholder: 'Fecha de caducidad',
                    allowClear: true,
                    data: listaCaducidades,
                    tags: true,
                    insertTag: function (data, tag) {
                        // Insertamos el tag al final de los resultados
                        data.push(tag);
                    },
                    dropdownCssClass: 'font-weight-bold',
                    theme: 'bootstrap'
                }).val(null).trigger('change').focus();

                if (listaCaducidades.length === 0) {
                    $('#txt_fecha_caducidad').val('').trigger('change').focus();
                    return;
                }
                else if (listaCaducidades.length === 1) {
                    // $('#txt_fecha_caducidad').val(listaCaducidades[0].id).trigger('change');
                    // if ($('#txt_cantidad').is('[readonly]')) {
                    //     inserta_fila_local(1);
                    //     return;
                    // }
                    // $('#txt_cantidad').val('').focus();
                    // return;
                }

            },
            function (ignored, error) {
                alert(error.message);
            });
    });

}


function consultaArrayDatos(strArray) {
    try {

        //si la lectura incluye el separador de lotes '|', entonces lo separamos por ese separador, sino validamos si incluye el simbolo de \u \u91WC9X00SX01ML1060180513102041667
        console.log('Lectura: ' + strArray);
        lecturaArray = strArray.split('|');

        console.log('Longitud: ' + lecturaArray.length);
        //si la longitud es diferente a 3 o 4, entonces no es un código válido
        if (lecturaArray.length < 3 || lecturaArray.length > 4) {
            cantidadFactorSeleccionado = 1;
            lecturaArray = '';
            suenaAlerta();
            MuestraAlerta3('Código no válido', 'warning');
            limpia_campos();
            $('#txt_lectura').val('').focus();
            return;
        }

        //si la longitud es 4 entoneces toma el valor de la lectura del primer elemento, sino elimina los primeros 2 caracteres del primer elemento
        lectura = lecturaArray.length === 4 ? lecturaArray[0].toString().trim() : lecturaArray[0].toString().trim().substring(2, lecturaArray[0].length);

        //si la longitud es 4, entonces toma el valor del segundo elemento, sino elimina los primeros 2 caracteres del segundo elemento
        var lote = lecturaArray.length === 4 ? lecturaArray[1].toString().trim() : lecturaArray[1].toString().trim().substring(2, lecturaArray[1].length);

        cantidadFactorSeleccionado = lecturaArray.length === 4 ? Number(lecturaArray[2].toString().trim()) : 1;
        fechaElaboracionSeleccionado = lecturaArray.length === 4 ? lecturaArray[3].toString().trim() : '';


        $('#txt_lectura').val(lectura).focus()
        $('#filaFactor').prop('hidden', false);
        $('#txtFactor').prop('readonly', false).val(cantidadFactorSeleccionado);
        $('#fila_lote').prop('hidden', false);
        // $('#txt_lote').prop('readonly', false);
        var listaLotes = [lote];
        $('#txt_lote').empty().select2({
            placeholder: 'Lote',
            allowClear: true,
            data: listaLotes,
            tags: true,
            insertTag: function (data, tag) {
                // Insertamos el tag al final de los resultados
                data.push(tag);
            },
            dropdownCssClass: 'font-weight-bold',
            theme: 'bootstrap'
        }).val(lote).trigger('change').focus();


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
                        unidadMedidaSeleccionado = '';

                        MuestraAlerta3('El código ' + lectura + ' no fue encontrado en el catálogo.', 'error');
                        suenaAlerta();
                        vibraAlerta(1000);

                        $('#lbl_descripcion').text('Producto no encontrado');
                        $('#seccionDescripcion').prop('hidden', false);
                        //$('#txt_lectura').val('');
                        //$('#txt_lote').val('');
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
                        PosicionaFoco();

                        return;
                    }

                    id_seleccionado = resultSet.rows.item(0).id_producto;
                    var codigo_1 = resultSet.rows.item(0).codigo_1;
                    codigo_2_seleccionado = resultSet.rows.item(0).codigo_2 || '';
                    codigo_3_seleccionado = resultSet.rows.item(0).codigo_3 || '';
                    var descripcion = resultSet.rows.item(0).descripcion;
                    unidadMedidaSeleccionado = resultSet.rows.item(0).unidad_medida;
                    precio_venta = Number(resultSet.rows.item(0).precio_venta) || 0;
                    cantidad_teorica = Number(resultSet.rows.item(0).cantidad_teorica) || 0;
                    codigo_forzado = 0;


                    $('#txt_lectura').val(codigo_1);
                    $('#lbl_descripcion').text(descripcion);
                    $('#seccionDescripcion').prop('hidden', false);

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

        if (!$('#txtFactor').is('[readonly]')) {
            cantidadFactorSeleccionado = Number($('#txtFactor').val());
            if ($('#txtFactor').val().trim() === '') {
                cantidadFactorSeleccionado = 1;
            }
        }

        totalFactorSeleccionado = cantidadFactorSeleccionado * cantidad;

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
        var id_producto = id_seleccionado;
        var codigo_1 = $('#txt_lectura').val();
        var codigo_2 = codigo_2_seleccionado;
        var codigo_3 = codigo_3_seleccionado;
        var descripcion = $('#lbl_descripcion').text();
        var importe = (Number(cantidad) * Number(precio_venta)).toFixed(3);
        //se cambia el importe total debido a que ahora se usa el factor
        //var importe = (Number(cantidad) * Number(totalFactorSeleccionado)).toFixed(3);


        var ubicacion = $('#txt_ubicacion').val().trim();
        //var cantidad = cantidad;
        var lote = $('#txt_lote').val();
        var n_serie = '';

        var fecha_caducidad = $('#txt_fecha_caducidad').val();
        var fecha_captura = strFecha(0);
        var hora_captura = strHora();
        var um = unidadMedidaSeleccionado;

        if ($('#chkValidarCatalogo').is(':checked')) {
            if (codigo_forzado === 1) {
                try {
                    codigo_1 = $('#txtCodigo1Forzado').val().trim();
                    codigo_2 = $('#txtCodigo2Forzado').val().trim();

                    base_datos.transaction(function (ts) {

                        //autoincrementamos la variable para generar un ID consecutivo
                        //n_productos++;
                        var id_producto = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');
                        //inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado, cantidad_real
                        ts.executeSql('INSERT INTO catalogos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                            [id_inventario, Number(id_producto), codigo_1, codigo_2, '', descripcion, 0, '', '', '', '', 0, '', '', 0, 1, 0, 0, 0, 1]);
                    }, function (error) {
                        alert(error.message);
                    }, function () {

                    });

                }
                catch (err) {
                    alert(err.message);
                }
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
                    'n_conteo': nConteo,
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
                    'eliminado': 0,
                    'unidad_medida': um,
                    'fecha_elaboracion': fechaElaboracionSeleccionado,
                    'factor': cantidadFactorSeleccionado,
                    'total_factor': totalFactorSeleccionado,
                    'lectura_array': lecturaArray.toString()

                };

                id = northwind.insert('registros', datosFila);
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
                'n_conteo': nConteo,
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
                'eliminado': 0,
                'unidad_medida': um,
                'fecha_elaboracion': fechaElaboracionSeleccionado,
                'factor': cantidadFactorSeleccionado,
                'total_factor': totalFactorSeleccionado,
                'lectura_array': lecturaArray.toString()

            };

            id = northwind.insert('registros', datosFila);
            northwind.commit();

            //consulta_inventario_local();
            datosFila["importe"] = importe;
            datosFila["ID"] = id;

            //alert(JSON.stringify(datosFila));
            tabla.row.add(datosFila).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
            MuestraAlerta3(descripcion + '\nCant.: ' + cantidad, 'success');


        }

        tabla.order([13, 'desc']).draw();
        //tabla.columns.adjust().draw();// adjustamos el tamaño de las columnas y redibujamos

        OcultaLoader();
        limpia_campos();
        calculaTotales();
        PosicionaFoco();

    } catch (err) {
        alert('Error InsertaFila: ' + err.message);
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

        var almacen = nombre_almacen;
        var ubicacion = $('#txt_ubicacion').val().trim();
        if (ubicacion.length === 0 || ubicacion.length > 15) {
            suenaAlerta();
            MuestraAlerta3('Capture una ubicación válida para continuar.', 'warning');
            $('#txt_ubicacion').val('').focus();
            return;
        }
        MuestraLoader('');

        MuestraAlerta3('Consultando ubicación...', 'success_s');

        setTimeout(function () {

            var datos_tabla = northwind.queryAll('registros', {
                query: { ubicacion: ubicacion, nombre_almacen: almacen }
            });

            datos_tabla = alasql('SELECT ID, cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad*precio_venta AS importe, lote, fecha_caducidad, n_serie, fecha_captura, hora_captura, unidad_medida, factor, total_factor, fecha_elaboracion FROM ?', [datos_tabla]);

            var x = datos_tabla.length;
            console.log('Registros: ' + x);

            tabla.clear().draw(); //clear() limpia las filas existentes de la tabla
            if (x === 0) {
                calculaTotales();
                OcultaLoader();
                $('#txt_lectura').val('').focus();
                return;
            }

            tabla.rows.add(datos_tabla).draw(true); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
            tabla.columns.adjust().draw(true);// adjustamos el tamaño de las columnas y redibujamos

            calculaTotales();
            OcultaLoader();

            PosicionaFoco();



        }, 100);

    }
    catch (err) {
        OcultaLoader();
        MuestraAlerta3(err.message, 'error');
    }


}


//cambiamos el tipo de conteo
$('input[type=checkbox][name=chkTipoConteo]').change(function () {
    //$('#chkTipoConteo').change(function () {
    //if (this.value === 'si') {
    if ($('#chkTipoConteo').is(':checked')) {
        MuestraAlerta3('Conteo por unidad activado', 'success');
        limpia_campos();
        $('#txt_cantidad').val('1');
        $('#txt_cantidad').prop('readonly', true).css("background-color", "#CCC");
        // $('#fila_cantidad').prop('hidden', true);
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
        // $('#fila_cantidad').prop('hidden', false);
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

        //if ($('#chkTipoConteo').val() === 'no') {
        if (!$('#chkTipoConteo').is(':checked')) {
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

    //if ($('#chkTipoConteo').val() === 'no') {
    if (!$('#chkTipoConteo').is(':checked')) {
        $('#txt_cantidad').val('').focus();
        return;
    }

    inserta_fila_local(1);
});

//
function calculaTotales() {
    var n_filas = tabla.rows().count();
    // var conteo_total = tabla.column(0).data().sum();
    var conteo_total = tabla.column(0).data().sum().toLocaleString();
    var valor_inventario = tabla.column(12).data().sum().toLocaleString();
    var totaFactor = tabla.column(16).data().sum().toLocaleString();

    $('#lbl_conteo_total').html('CONTEO TOTAL: <strong>' + conteo_total + '</strong>');
    $('#lbl_n_filas').html('REGISTROS: <strong>' + n_filas + '</strong>');
    $('#lbl_importe_total').html('VALOR DE INVENTARIO: <strong>' + valor_inventario.toLocaleString() + '</strong>');
    $('#lblTotalFactor').html('TOTAL FACTOR: <strong>' + totaFactor + '</strong>');
}

function imprime() {
    try {
        var n_filas = tabla.rows().count();

        if (n_filas === 0) {
            suenaError();
            vibraAlerta(500);
            MuestraAlerta3('No hay registros para imprimir', 'error');
            return;
        }

        MuestraLoader('Conectando a ' + nombre_impresora_0 + '\n' + mac_impresora_0);

        var fecha_captura = strFecha(0);
        var cantidad = '';
        var codigo_1 = '';
        var ubicacion_reporte = $('#txt_ubicacion').val().trim();
        var descripcion = '';
        var datos_reporte = '';
        var conteo_total = $('#lbl_conteo_total').text();
        var precio_venta = 0;
        var importe = 0;

        //var datos_tabla = [];
        var datos_tabla = northwind.queryAll('registros');
        //datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, descripcion, precio_venta, ROUND(SUM(cantidad)*precio_venta, 2) AS importe, nombre_almacen, ubicacion FROM ? WHERE ubicacion="' + ubicacion_reporte + '" AND nombre_almacen="' + nombre_almacen + '" GROUP BY codigo_1, codigo_2, descripcion, precio_venta, importe, nombre_almacen, ubicacion', [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));

        //alert(JSON.stringify(resultado));
        var il = 305;
        var datosTicketCPCL = '';
        var datos_ticket_cf = '';
        var n_registro = 0;
        var x = datos_tabla.length;

        $.each(datos_tabla, function (index, dato_tabla) {

            cantidad = dato_tabla.cantidad || 0;
            codigo_1 = dato_tabla.codigo_1 || '';
            descripcion = dato_tabla.descripcion || '';
            precio_venta = dato_tabla.precio_venta || 0;
            importe = dato_tabla.importe || 0;

            //datos_reporte += cantidad + '             ' + codigo_1 + '\r\n' + descripcion + '\r\n';
            if (marca_impresora_0 === 'Zebra') {

                datosTicketCPCL += 'T 7 0 25 ' + il.toString() + ' ' + descripcion.substring(0, 30) + '\r\n';
                il += 20;

                //datosTicketCPCL += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 5) + '    ' + codigo_1 + '\r\n';
                //il += 20;
                datosTicketCPCL += 'T 5 0 25 ' + il.toString() + ' ' + codigo_1 + '\r\n';
                il += 20;

                datosTicketCPCL += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 6) + '\t' + padLeft(precio_venta.toLocaleString(), 11) + '\r\n';
                il += 28;

            }
            else if (marca_impresora_0 === 'CF') {
                datos_ticket_cf += '\x1B!\x01'; //Font B
                datos_ticket_cf += descripcion.substring(0, 30) + ' \r\n';

                datos_ticket_cf += '\x1B!\x08'; //Emphasis
                datos_ticket_cf += padRight(cantidad.toString(), 9) + codigo_1.substring(0, 20) + '\r\n';
            }
        });

        datosTicketCPCL += 'T 7 0 25 ' + il.toString() + ' __\r\n';
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
            + 'T 5 0 25 225 PRODUCTO\r\n'
            + 'T 5 0 25 255 CANT     PRECIO     IMPORTE\r\n'
            + 'T 5 0 25 280 ***************************\r\n'
            + datosTicketCPCL
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
            //alert(ticket_zebra);
            imprimeBluetooth(mac_impresora_0, ticket_zebra);
        }
        else {
            vibraAlerta(500);
            OcultaLoader();
            MuestraAlerta3('Impresora no compatible, verifíque los modelos compatibles en las configuraciones de la aplicación.', 'error');
        }
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

$('#btnImprimirEtiquetas').on('click', function () {
    ImprimeEtiquetas();
});

function ImprimeEtiquetas() {
    try {
        var n_filas = tabla.rows().count();

        if (n_filas === 0) {
            suenaError();
            vibraAlerta(500);
            MuestraAlerta3('No hay registros para imprimir', 'error');
            return;
        }

        MuestraLoader('Conectando a ' + nombre_impresora_0 + '\n' + mac_impresora_0);

        var cantidad = '';
        var codigo_1 = '';
        var ubicacion_reporte = $('#txt_ubicacion').val().trim();
        var descripcion = '';
        var datos_reporte = '';
        var conteo_total = $('#lbl_conteo_total').text();
        var precio_venta = 0;
        var importe = 0;

        //var datos_tabla = [];
        // var datos_tabla = northwind.queryAll('registros');
        var almacen = nombre_almacen;
        var ubicacion = $('#txt_ubicacion').val().trim();
        var datos_tabla = northwind.queryAll('registros', {
            query: { ubicacion: ubicacion, nombre_almacen: almacen }
        });
        datos_tabla = alasql('SELECT SUM(cantidad*100)/100 AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, SUM(cantidad)*precio_venta AS importe FROM ? GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, importe', [datos_tabla]);

        //datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, descripcion, precio_venta, ROUND(SUM(cantidad)*precio_venta, 2) AS importe, nombre_almacen, ubicacion FROM ? WHERE ubicacion="' + ubicacion_reporte + '" AND nombre_almacen="' + nombre_almacen + '" GROUP BY codigo_1, codigo_2, descripcion, precio_venta, importe, nombre_almacen, ubicacion', [datos_tabla]);
        // console.log(JSON.stringify(datos_tabla));

        //alert(JSON.stringify(resultado));
        var ticket_zebra = '';
        var il = 135;
        var datosTicketCPCL = '';
        var datos_ticket_cf = '';
        var x = datos_tabla.length;
        var nRegistrosPorEtiqueta = 10; //Número de registros por etiqueta
        var nEtiquetas = Math.ceil(x / nRegistrosPorEtiqueta); //calculamos el número de etiquetas a imprimir y lo redondeamos al siguiente entero en caso de que el resultado sea decimal
        console.log('nEtiquetas: ' + nEtiquetas);
        var etiquetaActual = 1;
        var registroInicial = 0;
        var registroFinal = nRegistrosPorEtiqueta;
        var conteoTotal = $('#lbl_conteo_total').text();
        var fechaImpresion = strFecha(0).split('-');
        var fechaHoraImpresion = fechaImpresion[2] + '/' + fechaImpresion[1] + '/' + fechaImpresion[0] + ' ' + strHora().substring(0, 5);

        for (var i = 1; i <= nEtiquetas; i++) {

            console.log('Consultado los registros de ' + registroInicial + ' a ' + registroFinal);

            var nuevoJson = datos_tabla.slice(registroInicial, registroFinal); //devuelve un JSON con N elementos de otro JSON 

            console.log(JSON.stringify(nuevoJson));

            nuevoJson.forEach(function (element, index) {

                cantidad = element.cantidad || 0;

                codigo_1 = element.codigo_1 || '';
                descripcion = element.descripcion || '';
                precio_venta = element.precio_venta || 0;
                importe = element.importe || 0;

                datosTicketCPCL += 'T 7 0 15 ' + il.toString() + ' ' + codigo_1 + '\r\n';
                datosTicketCPCL += 'T 7 0 180 ' + il.toString() + ' ' + descripcion.substring(0, 29) + '\r\n';

                il += 25;

            });

            //setTimeout(function () {

            ticket_zebra += '! U1 setvar "device.languages" "cpcl"\n'
                + '! 0 200 200 ' + il.toString() + ' 1\n'
                + 'LABEL\n'
                + 'CONTRAST 0\n'
                + 'TONE 0\n'
                + 'SPEED 5\n'
                + 'PAGE-WIDTH 608\n'
                + 'BAR-SENSE\n'
                + ';// PAGE 0000000006080408\n'

                + 'T 7 0 15 15 TIENDA: ' + nombre_almacen + '\n'
                + 'T 5 1 300 20 MARBETE: ' + ubicacion + '\n'
                + 'T 7 0 15 40 ' + conteoTotal + '\n'
                + 'T 7 0 15 65 CONTADOR: ' + usuario_conteo + '\n'
                + 'T 7 0 15 90 FECHA Y HORA: ' + fechaHoraImpresion + '\n'
                + 'LINE 15 120 100 120 1\n'
                + 'BT 7 0 0\n'
                + 'VB 128 1 0 30 539 362 ' + ubicacion + '\n'
                + 'BT OFF\n'

                + 'T 0 2 480 375 Etiqueta ' + etiquetaActual + '/' + nEtiquetas + '\n';

            ticket_zebra += datosTicketCPCL;
            ticket_zebra += 'FORM\n'
                + 'PRINT\n';





            registroInicial += nRegistrosPorEtiqueta;
            registroFinal += nRegistrosPorEtiqueta;
            etiquetaActual++;
            datosTicketCPCL = '';
            il = 135;


        }


        //enviamos a imprimir todas las etiquetas en la misma conexión de la impresora (debe funcionar)

        ticket_zebra = normalizaStr(ticket_zebra);
        console.log('Etiqueta completa: ' + ticket_zebra);

        setTimeout(function () {
            imprimeBluetooth(mac_impresora_1, ticket_zebra);
        }, 1000);
        //
        // if (marca_impresora_0 === 'CF') {
        //     imprimeBluetooth(mac_impresora_0, ticket_cf);
        // }
        // else if (marca_impresora_0 === 'Zebra') {
        //     //alert(ticket_zebra);

        // }
        // else {
        //     vibraAlerta(500);
        //     OcultaLoader();
        //     MuestraAlerta3('Impresora no compatible, verifíque los modelos compatibles en las configuraciones de la aplicación.', 'error');
        // }
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

$('#modal_n_series').on('hidden.bs.modal', function () {
    limpia_campos();
    PosicionaFoco();
});

$('#modal_forzado').on('hidden.bs.modal', function () {
    if (codigo_forzado === 0) {
        limpia_campos();
        PosicionaFoco();
    }
    else {

        //var lectura = $('#txt_lectura').val();
        var descripcion_codigo_forzado = $('#txt_lectura_forzado').val().trim();
        if (descripcion_codigo_forzado === '') {
            descripcion_codigo_forzado = 'Código forzado';
        }
        $('#lbl_descripcion').html(descripcion_codigo_forzado);
        $('#seccionDescripcion').prop('hidden', false);

        if ($('#chk_lotes').is(':checked')) {
            $('#txt_lote').val('').focus();
            return;
        }
        if ($('#chk_n_series').is(':checked')) {
            $('#modal_n_series').modal('show');
            $('#txt_sn').val('').focus();
            return;
        }
        if (!$('#txtFactor').is('[readonly]')) {
            $('#txtFactor').val('').focus();
            return;
        }
        //if ($('#chkTipoConteo').val() === 'no') {
        if (!$('#chkTipoConteo').is(':checked')) {
            $('#txt_cantidad').val('').focus();
            return;
        }
        inserta_fila_local(1);
    }
});

$('#modal_forzado').on('shown.bs.modal', function () {
    var codigoLeido = $('#txt_lectura').val().trim();
    $('#txtCodigo1Forzado').val(codigoLeido).focus();
    $('#txtCodigo2Forzado').val(codigoLeido);
});

$('#modal_n_series').on('shown.bs.modal', function () {
    $('#txt_sn').val('').focus();
});

$('#modalOpciones').on('hidden.bs.modal', function () {
    limpia_campos();
    setTimeout(function () {
        PosicionaFoco();
    }, 100);
});

$('#btnOpcionesCaptura').on('click', function () {
    $('#modalOpcionesLectura').modal('show');
});


$('#modalOpcionesLectura').on('hidden.bs.modal', function () {
    configuraOpcionesLectura();
});

function configuraOpcionesLectura() {
    if ($('#chk_n_series').is(':checked')) {
        $('#fila_cantidad').prop('hidden', true);
        $('#td_lbl_tipo_conteo').prop('hidden', true);
        $('#td_chkTipoConteo').prop('hidden', true);
    }
    else {
        //if (!$('#chkTipoConteo').is(':checked')) {
        $('#fila_cantidad').prop('hidden', false);
        $('#td_lbl_tipo_conteo').prop('hidden', false);
        $('#td_chkTipoConteo').prop('hidden', false);
        //}
    }
    if ($('#chk_lotes').is(':checked')) {
        //$('#fila_lote').css('display', 'inherit');
        $('#fila_lote').prop('hidden', false);
        $('#txt_lote').val('');
        $('#txt_lote').prop('readonly', false);
        $('#fila_caducidad').prop('hidden', false);
        $('#txt_fecha_caducidad').val('');
        $('#txt_fecha_caducidad').prop('readonly', false);
    }
    else {
        $('#fila_lote').prop('hidden', true);
        //$('#fila_lote').css('display', 'none');
        $('#txt_lote').val('');
        $('#txt_lote').prop('readonly', true);
        $('#fila_caducidad').prop('hidden', true);
        //$('#fila_lote').css('display', 'none');
        $('#txt_fecha_caducidad').val('');
        $('#txt_fecha_caducidad').prop('readonly', true);
    }

    //if ($('#chkTipoConteo').val() === 'si') {
    if ($('#chkTipoConteo').is(':checked')) {
        $('#fila_cantidad').prop('hidden', true);
    }
    if ($('#chkGPS').is(':checked')) {
        actualizaPosicionActual();
    }
    else {
        detenerPosicionGPS();
    }
    if ($('#chkFactor').is(':checked')) {
        $('#filaFactor').prop('hidden', false);
        $('#txtFactor').val('');
        $('#txtFactor').prop('readonly', false);
    }
    else {
        $('#filaFactor').prop('hidden', true);
        $('#txtFactor').val('');
        $('#txtFactor').prop('readonly', true);
    }

    $('#modalOpciones').modal('hide');

}

function PosicionaFoco() {
    if ($('#txt_ubicacion').val().trim().length === 0) {
        $('#txt_ubicacion').val('').focus();
        $('#txt_ubicacion').prop('readonly', true);
        setTimeout(function () {
            $('#txt_ubicacion').prop('readonly', false);
        }, 100);
        return;
    }

    $('#txt_lectura').val('').focus();
    $('#txt_lectura').prop('readonly', true);
    setTimeout(function () {
        $('#txt_lectura').prop('readonly', false);
    }, 100);


}

function elimina_seleccionado_local(idSeleccionado) {
    console.log('ID seleccionado: ' + idSeleccionado);
    var dialog = confirm('¿Desea eliminar el registro seleccionado?');
    if (dialog === false) {
        $('#modalOpciones').modal('hide');
        $('#txt_lectura').val('').focus();
        return;
    }
    //eliminamos el registro de la base de datos 
    //northwind.deleteRows('registros', { cantidad: cantidad_seleccionada, codigo_1: codigo_seleccioando, n_serie: n_serie_seleccionado, fecha_captura: fecha_seleccionada, hora_captura: hora_seleccionada });
    northwind.deleteRows('registros', { ID: idSeleccionado });
    northwind.commit();

    suenaExito();
    $('#modalOpciones').modal('hide');
    //eliminamos el registro seleccionado de la tabla
    tabla.row(indexSeleccionado).remove().draw(true);
    MuestraAlerta3('Registro eliminado exitosamente', 'success');
    tabla.columns.adjust().draw(false);
    calculaTotales();
    limpia_campos();
    PosicionaFoco();

}

function inserta_n_serie() {
    var lectura_serie = String($('#txt_sn').val().trim());
    if (lectura_serie === '') {
        suenaError();
        toastr.warning('Capture el número serie para continuar', '', { "positionClass": "md-toast-bottom-center", "progressBar": true, "preventDuplicates": true, "timeOut": 3000 });
        $('#txt_sn').val('').focus();
        return;
    }
    //index_t_series++;
    var fila = "<tr>"
        + "<td>" + lectura_serie + "</td>"
        + "<td><button class='btn btn-danger btn-sm btn-block' onclick='elimina_registro_serie(this)'><i class='fas fa-times'></i></button></td>"
        + "</tr>";
    $('#tabla_n_series tbody').prepend(fila);
    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    $('#lbl_total_n_series').text(n_filas_series);
    $('#txt_sn').val('');
    $('#txt_sn').focus();
}


$('#btn_aceptar_n_series').on('click', function () {

    var n_filas_series = $('#tabla_n_series tbody').children('tr').length;
    if (n_filas_series === 0) {

        suenaError();
        toastr.warning('Capture al menos un número serie para continuar', '', { "positionClass": "md-toast-bottom-center", "progressBar": true, "preventDuplicates": true, "timeOut": 3000 });

        //MuestraAlerta3('Capture al menos un número serie para continuar', 'warning');
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
        if (!$('#txtFactor').is('[readonly]')) {
            $('#txtFactor').val('').focus();
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
    if (!$('#txtFactor').is('[readonly]')) {
        $('#txtFactor').val('').focus();
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

$('#txtFactor').on('keydown', function (e) {
    if (e.keyCode === 13 || e.keyCode === 9) {
        e.preventDefault();
        $('#txt_cantidad').val('').focus();
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
    PosicionaFoco();
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

        var datos_tabla = northwind.queryAll('registros', {
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
        northwind.deleteRows('registros', { ubicacion: ubicacion, nombre_almacen: almacen });
        northwind.commit();

        var ubicacionActual = $('#txt_ubicacion').val().trim();
        if (ubicacion === ubicacionActual) {
            $('#txt_ubicacion').val('');
            tabla.clear().draw();
            calculaTotales();
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
    var factor = arrDatos[0].factor;

    if (validar_catalogo === 1) {
        $('#chkValidarCatalogo').click();
    }
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

    if (cantidad_cero === 1) {
        $('#chk_cant_cero').click();
    }
    if (cantidades_negativas === 1) {
        $('#chk_cant_negativa').click();
    }
    if (coordenadas === 1) {
        $('#chkGPS').click();
    }
    if (factor === 1) {
        $('#chkFactor').click();
    }

    configuraOpcionesLectura();

}

//actualizamos las opciones de lectura 
$('input[type=checkbox][name=chkValidarCatalogo]').change(function () {
    try {
        var valor = 0;
        if ($('#chkValidarCatalogo').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.validar_catalogo = valor;
            return row;
        });
        northwind.commit();
    }
    catch (err) {
        alert(err.message);
    }
});


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

$('input[type=checkbox][name=chkFactor]').change(function () {
    try {
        var valor = 0;
        if ($('#chkFactor').is(':checked')) {
            valor = 1;
        }
        northwind.update('configuraciones_lectura', { ID: 1 }, function (row) {
            row.factor = valor;
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

var tabla = $('#tablaDatos').DataTable({
    select: {
        style: 'single'
    },
    order: [[13, 'desc']],
    //"bFilter": true,
    info: false,
    //LengthChange: true,
    paging: true,
    pageLength: 30,
    pagingType: 'numbers',
    dom: '<"top"pt>',
    scrollY: '60vh',
    scrollX: true,
    scrollCollapse: false,
    searching: false,
    autoWidth: true,
    responsive: true,
    fixedColumns: {
        leftColumns: 0,
        rightColumns: 0
    },
    columnDefs: [
        {
            defaultContent: '',
            targets: "_all"
        }
    ],
    data: [],
    columns: [
        //Si deseamos agregar nuevas columnas a la tabla debemos hacerlo también en el archivo HTML
        { title: 'Cant', data: 'cantidad', visible: true, searchable: false, width: '1%' },
        { title: 'SKU', data: 'codigo_2', visible: true, searchable: false, width: '1%' },
        { title: 'Descripción', data: 'descripcion', visible: true, searchable: false, width: '1%' },
        { title: 'Código 1', data: 'codigo_1', visible: true, searchable: false, width: '1%' },
        { title: 'Código 3', data: 'codigo_3' },
        { title: 'Lote', data: 'lote', width: '1%' },

        { title: 'Fecha Caducidad', data: 'fecha_caducidad', width: '1%' },
        { title: 'Número Serie', data: 'n_serie', visible: true, searchable: false, width: '1%' },
        { title: 'Unidad Medida', data: 'unidad_medida', visible: true, searchable: false, width: '1%' },
        { title: 'Fecha Captura', data: 'fecha_captura' },
        { title: 'Hora Captura', data: 'hora_captura' },
        {
            //className asigna la clase a toda la columna incluyendo la cabecera
            title: 'Precio Venta', data: 'precio_venta', className: '', width: '1%', render: function (data, type, row) {
                return Number(data);
            }
        },
        {
            title: 'Importe', data: 'importe', className: '', width: '1%', render: function (data, type, row) {
                return Number(data).toLocaleString();
            }
        },
        { title: 'ID', data: 'ID', visible: false, searchable: false },
        { title: 'Fecha Elaboración', data: 'fecha_elaboracion' },
        { title: 'Factor de conversión', data: 'factor', visible: true, searchable: false, width: '1%' },
        { title: 'Total Factor', data: 'total_factor', visible: true, searchable: false, width: '1%' },
        {
            title: '', data: 'ID', width: '1%', render: function (data, type, row) {
                return '<button class="btn btn-danger btn-sm btn-block" onclick="elimina_seleccionado_local(' + data + ')"><i class="fas fa-times"></i> Eliminar registro</button>';

            }
        }

    ],
    createdRow: function (row, data, index) {
        //personalizamos las columnas deseadas
        $('td', row).eq(0).addClass('text-danger text-right font-weight-bold');
        $('td', row).eq(1).addClass('text-wrap');

        $('td', row).eq(2).addClass('small text-wrap');
        //$('td', row).eq(9).addClass('text-right');
        $('td', row).eq(11).addClass('text-right font-weight-bold');
        $('td', row).eq(12).addClass('text-primary text-right font-weight-bold');
        $('td', row).eq(14).addClass('text-primary text-right font-weight-bold bg-white');
        $('td', row).eq(15).addClass('text-danger text-right font-weight-bold bg-white');

    }

});

$(tabla.table().header()).addClass('elegant-color-dark text-white');

var id_producto_seleccionado = 0;
var indexSeleccionado = -1;
var cantidad_seleccionada = '';
var codigo_seleccioando = '';
var n_serie_seleccionado = '';
var fecha_seleccionada = '';
var hora_seleccionada = '';
var datosSeleccionados = [];

$('#tablaDatos tbody').on('click', 'tr', function () {
    datosSeleccionados = tabla.row(this).data();
    //alert( tabla.row( this ).data() ); //muestra los datos de toda la fila separados por coma
    var indexOK = tabla.row(this).index();
    if (indexOK !== undefined) {
        //debido a que el index no se reconoce al hacer responsiva la tabla guardamos el último index seleccionado
        indexSeleccionado = indexOK;
    }
    id_seleccionado = tabla.cell(indexSeleccionado, 13).data(); //conseguimos el valor de la fila y celda deseada
    console.log('ID seleccionado: ' + id_seleccionado);
    console.log('Index seleccionado: ' + indexSeleccionado);
    console.log('Datos seleccionados: ' + JSON.stringify(datosSeleccionados));

    cantidad_seleccionada = tabla.cell(indexSeleccionado, 0).data();
    codigo_seleccioando = tabla.cell(indexSeleccionado, 1).data();
    n_serie_seleccionado = tabla.cell(indexSeleccionado, 7).data();
    fecha_seleccionada = tabla.cell(indexSeleccionado, 9).data();
    hora_seleccionada = tabla.cell(indexSeleccionado, 10).data();



});



//Catálogo de productos 
$('#BtnModalCatalogo').on('click', function () {
    $("#ModalCatalogoProductos").modal('show');
});

$("#ModalCatalogoProductos").on('hidden.bs.modal', function () {
    var lista = $('#lista_0');
    lista.empty();
    setTimeout(function () {
        if ($('#txt_lectura').val().trim() === '') {
            $('#txt_lectura').focus();
        } else {
            if (!$('#txtFactor').is('[readonly]')) {
                $('#txtFactor').val('').focus();
                return;
            }
            $('#txt_cantidad').val('').focus();
        }
    }, 100);
});

$("#ModalCatalogoProductos").on('shown.bs.modal', function () {
    $("#modalOpciones").modal('hide');
    consulta_lista_0('');
    $('#TxtLecturaCat').val('').focus();
});

$('#TxtLecturaCat').on('keyup', function (e) {
    if (e.keyCode === 13) {
        var lectura = $('#TxtLecturaCat').val().trim();
        consulta_lista_0(lectura);
    }
});

$('#BtnCatProd').on('click', function () {
    var lectura = $('#TxtLecturaCat').val().trim();
    consulta_lista_0(lectura);
});

function consulta_lista_0(lectura) {

    try {
        MuestraLoader('');
        var query = 'SELECT * FROM catalogos ORDER BY id_producto ASC LIMIT 100';
        if (lectura !== '') {
            query = "SELECT * FROM catalogos WHERE codigo_1='" + lectura + "' OR codigo_2='" + lectura + "' OR codigo_3='" + lectura + "' OR descripcion LIKE '%" + lectura + "%';";
        }

        var lista = $('#lista_0');
        lista.empty();

        ////#####SQLite
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //var dt = resultSet.rows.length;
                    //alert(JSON.stringify(dt));
                    for (var i = 0; i < resultSet.rows.length; i++) {

                        var id_productoCat = resultSet.rows.item(i).id_producto;
                        var codigo_1Cat = resultSet.rows.item(i).codigo_1.toString();
                        var codigo_2Cat = resultSet.rows.item(i).codigo_2.toString();
                        var codigo_3Cat = resultSet.rows.item(i).codigo_3.toString();

                        var descripcionCat = resultSet.rows.item(i).descripcion || '';
                        var precio_ventaCat = resultSet.rows.item(i).precio_venta || 0;
                        precio_ventaCat = Number(precio_venta).toFixed(2).toLocaleString();
                        var unidad_medidaCat = resultSet.rows.item(i).unidad_medida || '';
                        var cantidad_teorica = resultSet.rows.item(i).cantidad_teorica || 0;
                        var factorCat = resultSet.rows.item(i).factor || 0;
                        var fila = '<li class="list-group-item card mt-1 waves-effect" id="' + id_productoCat + '"> '
                            + '<div class="card-body card-body-cascade text-center m-0">'
                            + '<span class="card-title m-0">CÓDIGO: <strong>' + codigo_1Cat + '</strong></span>'
                            + '<h6 class="font-weight-bold indigo-text p-0">' + descripcionCat + '</h6>'
                            + '<p class="card-text m-0">';

                        if (codigo_2Cat !== '' && codigo_2Cat !== null) {
                            fila += '<label class="m-0">'
                                + 'SKU: <span class="font-weight-bold">' + codigo_2Cat + '</span>'
                                + '</label><br />';
                        }

                        if (codigo_3Cat !== '' && codigo_3Cat !== null) {
                            fila += '<label class="m-0">'
                                + 'CÓDIGO 3: <span class="font-weight-bold">' + codigo_3Cat + '</span>'
                                + '</label><br />';
                        }

                        if (unidad_medidaCat !== '' && unidad_medidaCat !== null) {
                            fila += '<label class="m-0">'
                                + 'UNIDAD DE MEDIDA: <span class="font-weight-bold">' + unidad_medidaCat + '</span>'
                                + '</label><br />';
                        }

                        //mostramos el factor
                        fila += '<label class="m-0">'
                            + 'FACTOR: <span class="font-weight-bold">' + factorCat.toLocaleString() + '</span>'
                            + '</label><br />';

                        fila += '<label class="m-0">'
                            + 'PRECIO DE VENTA: <span class="font-weight-bold">' + precio_ventaCat.toLocaleString() + '</span>'
                            + '</label><br />'
                            + '</p>'
                            + '<hr class="m-0"> '
                            + '<a class="btn btn-md btn-success btn-rounded" onclick="SeleccionaProductoCatalogo(' + id_productoCat + ');"> <i class="fas fa-check"></i> Aceptar </a> '
                            + '</div>'
                            + '</li >';

                        lista.append(fila);
                        $('#TxtLecturaCat').val('').focus();
                    }

                    OcultaLoader();
                    $('#TxtLecturaCat').val('').focus();
                });
        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });

        TotalProductos(lectura);
        ////ocultamos el loader

        $('#TxtLecturaCat').val('').focus();
    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
        $('#TxtLecturaCat').val('').focus();
    }

}

function SeleccionaProductoCatalogo(CodigoSelCat) {
    $('#txt_lectura').val(CodigoSelCat);
    ConsultaProductoPorId(CodigoSelCat);
    $("#ModalCatalogoProductos").modal('hide');

}

function ConsultaProductoPorId(lectura) {
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
        var query = "SELECT * FROM catalogos WHERE id_producto='" + lectura + "';";
        //alert(query);
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

                        unidadMedidaSeleccionado = '';
                        MuestraAlerta3('El código ' + lectura + ' no fue encontrado en el catálogo.', 'error');
                        suenaAlerta();
                        vibraAlerta(1000);

                        $('#lbl_descripcion').text('Producto no encontrado');
                        $('#seccionDescripcion').prop('hidden', false);
                        $('#txt_lectura').val('');
                        $('#txt_lote').val('');
                        $('#txt_fecha_caducidad').val('');

                        if ($('#chk_lotes').is(':checked')) {
                            $('#txt_lote').val('').focus();
                            return;
                        }
                        else if ($('#chk_n_series').is(':checked')) {
                            $('#modal_n_series').modal('show');
                            $('#txt_sn').val('').focus();
                            return;
                        }
                        else if (!$('#txtFactor').is('[readonly]')) {
                            $('#txtFactor').val('').focus();
                            return;
                        }
                        else if (!$('#txt_cantidad').is('[readonly]')) {
                            $('#txt_cantidad').val('').focus();
                            return;
                        }

                        codigo_forzado = 0;
                        limpia_campos();
                        PosicionaFoco();
                        return;
                    }
                    suenaExito();
                    id_seleccionado = resultSet.rows.item(0).id_producto;
                    var codigo_1 = resultSet.rows.item(0).codigo_1;
                    codigo_2_seleccionado = resultSet.rows.item(0).codigo_2 || '';
                    codigo_3_seleccionado = resultSet.rows.item(0).codigo_3 || '';

                    var descripcion = resultSet.rows.item(0).descripcion;
                    unidadMedidaSeleccionado = resultSet.rows.item(0).unidad_medida;
                    //var modelo = resultSet.rows.item(0).modelo;
                    //var marca = resultSet.rows.item(0).marca;
                    precio_venta = Number(resultSet.rows.item(0).precio_venta) || 0;
                    cantidad_teorica = Number(resultSet.rows.item(0).cantidad_teorica) || 0;
                    cantidadFactorSeleccionado = Number(resultSet.rows.item(0).factor) || 1;
                    codigo_forzado = 0;

                    $('#txt_lectura').val(codigo_1);
                    $('#lbl_descripcion').text(descripcion);
                    $('#seccionDescripcion').prop('hidden', false);
                    //MuestraAlerta3(descripcion, 'success_s');

                    if ($('#chk_lotes').is(':checked')) {
                        ConsultaLotes(codigo_2_seleccionado);
                        return;
                    }

                    if ($('#chk_n_series').is(':checked')) {
                        $('#modal_n_series').modal('show');
                        $('#txt_sn').val('').focus();
                        return;
                    }
                    if (!$('#txtFactor').is('[readonly]')) {
                        $('#txtFactor').val('').focus();
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

function TotalProductos(lectura) {

    base_datos.transaction(function (ts) {
        var n = $('#lista_0 li').length;
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
                    mensaje = 'Mostrando primeros ' + n + ' productos de ' + Number(n_productos).toLocaleString();
                }
                $('#lbl_total').html(mensaje);
                $('#TxtLecturaCat').val('').focus();
            });
        $('#TxtLecturaCat').val('').focus();
    }, function (error) {
        $('#lbl_total').html('0 coincidencias');
        alert(error.message);
    });

}
//////////


MuestraLoader('');

consulta_almacenes();

$('#btnExportar').on('click', function () {
    var datos_tabla = northwind.queryAll('registros');
    var x = datos_tabla.length;
    if (x === 0) {
        $('#modalOpciones').modal('hide');
        vibraAlerta(500);
        MuestraAlerta3('No hay registros para exportar', 'warning');
        return;
    }

    //$('#modalExportacion').modal('show');
    $(location).attr('href', 'inventario_exportacion_ssr.html?url=inventario');

});



document.addEventListener('deviceready', function () {
    // $(document).ready(function () {
    try {

        MuestraLoader('');
        // $('#fila_ubicacion').prop('hidden', true);
        // $('#fila_codigo').prop('hidden', true);
        // $('#fila_lote').prop('hidden', true);
        // $('#fila_caducidad').prop('hidden', true);
        // $('#fila_cantidad').prop('hidden', true);
        // $('#seccionDescripcion').prop('hidden', true);

        consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)

        consulta_lista_impresoras();
        consultaDatosServidor();
        //consulta_almacenes();
        consulta_datos_sesiones();
        AbreConexionBD();

        // $('#tablaTotales').prop('hidden', false);
        // $('#fila_ubicacion').prop('hidden', false);
        // $('#fila_codigo').prop('hidden', false);
        // $('#fila_cantidad').prop('hidden', false);
        limpia_campos();

        //si el fabricante del dispositivo es Huawei ocultamos la opción de capturar las coordenadas debido a que no funciona en el emulador
        if (fabricante_dispositivo === 'HUAWEI') {
            $('#SeccionGPS').css('visibility', 'hidden');
        }

        cargaConfiguracionesLectura();

        OcultaLoader();

        var strUbicacion = 'Almacén: ' + nombre_almacen + '\nUsuario: ' + usuario_conteo;
        if (ubicacionSeleccioanda.length > 0) {
            $('#txt_ubicacion').val(ubicacionSeleccioanda);
            strUbicacion = 'Almacén: ' + nombre_almacen + '\nUbicación: ' + ubicacionSeleccioanda + '\nUsuario: ' + usuario_conteo;
            consulta_inventario_local();
        }
        MuestraAlerta3(strUbicacion, 'success');


        $('#txt_lote').select2({
            placeholder: 'Lote',
            allowClear: true,
            tags: true,
            insertTag: function (data, tag) {
                // Insertamos el tag al final de los resultados
                data.push(tag);
            },
            dropdownCssClass: 'font-weight-bold',
            theme: 'bootstrap'
        });


        $('#txt_fecha_caducidad').select2({
            placeholder: 'Fecha de caducidad',
            allowClear: true,
            tags: true,
            insertTag: function (data, tag) {
                // Insertamos el tag al final de los resultados
                data.push(tag);
            },
            dropdownCssClass: 'font-weight-bold',
            theme: 'bootstrap'
        });



    } catch (err) {
        console.warn('Error: ' + err.message);
    }


});
