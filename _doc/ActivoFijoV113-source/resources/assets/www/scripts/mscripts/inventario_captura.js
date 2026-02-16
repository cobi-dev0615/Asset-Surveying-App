//obtenemos las variables de la url
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

var imagenSeleccionada = '';
var imagenSeleccionada2 = '';
var imagenSeleccionada3 = '';
var almacen_conteo = obtener_parametros_url('almacen_conteo');
var ubicacionSeleccionada = obtener_parametros_url('ubicacion');
var nConteo = obtener_parametros_url('nConteo');

var codigo_forzado = 0;
var index_t_series = 0;
var agregar = true;
var url_previa = 'inventario_ubicacion.html';
//alert(url_previa);

var productoEncontrado = false;
var traspasoSucursal = false;
var idProductoSeleccionado = 0;
var codigo1ProductoSeleccionado = '';
var nSerieSeleccionado = '';
var codigo2ProductoSeleccionado = '';
var sucursalOrigen = '';

function consultaProductoInfo(lectura) {
    try {

        if (lectura.length === 0) {
            suenaAlerta();
            muestraAlerta3('Captura el código del producto para continuar', 'warning');
            $('#txtCodigo').val('').focus();
            return;
        }
        MuestraLoader('');
        var datosSesion = consultaDatoSesionActual();
        //si no hay datos de sesión guardados cerramos la sesión

        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var categoria = $('#selectCategoria').val();
        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var idEmpresaSeleccionada = datosSesion[0].idEmpresa;
        var phpArchivo = ruta_php + 'productosConsultarCodigo.php';
        // alert('phpArchivo: ' + phpArchivo);

        var datos = 'idInventario=' + idInventarioSeleccionado +
            '&idEmpresa=' + idEmpresaSeleccionada +
            '&categoria=' + categoria +
            '&almacen=' + almacen_conteo +
            '&codigoProducto=' + lectura;

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                switch (status) {
                    case 'warning':
                        suenaAlerta();
                        muestraAlerta3(mensaje, status);
                        $('#txtCodigo').val('').focus();
                        break;
                    case 'danger':
                        suenaAlerta();
                        //muestraAlerta3(mensaje, status);
                        if (mensaje.includes('Activo no encontrado')) {
                            preguntaAgregarForzado();
                            return;
                        }
                        else {

                            swal({
                                title: 'Atención',
                                text: mensaje,
                                icon: 'error',
                                closeOnClickOutside: false,
                                closeOnEsc: false,
                                dangerMode: true,
                                buttons: {
                                    aceptar: {
                                        text: 'Aceptar',
                                        value: 'aceptar',
                                        visible: true,
                                        className: 'btn btn-danger',
                                        closeModal: true
                                    }
                                }
                            }).then(function (value) {
                                switch (value) {
                                    case 'aceptar':
                                        LimpiaCampos();
                                        posiciona_focus();
                                        break;
                                }
                            });

                        }


                        break;
                    case 'success':
                        if (mensaje == 'OtraSucursal') {
                            sucursalOrigen = datosRecibidos[0].subsidaria;
                            //si el activo se encontró en otra sucursal que no le pertenece
                            suenaAlerta();
                            swal({
                                title: '¡Este activo pertenece a la sucursal ' + sucursalOrigen + ' !',
                                text: '¿Deseas registrarlo en esta sucursal?\nSi seleccionas que si el activo seleccionado se moverá de sucursal al guardar el registro.',
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

                                        LimpiaCampos();
                                        break;
                                    case 'Si':
                                        traspasoSucursal = true;
                                        muestraAlerta3('El activo seleccionado se moverá de sucursal al guardar el registro', 'info');

                                        // $('#txtNSerieViejo').focus();



                                        agregar = false;
                                        productoEncontrado = true;
                                        //muestraAlerta3(datosRecibidos[0].descripcion, status);
                                        // $('#seccionDescripcion').prop('hidden', false);
                                        idProductoSeleccionado = datosRecibidos[0].id;
                                        var codigo1 = datosRecibidos[0].codigo_1;
                                        var codigo2 = datosRecibidos[0].codigo_2;
                                        var marca = datosRecibidos[0].marca;
                                        // var modelo = datosRecibidos[0].modelo;
                                        var nSerie = datosRecibidos[0].n_serie;
                                        var categoria = datosRecibidos[0].categoria_2;
                                        //agregar txtCategoriaForzado para que se pueda editar la categoría
                                        $('<option/>', {
                                            value: categoria,
                                            html: categoria
                                        }).appendTo('#txtCategoriaForzado');


                                        var descripcion = datosRecibidos[0].descripcion;
                                        nSerieSeleccionado = nSerie;
                                        codigo1ProductoSeleccionado = codigo1;
                                        var observaciones = datosRecibidos[0].observaciones;

                                        $('#lblTituloFormulario').text('EDICIÓN DE INFORMACIÓN DEL ACTIVO');
                                        $('#txtCodigo1Forzado').val(codigo1).prop('readonly', true);
                                        $('#txtCodigo2Forzado').val(codigo2);
                                        $('#txtNSerieViejo').val(nSerie);

                                        $('#selectMarca').val(marca).trigger('change');
                                        // $('#txtModelo').val(modelo);
                                        $('#txtCategoriaForzado').val(categoria);
                                        $('#txtDescripcionForzado').val(descripcion);
                                        $('#txtObservaciones').val(observaciones);
                                        $('#modalRegistro').modal('show');
                                        break;
                                }
                            });
                            return;
                        }


                        agregar = false;
                        productoEncontrado = true;
                        idProductoSeleccionado = datosRecibidos[0].id;
                        var codigo1 = datosRecibidos[0].codigo_1;
                        var codigo2 = datosRecibidos[0].codigo_2;

                        var marca = datosRecibidos[0].marca;
                        // var modelo = datosRecibidos[0].modelo;
                        var nSerie = datosRecibidos[0].n_serie;
                        var categoria = datosRecibidos[0].categoria_2;
                        var descripcion = datosRecibidos[0].descripcion;
                        nSerieSeleccionado = nSerie;
                        codigo1ProductoSeleccionado = codigo1;
                        var observaciones = datosRecibidos[0].observaciones;

                        $('#lblTituloFormulario').text('EDICIÓN DE INFORMACIÓN DEL ACTIVO');
                        $('#txtCodigo1Forzado').val(codigo1).prop('readonly', true);
                        $('#txtCodigo2Forzado').val(codigo2);
                        $('#txtNSerieViejo').val(nSerie);

                        $('#selectMarca').val(marca).trigger('change');
                        // $('#txtModelo').val(modelo);
                        $('#txtCategoriaForzado').val(categoria);
                        $('#txtDescripcionForzado').val(descripcion);
                        $('#txtObservaciones').val(observaciones);
                        $('#modalRegistro').modal('show');
                        break;
                }


            },
            error: function (respuesta) {
                productoEncontrado = false;
                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            }
        });

    } catch (err) {
        productoEncontrado = false;
        OcultaLoader();
        muestraAlerta1('Error consultaProductoInfo: ' + err.message);
    }
}



