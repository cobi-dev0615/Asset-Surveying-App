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

var url_previa = 'inicio.html';
//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);
function onBackKeyDown() {
    $(location).attr('href', url_previa);
}

$('#btn_aceptar').on('click', function () {
    $(location).attr('href', url_previa);
});


function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
};

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
};

//document.addEventListener('deviceready', function () {
$('#lbl_mensaje').html('Producto activado a nombre de ' + cliente_activacion + '<br />ID de activación <strong>' + id_activacion + '</strong><br />Su licencia estará activa hasta <strong>' + fecha_fin + '</strong>');
//})();