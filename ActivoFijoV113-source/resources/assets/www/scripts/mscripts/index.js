var esEmpresaValida = true;
var empresaSeleccionada = -1;
var datosSesion;

function consultaCatalogoEmpresas() {

    try {
        MuestraLoader('Consultando empresas');

        var rutaPhp = ruta_php + 'empresasCatalogo.php';
        var datos = '';

        console.log('rutaPhp: ' + rutaPhp);
        console.log('datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(rutaPhp),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            success: function (respuesta) {

                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;

                $('#txtEmpresas').empty();

                switch (status) {
                    case 'warning':
                        muestraAlerta3(mensaje, status);
                        break;
                    case 'danger':
                        muestraAlerta3(mensaje, status);
                        break;
                    case 'success':
                        if (datosRecibidos.length > 0) {
                            datosRecibidos.forEach(function (element) {
                                $('<option/>', {
                                    value: element.id,
                                    html: element.nombre
                                }).appendTo('#txtEmpresas');
                            });
                        }
                        $('#txtEmpresas')[0].selectedIndex = -1;
                        $('#txtEmpresas').focus();
                        break;
                }
            },
            error: function (respuesta) {
                OcultaLoader();
                muestraAlerta1('Error consultaCatalogoEmpresas: ' + JSON.stringify(respuesta));

            },
            timeout: 7000 // establecenes un timeout
        });

    } catch (err) {
        OcultaLoader();
        muestraAlerta1('Error consultaCatalogoEmpresas: ' + err.message);
    }
}