function preguntaAgregarForzado() {
    suenaAlerta();
    swal({
        title: 'Activo no encontrado',
        text: '¿Deseas darlo alta?',
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
                agregar = false;
                LimpiaCampos();
                posiciona_focus();
                break;
            case 'Si':
                agregar = true;
                $('#modalRegistro').modal('show');
                break;
        }
    });
}

function preguntaMarcarNoEncontrado(idSeleccionado) {
    suenaAlerta();
    swal({
        title: '¿Deseas marcar el activo como no encontrado?',
        text: 'Para deshacer esta acción en caso de encontrar el activo debes solicitarlo a un Supervisor.',
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
                LimpiaCampos();
                break;
            case 'Si':
                marcarNoEncontrado(idSeleccionado);
                break;
        }
    });
}


function guardaCodigoForzado() {

    try {

        var codigo1 = $('#txtCodigo1Forzado').val().trim();
        var codigo2 = $('#txtCodigo2Forzado').val().trim();
        var codigo3 = $('#txtCodigo3Forzado').val().trim();
        var nSerie = $('#txtNSerieViejo').val().trim();
        var nSerieNuevo = $('#txtNSerieForzado').val().trim();
        var categoria = $('#txtCategoriaForzado').val() == null ? '' : $('#txtCategoriaForzado').val();
        var descripcion = $('#txtDescripcionForzado').val().trim();
        var marca = $('#selectMarca').val() == null ? '' : $('#selectMarca').val();

        var observaciones = $('#txtObservaciones').val();
        var cantidad = Number($('#txtCantidad').val());
        codigo_forzado = 1;

        if (agregar) {
            if (codigo3.length === 0) {
                suenaAlerta();
                muestraAlerta3('Captura el número de activo para continuar', 'warning');
                $('#txtCodigo3Forzado').val('').focus();
                return;
            }
        }
        // if (categoria === '' || categoria === null) {
        //     suenaAlerta();
        //     muestraAlerta3('Selecciona la categoría para continuar', 'warning');
        //     $('#txtCategoriaForzado').focus();
        //     return;
        // }
        if (descripcion.length === 0) {
            suenaAlerta();
            muestraAlerta3('Captura la descripción para continuar', 'warning');
            $('#txtDescripcionForzado').val('').focus();
            return;
        }

        if (cantidad <= 0) {
            suenaAlerta();
            muestraAlerta3('La cantidad de unidades debe ser mayor a cero', 'warning');
            $('#txtCantidad').val('1').focus();
            return;
        }
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();

        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }

        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var idEmpresa = datosSesion[0].idEmpresa;
        var idUsuario = datosSesion[0].idUsuario;
        var sucursal = datosSesion[0].nombreInventarioSeleccionado;

        var phpArchivo = ruta_php + 'productoForzadoRegistro.php';
        if (agregar == false) {
            phpArchivo = ruta_php + 'ProductoEdicion.php';
        }

        var datos = 'idInventario=' + idInventarioSeleccionado +
            '&idEmpresa=' + idEmpresa +
            '&idUsuario=' + idUsuario +
            '&almacen=' + almacen_conteo +
            '&sucursal=' + sucursal +
            '&codigo1=' + codigo1 +
            '&codigo1ProductoSeleccionado=' + codigo1ProductoSeleccionado +
            '&codigo2=' + codigo2 +
            '&codigo3=' + codigo3 +
            '&nSerie=' + nSerie +
            '&nSerieSeleccionado=' + nSerieSeleccionado +
            '&categoria=' + categoria +
            '&descripcion=' + descripcion +
            '&observaciones=' + observaciones +
            '&cantidad=' + cantidad +
            '&latitud=' + latitud_actual +
            '&longitud=' + longitud_actual +
            '&traspasoSucursal=' + traspasoSucursal +
            '&sucursalOrigen=' + sucursalOrigen +
            '&versionApp=' + configuracionesApp.versionSoftware +
            '&nSerieNuevo=' + nSerieNuevo +
            '&marca=' + marca +
            '&cantidad=' + cantidad;

        if (imagenSeleccionada !== '' || imagenSeleccionada !== null) {
            datos += '&imagen=' + encodeURIComponent(imagenSeleccionada);
        }
        if (imagenSeleccionada2 !== '' || imagenSeleccionada2 !== null) {
            datos += '&imagen2=' + encodeURIComponent(imagenSeleccionada2);
        }
        if (imagenSeleccionada3 !== '' || imagenSeleccionada3 !== null) {
            datos += '&imagen3=' + encodeURIComponent(imagenSeleccionada3);
        }

        if (!agregar) {
            datos += '&idSeleccionado=' + idProductoSeleccionado;
        }

        console.log('phpArchivo: ' + phpArchivo);
        // console.log('datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 30000, // establecenes un timeout de 15 segundos
            success: function (respuesta) {

                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos; //solo se devuelve el id de registro de en la BD

                switch (status) {
                    case 'success':
                        codigo_forzado = 0;
                        $('#modalRegistro').modal('hide');
                        muestraAlerta3(mensaje, status);
                        LimpiaCampos();
                        consultaInventarioPendiente();
                        break;
                    default:
                        suenaAlerta();
                        // muestraAlerta3('Error: ' + mensaje, status);

                        swal({
                            title: 'Atención',
                            text: mensaje,
                            icon: status,
                            closeOnClickOutside: false,
                            closeOnEsc: false,
                            buttons: {
                                aceptar: {
                                    text: 'Aceptar',
                                    value: 'aceptar',
                                    visible: true,
                                    className: 'btn btn-danger',
                                    closeModal: true
                                }
                            }
                        }).then(function (value) {
                            switch (value) {
                                case 'aceptar':
                                    // LimpiaCampos();
                                    break;
                            }
                        });


                        break;
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('Error: ' + JSON.stringify(jqXHR));
                productoEncontrado = false;
                OcultaLoader();
                if (jqXHR.status === 0) {
                    alert("No se pudo conectar. Verifica tu red o la URL del servidor.");
                } else if (jqXHR.status == 404) {
                    alert("Página solicitada no encontrada [404].");
                } else if (jqXHR.status == 500) {
                    alert("Error interno del servidor [500].");
                } else if (textStatus === 'parsererror') {
                    alert("Error al analizar JSON solicitado.");
                } else if (textStatus === 'timeout') {
                    alert("Error de tiempo de espera.");
                } else if (textStatus === 'abort') {
                    alert("Petición AJAX abortada.");
                } else {
                    alert("Error desconocido: " + jqXHR.responseText);
                }
            }
        });

    } catch (err) {
        productoEncontrado = false;
        OcultaLoader();
        muestraAlerta1('Error guardaCodigoForzado: ' + err.message);
    }
}

