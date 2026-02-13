/**
 * variables y funciones
 */
var url_previa = 'index.html';
var coloresGraficas = ['#ff4444', '#00C851', '#4285F4', '#33b5e5', '#ffbb33', '#aa66cc', '#2BBBAD', '#2E2E2E', '#3F729B', '#c51162'];
var tablaAvanceInventario;
var tablaAvanceDepartamento;
var tablaAvanceCategoria;

function saludoHorario() {

    var hora = strHora();
    var strSaludo = '<i class="far fa-sun"></i> Buen día ';
    if (hora >= '00:00:00' && hora < '12:00:00') {
        strSaludo = '<i class="far fa-sun"></i> Buen día ';
    } else if (hora >= '12:00:00' && hora <= '19:00:00') {
        strSaludo = '<i class="fas fa-sun"></i> Buena tarde ';
    } else {
        strSaludo = '<i class="far fa-moon"></i> Buena noche ';
    }
    return strSaludo;
}

function validaSesion() {
    try {
        var nombreEmpresa = '';
        var nombreSucursal = '';
        var nombreUsuario = '';
        var logoEmpresa = '';
        var nombreInventario = '';
        var idInventarioSeleccionado = 0;
        var datosSesion = consultaDatoSesionActual();
        //  alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var idEmpresa = datosSesion[0].idEmpresa;
        nombreEmpresa = datosSesion[0].nombreEmpresaSeleccionada;
        nombreSucursal = datosSesion[0].nombreSucursal;
        nombreUsuario = datosSesion[0].nombreUsuario;
        logoEmpresa = datosSesion[0].imagenLogo;
        idInventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        nombreInventario = datosSesion[0].nombreInventarioSeleccionado;
        var rolUsuario = datosSesion[0].idRol;
        var fechaActual = strFecha(0).split('-');
        var dia = fechaActual[2];
        var mes = fechaActual[1];
        var anio = fechaActual[0];
        $('#lblSesionUsuario').html('<i class="fas fa-user"></i> ' + nombreUsuario);
        $('#lblNombreEmpresa').html(nombreEmpresa);
        $('#lblNombreSucursal').html(nombreInventario);

        $('#lblMsgInicial').html(saludoHorario() + ' ' + nombreUsuario + ' <br><small>Estos son los avances del inventario al día de hoy ' + dia + '-' + mes + '-' + anio + '.</small>');

        // $('#lblNombreSucursal').text(nombreSucursal);
        if (logoEmpresa !== '' && logoEmpresa !== null) {
            //$('#logoEmpresa').attr('src', 'empresas/' + idSucursal + '/img/logo/' + logoEmpresa);
        }
        if (rolUsuario === '4') {
            $('#seccionBtn1').prop('hidden', true);
            // $('#seccionBtn2').prop('hidden', false);
        }
    } catch (err) {
        alert(err.message);
    }
}

function cierraSesion() {
    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        var idRegistroSesion = datosSesion[0].idRegistroSesion;

        var phpArchivo = ruta_php + 'sesionCerrar.php';

        var datos = 'idRegistroSesion=' + idRegistroSesion;
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
            success: function (respuesta) {

                // alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;


                switch (status) {
                    case 'warning':
                        // mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'danger':
                        // mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'success':
                        muestraAlerta3(mensaje, status);
                        break;
                }
                //independientemente de la respuesta vamos a cerrar sesión
                eliminaDatosSesion();
                $(location).attr('href', 'index.html'); //redireccionamos a la pantalla de login
            },
            error: function (respuesta) {
                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));
                eliminaDatosSesion();
                $(location).attr('href', 'index.html'); //redireccionamos a la pantalla de login
            },
            timeout: 7000 // establecenes un timeout
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error cierraSesion: ' + err.message);
    }


}

/**
 * inicia grafica de avance de inventario 
 */
