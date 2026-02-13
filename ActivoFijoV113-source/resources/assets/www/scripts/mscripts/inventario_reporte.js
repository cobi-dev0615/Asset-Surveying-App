var url_previa = 'inicio.html';
//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {

    if ($('#modalExportacion').hasClass('show')) {
        $('#modalExportacion').modal('hide');
        return;
    }
    if ($('#modalEliminarInventario').hasClass('show')) {
        $('#modalEliminarInventario').modal('hide');
        return;
    }
    if ($('#modalAyuda').hasClass('show')) {
        $('#modalAyuda').modal('hide');
        return;
    }
    //eliminaBannerAd();
    $(location).attr('href', url_previa);
}

$('#combo_tipo_reporte').on('change', function () {
    MuestraLoader('');
    muestraAlerta3('Consultando reporte...', 'success_l');
    setTimeout(function () { //tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
        //$('#tabla_datos').empty(); 
        var tipo_reporte = $('#combo_tipo_reporte').val();
        //$('#seccionDatosDiferencias').css('display', 'none');
        $('#seccionDatosDiferencias').removeClass('d-block');
        $('#seccionDatosDiferencias').addClass('d-none');

        $('#seccionTotales').removeClass('d-none');
        $('#seccionTotales').addClass('d-block');

        //$('#seccionDatosDiferencias').removeClass('col-7');
        //$('#seccionTotales').removeClass('col-5');

        //$('#seccionDatosDiferencias').addClass('col-5');
        //$('#seccionTotales').addClass('col-7');

        if (tipo_reporte === '0') {
            reporte_agrupacion_producto();
        }
        else if (tipo_reporte === '1') {
            reporte_agrupacion_producto_ubicacion();
        }
        else if (tipo_reporte === '2') {
            //$('#seccionDatosDiferencias').css('display', 'block');
            $('#seccionDatosDiferencias').removeClass('d-none');
            $('#seccionDatosDiferencias').addClass('d-block');

            $('#seccionTotales').removeClass('d-block');
            $('#seccionTotales').addClass('d-none');

            reporte_diferencias();


            //$('#seccionDatosDiferencias').removeClass('col-5');
            //$('#seccionTotales').removeClass('col-7');

            //$('#seccionDatosDiferencias').addClass('col-7');
            //$('#seccionTotales').addClass('col-5');
        }
        else if (tipo_reporte === '3') {
            reporte_conteo_detalle();
        }
        else if (tipo_reporte === '4') {
            reporteConteoCruzado();
        }
    }, 100);


});

function elimina_diferencias() {
    try {
        base_datos.transaction(function (ts) {
            ts.executeSql("UPDATE catalogos SET cantidad_real='0'");
        }, function (error) {
            alert(error.message);
        });
    } catch (err) {
        alert(err.message);
    }
}

