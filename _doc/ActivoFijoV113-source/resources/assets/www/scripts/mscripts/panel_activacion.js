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
    
    window.history.back();
}

$('#btn_valida_licencia').on('click', function () {

    var codigo_activacion = $('#txt_codigo').val().trim();
    if (codigo_activacion === '') {
        suenaError();
        vibraAlerta(500);
        muestraAlerta3('captura el código de activación para continuar.', 'warning');
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
            muestraAlerta3('captura el código de activación para continuar.', 'warning');
            $('#txt_codigo').val('').focus();
            return;
        }
        activa_licencia(codigo_activacion);
    }
});

$('#btn_solicitar_lic').on('click', function () {
    //$(location).attr('href', 'https://shop.codigofractal.com/software/22-ssmandroid.html');
    //$('#modalMetodoPago').modal('show');
    $(location).attr('href', 'panel_pago.html');
});




function solicitarPedido() {
    try {
        if (email_enviado === true) {
            vibraAlerta(500);
            muestraAlerta1('Ya hemos recibido su solicitud anteriormente, nos comunicaremos los antes posible con usted.\nGracias por su paciencia.');
            return;
        }
        var empresa = $('#txt_empresa').val().trim();
        var nombre = $('#txt_nombre').val().trim();
        var telefono = $('#txt_telefono').val().trim();
        var email = $('#txt_email').val().trim();
        var direccion = 'No identificado'; //$('#txt_direccion').val().trim();
        var pais = 'No identificado'; //$('#txt_pais').val().trim();
        var n_licencias = Number($('#txt_cantidad').val());
        
        if (empresa === '' || nombre === '' || telefono === '' || email === '' || direccion === '' || pais === '' || n_licencias === 0) {
            muestraAlerta1('Capture los campos obligatorios para continuar');
            return;
        }

        var datos = 'producto=' + producto +
            '&empresa=' + empresa + 
            '&nombre=' + nombre +
            '&telefono=' + telefono +
            '&email=' + email +
            '&direccion=' + direccion +
            '&pais=' + pais +
            '&n_licencias=' + n_licencias;

        //alert(datos);

        var php_consulta = ruta_php + 'solicitud_licencia.php';
        php_consulta = 'http://www.codigofractal.com/php/solicitud_licencia.php';
        //alert(php_consulta);
        MuestraLoader('Enviando solicitud...');
        $.ajax({
            type: 'POST',
            url: encodeURI(php_consulta),
            data: datos,
            crossDomain: true,
            cache: false,
            success: function (respuesta) {
                OcultaLoader();
                //alert(respuesta);
                if (respuesta === 'ok') {
                    
                    ////creaInterAd();
                    email_enviado = true;
                    alert('Hemos recibido su solicitud, uno de nuestros vendedores se comunicará con usted para validar su pedido y hacerle llegar la solicitud de pago.\nGracias por su preferencia!');
                    window.history.back();
                }
                else {
                    email_enviado = false;
                    vibraAlerta(1000);
                    muestraAlerta1(respuesta + '\nLa solicitud no pudo ser enviada, verifíca que el dispositivo tenga conexión a Internet y si el problema persiste contactenos a ventas@codigofractal.com');
                }

            },
            error: function (respuesta) {
                email_enviado = false;
                vibraAlerta(1000);
                OcultaLoader();
                var mensaje = JSON.stringify(respuesta) + '\nLa solicitud no pudo ser enviada, verifíca que el dispositivo tenga conexión a Internet y si el problema persiste contactenos a ventas@codigofractal.com';
                //muestraAlerta3(JSON.stringify(respuesta));
                muestraAlerta1(mensaje);
            }
        });


    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


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
        muestraAlerta3('Capture una dirección de correo electrónico válida para continuar', 'warning');
        $('#txtEmailGmail').val('').focus();
        return;
    }
    if (!validaEmail(email)) {
        suenaError();
        muestraAlerta3('Capture una dirección de correo electrónico válida para continuar', 'warning');
        $('#txtEmailGmail').val('').focus();
        return;
    }
    nonRenewing.openSubscriptionManager(); //abre la ventana con el status de vigencia
});


document.addEventListener('deviceready', function () {
//$(document).ready(function () {
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    ////consulta_permisos_uso(); //consultamos el status de la licencia de la aplicación

    

    ///////////
    var arrPrecios = [
        {
            id: '1', //7 días
            duration: 7
        },
        {
            id: '4', //1 mes
            duration: 30
        }, {
            id: '6', //3 meses
            duration: 90
        }, {
            id: '7', //6 meses
            duration: 180
        },
        {
            id: '8', //12 meses
            duration: 365
        }
    ];

 
    //nonRenewing.initialize({
    //    verbosity: store.RELEASE,
    //    products: arrPrecios
    //});
   

});