function consultaAvanceInventario() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        var idInventario = datosSesion[0].inventarioSeleccionado;
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var phpArchivo = ruta_php + 'reporteGralAvanceInventario.php';
        //alert('phpArchivo: ' + phpArchivo);
        var datos = 'id=' + idInventario;

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            success: function (respuesta) {

                // alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                switch (status) {
                    case 'warning':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'danger':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'success':
                        var nRegistros = datosRecibidos.length;
                        if (nRegistros === 0) {
                            //mensajeAlerta('No hay datos registrados', 'warning', false, null);
                        }

                        var datosTabla = [];

                        var datosGrafica = [];
                        if (nRegistros === 0) {
                            datosGrafica = [
                                ['ACTIVOS PENDIENTES POR CONTAR', 100], //siempre 100 porque representa el 100% del total
                                ['ENCONTRADOS', 0],
                                ['NO ENCONTRADOS', 0]
                            ];
                        }
                        //tomamos los datos para la tabla y la gráfica respectivamente 
                        if (datosRecibidos.length > 0) {
                            datosRecibidos.forEach(function (element) {
                                var nContados = Number(element.nEncontrados) + Number(element.nNoEncontrados);
                                // alert('nContados: ' + nContados);
                                var nFaltantes = Number(element.nProductos) - nContados;
                                // alert('nFaltantes: ' + nFaltantes);

                                // datosTabla.push({
                                //     'nProductos': element.nProductos,
                                //     'nContados': element.nContados,
                                //     'nNoContados': element.nNoEncontrados,
                                //     'nFaltantes': nFaltantes
                                // });

                                var porcentajeEncontrados = (100 / Number(element.nProductos)) * Number(element.nEncontrados);
                                var porcentajeNoEncontrados = (100 / Number(element.nProductos)) * Number(element.nNoEncontrados);
                                var porcentajePendientes = 100 - porcentajeEncontrados - porcentajeNoEncontrados;//(100 / Number(element.nProductos)) * nFaltantes;

                                // alert('porcentajePendientes: ' + porcentajePendientes);
                                // alert('porcentajeEncontrados: ' + porcentajeEncontrados);
                                // alert('porcentajeNoEncontrados: ' + porcentajeNoEncontrados);
                                datosGrafica.push(['ACTIVOS PENDIENTES POR CONTAR', porcentajePendientes]);
                                datosGrafica.push(['ENCONTRADOS', porcentajeEncontrados]);
                                datosGrafica.push(['NO ENCONTRADOS', porcentajeNoEncontrados]);

                            });
                        }
                        // inicializaTabla(datosTabla);
                        inizializaGraficaAvanceInventario(datosGrafica);
                        break;
                }

            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            },
            timeout: 7000 // establecenes un timeout
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

var graficaAvanceInventario;

function inizializaGraficaAvanceInventario(datosGrafica) {
    try {
        graficaAvanceInventario = c3.generate({
            bindto: '#graficaAvanceInventario',
            data:
            {
                // iris data from R
                columns: datosGrafica,
                type: 'donut' //,
                //onclick: function (d, i) { console.log("onclick", d, i); },
                // onmouseover: function (d, i) { console.log("onmouseover", d, i); },
                //onmouseout: function (d, i) { console.log("onmouseout", d, i); }
            },
            donut:
            {
                title: 'Avance del inventario',
                label: {
                    show: true
                }
            },
            color:
            {
                pattern: coloresGraficas
            }
            // axis: {
            //     y: {
            //         inverted: false
            //     },
            //     x: {
            //         tick: {
            //             rotate: 60
            //         }
            //     }
            // }
        });
    } catch (err) {
        alert(err.message);
    }
}
/**
 * finaliza grafica de avance de inventario 
 */


/**
 * inicia reporte de avance por departamento
 */
function consultaAvanceDepartamento() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        var idInventario = datosSesion[0].inventarioSeleccionado;
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var phpArchivo = ruta_php + 'reporteGralAvanceDepartamento.php';
        //alert('phpArchivo: ' + phpArchivo);
        var datos = 'id=' + idInventario;

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            success: function (respuesta) {

                //alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                switch (status) {
                    case 'warning':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'danger':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'success':

                        var nRegistros = datosRecibidos.length;
                        if (nRegistros === 0) {
                            //mensajeAlerta('No hay datos registrados', 'warning', false, null);
                        }

                        //inicializaTablaAvanceDepartamento(datosRecibidos);

                        var datosGrafica = []; //siempre 100 porque representa el 100% del total
                        if (nRegistros === 0) {
                            datosGrafica = [['', 0]];
                        }
                        //tomamos los datos para la gráfica 
                        if (datosRecibidos.length > 0) {
                            datosRecibidos.forEach(function (element) {
                                var porcentajeAvance = (100 / Number(element.n_productos)) * Number(element.n_contados);
                                var nombreAlmacen = element.nombre_almacen;
                                datosGrafica.push([nombreAlmacen, porcentajeAvance]);
                            });
                        }
                        inizializaGraficaAvanceDepartamento(datosGrafica);

                        break;
                }

            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            },
            timeout: 7000 // establecenes un timeout
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

var graficaAvanceDepartamento;