function reporte_agrupacion_producto() {
    try {

        var datos_tabla = northwind.queryAll('registros');
        var x = datos_tabla.length;
        //alert(JSON.stringify(datos_tabla));
        //alert(x);
        if (x === 0) {
            calcula_totales();
            OcultaLoader();
            muestraAlerta3('No hay registros capturados.', 'warning');
            return;
        }
        MuestraLoader('');
        datos_tabla = alasql('SELECT SUM(cantidad*100)/100 AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, SUM(cantidad)*precio_venta AS importe FROM ? GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, importe', [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));

        tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
        $('#tabla_datos').empty(); // empty() en caso de que las columnas cambien

        //definimos una nueva tabla con sus propiedades
        tabla = $('#tabla_datos').DataTable({
            select: {
                style: 'single'
            },
            processing: true,
            //deferLoading: 57,
            ordering: false,
            order: [[1, 'asc']],
            bFilter: false,
            bInfo: false,
            bLengthChange: false,
            bStateSave: false, // saves sort state using localStorage
            paging: true,
            pageLength: 30,
            pagingType: 'numbers',
            dom: '<"top"pt>',
            scrollY: altoTabla,
            scrollX: true,
            searching: false,
            autoWidth: true,
            fixedColumns: {
                leftColumns: 1,
                rightColumns: 0
            },
            data: datos_tabla,
            columns: [
                { title: 'Cantidad', data: 'cantidad' },
                { title: 'Código 1', data: 'codigo_1' },
                { title: 'Código 2', data: 'codigo_2' },
                { title: 'Código 3', data: 'codigo_3' },
                { title: 'Descripción', data: 'descripcion' },
                { title: 'Precio Venta', data: 'precio_venta' },
                {
                    title: 'Importe', data: 'importe', className: '', width: '5%', render: function (data, type, row) {
                        return Number(data).toLocaleString();
                    }
                }
            ],
            columnDefs: [
                { className: 'small', 'targets': '_all' }
            ],
            createdRow: function (row, data, index) {
                //personalizamos las columnas deseadas
                $('td', row).eq(0).addClass('text-danger text-right font-weight-bold bg-white');
                $('td', row).eq(4).addClass('small');
                $('td', row).eq(5).addClass('text-right font-weight-bold');
                $('td', row).eq(6).addClass('text-primary text-right font-weight-bold');
            },
            drawCallback: function (settings) {
    
            },
            //cuando la tablaDatos se ha inicializado completamente
            initComplete: function (settings, json) {
                
    
            }

        });

        tabla.columns.adjust().draw(false);
        calcula_totales();
        OcultaLoader();

    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function reporte_agrupacion_producto_ubicacion() {
    try {

        var datos_tabla = northwind.queryAll('registros');
        var x = datos_tabla.length;
        //alert(JSON.stringify(datos_tabla));
        //alert(x);
        if (x === 0) {
            calcula_totales();
            OcultaLoader();
            muestraAlerta3('No hay registros capturados.', 'warning');
            return;
        }
        MuestraLoader('');
        datos_tabla = alasql('SELECT SUM(cantidad*100)/100 AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, SUM(cantidad)*precio_venta AS importe, nombre_almacen, ubicacion FROM ? GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, importe, nombre_almacen, ubicacion', [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));

        tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
        $('#tabla_datos').empty(); // empty() en caso de que las columnas cambien

        //definimos una nueva tabla con sus propiedades
        tabla = $('#tabla_datos').DataTable({
            select: {
                style: 'single'
            },
            processing: true,
            //deferLoading: 57,
            ordering: false,
            order: [[1, 'asc']],
            bFilter: false,
            bInfo: false,
            bLengthChange: false,
            bStateSave: false, // saves sort state using localStorage

            paging: true,
            pageLength: 30,
            pagingType: 'numbers',
            dom: '<"top"pt>',

            scrollY: altoTabla,
            scrollX: true,
            searching: false,
            autoWidth: true,
            fixedColumns: {
                leftColumns: 1,
                rightColumns: 0
            },
            data: datos_tabla,
            columns: [
                { title: 'Cantidad', data: 'cantidad' },
                { title: 'Código 1', data: 'codigo_1' },
                { title: 'Código 2', data: 'codigo_2' },
                { title: 'Código 3', data: 'codigo_3' },
                { title: 'Descripción', data: 'descripcion' },
                //{ title: 'Precio Venta', data: 'precio_venta' },
                //{ title: 'Importe', data: 'importe' },

                {
                    //className asigna la clase a toda la columna incluyendo la cabecera
                    title: 'Precio Venta', data: 'precio_venta', className: '', width: '5%', render: function (data, type, row) {
                        return Number(data);
                    }
                },
                {
                    title: 'Importe', data: 'importe', className: '', width: '5%', render: function (data, type, row) {
                        return Number(data).toLocaleString();
                    }
                },

                { title: 'Nombre Almacén', data: 'nombre_almacen' },
                { title: 'Ubicación', data: 'ubicacion' }



            ],
            columnDefs: [
                { className: 'small', 'targets': '_all' }
            ],
            createdRow: function (row, data, index) {
                //personalizamos las columnas deseadas
                $('td', row).eq(0).addClass('text-danger text-right font-weight-bold bg-white');
                $('td', row).eq(4).addClass('small');
                $('td', row).eq(5).addClass('text-right font-weight-bold');
                $('td', row).eq(6).addClass('text-primary text-right font-weight-bold');
            }
        });

        tabla.columns.adjust().draw(false);
        calcula_totales();
        OcultaLoader();

    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function reporte_conteo_detalle() {
    try {

        var datos_tabla = northwind.queryAll('registros');
        //creaDirectoriosExtras('datosInventario.json', JSON.stringify(datos_tabla));

        var x = datos_tabla.length;

        console.log(JSON.stringify(datos_tabla));

        
        if (x === 0) {
            calcula_totales();
            OcultaLoader();
            muestraAlerta3('No hay registros capturados.', 'warning');
            return;
        }
        MuestraLoader('');
        datos_tabla = alasql('SELECT cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad*precio_venta AS importe, lote, fecha_caducidad, n_serie, nombre_almacen, ubicacion, nombre_usuario, latitud, longitud, fecha_captura, hora_captura, unidad_medida, n_conteo, factor, total_factor, fecha_elaboracion FROM ?', [datos_tabla]);
        //console.log.(JSON.stringify(datos_tabla));

        tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
        $('#tabla_datos').empty(); // empty() en caso de que las columnas cambien

        //definimos una nueva tabla con sus propiedades
        tabla = $('#tabla_datos').DataTable({
            select: {
                style: 'single'
            },
            processing: true,
            //deferLoading: 57,
            ordering: false,
            //order: [[2, "asc"]],
            bFilter: false,
            bInfo: false,
            bLengthChange: false,
            bStateSave: false, // saves sort state using localStorage

            paging: true,
            pageLength: 30,
            pagingType: 'numbers',
            dom: '<"top"pt>',

            scrollY: altoTabla,
            scrollX: true,
            searching: false,
            autoWidth: true,
            fixedColumns: {
                leftColumns: 1,
                rightColumns: 0
            },
            data: datos_tabla,
            columns: [
                { title: 'Cantidad', data: 'cantidad' },
                { title: 'Código 1', data: 'codigo_1' },
                { title: 'Código 2', data: 'codigo_2' },
                { title: 'Código 3', data: 'codigo_3' },
                { title: 'Descripción', data: 'descripcion' },
                { title: 'Conteo', data: 'n_conteo' },
                { title: 'Precio Venta', data: 'precio_venta' },
                {
                    title: 'Importe', data: 'importe', className: '', width: '5%', render: function (data, type, row) {
                        return Number(data).toLocaleString();
                    }
                },
                { title: 'Unidad Medida', data: 'unidad_medida' },
                { title: 'Lote', data: 'lote' },
                { title: 'Fecha Caducidad', data: 'fecha_caducidad' },
                { title: 'Numero Serie', data: 'n_serie' },
                { title: 'Almacén', data: 'nombre_almacen' },
                { title: 'Ubicacion', data: 'ubicacion' },
                { title: 'Usuario', data: 'nombre_usuario' },
                { title: 'Latitud', data: 'latitud' },
                { title: 'Longitud', data: 'longitud' },
                { title: 'Fecha Captura', data: 'fecha_captura' },
                { title: 'Hora Captura', data: 'hora_captura' }, 
                { title: 'Factor', data: 'factor' },
                { title: 'Total Factor', data: 'total_factor' },
                { title: 'Fecha Elaboración', data: 'fecha_elaboracion' }

            ],
            columnDefs: [
                { className: 'small', 'targets': '_all' }
            ],
            createdRow: function (row, data, index) {
                //personalizamos las columnas deseadas
                $('td', row).eq(0).addClass('text-danger text-right font-weight-bold bg-white');
                $('td', row).eq(4).addClass('small');
                $('td', row).eq(5).addClass('text-right font-weight-bold');
                $('td', row).eq(6).addClass('text-primary text-right font-weight-bold');
            }

        });

        tabla.columns.adjust().draw(false);
        calcula_totales();
        OcultaLoader();

    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function reporte_diferencias() {
    try {
        var datos_tabla = [];

        MuestraLoader('');
        var query = "SELECT codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad_teorica, cantidad_real FROM catalogos WHERE cantidad_real != '0'";
        base_datos.transaction(function (ts) {
            ts.executeSql(query, [],
                function (ignored, resultSet) {
                    var x = resultSet.rows.length;
                    if (x === 0) {
                        calcula_totales();
                        OcultaLoader();
                        muestraAlerta3('No hay registros capturados.', 'warning');
                    }
                    //alert(JSON.stringify(x));
                    for (var i = 0; i < x; i++) {

                        var codigo_1 = resultSet.rows.item(i).codigo_1;
                        var codigo_2 = resultSet.rows.item(i).codigo_2;
                        var codigo_3 = resultSet.rows.item(i).codigo_3;
                        var descripcion = resultSet.rows.item(i).descripcion;

                        var precio_venta = resultSet.rows.item(i).precio_venta || 0;

                        var cantidad_teorica = resultSet.rows.item(i).cantidad_teorica || 0;
                        var cantidad_real = resultSet.rows.item(i).cantidad_real || 0;

                        var importe_teorico = precio_venta * cantidad_teorica;
                        var importe_real = precio_venta * cantidad_real;

                        var diferencia_cantidad = cantidad_real - cantidad_teorica;
                        var diferencia_importe = importe_real - importe_teorico;

                        if (cantidad_real !== 0) {
                            datos_tabla.push({
                                'codigo_1': codigo_1, 'codigo_2': codigo_2, 'codigo_3': codigo_3, 'descripcion': descripcion, 'precio_venta': precio_venta, 'cantidad_teorica': cantidad_teorica, 'cantidad_real': cantidad_real, 'importe_teorico': importe_teorico.toFixed(3), 'importe_real': importe_real.toFixed(3), 'diferencia_cantidad': diferencia_cantidad.toFixed(3), 'diferencia_importe': diferencia_importe.toFixed(3)
                            });
                        }

                    }

                });
        }, function (error) {
            OcultaLoader();
            alert(error.message);
        }, function () {

            //alert(JSON.stringify(datos_tabla));

            tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
            $('#tabla_datos').empty(); // empty() en caso de que las columnas cambien

            //definimos una nueva tabla con sus propiedades
            tabla = $('#tabla_datos').DataTable({
                select: {
                    style: 'single'
                },
                processing: true,
                //deferLoading: 57,
                ordering: false,
                order: [[2, "asc"]],
                bFilter: false,
                bInfo: false,
                bLengthChange: false,
                paging: false,
                bStateSave: false, // saves sort state using localStorage
                scrollY: altoTabla,
                scrollX: true,
                searching: false,
                autoWidth: true,
                data: datos_tabla,
                columns: [

                    { title: 'Código 1', data: 'codigo_1' },
                    { title: 'Código 2', data: 'codigo_2' },
                    { title: 'Código 3', data: 'codigo_3' },
                    { title: 'Descripción', data: 'descripcion' },
                    { title: 'Precio Venta', data: 'precio_venta' },
                    { title: 'Cantidad Real', data: 'cantidad_real' },
                    { title: 'Cantidad Teórica', data: 'cantidad_teorica' },
                    { title: 'Diferencia Cantidad', data: 'diferencia_cantidad' },
                    { title: 'Importe Real', data: 'importe_real' },
                    { title: 'Importe Teórico', data: 'importe_teorico' },
                    { title: 'Diferencia Importe', data: 'diferencia_importe' }

                ],
                columnDefs: [
                    { className: 'small', 'targets': '_all' }
                ],
                createdRow: function (row, data, index) {
                    //personalizamos las columnas deseadas
                    var dc = Number(data.diferencia_cantidad);
                    var di = Number(data.diferencia_importe);

                    var estiloDif = '';
                    if (dc < 0) {
                        estiloDif = 'bg-danger text-white text-right font-weight-bold';
                    } else if (dc === 0) {
                        estiloDif = 'bg-success text-white text-right font-weight-bold';
                    } else if (dc > 0) {
                        estiloDif = 'bg-warning text-white text-right font-weight-bold';
                    }
                    $('td', row).eq(7).addClass(estiloDif);
                    if (di < 0) {
                        estiloDif = 'bg-danger text-white text-right font-weight-bold';
                    } else if (di === 0) {
                        estiloDif = 'bg-success text-white text-right font-weight-bold';
                    } else if (di > 0) {
                        estiloDif = 'bg-warning text-white text-right font-weight-bold';
                    }


                    $('td', row).eq(10).addClass(estiloDif);
                }

            });

            tabla.columns.adjust().draw(false);



            OcultaLoader();
            calcula_totales();

        });

    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function genera_reporte_diferencias() {

    var datos_tabla = northwind.queryAll('registros');
    datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1 FROM ? GROUP BY codigo_1', [datos_tabla]);
    //alert(JSON.stringify(datos_tabla));

    var x = datos_tabla.length;
    if (x === 0) {
        OcultaLoader();
        return;
    }

    function consigueJSONDelay() {
        var d = $.Deferred();
        setTimeout(function () {
            d.resolve(datos_tabla);
        }, 150);
        return $.when(d);
    }

    try {
        var cantidad = '';
        var codigo_1 = '';
        var descripcion = '';
        var precio_venta = 0;
        var importe = 0;

        consigueJSONDelay().then(function (jsonObjectArray) {
            //exceljson = [];
            base_datos.transaction(function (ts) {
                $.each(jsonObjectArray, function (index, dato_tabla) {

                    cantidad = dato_tabla.cantidad;
                    codigo_1 = dato_tabla.codigo_1;
                    //importe = dato_tabla.importe;

                    var query = "UPDATE catalogos SET cantidad_real='" + cantidad + "' WHERE codigo_1='" + codigo_1 + "'";
                    //alert(query);
                    ts.executeSql(query);

                });
            }, function (error) {
                alert(error.message);
            }, function () {
                //alert('ok');
            });
        });
    }
    catch (err) {
        OcultaLoader();
        muestraAlerta1(err.message);
    }
}

/////
function reporteConteoCruzado() {
    try {

        var datos_tabla = northwind.queryAll('registros_cruzados');
        //creaDirectoriosExtras('datosInventario.json', JSON.stringify(datos_tabla));

        var x = datos_tabla.length;

        //alert(JSON.stringify(datos_tabla));
        //alert(x);
        if (x === 0) {
            calcula_totales();
            OcultaLoader();
            muestraAlerta3('No hay registros capturados.', 'warning');
            return;
        }
        MuestraLoader('');


        var arrA = alasql('SELECT * FROM ? WHERE n_conteo="1"', [datos_tabla]);

        console.log('arrA: ' + JSON.stringify(arrA));

        var arrB = alasql('SELECT * FROM ? WHERE n_conteo="2"', [datos_tabla]);

        console.log('arrB: ' + JSON.stringify(arrB));

        /////aquí empieza lo bueno

        var arrC = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, ROUND(SUM(cantidad)*precio_venta, 3) AS importe, nombre_almacen, ubicacion FROM ? GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, nombre_almacen, ubicacion', [arrA]);

        $('#res1').text(JSON.stringify(arrC));

        //conteo 2
        var arrD = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, ROUND(SUM(cantidad)*precio_venta, 3) AS importe, nombre_almacen, ubicacion FROM ? GROUP BY codigo_1, codigo_2, codigo_3, descripcion, precio_venta, nombre_almacen, ubicacion', [arrB]);

        //$('#res2').text(JSON.stringify(arrD));


        var arrE = alasql('SELECT arrC.codigo_1, arrC.codigo_2, arrC.codigo_3, arrC.descripcion, arrC.nombre_almacen, arrC.ubicacion, arrC.cantidad AS conteo_1, arrD.cantidad AS conteo_2, arrC.cantidad - arrD.cantidad AS diferencia FROM ? arrC INNER JOIN ? arrD ON arrC.codigo_1=arrD.codigo_1', [arrC, arrD]);

        //$('#res3').text(JSON.stringify(arrE));

        var arrF = alasql('SELECT arrD.codigo_1, arrD.codigo_2, arrD.codigo_3, arrD.descripcion, arrD.nombre_almacen, arrD.ubicacion, 0 AS conteo_1, arrD.cantidad AS conteo_2,  0 -arrD.cantidad AS diferencia FROM ? arrD SEMI JOIN ? arrE ON arrD.codigo_1=arrE.codigo_1', [arrD, arrE]);


        //$('#res4').text(JSON.stringify(arrF));


        var arrG = alasql('SELECT * FROM ? arrE UNION ALL CORRESPONDING  SELECT * FROM ? arrF', [arrE, arrF]);
        // $('#res5').text(JSON.stringify(arrG));



        tabla.destroy(); //método para destruir una tabla existente, esto nos permite inicializar una nueva en su lugar
        $('#tabla_datos').empty(); // empty() en caso de que las columnas cambien

        //definimos una nueva tabla con sus propiedades
        tabla = $('#tabla_datos').DataTable({
            select: {
                style: 'single'
            },
            processing: true,
            //deferLoading: 57,
            ordering: false,
            //order: [[2, "asc"]],
            bFilter: false,
            bInfo: false,
            bLengthChange: false,
            bStateSave: false, // saves sort state using localStorage

            paging: true,
            pageLength: 30,
            pagingType: 'numbers',
            dom: '<"top"pt>',

            scrollY: altoTabla,
            scrollX: true,
            searching: false,
            autoWidth: true,
            data: arrG,
            columns: [

                { title: 'Código 1', data: 'codigo_1' },
                { title: 'Código 2', data: 'codigo_2' },
                { title: 'Código 3', data: 'codigo_3' },
                { title: 'Descripción', data: 'descripcion' },
                //{ title: 'Precio Venta', data: 'precio_venta' },
                //{ title: 'Importe', data: 'importe' },
                //{ title: 'Lote', data: 'lote' },
                //{ title: 'Fecha Caducidad', data: 'fecha_caducidad' },
                //{ title: 'Numero Serie', data: 'n_serie' },
                { title: 'Almacén', data: 'nombre_almacen' },
                { title: 'Ubicacion', data: 'ubicacion' },
                //{ title: 'Usuario', data: 'nombre_usuario' },
                //{ title: 'Latitud', data: 'latitud' },
                //{ title: 'Longitud', data: 'longitud' },
                //{ title: 'Fecha Captura', data: 'fecha_captura' },
                //{ title: 'Hora Captura', data: 'hora_captura' }, 
                { title: 'Conteo 1', data: 'conteo_1' },
                { title: 'Conteo 2', data: 'conteo_2' },
                { title: 'Diferencia', data: 'diferencia' }

            ],
            columnDefs: [
                { className: 'small', 'targets': '_all' }
            ]

        });

        tabla.columns.adjust().draw(false);
        calcula_totales();
        OcultaLoader();

    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


function imprime_reporte() {
    try {
        //$('#combo_tipo_reporte').val('0');

        var n_filas = tabla.rows().count();
        if (n_filas === 0) {
            suenaError();
            vibraAlerta(500);
            muestraAlerta3('No hay inventario para imprimir.', 'warning');
            return;
        }

        MuestraLoader('Conectando a ' + nombre_impresora_0 + '\n' + mac_impresora_0);

        var datos_tabla = northwind.queryAll('registros');
        datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, codigo_1, codigo_2, descripcion, precio_venta, SUM(cantidad)*precio_venta AS importe FROM ? GROUP BY codigo_1, codigo_2, descripcion, precio_venta, importe', [datos_tabla]);
        //alert(JSON.stringify(datos_tabla));

        var fecha = strFecha(0);
        var cantidad_reporte = '';
        var codigo_reporte = '';
        var descripcion_reporte = '';
        var datos_reporte = '';
        var conteo_total = $('#lbl_n_productos').text();
        var importe_inventario = $('#lbl_importe_inventario').text();

        var nRegistros = $('#lbl_n_registros').text();
        var nAlmacences = $('#lblNAlmacenes').text();
        var nUbicaciones = $('#lblNUbicaciones').text();

        var conteoReal = $('#lblInventarioReal').text();
        var conteoTeorico = $('#lblInventarioTeorico').text();
        var conteoDiferencia = $('#lblInventarioDiferencia').text();
        var importeReal = $('#lblImporteRealTotal').text();
        var importeTeorico = $('#lblImporteTeoricoTotal').text();
        var importeDiferecia = $('#lblImporteDiferencia').text();


        ////agrupamos los datos del arreglo para sumar las cantidades 
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

        var il = 320;
        var cantidad = '';
        var codigo_1 = '';
        var descripcion = '';
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
                datos_ticket_zebra += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 5) + '    ' + codigo_1 + '\r\n';
                il += 20;
                datos_ticket_zebra += 'T 7 0 25 ' + il.toString() + ' ' + descripcion.substring(0, 30) + '\r\n';
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
            + 'T 5 0 25 25 REPORTE GRAL INVENTARIO\r\n'
            + 'T 7 0 25 50 Fecha consulta: ' + fecha + '\r\n'
            + 'T 7 0 25 75 ' + conteo_total + '\r\n'
            + 'T 7 0 25 100 ' + importe_inventario + '\r\n'

            + 'T 7 0 25 125 ' + nRegistros + '\r\n'
            + 'T 7 0 25 150 ' + nAlmacences + '\r\n'
            + 'T 7 0 25 175 ' + nUbicaciones + '\r\n'


            + 'T 5 0 25 200 ***************************\r\n'
            + 'T 5 0 25 230 CANT         CÓDIGO\r\n'
            + 'T 5 0 25 260 DESCRIPCIÓN\r\n'
            + 'T 5 0 25 290 ***************************\r\n'
            + datos_ticket_zebra
            + 'PRINT\r\n';

        ticket_zebra = normalizaStr(ticket_zebra);

        //ticket ESC/POS
        var esc = '\x1B'; //ESC byte in hex notation
        var newLine = '\x0A'; //LF byte in hex notation
        var ticket_cf = esc + '!\x10'; //Double-height + Double-width mode ESC ! 10 + 20
        ticket_cf += esc + '\x61\x01'; //Align center
        //ticket_cf += btoa(logo_empresa);
        ticket_cf += 'REPORTE GENERAL DE INVENTARIO\r\n';
        ticket_cf += esc + '!\x00'; //Font A
        ticket_cf += esc + '\x61\x00';  //Align left
        //ticket_cf += esc + '!\x21!\x00'; //Font A
        ticket_cf += 'Fecha de consulta ' + strFecha(0) + ' ' + strHora() + '\r\n';
        ticket_cf += conteo_total + '\r\n';
        ticket_cf += importe_inventario + '\r\n';

        ticket_cf += nRegistros + '\r\n';
        ticket_cf += nAlmacences + '\r\n';
        ticket_cf += nUbicaciones + '\r\n';

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
        ticket_cf += esc + '\x61\x00'; //Align left
        //ticket_cf += '********************************\r\n';

        ticket_cf += '__\r\n';
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
            muestraAlerta3('Impresora no compatible, verifíca los modelos compatibles en las configuraciones de la aplicación', 'error');
        }


    } catch (err) {
        OcultaLoader();
        vibraAlerta(1000);
        muestraAlerta1(err.message);
    }
}

function calcula_totales() {

    var n_filas = tabla.rows().count();


    var tipo_reporte = $('#combo_tipo_reporte').val();
    if (tipo_reporte === '2') {
        //calculamos los totales generales para este reporte

        var cant_real = tabla.column(5).data().sum().toLocaleString();
        var cant_teo = tabla.column(6).data().sum().toLocaleString();
        var dif_cant = tabla.column(7).data().sum().toLocaleString();

        var imp_real = tabla.column(8).data().sum().toLocaleString();
        var imp_teo = tabla.column(9).data().sum().toLocaleString();
        var dif_importe = tabla.column(10).data().sum().toLocaleString();


        $('#lblInventarioReal').html('Conteo total: <strong>' + cant_real.toLocaleString() + '</strong>');
        $('#lblInventarioTeorico').html('Conteo teórico: <strong>' + cant_teo.toLocaleString() + '</strong>');
        $('#lblInventarioDiferencia').html('Diferencia: ' + dif_cant.toLocaleString());

        $('#lblImporteRealTotal').html('Valor de inventario contado: <strong>' + imp_real.toLocaleString() + '</strong>');
        $('#lblImporteTeoricoTotal').html('Valor de inventario teórico: <strong>' + imp_teo.toLocaleString() + '</strong>');
        $('#lblImporteDiferencia').text('Diferencia: ' + dif_importe.toLocaleString());

        $('#avanceInventario').html('15%');

    }

    if (tipo_reporte === '3') { 
        //reporte a detalle
        var n_productos = tabla.column(0).data().sum();
        var importe = tabla.column(7).data().sum();
        $('#lbl_n_productos').text('Conteo total: ' + n_productos.toLocaleString());
        $('#lbl_n_registros').html('Registros:  <strong>' + n_filas + '</strong>');
        $('#lbl_importe_inventario').html('Valor de inventario: <strong>' + importe.toLocaleString() + ' </strong>');
    } else { 
        //reportes agrupados por producto y ubicación
        var n_productos = tabla.column(0).data().sum();
        var importe = tabla.column(6).data().sum();
        $('#lbl_n_productos').text('Conteo total: ' + n_productos.toLocaleString());
        $('#lbl_n_registros').html('Registros:  <strong>' + n_filas + '</strong>');
        $('#lbl_importe_inventario').html('Valor de inventario: <strong>' + importe.toLocaleString() + ' </strong>');
    }
}

function calculaNUbicaciones() {

    var datos_tabla = northwind.queryAll('registros', {
        distinct: ['nombre_almacen']
    });

    $('#lblNAlmacenes').html('Almacenes visitados:  <strong>' + datos_tabla.length + '</strong>');

    datos_tabla = northwind.queryAll('registros', {
        distinct: ['ubicacion']
    });

    $('#lblNUbicaciones').html('Ubicaciones visitadas:  <strong>' + datos_tabla.length + '</strong>');


}

$('#tabla_datos tbody').on('click', 'tr', function () {

    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected');
    }
    else {
        $('#tabla_datos').DataTable().$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    }

});

$('#btn_imprimir').on('click', function () {
    imprime_reporte();
});

function exporta_datos_csv(n) { //1: WA, 2: Mail, 3: CSV
    try {
        //var datos_array = tabla.column(0).data().toArray(); //toArray(): crea un array nativo de Javascript array con los datos de la columna deseada
        //alert(JSON.stringify(datos_array));
        //return;
        MuestraLoader('');
        var archivo_nombre = '';
        var datos = '';
        var datos_tabla = '';
        var x = 0;
        var i = 0;
        var conteo_total = '"' + $('#lbl_n_productos').text().toUpperCase() + '"';
        var importe_inventario = '"' + $('#lbl_importe_inventario').text().toUpperCase() + '"';
        var nRegistros = '"' + $('#lbl_n_registros').text().toUpperCase() + '"';
        var nAlmacences = '"' + $('#lblNAlmacenes').text().toUpperCase() + '"';
        var nUbicaciones = '"' + $('#lblNUbicaciones').text().toUpperCase() + '"';

        var conteoReal = '"' + $('#lblInventarioReal').text().toUpperCase() + '"';
        var conteoTeorico = '"' + $('#lblInventarioTeorico').text().toUpperCase() + '"';
        var conteoDiferencia = '"' + $('#lblInventarioDiferencia').text().toUpperCase() + '"';
        var importeReal = '"' + $('#lblImporteRealTotal').text().toUpperCase() + '"';
        var importeTeorico = '"' + $('#lblImporteTeoricoTotal').text().toUpperCase() + '"';
        var importeDiferecia = '"' + $('#lblImporteDiferencia').text().toUpperCase() + '"';

        var tipo_reporte = $('#combo_tipo_reporte').val();
        if (tipo_reporte === '0') {
            archivo_nombre = 'ConteoPorProducto ' + strFecha(0) + 'at' + strHora().replace(/:/g, '.') + '.csv';
            //cabeceras de las columnas del archivo de salida
            datos = 'Cantidad, Codigo1, Codigo2, Codigo3, Descripcion, PrecioVenta, Importe\n';
            //datos de la tabla para el archivo de salida
            for (i = 0; i < tabla.rows().count(); i++) {
                datos_tabla = tabla.row(i).data();
                //alert(JSON.stringify(datos_tabla));

                datos += datos_tabla.cantidad +
                    ', ' + datos_tabla.codigo_1.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_2.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_3.replace(/,/g, '') +
                    ', ' + datos_tabla.descripcion.replace(/,/g, '') +
                    ', ' + datos_tabla.precio_venta +
                    ', ' + datos_tabla.importe +
                    '\n';
            }
            datos += '\n\n' + conteo_total + '\n' + importe_inventario + '\n' + nRegistros;
        }
        else if (tipo_reporte === '1') {
            archivo_nombre = 'ConteoPorProductoUbicacion ' + strFecha(0) + 'at' + strHora().replace(/:/g, '.') + '.csv';
            //cabeceras de la tabla para el archivo de salida
            datos = 'Cantidad, Codigo1, Codigo2, Codigo3, Descripcion, PrecioVenta, Importe,  NombreAlmacen, Ubicacion\n';
            //datos de la tabla para el archivo de salida
            for (i = 0; i < tabla.rows().count(); i++) {
                datos_tabla = tabla.row(i).data();
                //alert(JSON.stringify(datos_tabla));

                datos += datos_tabla.cantidad +
                    ', ' + datos_tabla.codigo_1.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_2.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_3.replace(/,/g, '') +
                    ', ' + datos_tabla.descripcion.replace(/,/g, '') +
                    ', ' + datos_tabla.precio_venta +
                    ', ' + datos_tabla.importe +
                    ', ' + datos_tabla.nombre_almacen +
                    ', ' + datos_tabla.ubicacion +
                    '\n';
            }
            datos += '\n\n' + conteo_total + '\n' + importe_inventario + '\n' + nRegistros + '\n' + nAlmacences + '\n' + nUbicaciones;
        }

        else if (tipo_reporte === '3') {

            archivo_nombre = 'ConteoADetalle ' + strFecha(0) + 'at' + strHora().replace(/:/g, '.') + '.csv';
            //cabeceras de las columnas del archivo de salida
            datos = 'Cantidad, Codigo1, Codigo2, Codigo3, Descripcion, Conteo, PrecioVenta, Importe, UnidadMedida, Lote, NSerie, FechaCaducidad, NombreAlmacen, Ubicacion, NombreUsuario, Latitud, Longitud, FechaCaptura, HoraCaptura, Factor, TotalFactor, FechaElaboracion\n';
            //datos_tabla = northwind.queryAll('registros');
            //datos_tabla = alasql('SELECT cantidad, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, cantidad*precio_venta AS importe, lote, fecha_caducidad, n_serie, nombre_almacen, ubicacion, nombre_usuario, latitud, longitud, fecha_captura, hora_captura FROM ?', [datos_tabla]);
            //x = datos_tabla.length;
            for (i = 0; i < tabla.rows().count(); i++) {
                datos_tabla = tabla.row(i).data();
                //alert(JSON.stringify(datos_tabla));

                datos += datos_tabla.cantidad +
                    ', ' + datos_tabla.codigo_1.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_2.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_3.replace(/,/g, '') +
                    ', ' + datos_tabla.descripcion.replace(/,/g, '') +
                    ', ' + datos_tabla.n_conteo +
                    ', ' + datos_tabla.precio_venta +
                    ', ' + datos_tabla.importe +
                    ', ' + datos_tabla.unidad_medida +
                    ', ' + datos_tabla.lote.replace(/,/g, '') +
                    ', ' + datos_tabla.n_serie.replace(/,/g, '') +
                    ', ' + datos_tabla.fecha_caducidad.replace(/,/g, '') +
                    ', ' + datos_tabla.nombre_almacen.replace(/,/g, '') +
                    ', ' + datos_tabla.ubicacion.replace(/,/g, '') +
                    ', ' + datos_tabla.nombre_usuario.replace(/,/g, '') +
                    ', ' + datos_tabla.latitud +
                    ', ' + datos_tabla.longitud +
                    ', ' + datos_tabla.fecha_captura +
                    ', ' + datos_tabla.hora_captura + 
                    ', ' + datos_tabla.factor +
                    ', ' + datos_tabla.total_factor +
                    ', ' + datos_tabla.fecha_elaboracion + '\n';
                '\n';
            }


            //$.each(datos_tabla, function (index, dato_tabla) {

            //    datos += dato_tabla.cantidad +
            //        ', ' + dato_tabla.codigo_1.replace(/,/g, '') +
            //        ', ' + dato_tabla.codigo_2.replace(/,/g, '') +
            //        ', ' + dato_tabla.codigo_3.replace(/,/g, '') +
            //        ', ' + dato_tabla.descripcion.replace(/,/g, '') +
            //        ', ' + dato_tabla.precio_venta +
            //        ', ' + '"' + dato_tabla.importe.toLocaleString() + '"' +
            //        ', ' + dato_tabla.lote.replace(/,/g, '') +
            //        ', ' + dato_tabla.n_serie.replace(/,/g, '') +
            //        ', ' + dato_tabla.fecha_caducidad.replace(/,/g, '') +

            //        ', ' + dato_tabla.nombre_almacen.replace(/,/g, '') +
            //        ', ' + dato_tabla.ubicacion.replace(/,/g, '') +
            //        ', ' + dato_tabla.nombre_usuario.replace(/,/g, '') +
            //        ', ' + dato_tabla.latitud +
            //        ', ' + dato_tabla.longitud +
            //        ', ' + dato_tabla.fecha_captura +
            //        ', ' + dato_tabla.hora_captura + '\n';


            //});



            datos += '\n\n' + conteo_total + '\n' + importe_inventario + '\n' + nRegistros + '\n' + nAlmacences + '\n' + nUbicaciones;
        }


        else if (tipo_reporte === '2') {

            archivo_nombre = 'ReporteDiferencias ' + strFecha(0) + 'at' + strHora().replace(/:/g, '.') + '.csv';
            //cabeceras de la tabla para el archivo de salida
            datos = 'Codigo1, Codigo2, Codigo3, Descripcion, PrecioVenta, CantidadReal, CantidadTeorica, DiferenciaCantidad, ImporteReal, ImporteTeorico, DiferenciaImporte\n';
            //datos de la tabla para el archivo de salida
            for (i = 0; i < tabla.rows().count(); i++) {
                datos_tabla = tabla.row(i).data();
                //alert(JSON.stringify(datos_tabla));

                datos += datos_tabla.codigo_1.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_2.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_3.replace(/,/g, '') +
                    ', ' + datos_tabla.descripcion.replace(/,/g, '') +
                    ', ' + datos_tabla.precio_venta +
                    ', ' + datos_tabla.cantidad_real +
                    ', ' + datos_tabla.cantidad_teorica +
                    ', ' + datos_tabla.diferencia_cantidad +
                    ', ' + datos_tabla.importe_real +
                    ', ' + datos_tabla.importe_teorico +
                    ', ' + datos_tabla.diferencia_importe +
                    '\n';
            }

            datos += '\n\n' + conteoReal + '\n' + conteoTeorico + '\n' + conteoDiferencia + '\n' + importeReal + '\n' + importeTeorico + '\n' + importeDiferecia;
        }


        else if (tipo_reporte === '4') {

            archivo_nombre = 'ConteoCruzado ' + strFecha(0) + 'at' + strHora().replace(/:/g, '.') + '.csv';
            //cabeceras de las columnas del archivo de salida
            datos = 'Codigo1, Codigo2, Codigo3, Descripcion, NombreAlmacen, Ubicacion, Conteo1, Conteo2, Diferencia\n';
            datos_tabla = northwind.queryAll('registros_cruzados');


            for (i = 0; i < tabla.rows().count(); i++) {
                datos_tabla = tabla.row(i).data();
                //alert(JSON.stringify(datos_tabla));

                datos += datos_tabla.codigo_1.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_2.replace(/,/g, '') +
                    ', ' + datos_tabla.codigo_3.replace(/,/g, '') +
                    ', ' + datos_tabla.descripcion.replace(/,/g, '') +
                    ', ' + datos_tabla.nombre_almacen +
                    ', ' + datos_tabla.ubicacion +
                    ', ' + datos_tabla.conteo_1 +
                    ', ' + datos_tabla.conteo_2 +
                    ', ' + datos_tabla.diferencia +
                    '\n';
            }

            datos += '\n\n' + conteo_total + '\n' + importe_inventario + '\n' + nRegistros;
        }
        //////

        creaDirectoriosExtras(archivo_nombre, normalizaStr(datos), n);


        setTimeout(function () {
            var rutaTemp = cordova.file.externalRootDirectory + 'TempSSM/TempSSM/';
            //alert(rutaTemp);
            if (n === 1) {
                try {

                    //window.plugins.socialsharing.share('Te envio el archivo', rutaTemp + archivo_nombre, archivo_nombre);

                    window.plugins.socialsharing.canShareVia('whatsapp', 'msg', null, null, null, function (e) {

                        window.plugins.socialsharing.shareViaWhatsApp(archivo_nombre, rutaTemp + archivo_nombre, null, function () {
                            //eliminaArchivoReporte(rutaTemp, archivo_nombre);
                            console.log('Envio 1 OK');
                        }, function (errormsg) {
                            suenaError();
                            //eliminaArchivoReporte(rutaTemp, archivo_nombre);
                            muestraAlerta1('¡Error!\nVerifíca que WhatsApp esté instalado y configurado correctamente.');
                        });


                    }, function (e) {
                        suenaError();
                        //eliminaArchivoReporte(rutaTemp, archivo_nombre);
                        muestraAlerta1('¡Error!\nVerifíca que WhatsApp esté instalado y configurado correctamente.');

                    });


                } catch (err) {
                    alert('Error! ' + err.message);
                }
            }
            else if (n === 2) {
                try {
                    window.plugins.socialsharing.canShareViaEmail(function (e) {

                        window.plugins.socialsharing.shareViaEmail(
                            'Te envío adjunto el reporte de inventario: ' + archivo_nombre + '<br /><br />Creado por ' + configuracionesApp.nombreSoftware + ' <a href="https://' + sitioWeb + '" target="_blank">' + sitioWeb + '</a>', // can contain HTML tags, but support on Android is rather limited:  http://stackoverflow.com/questions/15136480/how-to-send-html-content-with-image-through-android-default-email-client
                            'Reporte ' + archivo_nombre,
                            null, // TO: must be null or an array
                            null, // CC: must be null or an array
                            null, // BCC: must be null or an array
                            [rutaTemp + archivo_nombre], // FILES: can be null, a string, or an array
                            function () {

                                // eliminaArchivoReporte(rutaTemp, archivo_nombre);
                                console.log('Envio 2 OK');
                            },
                            function (errormsg) {
                                suenaError();
                                //eliminaArchivoReporte(rutaTemp, archivo_nombre);
                                muestraAlerta1('¡Error!\nVerifíca que tu aplicación de correo esté instalado y configurado correctamente.');
                            }
                        );

                    }, function (e) {
                        suenaError();
                        //eliminaArchivoReporte(rutaTemp, archivo_nombre);
                        muestraAlerta1('¡Error!\nVerifíca que tu aplicación de correo esté instalado y configurado correctamente.');

                    });



                } catch (err) {
                    alert('Error! ' + err.message);
                }
            }
            else {
                //
            }

            OcultaLoader();
            $('#modalExportacion').modal('hide');
            //
        }, 3500);



    }
    catch (err) {
        //OcultaLoader();
        vibraAlerta(500);
        muestraAlerta1(err.message);
        $('#btn_exportar').prop('disabled', false);
    }
}

function eliminaArchivoReporte(dir, archivo_nombre) {
    //console.log('Archivo: ' + dir + archivo_nombre);
    ////eliminamos el archivo dato y volvemos a crearlo
    //dir.getFile(archivo_nombre, { create: false, exclusive: false },
    //    function (archivo) {

    //        archivo.remove(function () {
    //            console.log('Archivo eliminado ' + archivo_nombre);
    //        }, function (error) {
    //            //suenaError();
    //            alert('Error al eliminar: ' + error.code);
    //        });
    //    }
    //    , null);
}



$('#btnCompartirWA').on('click', function () {

    if (tabla.rows().count() === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay inventario para exportar.', 'warning');
        return;
    }
    exporta_datos_csv(1);


});

$('#btnCompartirEmail').on('click', function () {

    if (tabla.rows().count() === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay inventario para exportar.', 'warning');
        return;
    }
    exporta_datos_csv(2);


});

$('#btn_exportar_csv').on('click', function () {

    if (tabla.rows().count() === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay inventario para exportar.', 'warning');
        return;
    }
    exporta_datos_csv(3);
});


function elimina_inventario_local() {

    try {
        MuestraLoader('');
        northwind.truncate('registros');
        northwind.commit();

        northwind.truncate('registros_cruzados');
        northwind.commit();

        elimina_diferencias();

        // 

        //vibraAlerta(500);
        suenaExito();
        muestraAlerta3('Inventario eliminado exitosamente.', 'success');

        setTimeout(function () {
         
            //reporte_conteo_detalle();
            tabla.clear().draw();
            calcula_totales();
            calculaNUbicaciones();

            OcultaLoader();
            $('#modalEliminarInventario').modal('hide');
            //$('#btn_sincronizar').prop('disabled', false);
        }, 500);


    }
    catch (err) {
        OcultaLoader();
        muestraAlerta1(err.message);
    }
}





$('#btn_eliminar').on('click', function () {
    var n_filas = tabla.rows().count();
    if (n_filas === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay inventario para eliminar.', 'warning');
        return;
    }

    //var dialog = confirm("Al eliminar el inventario se eliminan todos los registros capturados y esta acción no se podrá deshacer.\n¿Desea continuar?");
    //if (dialog === false) {
    //    //vibraAlerta(500);
    //    return;

    //}

    $('#modalEliminarInventario').modal('show');

});

$('#btnAceptarEliminar').on('click', function () {
    elimina_inventario_local();
});

$('#btnExportar').on('click', function () {
    if (tabla.rows().count() === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay inventario para exportar.', 'warning');
        return;
    }

    $('#modalExportacion').modal('show');
    //$(location).attr('href', 'inventario_exportacion_ssr.html');
});

$('#btnExportarSSR').on('click', function () {
    $(location).attr('href', 'inventario_exportacion_ssr.html?url=reporte');
});


$('#tabla_datos tbody').on('click', 'tr', function () {

    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected');
    }
    else {
        $('#tabla_datos').DataTable().$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    }

});


function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}



//$('#modalAyuda').modal('show');
//$('#modalExportacion').modal('show');
//$('#modalEliminarInventario').modal('show');

document.addEventListener('deviceready', function () {
    //$(document).ready(function () {


    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consulta_lista_impresoras();

    //consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación

    MuestraLoader('');

    consultaDatosServidor();

    abre_conexion_bd();
    elimina_diferencias();

    setTimeout(function () {
        //$('#seccionDatosDiferencias').hide();
        genera_reporte_diferencias();
        //reporte_agrupacion_producto();
        reporte_conteo_detalle();
        calculaNUbicaciones();
        OcultaLoader();
        ////

    }, 100);


    //creaInterAd();

    //if(consultaInfoConexion() === 'NoNetwork'){
    //    vibraAlerta(1000);
    //    muestraAlerta1('Algunas funciones de la aplicación requieren conexión a Internet, para continuar verifique que su dispositivo se encuentre conectado a Internet e intente ingresar nuevamente.');
    //    //$('*').attr('disabled', 'disabled');
    //    $('#btn_exportar').prop('disabled', true);
    //    $('#btn_imprimir').prop('disabled', true);
    //    $('#btn_eliminar').prop('disabled', true);
    //    return;
    //}


});