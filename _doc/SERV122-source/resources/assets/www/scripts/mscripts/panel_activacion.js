var email_enviado = false;

document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {
    if ($('#modal_activacion').hasClass('show')) {
        $('#modal_activacion').modal('hide');
        return;
    }
    if ($('#modalEmailGmail').hasClass('show')) {
        $('#modalEmailGmail').modal('hide');
        return;
    }
    $(location).attr('href', 'inicio.html');
}

$('#btn_valida_licencia').on('click', function () {

    var codigo_activacion = $('#txt_codigo').val().trim();
    if (codigo_activacion === '') {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('Capture el código de activación para continuar.', 'warning');
        $('#txt_codigo').val('').focus();
        return;
    }
    activa_licencia(codigo_activacion);
});

$('#txt_codigo').on('keyup', function (e) {
    if (e.keyCode === 13) {
        var codigo_activacion = $('#txt_codigo').val().trim();
        if (codigo_activacion === '') {
            suenaError();
            vibraAlerta(500);
            MuestraAlerta3('Capture el código de activación para continuar.', 'warning');
            $('#txt_codigo').val('').focus();
            return;
        }
        activa_licencia(codigo_activacion);
    }
});

$('#btn_solicitar_lic').on('click', function () {
    $(location).attr('href', 'panel_pago.html');
});

$('#btnEliminarLicencia').on('click', function () {
    var dialog = confirm("A nombre de Código Fractal muchas gracias por la oportunidad de apoyarle en su empresa y por su honestidad, a continuación la aplicación se cerrará y será deshabilitada.");
    if (dialog === false) {
        return;
    }
    eliminaLicencia();
    eliminaDatosPago();
    navigator.app.exitApp();
});

$('#btnAceptarEmail').click(function (e) {

    var email = $('#txtEmailGmail').val().trim();
    if (email.length === 0) {
        suenaError();
        MuestraAlerta3('Capture una dirección de correo electrónico válida para continuar', 'warning');
        $('#txtEmailGmail').val('').focus();
        return;
    }
    if (!validaEmail(email)) {
        suenaError();
        MuestraAlerta3('Capture una dirección de correo electrónico válida para continuar', 'warning');
        $('#txtEmailGmail').val('').focus();
        return;
    }
    nonRenewing.openSubscriptionManager(); //abre la ventana con el status de vigencia
});


document.addEventListener('deviceready', function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, 

});