function inizializaGraficaAvanceDepartamento(datosGrafica) {
    setTimeout(function () {
        graficaAvanceDepartamento = c3.generate(
            {
                bindto: '#graficaAvanceDepartamento',
                data:
                {
                    // iris data from R
                    columns: datosGrafica,
                    type: 'donut' //,
                    // onclick: function (d, i) { console.log("onclick", d, i); },
                    // onmouseover: function (d, i) { console.log("onmouseover", d, i); },
                    //onmouseout: function (d, i) { console.log("onmouseout", d, i); }
                },
                donut:
                {
                    title: 'Porcentaje por área'

                },
                color:
                {
                    pattern: coloresGraficas
                }
            });
    }, 1000);
}

/**
 * finaliza reporte de avance por departamento
 */


/**
 * inicia reporte de avance por Categoría
 */

function consultaAvanceCategoria() {

    try {
        MuestraLoader('');

        var datosSesion = consultaDatoSesionActual();
        var idInventario = datosSesion[0].inventarioSeleccionado;
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var phpArchivo = ruta_php + 'reporteGralAvanceCategoria.php';
        //alert('phpArchivo: ' + phpArchivo);
        var datos = 'id=' + idInventario;

        $.ajax({
            type: 'POST',
            url: encodeURI(phpArchivo),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            success: function (respuesta) {

                //alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                switch (status) {
                    case 'warning':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'danger':
                        mensajeAlerta(mensaje, status, true, null);
                        break;
                    case 'success':

                        var nRegistros = datosRecibidos.length;
                        if (nRegistros === 0) {
                            //mensajeAlerta('No hay datos registrados', 'warning', false, null);
                        }

                        // inicializaTablaAvanceCategoria(datosRecibidos);

                        var datosGrafica = [];
                        if (nRegistros === 0) {
                            datosGrafica = [['', 0]];
                        }
                        var totalRegistros = 0;
                        //tomamos los datos para la gráfica 
                        if (datosRecibidos.length > 0) {
                            datosRecibidos.forEach(function (element) {
                                //var porcentajeAvance = (100 / Number(element.n_productos)) * Number(element.n_contados);
                                var categoria_2 = element.categoria_2;
                                var cantidad = element.cantidad;
                                totalRegistros += cantidad;
                                datosGrafica.push([categoria_2, cantidad]);
                            });
                            //datosGrafica.push([nombreAlmacen, porcentajeAvance]);
                        }
                        inizializaGraficaAvanceCategoria(datosGrafica);
                        break;
                }

            },
            error: function (respuesta) {

                OcultaLoader();
                muestraAlerta1('Error: ' + JSON.stringify(respuesta));

            },
            timeout: 7000 // establecenes un timeout
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}


var graficaAvanceCategoria;

function inizializaGraficaAvanceCategoria(datosGrafica) {
    setTimeout(function () {
        graficaAvanceCategoria = c3.generate(
            {
                bindto: '#graficaAvanceCategoria',
                data:
                {
                    // iris data from R
                    columns: datosGrafica,
                    type: 'bar' //,
                    //onclick: function (d, i) { console.log("onclick", d, i); },
                    // onmouseover: function (d, i) { console.log("onmouseover", d, i); },
                    //onmouseout: function (d, i) { console.log("onmouseout", d, i); }
                },
                bar:
                {
                    title: 'Porcentaje por categoría',
                    width: {
                        ratio: 0.5 // this makes bar width 50% of length between ticks
                    }

                },
                color:
                {
                    pattern: coloresGraficas
                }
            });
    }, 1000);

    //ajustamos el tamaño de la gráfica dependiendo de la cantidad de datos para que se ajuste un poco mejor
    setTimeout(function () {
        if (datosGrafica.length > 5 && datosGrafica.length <= 10) {
            graficaAvanceCategoria.resize({ height: 400, weight: 500 })
        }
        else if (datosGrafica.length > 10 && datosGrafica.length <= 15) {
            graficaAvanceCategoria.resize({ height: 500, weight: 500 })
        }
        else if (datosGrafica.length > 15 && datosGrafica.length <= 18) {
            graficaAvanceCategoria.resize({ height: 600, weight: 500 })
        }
        else if (datosGrafica.length > 18 && datosGrafica.length <= 25) {
            graficaAvanceCategoria.resize({ height: 800, weight: 500 })
        }
        else if (datosGrafica.length > 25) {
            graficaAvanceCategoria.resize({ height: 1200, weight: 500 })
        }
    }, 1000);
}

/**
 * finaliza reporte de avance por Categoría
 */

function onBackKeyDown() {
    OcultaLoader(); //en caso de que esté visible
   
    if ($('#modal_impresoras').hasClass('show')) {
        $('#modal_impresoras').modal('hide');
        return;
    }
    
    if (n_usuarios() > 0) {
        $(location).attr('href', url_previa);
        return;
    }
    preguntaSalir();
}

/**
 * eventos
 */

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').click(function (e) {
    //alert('Salir');
    var datosSesion = consultaDatoSesionActual();
    //si no hay datos de sesión guardados cerramos la sesión
    if (datosSesion.length === 0) {
        cierraSesion();
    }
    e.preventDefault();
    swal({
        title: datosSesion[0].nombreUsuario,
        text: '¿Deseas cerrar tu sesión?',
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
                cierraSesion();
                break;
        }
    });
});