function consultaInventarioPendiente() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        //alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var categoria = $('#selectCategoria').val();
        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;

        var phpArchivo = ruta_php + 'consultaInventarioPendiente.php';
        //alert('phpArchivo: ' + phpArchivo);

        var datos = 'idInventario=' + idInventarioSeleccionado +
            '&categoria=' + categoria +
            '&almacen=' + almacen_conteo;
        //alert('Datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {

                // alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();
                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;
                switch (status) {
                    case 'warning':
                        muestraAlerta3(mensaje, status);

                        break;
                    case 'danger':
                        muestraAlerta3(mensaje, status);
                        break;
                    case 'success':
                        if (categoria.length > 0 && datosRecibidos.length === 0) {
                            suenaError();
                            muestraAlerta3('La categoría seleccionada ya no tiene activos pendientes por inventariar', 'warning');
                        }
                        else if (categoria.length === 0 && datosRecibidos.length === 0) {
                            suenaError();
                            // navigator.notification.alert('Ya no hay productos pendientes por inventariar', null, 'Atención', 'ACEPTAR');

                            MensajeAlerta('Ya no hay productos pendientes por inventariar', 'warning', ['ACEPTAR'], true, null);

                            // function salirInventario() {
                            //     $(location).attr('href', 'inicio.html')
                            // }
                        }
                        inicializaTabla(datosRecibidos);
                        break;
                }

            },
            error: function (respuesta) {
                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));
            }
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

var altoPantalla = screen.height;
var anchoPantalla = screen.width;
console.log(anchoPantalla + ' * ' + altoPantalla);
var altoTabla = '725px';
if (altoPantalla <= 1024) {
    altoTabla = '665px';
}
if (altoPantalla <= 1140) {
    altoTabla = '325px';
}
if (altoPantalla <= 992) {
    altoTabla = '375px';
}
if (altoPantalla <= 864) { //laptop ASUS
    altoTabla = '365px';
}
if (altoPantalla <= 768) {
    altoTabla = '295px';
}
if (altoPantalla <= 640) { //HTC One M8
    altoTabla = '245px';
}
if (altoPantalla <= 576) {
    altoTabla = '195px';
}
if (altoPantalla <= 534) { //Speedata
    altoTabla = '150px';
}
var tabla;

