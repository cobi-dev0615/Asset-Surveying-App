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

var id_seleccionado = obtener_parametros_url('id').trim();
var url_previa = 'productos_catalogo.html';

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);
function onBackKeyDown() {
    $(location).attr('href', url_previa);
    return;
}

$('#btnCamaraCod1').on('click', function () {
    scan(1);
});

$('#btnCamaraCod2').on('click', function () {
    scan(2);
});

$('#btnCamaraCod3').on('click', function () {
    scan(3);
});

//escaneamos los códigos de barra
function scan(valor) {
    try {
        var mensaje_prompt = "captura el código principal del producto.";
        if (valor === 2) {
            mensaje_prompt = "Capture un código alterno del producto.";
        }
        else if (valor === 3) {
            mensaje_prompt = "Capture un código alterno del producto.";
        }
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                if (valor === 1) {
                    //escaneamos la ubicación
                    $('#txt_codigo_1').val(result.text).focus();
                }
                if (valor === 2) {
                    //escaneamos y consultamos el código del producto
                    $('#txt_codigo_2').val(result.text);
                }
                else if (valor === 3) {
                    //escanemos el número de lote del producto
                    $('#txt_codigo_3').val(result.text);
                }
            },
            function (error) {
                muestraAlerta3("Error de lectura: " + error, 'error');
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
//

//consultamos la lista de zonas registradas
function consultaProducto() {
    try {

        MuestraLoader('');
        var query = "SELECT * FROM catalogos WHERE id_producto=" + id_seleccionado;
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //alert(query);
                    //alert(JSON.stringify(resultSet.rows));
                    var dt = resultSet.rows.length;
                    if (dt === 0) {
                        OcultaLoader();
                        muestraAlerta1('Registro no encontrado');
                        $(location).attr('href', url_previa);
                        return;
                    }
                    //var id_producto = '';
                    var codigo_1 = resultSet.rows.item(0).codigo_1;
                    var codigo_2 = resultSet.rows.item(0).codigo_2;
                    var codigo_3 = resultSet.rows.item(0).codigo_3;
                    var descripcion = resultSet.rows.item(0).descripcion;
                    var modelo = resultSet.rows.item(0).modelo;
                    var marca = resultSet.rows.item(0).marca;
                    var precio_venta = Number(resultSet.rows.item(0).precio_venta).toFixed(3) || 0;
                    var cantidad_teorica = Number(resultSet.rows.item(0).cantidad_teorica) || 0;
                    var UnidadMedida =  resultSet.rows.item(0).unidad_medida;
                    $('#txt_codigo_1').val(codigo_1);
                    $('#txt_codigo_2').val(codigo_2);
                    $('#txt_codigo_3').val(codigo_3);
                    $('#txt_descripcion').val(descripcion);
                    $('#txtUnidadMedida').val(UnidadMedida);
                    $('#txt_precio_venta').val(precio_venta);
                    $('#txt_cantidad_teorica').val(cantidad_teorica);
                    OcultaLoader();
                   
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
//

function guardaRegistro() {
    try {
        var id_producto = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');
        id_producto = Number(id_producto);
        var codigo_1 = $('#txt_codigo_1').val().trim();
        var codigo_2 = $('#txt_codigo_2').val().trim();
        var codigo_3 = $('#txt_codigo_3').val().trim();
        var descripcion = $('#txt_descripcion').val().trim();
        var precio_venta = $('#txt_precio_venta').val();
        var cantidad_teorica = $('#txt_cantidad_teorica').val();
        var unidadMedida = $('#txtUnidadMedida').val();
        var forzado = 1;

        if (codigo_1 === '') {
            vibraAlerta(500);
            suenaError();
            muestraAlerta3('captura el código 1 del producto.', 'warning');
            $('#txt_codigo_1').val('').focus();
            return;
        }
        if (codigo_2 !== '') {
            if (codigo_1 === codigo_2) {
                vibraAlerta(500);
                suenaError();
                muestraAlerta3('El código 1 y 2 deben ser diferentes.', 'warning');
                $('#txt_codigo_2').focus();
                return;
            }
            if (codigo_3 !== '') {
                if (codigo_2 === codigo_3) {
                    vibraAlerta(500);
                    suenaError();
                    muestraAlerta3('El código 2 y 3 deben ser diferentes.', 'warning');
                    $('#txt_codigo_2').focus();
                    return;
                }
            }
        }

        if (codigo_3 !== '') {
            if (codigo_1 === codigo_3) {
                vibraAlerta(500);
                suenaError();
                muestraAlerta3('El código 1 y 3 deben ser diferentes.', 'warning');
                $('#txt_codigo_3').focus();
                return;
            }
        }

        if (descripcion === '') {
            vibraAlerta(500);
            suenaError();
            muestraAlerta3('captura la descripción del producto.', 'warning');
            $('#txt_descripcion').val('').focus();
            return;
        }

        MuestraLoader('');
        var dt = 0;
        var query = "SELECT codigo_1 FROM catalogos WHERE codigo_1='" + codigo_1 + "' OR codigo_2='" + codigo_1 + "' OR codigo_3='" + codigo_1 + "'";

        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //alert(query);
                    //alert(JSON.stringify(resultSet.rows));
                    dt = resultSet.rows.length;
                    //alert(dt);
                    if (dt > 0) {
                        suenaError();
                        OcultaLoader();
                        muestraAlerta3('El código ' + codigo_1 + ' ya está asignado a otro producto.', 'error');
                        $('#txt_codigo_1').focus();
                        return;
                    }
                    //
                    base_datos.transaction(function (ts) {
                        //alert(id_producto);
                        ts.executeSql('INSERT INTO catalogos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                            [id_inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, '', '', '', '', 0, unidadMedida, '', cantidad_teorica, 1, 0, 0, 0]);
                        //'inventario', 'id_producto', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'precio_venta', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'unidad_medida', 'observaciones', 'cantidad_teorica', 'forzado', 'sincronizado', 'eliminado'

                    }, function (error) {
                        //habilita_controles();
                        vibraAlerta(500);
                        suenaError();
                        OcultaLoader();
                        muestraAlerta3('Error: ' + error.message, 'error');
                    }, function () {
                        suenaExito();
                        OcultaLoader();
                        muestraAlerta3('Datos guardados exitosamente.', 'success');
                        $('#form_registro').hide();
                        $('#seccion_acciones').css('display', 'inherit');

                    });
                    //
                });

        }, function (error) {
            OcultaLoader();
            alert(error.message);
        });

        /*
        if (codigo_2 !== '') {
            query = "SELECT codigo_2 FROM catalogos WHERE codigo_1='" + codigo_2 + "' OR codigo_2='" + codigo_2 + "' OR codigo_3='" + codigo_2 + "'";
            base_datos.transaction(function (ts) {
                ts.executeSql(query, [],
                    function (ignored, resultSet) {
                        //alert(query);
                        //alert(JSON.stringify(resultSet.rows));
                        var dt = resultSet.rows.length;
                        if (dt > 0) {
                            suenaError();
                            OcultaLoader();
                            muestraAlerta1('El código ' + codigo_2 + ' ya está asignado a otro producto.');
                            return;
                        }

                        //
                        if (codigo_3 !== '') {
                            query = "SELECT codigo_3 FROM catalogos WHERE codigo_1='" + codigo_3 + "' OR codigo_2='" + codigo_3 + "' OR codigo_3='" + codigo_3 + "'";
                            base_datos.transaction(function (ts) {
                                ts.executeSql(query, [],
                                    function (ignored, resultSet) {
                                        //alert(query);
                                        //alert(JSON.stringify(resultSet.rows));
                                        var dt = resultSet.rows.length;
                                        if (dt > 0) {
                                            suenaError();
                                            OcultaLoader();
                                            muestraAlerta1('El código ' + codigo_3 + ' ya está asignado a otro producto.');
                                            return;
                                        }
                                    });

                            }, function (error) {
                                OcultaLoader();
                                alert(error.message);
                            });
                        }
                        //

                    });

            }, function (error) {
                OcultaLoader();
                alert(error.message);
            });
        }
        */

    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function editaRegistro() {
    try {
        //var id_producto = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');
        //id_producto = Number(id_producto);
        var codigo1 = $('#txt_codigo_1').val().trim();
        var codigo_2 = $('#txt_codigo_2').val().trim();
        var codigo_3 = $('#txt_codigo_3').val().trim();
        var descripcion = $('#txt_descripcion').val().trim();
        var precio_venta = $('#txt_precio_venta').val();
        var cantidad_teorica = $('#txt_cantidad_teorica').val();
        var unidadMedida = $('#txtUnidadMedida').val();
        var forzado = 1;

        if (codigo1 === '') {
            vibraAlerta(500);
            suenaError();
            muestraAlerta3('captura el código 1 del producto.', 'warning');
            $('#txt_codigo_1').val('').focus();
            return;
        }
        if (codigo_2 !== '') {
            if (codigo1 === codigo_2) {
                vibraAlerta(500);
                suenaError();
                muestraAlerta3('El código 1 y 2 deben ser diferentes.', 'warning');
                $('#txt_codigo_2').focus();
                return;
            }
            if (codigo_3 !== '') {
                if (codigo_2 === codigo_3) {
                    vibraAlerta(500);
                    suenaError();
                    muestraAlerta3('El código 2 y 3 deben ser diferentes.', 'warning');
                    $('#txt_codigo_2').focus();
                    return;
                }
            }
        }

        if (codigo_3 !== '') {
            if (codigo1 === codigo_3) {
                vibraAlerta(500);
                suenaError();
                muestraAlerta3('El código 1 y 3 deben ser diferentes.', 'warning');
                $('#txt_codigo_3').focus();
                return;
            }
        }

        if (descripcion === '') {
            vibraAlerta(500);
            suenaError();
            muestraAlerta3('captura la descripción del producto.');
            $('#txt_descripcion').val('').focus();
            return;
        }

        MuestraLoader('');
        var dt = 0;
        var query = "SELECT codigo_1 FROM catalogos WHERE (codigo_1='" + codigo1 + "' OR codigo_2='" + codigo1 + "' OR codigo_3='" + codigo1 + "') AND id_producto!=" + id_seleccionado + "";

        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    //alert(query);
                    //alert(JSON.stringify(resultSet.rows));
                    dt = resultSet.rows.length;
                    //alert(dt);
                    if (dt > 0) {
                        suenaError();
                        OcultaLoader();
                        muestraAlerta3('El código ' + codigo1 + ' ya está asignado a otro producto.', 'warning');
                        $('#txt_codigo_1').focus();
                        return;
                    }
                    //
                    base_datos.transaction(function (ts) {

                        ts.executeSql("UPDATE catalogos SET codigo_1='" + codigo1 + "', codigo_2='" + codigo_2 + "', codigo_3='" + codigo_3 + "', descripcion='" + descripcion + "', precio_venta='" + precio_venta + "', cantidad_teorica='" + cantidad_teorica + "', unidad_medida='"+unidadMedida+"' WHERE id_producto=" + id_seleccionado + "");
                        //'inventario', 'id_producto', 'codigo_1', 'codigo_2', 'codigo_3', 'descripcion', 'precio_venta', 'modelo', 'marca', 'categoria', 'subcategoria', 'precio_compra', 'unidad_medida', 'observaciones', 'cantidad_teorica', 'forzado', 'sincronizado', 'eliminado'

                        //alert(id_producto);
                        northwind.update('registros', { codigo_1: codigo1 }, function (fila) {
                            fila.codigo_1 = codigo1;
                            fila.codigo_2 = codigo_2;
                            fila.codigo_3 = codigo_3;
                            fila.descripcion = descripcion;
                            fila.precio_venta = precio_venta;
                            fila.unidad_medida = unidadMedida;
                            return fila;
                        });
                        northwind.commit();

                    }, function (error) {
                        //habilita_controles();
                        vibraAlerta(500);
                        suenaError();
                        OcultaLoader();
                        muestraAlerta3('Error: ' + error.message, 'error');
                    }, function () {
                        suenaExito();
                        OcultaLoader();
                        muestraAlerta3('Datos guardados exitosamente.', 'success');
                        $(location).attr('href', url_previa);

                        //OcultaLoader();
                    });
                    //
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

function LimpiaCampos() {
    $('#txt_codigo_1').val('');
    $('#txt_codigo_2').val('');
    $('#txt_codigo_3').val('');
    $('#txt_descripcion').val('');
    $('#txt_precio_venta').val('');
    $('#txt_cantidad_teorica').val('');
    $('#txt_codigo_1').focus();
}

$('#btn_nuevo_producto').on('click', function () {
    document.getElementById('form_registro').reset(); //reseteamos el formulario para un nuevo registro
    $('#form_registro').show();
    $('#seccion_acciones').css('display', 'none');
    $('#txt_codigo_1').focus();
});

$('#btn_guardar').click(function (e) {
    e.preventDefault();
    if (id_seleccionado !== '') {
        editaRegistro();
    }
    else {
        guardaRegistro();      
    }
});

$('#txt_codigo_1').on('keydown', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault();
        $('#txt_codigo_2').focus();
    }
});

$('#txt_codigo_2').on('keydown', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault();
        $('#txt_codigo_3').focus();
    }
});

$('#txt_codigo_3').on('keydown', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault();
        $('#txt_descripcion').focus();
    }
});

$('#txt_cantidad_teorica').on('keydown', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault();
    }
});

$('#btn_cancelar').on('click', function () {
    LimpiaCampos();
    //$(location).attr('href', url_previa);
});

$('#btn_salir').on('click', function () {
    $(location).attr('href', url_previa);
});


function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    abre_conexion_bd();
    if (id_seleccionado !== '') {
        $('#lblTitulo').html('<i class="fa fa-edit"></i> Editar producto');
        consultaProducto();
    }
    //$('#txt_codigo_1').focus();

    //validaPermisosUsuario();

    
    //
    //---
});