$('#btnSalir').click(function (e) {
    preguntaSalir(e);
});

function preguntaSalir() {
    var datosSesion = consultaDatoSesionActual();
    //si no hay datos de sesión guardados cerramos la sesión
    if (datosSesion.length === 0) {
        cierraSesion();
    }
    // e.preventDefault();
    swal({
        title: datosSesion[0].nombreUsuario,
        text: '¿Deseas cerrar tu sesión?',
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
                cierraSesion();
                break;
        }
    });
};

$('#btnModalSalir').on('click', function () {
    navigator.app.exitApp();
});


$('#btn_inventario').on('click', function () {
    $(location).attr('href', 'inventario_ubicacion.html');
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
        muestraAlerta3('Impresora no compatible, verifíca los modelos compatibles en las configuraciones de la aplicación', 'error');
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

$('#combo_dispositivos_bluetooth_0').on('change', function () {
    guarda_datos_impresora();
});

$('#combo_dispositivos_bluetooth_1').on('change', function () {
    guarda_datos_impresora();
});

$('#combo_marca_impresora').on('change', function () {
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
                muestraAlerta1('No se encontraron impresoras emparejadas con este dispositivo, empareje al menos una impresora para continuar.');
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
                    muestraAlerta1('No se encontraron impresoras sincronizadas con este dispositivo, empareje al menos una impresora para continuar.');
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
    muestraAlerta1('No se encontraron dispositivos conectados, enciende el bluetooth e intenta nuevamente.');
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
        //lista_dispositivos_1.selectmenu('refresh');
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
        //muestraAlerta3('Datos guardados exitosamente', 'success');
        consultaDatosServidor();
    }
    catch (error) {
        alert(error.message);
    }
}

//licencia
$('#btn_licencia').on('click', function () {
    //consulta_permisos_uso();
    if (status_licencia === 'vigente') {
        if (id_activacion === 0) {
            $(location).attr('href', 'panel_activacion.html');
            return;
        }
        else {

            $(location).attr('href', 'panel_licencia_activa.html?cliente_activacion=' + cliente_activacion + '&id_activacion=' + id_activacion + '&fecha_fin=' + fecha_fin_activacion);
            //var mensaje = 'Producto activado a nombre de ' + cliente_activacion + '\nID de activación: ' + id_activacion;
            //muestraAlerta1(mensaje);
        }
    }
});

$('#btnActualizar').on('click', function () {
    consultaInformacion();
});

function consultaInformacion() {

    consultaAvanceInventario();
    consultaAvanceDepartamento();
    consultaAvanceCategoria();
}

document.addEventListener('deviceready', function () {

    validaBDLocal();

    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consultaDatosServidor(); //consultamos los datos de conexión del servidor
    consulta_datos_sesiones(); //consultamos los datos del último usuario logueado en la aplicación y la fecha del último acceso
    //consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación
    /*
    Comparamos la fecha de la última sesión contra la fecha en que inició el periodo de la licencia, si se detecta un intento de trampa
    se cierra la aplicación
    */
    //console.log('Último acceso: ' + fechaUltimoAcceso);
    // if (fechaUltimoAcceso > strFecha(0)) {
    //     muestraAlerta3('Su último acceso fue en: ' + fechaUltimoAcceso, 'error');
    //     vibraAlerta(500);
    //     alert('Para poder usar la aplicación es necesario que la fecha y hora del dispositivo sean correctos.');
    //     navigator.app.exitApp();
    // } else {
    //     ////si todo sale bien guardamos la fecha del último acceso
    //     actualizaFechaSesion(strFecha(0));
    // }
    validaSesion();
    consultaInformacion();

    $('#lblVersion').text(configuracionesApp.versionSoftware);

});