function inicializaTabla(datosTabla) {
    try {
        tabla.destroy(); //intentamos destruir la tablaDatos en caso de que ya esté inizializada y necesitemos recargar los datos
    } catch (err) {
        console.log(err.message);
    }
    tabla = $('#tabla_datos').DataTable({
        select: {
            style: 'single'
        },
        order: [[0, 'asc']],
        //"bFilter": true,
        info: false,
        //LengthChange: true,
        paging: true,
        pageLength: 30,
        pagingType: 'numbers',
        dom: '<"top"pt>',
        scrollY: '70vh',
        scrollX: true,
        scrollCollapse: false,
        searching: false,
        autoWidth: true,
        responsive: true,
        fixedColumns: {
            leftColumns: 0,
            rightColumns: 0
        },
        data: datosTabla,
        columns: [
            { title: 'ID', data: 'id', visible: false, searchable: true, width: '10%' }, //id_producto
            { title: 'DESCRIPCIÓN', data: 'descripcion' },
            { title: 'N TAG', data: 'codigo_2' },
            { title: 'N ACTIVO', data: 'codigo_1' },
            { title: 'NÚMERO DE SERIE', data: 'n_serie' },
            { title: 'CATEGORIA 2', data: 'categoria_2' },
            // { title: 'TIPO DE ACTIVO', data: 'tipo_activo' },
            {
                title: '',
                data: 'id',
                render: function (data, type, row, meta) {
                    // return '<button class="btn-sm btn-info" onclick="seleccionarRegistroTabla(' + data + ')"><i class="fas fa-check-circle"></i> SELECCIONAR</button>'

                    return '<button class="btn-sm btn-info" onclick="ConsultaRegistroSeleccionado(' + data + ')"><i class="fas fa-check-circle"></i> SELECCIONAR</button>'

                }
            },
            {
                title: '',
                data: 'id',
                render: function (data, type, row, meta) {
                    return '<button class="btn-sm btn-danger" onclick="preguntaMarcarNoEncontrado(' + data + ')"><i class="fas fa-minus-circle"></i> NO ENCONTRADO</button>'
                }
            }

            // {
            //     title: 'CONTADO', data: 'faltante', 'render': function (data, type, row, meta) {
            //         var contado = 'CONTADO';
            //         var label = 'success';
            //         if (data > 0) { //Si la diferencia es mayor a cero es que aún no se ha contado el producto
            //             label = 'danger';
            //             contado = 'NO CONTADO';
            //         }
            //         data = '<span class="badge badge-' + label + '">' + contado + '</span>';
            //         return data;
            //     }
            // }

        ],
        columnDefs: [ /*{ className: "bg-white font-weight-bold text-danger", "targets": [0] }, { className: "bg-white", "targets": [1] },*/
            // {
            //     targets: 7,
            //     data: null,
            //     defaultContent: '<button class="btn btn-sm btn-info btnSeleccionarRegistro" id="#btnSeleccionarRegistro"><i class="fas fa-check-circle"></i> SELECCIONAR</button>',
            // },
            // {
            //     targets: 8,
            //     data: null,
            //     defaultContent: '<button class="btn btn-sm btn-danger btnSeleccionarRegistro" id="#btnSeleccionarRegistro"><i class="fas fa-minus-circle"></i> NO ENCONTRADO</button>',
            // }
        ],
        createdRow: function (row, data, index) {
            // //personalizamos las columnas deseadas
            // $('td', row).eq(0).addClass('text-danger text-right font-weight-bold');
            // //$('td', row).eq(2).addClass('small');
            // //$('td', row).eq(9).addClass('text-right');
            // $('td', row).eq(11).addClass('text-right font-weight-bold');
            // $('td', row).eq(12).addClass('text-primary text-right font-weight-bold');
            // $('td', row).eq(14).addClass('text-primary text-right font-weight-bold bg-white');
            // $('td', row).eq(15).addClass('text-danger text-right font-weight-bold bg-white');

        },
        drawCallback: function (settings) {

        },
        //cuando la tablaDatos se ha inicializado completamente
        initComplete: function (settings, json) {
            LimpiaCampos();
            var categoria = $('#selectCategoria').val();
            if (categoria == '') {
                $('#lbl_n_filas').html('Activos pendientes: <span class="font-weight-bold" id="">' + datosTabla.length.toLocaleString() + '</span>');

            } else {
                $('#lbl_n_filas').html('Activos pendientes en esta categoría: <span class="font-weight-bold" id="">' + datosTabla.length.toLocaleString() + '</span>');
            }
            $('#tabla_datos thead.tr').addClass('elegant-color-dark lighten-1 text-white');
            $('#txtCodigo').val('').focus();

        }
    });

    $('#tabla_datos tbody').on('click', 'td button', function (e) {
        // var registroSeleccionado = tabla.row('.selected').data();
        // var codigo1 = registroSeleccionado["codigo_1"];

    });
}

function ConsultaRegistroSeleccionado(idSeleccionado) {

    try {
        agregar = false;
        LimpiaCampos();
        // if (configuracionesApp.modoDebug) {
        console.log('Id seleccionado: ' + idSeleccionado);
        // }

        MuestraLoader('');
        var datosSesion = consultaDatoSesionActual();

        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }

        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var idEmpresaSeleccionada = datosSesion[0].idEmpresa;
        var phpArchivo = ruta_php + 'ProductoConsultaId.php';

        console.log('phpArchivo: ' + phpArchivo);

        var datos = 'idInventario=' + idInventarioSeleccionado +
            '&idEmpresa=' + idEmpresaSeleccionada +
            '&idSeleccionado=' + idSeleccionado;

        console.log('datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {
                // console.log(JSON.stringify(respuesta));
                OcultaLoader();
                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                console.log('datosRecibidos: ' + JSON.stringify(datosRecibidos));

                switch (status) {
                    case 'warning':
                        suenaAlerta();
                        muestraAlerta3(mensaje, status);
                        $('#txtCodigo').val('').focus();
                        break;
                    case 'danger':
                        suenaAlerta();
                        muestraAlerta3(mensaje, status);
                        break;
                    case 'success':
                        // ConsultaMarcas();
                        idProductoSeleccionado = datosRecibidos[0].id;
                        var codigo1 = datosRecibidos[0].codigo_1;
                        var codigo2 = datosRecibidos[0].codigo_2;
                        var marca = datosRecibidos[0].marca;
                        // var modelo = datosRecibidos[0].modelo;
                        var nSerie = datosRecibidos[0].n_serie;
                        var categoria = datosRecibidos[0].categoria_2;
                        var descripcion = datosRecibidos[0].descripcion;
                        nSerieSeleccionado = nSerie;
                        codigo1ProductoSeleccionado = codigo1;
                        var observaciones = datosRecibidos[0].observaciones;


                        $('#lblTituloFormulario').text('EDICIÓN DE INFORMACIÓN DEL ACTIVO');
                        $('#txtCodigo1Forzado').prop('disabled', true).val(codigo1);
                        $('#txtCodigo2Forzado').val(codigo2);
                        $('#txtNSerieViejo').val(nSerie);
                        $('#txtCategoriaForzado').prop('disabled', true).val(categoria).trigger('change');
                        $('#selectMarca').val(marca).trigger('change');
                        $('#txtDescripcionForzado').prop('disabled', true).val(descripcion);
                        $('#txtObservaciones').val(observaciones);
                        $('#modalRegistro').modal('show');
                        break;
                }
            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            }
        });

    } catch (err) {

        OcultaLoader();
        muestraAlerta1('Error ConsultaRegistroSeleccionado: ' + err.message);
    }
}