function consultaCatalogoInventarios(datosRecibidos) {

    try {
        MuestraLoader('Consultando sucursales');

        // Validamos que el código de la empresa exista en el servidor
        var empresaSeleccionada = $('#txtEmpresas').val();
        var rutaPhp = ruta_php + 'inventariosEmpresa.php';

        var inventariosAcceso = datosRecibidos[0].inventariosAcceso || '';

        if (inventariosAcceso.length === 0) {
            OcultaLoader();
            MensajeAlerta('No tienes acceso a ningún inventario.', 'warning', ['Aceptar'], false, null);

            return;
        }

        //alert('rutaPhp: ' + rutaPhp);
        var datos = 'empresaSeleccionada=' + empresaSeleccionada +
            '&inventariosAcceso=' + inventariosAcceso;
        // alert(datos);
        $.ajax({
            type: 'POST',
            url: encodeURI(rutaPhp),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            dataType: 'json',
            encode: true,
            success: function (respuesta) {

                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;


                $('#comboInventarios').empty();

                switch (status) {
                    case 'success':
                        nSucursales = datosRecibidos.length;

                        $('#comboInventarios').select2({
                            dropdownParent: '#modalInventarios',
                            placeholder: 'Selecciona una sucursal',
                            allowClear: true,
                            width: '100%',
                            theme: 'bootstrap',

                            data: datosRecibidos.map(function (element) {
                                return {
                                    id: element.id,
                                    text: element.sucursal + ': ' + element.nombre
                                };
                            })
                        }).val(null).trigger('change');

                        $('#modalInventarios').modal('show');


                        break;
                    default:
                        MensajeAlerta(mensaje, status, ['Aceptar'], false, null);
                        return;
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

function iniciarSesion(sucursalSeleccionada) {
    try {
        var usuario = $('#txtUsuario').val().trim();
        var password = $('#txtPassword').val().trim();
        var empresaSeleccionada = $('#txtEmpresas').val();
        var nombreEmpresaSeleccionada = $('#txtEmpresas option:selected').text();
        var inventarioSeleccionado = $('#comboInventarios').val();
        var nombreInventarioSeleccionado = $('#comboInventarios option:selected').text();
        var recordar_sesion = 0;
        if (empresaSeleccionada === '' || empresaSeleccionada === null) {
            suenaError();
            muestraAlerta3('Selecciona la empresa que deseas consultar.', 'warning');
            $('#txtEmpresas').val('').focus();
            return;
        }

        if (usuario.length === 0) {
            suenaError();
            muestraAlerta3('Captura tu nombre de usuario para continuar.', 'warning');
            $('#txtUsuario').val('').focus();
            return;
        }
        if (password.length === 0) {
            suenaError();
            muestraAlerta3('Captura tu contraseña para continuar.', 'warning');
            $('#txtPassword').val('').focus();
            return;
        }
        if (sucursalSeleccionada === true) {
            if (inventarioSeleccionado === '' || inventarioSeleccionado === null) {
                suenaError();
                muestraAlerta3('Selecciona la sucursal que deseas consultar.', 'warning');
                $('#comboInventarios').val('').focus();
                return;
            }
        }
        if ($('#chk_recordar').is(':checked')) {
            recordar_sesion = 1;
        }

        inhabilitarBotonLogin();

        password = sha256(password);

        var rutaPhp = ruta_php + 'loginV2.php';

        var datos = 'empresaSeleccionada=' + empresaSeleccionada
            + '&nombreEmpresaSeleccionada=' + nombreEmpresaSeleccionada
            + '&usuario=' + usuario
            + '&password=' + password;

        console.log('rutaPhp: ' + rutaPhp);
        console.log('datos: ' + datos);

        $.ajax({
            type: 'POST',
            url: encodeURI(rutaPhp),
            data: datos,
            crossDomain: true,
            cache: false,
            async: true,
            // dataType: 'json',
            // encode: true,
            timeout: 20000,
            success: function (respuesta) {

                //alert(JSON.stringify(respuesta));
                console.log(JSON.stringify(respuesta));
                OcultaLoader();

                habilitarBotonLogin();

                var status = respuesta[0].status;
                var mensaje = respuesta[0].mensaje;
                var datosRecibidos = respuesta[0].datos;
                switch (status) {
                    case 'success':
                        datosSesion = datosRecibidos;
                        suenaExito();
                        consultaCatalogoInventarios(datosRecibidos); ////dependiendo del rol del usuario mostramos o no los inventarios ya terminados
                        break;
                    default:
                        MensajeAlerta(mensaje, status, ['Aceptar'], true, null);
                        break;
                }


            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('Error Ajax Login:', JSON.stringify(jqXHR), textStatus, errorThrown);
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
            },
            complete: function () {
                habilitarBotonLogin();
                OcultaLoader();
            }
        });

    }
    catch (err) {
        console.error('Error iniciarSesion: ' + err.message);
        habilitarBotonLogin();
        OcultaLoader();
        MensajeAlerta('Error iniciarSesion: ' + err.message, 'danger', ['Aceptar'], false, null);
    }
}

$("#modalInventarios").on('hidden.bs.modal', function () {
    LimpiaCampos();
});


function inhabilitarBotonLogin() {
    MuestraLoader('');
    $('#txtUsuario').prop('disabled', true);
    $('#txtPassword').prop('disabled', true);


    $('#btnLogin').html('<i class="fas fa-spinner fa-spin"></i> Procesando');
    $('#btnLogin').prop('disabled', true);
}

function habilitarBotonLogin() {
    OcultaLoader();
    $('#txtUsuario').prop('disabled', false);
    $('#txtPassword').prop('disabled', false);

    //cambiamos el estilo de los botones
    if (!esEmpresaValida) {
        $('#btnLogin').removeClass('btn-success').addClass('btn-primary');
        $('#btnLogin').html('<i class="fas fa-check"></i> Validar correo electrónico');
        $('#btnCancelar').prop('hidden', true);

    } else {
        $('#btnLogin').removeClass('btn-primary').addClass('btn-success');
        $('#btnLogin').html('<i class="fas fa-sign-in-alt"></i> Iniciar sesión');
        $('#btnCancelar').prop('hidden', false);
    }
    $('#btnLogin').prop('disabled', false);
}

function LimpiaCampos() {
    empresaSeleccionada = -1;
    $('#formLogin')[0].reset(); //limpiamos el formulario
    habilitarBotonLogin(); //reestablecemos el estilo del botón
    consultaCatalogoEmpresas();

}

/* 
eventos 
*/
$('#txtEmpresas').on('change', function () {

});

$('#txtPassword').on('keydown', function (e) {
    if (e.keyCode === 13) {
        iniciarSesion(false);
    }
});

$('#btnLogin').on('click', function () {
    iniciarSesion(false);
});

$('#btnAceptarInventario').on('click', function () {

    var inventarioSeleccionado = $('#comboInventarios').val();
    var nombreInventarioSeleccionado = $('#comboInventarios option:selected').text();
    if (inventarioSeleccionado === '' || inventarioSeleccionado === null) {
        // $('#lblMensaje2').html('<div class="alert alert-warning fade show"><i class="far fa-smile fa-lg"></i> Selecciona la sucursal que deseas consultar.</div>');
        MensajeAlerta('Selecciona la sucursal que deseas consultar.', 'warning', ['Aceptar'], false, null);
        $('#comboInventarios').focus();
        return;
    }
    datosSesion[0].inventarioSeleccionado = inventarioSeleccionado;
    datosSesion[0].nombreInventarioSeleccionado = nombreInventarioSeleccionado;


    guardaDatosSesion(datosSesion);

    $(location).attr('href', 'inicio.html');

    // iniciarSesion(true);
});

$('#btnAceptarConexion').on('click', function () {
    try {
        var strConexion = $('#txtServidor').val().trim();
        LimpiaCampos();
        if (strConexion.length === 0) {
            suenaError();
            muestraAlerta3('Captura la dirección del servidor para continuar', 'warning');

            return;
        }
        guardaDatosConexion(1, strConexion, strConexion);
        $('#modal_info').modal('hide');
        consultaCatalogoEmpresas();
    } catch (err) {
        alert(err.message);
    }
});


document.addEventListener('backbutton', onBackKeyDown, false);
//si presionan el botón Back del dispositivo móvil cerramos la aplicación
function onBackKeyDown() {
    navigator.app.exitApp();
}

document.addEventListener('deviceready', function () {
    try {
        creaBDLocal();
        creaBDSQLite();
        consultaDatosServidor();

        // // //si hay datos de sesión en el localstorage redirigimos al panel
        // if (consultaDatoSesionActual().length > 0) {
        //     $(location).attr('href', 'inicio.html');
        // } else {
        consultaCatalogoEmpresas();
        // }
        $('#txtServidor').val(nombre_servidor);
        $('#txtUsuario').val(usuario_logueado);
        ConsultaActualizacionApp(); //consultamos si hay una actualización de la aplicación disponible

        if (consultaInfoConexion() === 'NoNetwork') {
            alert('El dispositivo no cuenta con conexión a Internet.');
        }

        if (configuracionesApp.modoDebug) {
            $('#txtUsuario').val('mgarcia');
            $('#txtPassword').val('123');
        }


    } catch (err) {
        alert(err.message);
    }
});
