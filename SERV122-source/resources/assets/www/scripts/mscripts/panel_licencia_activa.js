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

var cliente_activacion = obtener_parametros_url('cliente_activacion');
var id_activacion = obtener_parametros_url('id_activacion');
var fecha_fin = obtener_parametros_url('fecha_fin');

if (fecha_fin === strFecha(0)) {
    fecha_fin = '<strong class="text-danger">hoy</strong>';
}

function preguntaEliminarLicencia() {
    swal({
        title: 'Atención',
        text: 'Al eliminar la licencia de este dispositivo usted podrá migrarla a otro equipo solamente capturando el código de activación que recibió en su correo electrónico al realizar su compra.\n¿Desea continuar?',
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
                className: 'btn btn-danger',
                closeModal: true
            }
        }
    }).then(function (value) {
        switch (value) {
            case 'No':
                onBackKeyDown();
                break;
            case 'Si':
                eliminaLicenciaServidor();
                break;
        }
    });
}

$('#btnEliminarLicencia').on('click', function () {
    preguntaEliminarLicencia();
});


//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    $(location).attr('href', 'inicio.html');
}

$('#btn_aceptar').on('click', function () {
    onBackKeyDown();
});

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
};

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
};

document.addEventListener('deviceready', function () {
    try {
        validaBDLocal();
        var arrFecha = fecha_fin.split('-');
        var dia = arrFecha[2];
        var mes = arrFecha[1];
        var anio = arrFecha[0];
        fecha_fin = dia + '-' + mes + '-' + anio;
        if (anio == '2999') {
            $('#opcionEliminarLicencia').prop('hidden', false);
            mensaje = 'Producto activado a nombre de ' + cliente_activacion + '<br />Su ID de activación es: <b>' + id_activacion + '</b>';
        } else {
            var mensaje = 'Producto activado a nombre de ' + cliente_activacion + '<br />Su ID de activación es: <b>' + id_activacion + '</b><br />Su licencia estará activa hasta <b>' + fecha_fin + '</b>';
        }

        $('#lbl_mensaje').html(mensaje);
    } catch (err) {
        alert(err.message);
    }
});