function marcarNoEncontrado(idSeleccionado) {
    try {
        MuestraLoader('');
        var datosSesion = consultaDatoSesionActual();
        //alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;

        var phpArchivo = ruta_php + 'registroInventarioMarcarNoEncontrado.php';
        // alert('phpArchivo: ' + phpArchivo);

        var datos = 'idInventario=' + idInventarioSeleccionado +
            '&idSeleccionado=' + idSeleccionado;

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {
                console.log(JSON.stringify(respuesta));
                OcultaLoader();
                var status = respuesta.status;
                var mensaje = respuesta.mensaje;
                var datosRecibidos = respuesta.datos;
                muestraAlerta3(mensaje, status);
                switch (status) {
                    case 'warning':
                        suenaAlerta();
                        // LimpiaCampos();
                        break;
                    case 'danger':
                        suenaAlerta();
                        // LimpiaCampos();
                        break;
                    case 'success':
                        suenaExito();
                        tabla.row('.selected').remove().draw(false);
                        calculaTotales();
                        LimpiaCampos();
                        break;
                }
            },
            error: function (respuesta) {
                productoEncontrado = false;
                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));
            }
        });
    } catch (err) {
        productoEncontrado = false;
        OcultaLoader();
        muestraAlerta1('Error marcarNoEncontrado: ' + err.message);
    }
}

function LimpiaCampos() {
    agregar = false;
    imagenSeleccionada = '';
    imagenSeleccionada2 = '';
    imagenSeleccionada3 = '';
    $('#picFoto1').attr('src', 'images/bg-black.png');
    $('#picFoto2').attr('src', 'images/bg-black.png');
    $('#picFoto3').attr('src', 'images/bg-black.png');
    traspasoSucursal = false;
    sucursalOrigen = '';
    productoEncontrado = false;
    idProductoSeleccionado = 0;
    codigo1ProductoSeleccionado = '';
    codigo2ProductoSeleccionado = '';
    $('#seccionDescripcion').prop('hidden', true);
    $('#lbl_descripcion').text('');
    $('#txtCodigo1Forzado').val('');
    $('#txtCodigo2Forzado').val('');
    $('#txtCodigo3Forzado').val('');
    $('#txtNSerieViejo').val('');
    $('#txtNSerieForzado').val('');
    $('#txtCategoriaForzado').val('');
    $('#txtDescripcionForzado').val('');
    $('#txtObservaciones').val('');
    $('#txtCantidad').val('1');
    $('#txtCodigo1Forzado').val('').prop('readonly', false);

}

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    if ($('#modalOpciones').hasClass('show')) {
        $('#modalOpciones').modal('hide');
        return;
    }
    if ($('#modalRegistro').hasClass('show')) {
        $('#modalRegistro').modal('hide');
        return;
    }
    if ($('#modal_n_series').hasClass('show')) {
        $('#modal_n_series').modal('hide');
        return;
    }
    // preguntaSalir();
    MensajeAlerta('¿Deseas salir del conteo de inventario?', 'warning', ['SI', 'NO'], false, function () {
        $(location).attr('href', url_previa);
    });
}

function preguntaSalir() {
    // e.preventDefault();
    swal({
        title: '¿Desea salir del conteo de inventario?',
        text: '',
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
                LimpiaCampos();
                break;
            case 'Si':
                $(location).attr('href', url_previa);
                break;
        }
    });
};


$('#btnModalSalir').on('click', function () {
    $(location).attr('href', url_previa);
});

$("#modalSalir").on('hidden.bs.modal', function () {
    posiciona_focus();
});

$("#modalSalir").on('shown.bs.modal', function () {
    //StatusBar.show();
    //NavigationBar.show();

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

$("#btnCamaraNSerie").on('click', function () {
    scan(5);
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
        var mensaje_prompt = "captura el código del producto.";

        switch (valor) {
            case 0:
                mensaje_prompt = "captura la ubicación del producto.";
                break;
            case 1:
                mensaje_prompt = "captura el código del producto.";
                break;
            case 2:
                mensaje_prompt = "captura el número de lote.";
                break;
            case 3:
                mensaje_prompt = "captura el número de serie.";
                break;
            case 4:
                mensaje_prompt = "captura la ubicación a eliminar.";
                break;
            case 5:
                mensaje_prompt = "captura el número de serie.";
                break;

        }

        cordova.plugins.barcodeScanner.scan(
            function (result) {
                if (valor === 0) {
                    //escaneamos la ubicación
                    $('#txt_ubicacion').val(result.text);
                    consultaInventarioPendiente();
                }
                if (valor === 1) {
                    //escaneamos y consultamos el código del producto
                    $('#txtCodigo').val(result.text);

                }
                else if (valor === 2) {
                    //escanemos el número de lote del producto
                    $('#txtNSerieViejo').val(result.text);
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

                else if (valor === 5) {
                    //escanemos el número de serie del producto
                    $('#txtNSerieForzado').val(result.text);
                    inserta_n_serie();
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
            });
    }
    catch (err) {
        alert(err.message);
    }
}

function salir() {

    var n_filas = tabla.rows().count();
    if (n_filas > 0) {
        suenaError();

        $('#modalSalir').modal('show');

    }
    else {
        //StatusBar.show();
        //NavigationBar.show();

        $(location).attr('href', url_previa);
    }


}

///botones
$("#btn_salir").on('click', function () {
    salir();
});

$('#btn_imprimir').on('click', function () {
    var filas = $('#tabla_datos tbody').children('tr').length;

    if (filas === 0) {
        vibraAlerta(500);
        muestraAlerta3('Capture almenos un registro para imprimir el reporte', 'warning');
        return;
    }
    $('#modalOpciones').modal('hide');
    imprime();
});

$('#txt_ubicacion').on('keydown', function (e) {
    // if (e.keyCode === 13) {
    //     e.preventDefault();
    //     consultaInventarioPendiente();
    // }
});

$('#txt_ubicacion').focusout(function () {

});

$('#btn_buscar_0').on('click', function () {
    consultaInventarioPendiente();
});

$('#txtCodigo').on('keydown', function (e) {
    if (e.keyCode === 13) {
        var lectura = $('#txtCodigo').val().trim();
        consultaProductoInfo(lectura);
    }
});

$('#btn_buscar_1').on('click', function () {
    var lectura = $('#txtCodigo').val().trim();

    consultaProductoInfo(lectura);
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



function inserta_fila_local(cantidad) {
    try {
        cantidad = Number(cantidad) || 0;
        var cantidad_minima = 0;

        totalFactorSeleccionado = cantidadFactorSeleccionado * cantidad;

        if (!$('#chk_cant_cero').is(':checked')) {

            if (cantidad === 0) {
                vibraAlerta(500);
                suenaAlerta();
                muestraAlerta3('captura la cantidad para continuar', 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }
        }

        if (!$('#chk_cant_negativa').is(':checked')) {
            if (cantidad < 0) {
                vibraAlerta(500);
                suenaAlerta();
                muestraAlerta3('La cantidad deben ser mayor a cero', 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }


        }
        else {
            cantidad_minima = -999999;
            if (cantidad < -999999) {
                vibraAlerta(500);
                suenaAlerta();
                muestraAlerta3('La cantidad no puede ser menor a ' + cantidad_minima, 'warning');
                $('#txt_cantidad').val('').focus();
                return;
            }
        }

        if (cantidad > 999999) {
            vibraAlerta(500);
            suenaAlerta();
            muestraAlerta3('La cantidad no puede ser mayor a 999999', 'warning');
            $('#txt_cantidad').val('').focus();
            return;
        }

        if ($('#lbl_descripcion').text() === '') {
            vibraAlerta(500);
            muestraAlerta3('captura el código del producto para continuar', 'warning');
            LimpiaCampos();
            $('#txtCodigo').val('');
            $('#txtCodigo').focus();
            return;
        }


        var n_filas = tabla.rows().count();
        //var n_columnas = tabla.columns(':visible').count();

        var id_producto = id_seleccionado;
        var codigo_1 = $('#txtCodigo').val();
        var codigo_2 = codigo_2_seleccionado;
        var codigo_3 = codigo_3_seleccionado;
        var descripcion = $('#lbl_descripcion').text();
        //alert('ok');

        var importe = (Number(cantidad) * Number(precio_venta)).toFixed(3);
        //se cambia el importe total debido a que ahora se usa el factor
        //var importe = (Number(cantidad) * Number(totalFactorSeleccionado)).toFixed(3);


        var ubicacion = $('#txt_ubicacion').val().trim();
        //var cantidad = cantidad;
        var lote = $('#txtNSerieViejo').val();
        var n_serie = '';

        var fecha_caducidad = $('#txt_fecha_caducidad').val();
        var fecha_captura = strFecha(0);
        var hora_captura = strHora();
        var um = unidadMedidaSeleccionado;

        if ($('#chkValidarCatalogo').is(':checked')) {
            if (codigo_forzado === 1) {
                try {
                    base_datos.transaction(function (ts) {

                        //autoincrementamos la variable para generar un ID consecutivo
                        //n_productos++;
                        var id_producto = strFecha(0).replace(/-/g, '') + strHora().replace(/:/g, '');
                        //inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado, cantidad_real
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


                datosFila["importe"] = importe;
                datosFila["ID"] = id;

                //alert(JSON.stringify(datosFila));
                tabla.row.add(datosFila).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
                muestraAlerta3(descripcion + '\nSN.: ' + n_serie, 'success_s');
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


            datosFila["importe"] = importe;
            datosFila["ID"] = id;

            //alert(JSON.stringify(datosFila));
            tabla.row.add(datosFila).draw(); //rows.add(data) Inserta nuevas filas al mismo tiempo desde una array de datos
            muestraAlerta3(descripcion + '\nCant.: ' + cantidad, 'success');


        }

        tabla.order([13, 'desc']).draw();
        //tabla.columns.adjust().draw();// adjustamos el tamaño de las columnas y redibujamos

        calculaTotales();

        OcultaLoader();
        LimpiaCampos();

        $('#txtCodigo').focus();
    } catch (err) {
        alert('Error InsertaFila: ' + err.message);
    }
}

function habilita_campo_lectura() {
    //habilitamos nuevamente el campo de lectura 
    $('#txtCodigo').prop('disabled', false);
}



$('#btnAceptarForzado').on('click', function () {
    guardaCodigoForzado();
});

$('#txtDescripcionForzado').on('keydown', function (e) {
    if (e.keyCode === 13) {

    }
});


//cambiamos el tipo de conteo
$('input[type=checkbox][name=chk_tipo_conteo]').on('change', function () {
    //$('#chk_tipo_conteo').on('change', function () {
    //if (this.value === 'si') {
    if ($('#chk_tipo_conteo').is(':checked')) {
        //muestraAlerta3('Conteo por unidad activado', 'success');
        LimpiaCampos();
        $('#txt_cantidad').val('1');
        $('#txt_cantidad').prop('readonly', true).css("background-color", "#CCC");
        $('#fila_cantidad').hide();
        if ($('#txt_ubicacion').val().trim() === '') {
            $('#txt_ubicacion').focus();
            return;
        }
        $('#txtCodigo').focus();
    }
    //else if (this.value === 'no') {
    else {
        // muestraAlerta3('Conteo por cantidad activado', 'success');
        LimpiaCampos();
        $('#txt_cantidad').val('');
        $('#txt_cantidad').prop('readonly', false).css("background-color", "#FFF");
        $('#fila_cantidad').show();
        if ($('#txt_ubicacion').val().trim() === '') {
            $('#txt_ubicacion').focus();
            return;
        }
        $('#txtCodigo').focus();
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
function calculaTotales() {
    var n_filas = tabla.rows().count();
    $('#lbl_n_filas').html('Activos pendientes: <span class="font-weight-bold" id="">' + n_filas.toLocaleString() + '</span>');
}

function imprime() {
    try {
        var n_filas = tabla.rows().count();

        if (n_filas === 0) {
            suenaError();
            vibraAlerta(500);
            muestraAlerta3('No hay inventario para imprimir', 'error');
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
        var datos_ticket_zebra = '';
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

                datos_ticket_zebra += 'T 7 0 25 ' + il.toString() + ' ' + descripcion.substring(0, 30) + '\r\n';
                il += 20;

                //datos_ticket_zebra += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 5) + '    ' + codigo_1 + '\r\n';
                //il += 20;
                datos_ticket_zebra += 'T 5 0 25 ' + il.toString() + ' ' + codigo_1 + '\r\n';
                il += 20;

                datos_ticket_zebra += 'T 5 0 25 ' + il.toString() + ' ' + padLeft(cantidad.toString(), 6) + '\t' + padLeft(precio_venta.toLocaleString(), 11) + '\r\n';
                il += 28;

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
            + 'T 5 0 25 225 PRODUCTO\r\n'
            + 'T 5 0 25 255 CANT     PRECIO     IMPORTE\r\n'
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
            //alert(ticket_zebra);
            imprimeBluetooth(mac_impresora_0, ticket_zebra);
        }
        else {
            vibraAlerta(500);
            OcultaLoader();
            muestraAlerta3('Impresora no compatible, verifíca los modelos compatibles en las configuraciones de la aplicación.', 'error');
        }
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

$('#modal_n_series').on('hidden.bs.modal', function () {
    LimpiaCampos();
    posiciona_focus();
});

$('#modalRegistro').on('hidden.bs.modal', function () {
    LimpiaCampos();
    posiciona_focus();
});

$('#modalRegistro').on('shown.bs.modal', function () {

    console.log('agregar: ' + agregar);
    if (agregar === true) {
        $('#txtCodigo1Forzado').prop('disabled', false);
        $('#txtCategoriaForzado').prop('disabled', false);
        $('#txtDescripcionForzado').prop('disabled', false);
        var codigoActivo = $('#txtCodigo').val();
        console.log('codigoActivo: ' + codigoActivo);
        $('#txtCodigo1Forzado').val(codigoActivo);
        $('#txtCodigo3Forzado').val(codigoActivo);

    }

    location.href = '#txtCodigo1Forzado';

    // ConsultaMarcas();
});


$('#modalRegistro').on('show.bs.modal', function () {
    console.log('agregar: ' + agregar);
    // if (agregar === true) {
    // ConsultaMarcas();
    // }
});


$('#modal_n_series').on('shown.bs.modal', function () {
    $('#txt_sn').val('').focus();
});


$('#modalOpciones').on('hidden.bs.modal', function () {
    LimpiaCampos();
    setTimeout(function () {
        posiciona_focus();
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
    $('#txtCodigo').val('').focus();
    $('#txtCodigo').prop('readonly', true);
    setTimeout(function () {
        $('#txtCodigo').prop('readonly', false);
    }, 100);
}

function elimina_seleccionado_local() {
    var n_filas = tabla.rows().count();
    if (n_filas === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('No hay registros para eliminar', 'error');
        $('#modalOpciones').modal('hide');
        posiciona_focus();
        return;
    }
    //suenaAlerta();
    var n_seleccionados = tabla.rows('.selected').count();
    if (n_seleccionados === 0) {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('Seleccione el registro a eliminar', 'warning');
        $('#modalOpciones').modal('hide');
        posiciona_focus();
        return;
    }
    //vibraAlerta(500);
    var dialog = confirm('¿Desea eliminar el registro seleccionado?');
    if (dialog === false) {
        $('#modalOpciones').modal('hide');
        $('#txtCodigo').val('').focus();
        return;
    }
    //eliminamos el registro de la base de datos 
    //northwind.deleteRows('registros', { cantidad: cantidad_seleccionada, codigo_1: codigo_seleccioando, n_serie: n_serie_seleccionado, fecha_captura: fecha_seleccionada, hora_captura: hora_seleccionada });
    northwind.deleteRows('registros', { ID: id_seleccionado });
    northwind.commit();

    suenaExito();
    $('#modalOpciones').modal('hide');
    //eliminamos el registro seleccionado de la tabla
    tabla.row('.selected').remove().draw(false);

    muestraAlerta3('Registro eliminado exitosamente', 'success');
    tabla.columns.adjust().draw(false);
    calculaTotales();
    LimpiaCampos();
    posiciona_focus();

}



function inserta_n_serie() {
    var lectura_serie = String($('#txt_sn').val().trim());
    if (lectura_serie === '') {
        suenaError();
        toastr.warning('captura el número serie para continuar', '', { "positionClass": "md-toast-bottom-center", "progressBar": true, "preventDuplicates": true, "timeOut": 3000 });
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

        //muestraAlerta3('Capture al menos un número serie para continuar', 'warning');
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

$('#txtNSerieViejo').on('keydown', function (e) {
    if (e.keyCode === 13) {
        $('#txtCodigo3Forzado').val('').focus();
    }
});

$('#btnAceptarNSerie').on('click', function () {
    $('#txtCodigo3Forzado').val('').focus();
});

$('#txtCodigo1Forzado').on('keydown', function (e) {
    if (e.keyCode === 13) {
        $('#txtCodigo3Forzado').focus();
    }
});

$('#txtCodigo3Forzado').on('keydown', function (e) {
    if (e.keyCode === 13) {
        $('#txtNSerieForzado').focus();
    }
});

$('#txtNSerieForzado').on('keydown', function (e) {
    if (e.keyCode === 13) {
        $('#selectMarca').focus();
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


$('#btnConsultaUbicacionEliminar').on('click', function () {
    consultaUbicacionEliminar();
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
$('input[type=checkbox][name=chkValidarCatalogo]').on('change', function () {
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


$('input[type=checkbox][name=chk_forzados]').on('change', function () {
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

$('input[type=checkbox][name=chkGPS]').on('change', function () {
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

$('input[type=checkbox][name=chk_lotes]').on('change', function () {
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

$('#chk_n_series').on('change', function () {
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

$('#chk_caducidad').on('change', function () {
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

$('#chk_cant_cero').on('change', function () {
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

$('#chk_cant_negativa').on('change', function () {
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


$('#chkGPS').on('change', function () {
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


var id_producto_seleccionado = 0;
var index_seleccionado = -1;
var cantidad_seleccionada = '';
var codigo_seleccioando = '';
var n_serie_seleccionado = '';
var fecha_seleccionada = '';
var hora_seleccionada = '';

// $('#tabla_datos tbody').on('click', 'tr', function () {
//     alert(tabla.row(this).data()); //muestra los datos de toda la fila separados por coma
//     index_seleccionado = this;
//     id_seleccionado = tabla.cell(index_seleccionado, 13).data(); //conseguimos el valor de la fila y celda deseada
//     //alert(id_seleccionado);

//     cantidad_seleccionada = tabla.cell(index_seleccionado, 0).data();
//     codigo_seleccioando = tabla.cell(index_seleccionado, 1).data();
//     n_serie_seleccionado = tabla.cell(index_seleccionado, 7).data();
//     fecha_seleccionada = tabla.cell(index_seleccionado, 9).data();
//     hora_seleccionada = tabla.cell(index_seleccionado, 10).data();

//     //alert(cantidad_seleccionada + '\n' + codigo_seleccioando + '\n' + fecha_seleccionada + '\n' + hora_seleccionada);


// });





MuestraLoader('');

consulta_almacenes();

$('#btnExportar').on('click', function () {
    var datos_tabla = northwind.queryAll('registros');
    var x = datos_tabla.length;
    if (x === 0) {
        $('#modalOpciones').modal('hide');
        vibraAlerta(500);
        muestraAlerta3('No hay registros para exportar', 'warning');
        return;
    }

    $(location).attr('href', 'inventario_exportacion_ssr.html?url=inventario');

});

function consultaCategoriasProductos() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        //alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var phpArchivo = ruta_php + 'productosCategoriasCatalogo.php';
        //alert('phpArchivo: ' + phpArchivo);
        var datos = 'id=' + idInventarioSeleccionado;
        // alert(datos);
        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {

                //alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                $('#selectCategoria').empty();
                $('#txtCategoriaForzado').empty();

                switch (status) {
                    case 'warning':
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');
                        break;
                    case 'danger':
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');
                        break;
                    case 'success':

                        $('<option/>', {
                            value: '',
                            html: 'TODAS LAS CATEGORÍAS'
                        }).appendTo('#selectCategoria');

                        $('<option/>', {
                            value: '',
                            html: 'SIN CATEGORÍA'
                        }).appendTo('#txtCategoriaForzado');

                        if (datosRecibidos.length > 0) {
                            datosRecibidos.forEach(function (element) {
                                if (element.categorias !== '') {
                                    $('<option/>', {
                                        value: element.categorias,
                                        html: element.categorias
                                    }).appendTo('#selectCategoria');

                                    $('<option/>', {
                                        value: element.categorias,
                                        html: element.categorias
                                    }).appendTo('#txtCategoriaForzado');
                                }
                            });
                        }
                        $('#selectCategoria')[0].selectedIndex = 0;
                        consultaInventarioPendiente();
                        break;
                }
                $('#selectCategoria').focus();

            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            }
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

function ConsultaMarcas() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        //alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var phpArchivo = ruta_php + 'ProductosMarcasCatalogo.php';

        var datos = 'id=' + idInventarioSeleccionado;
        console.log('phpArchivo: ' + phpArchivo);
        console.log(datos);
        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            timeout: 15000, // establecenes un timeout
            success: function (respuesta) {

                //alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                switch (status) {
                    case 'warning':
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');
                        break;
                    case 'danger':
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');
                        break;
                    case 'success':

                        $('#selectMarca').empty().select2({
                            // theme: 'bootstrap',                            
                            data: datosRecibidos.map(function (element) {
                                return { id: element.marca == null ? '' : element.marca, text: element.marca == null ? '' : element.marca };
                            }),
                            tags: true, // Habilitar la funcionalidad de creación de etiquetas
                            selectOnClose: true,
                            dropdownParent: $('#modalRegistro .modal-content'),
                            createTag: function (params) {
                                var term = $.trim(params.term);
                                if (term === "") {
                                    return null;
                                }
                                return {
                                    id: term,
                                    text: term,
                                    newTag: true
                                };
                            }
                        }).val(null).trigger('change');

                        break;
                }
                $('#selectCategoria').focus();

            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            }
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

$('#selectCategoria').on('change', function () {
    consultaInventarioPendiente();
});

$('#btnCamaraFoto1').on('click', function () {

    navigator.camera.getPicture(onSuccess, onFail, {
        quality: 80,
        destinationType: Camera.DestinationType.DATA_URL
    });

    function onSuccess(imageData) {
        imagenSeleccionada = imageData;
        var image = document.getElementById('picFoto1');
        image.src = "data:image/jpg;base64," + imageData;
    }

    function onFail(message) {
        imageData = '';
        muestraAlerta3(message, 'warning');
    }

});

$('#btnCamaraFoto2').on('click', function () {
    navigator.camera.getPicture(onSuccess, onFail, {
        quality: 80,
        destinationType: Camera.DestinationType.DATA_URL
    });

    function onSuccess(imageData) {
        imagenSeleccionada2 = imageData;
        var image = document.getElementById('picFoto2');
        image.src = "data:image/jpg;base64," + imageData;
    }

    function onFail(message) {
        imageData = '';
        muestraAlerta3(message, 'warning');
    }
});

$('#btnCamaraFoto3').on('click', function () {
    navigator.camera.getPicture(onSuccess, onFail, {
        quality: 80,
        destinationType: Camera.DestinationType.DATA_URL
    });

    function onSuccess(imageData) {
        imagenSeleccionada3 = imageData;
        var image = document.getElementById('picFoto3');
        image.src = "data:image/jpg;base64," + imageData;
    }

    function onFail(message) {
        imageData = '';
        muestraAlerta3(message, 'warning');
    }
});


document.addEventListener('deviceready', function () {
    //$(document).ready(function () {
    MuestraLoader('');
    // $('#lblTitulo').text(almacen_conteo);
    muestraAlerta3(almacen_conteo, 'info');
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consulta_lista_impresoras();
    consultaDatosServidor();
    consulta_datos_sesiones();
    abre_conexion_bd();
    cargaConfiguracionesLectura();
    OcultaLoader();
    consultaCategoriasProductos();
    ConsultaMarcas();
    // obtenerPosicionActual();
    actualizaPosicionActual();
    //$('#txt_ubicacion').focus();
    $('#chk_tipo_conteo').click();
});
