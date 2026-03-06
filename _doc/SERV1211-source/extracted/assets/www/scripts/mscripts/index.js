//    
function limpia_campos() {
    $('#txt_password').val('');
    $('#txt_usuario').focus();
}

$("#txt_usuario").on('keyup', function (e) {
    if (e.keyCode === 13) {
        iniciar_sesion();
    }
});

$("#txt_password").on('keyup', function (e) {
    if (e.keyCode === 13) {
        iniciar_sesion();
    }
});

function iniciar_sesion() {

    //if(modo_online == 0){

    //try {

    //    var usuario = $('#txt_usuario').val().trim();
    //    var password = $('#txt_password').val().trim();
    //    var status = '';
    //    var mensaje = '';

    //    var password_invalido = "<i class='fa fa-exclamation-triangle'></i><strong>Usuario o contraseña incorrectos.</strong>";

    //    if (usuario === '') {
    //        $('#mensaje').html('<i class="fa fa-exclamation"></i> <strong>Capture su usuario por favor.</strong>').css('display', 'inline').fadeOut(5000);
    //        $('#txt_usuario').val('').focus();
    //        return;
    //    }
    //    if (password === '') {
    //        $('#mensaje').html('<i class="fa fa-exclamation"></i> <strong>Capture su contraseña.</strong>').css('display', 'inline').fadeOut(5000);
    //        $('#txt_password').val('').focus();
    //        return;
    //    }

    //    password = sha256(password);

    //    MuestraLoader('');

    //    var datos_tabla = northwind.queryAll('usuarios', {
    //        query: { usuario: usuario, password: password }
    //    });

    //    OcultaLoader();
    //    //alert(JSON.stringify(datos_tabla));
    //    var x = datos_tabla.length;
    //    if (x === 0) {
    //        vibraAlerta(1000);
    //        MuestraAlerta3('Usuario o contraseña inválidos.', 'error');
    //        $('#mensaje').html('<i class="fa fa-exclamation"></i> <strong>Usuario o contraseña inválidos.').css('display', 'inline');
    //        $('#txt_password').focus();
    //        return;
    //    }

    //    id_usuario = datos_tabla[0].id_usuario;
    //    nombre_usuario = datos_tabla[0].nombre_usuario;
    //    administrador = datos_tabla[0].administrador;
    //    //alert(id_usuario + '\n' + nombre_usuario +'\n' + administrador);

    //    var fecha_hora = strFecha(0);
    //    guarda_datos_sesion(id_usuario, usuario, nombre_usuario, administrador, fecha_hora);
    //    $(location).attr('href', 'inicio.html');

    //}
    //catch (err) {
    //    alert(err.message);
    //}

}

//botones
$('#btn_login').click(iniciar_sesion);




function deshabilita_controles() {
    //$('*').attr('disabled', 'disabled');
    $('#txt_usuario').prop('disabled', true);
    $('#txt_password').prop('disabled', true);
    $('#btn_login').prop('disabled', true);
}

//---
//escaneamos los códigos de barra

function excel() {
    try {
        //var data = [
        //    { id: "1", name: "claudio" },
        //    { id: "2", name: "marta" },
        //    { id: "3", name: "isabela" }
        //];
        //var dirname = "Download";
        //var filename = "file-example.xls";
        //var sheetname = "Plan1";

        //window.xls.save(data, dirname, filename, sheetname,
        //    function () { alert('success'); }, 

        //    function (err) { alert(err); }
        //);

        //////////////////////////
        //window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, function (fs) {

        //    console.log('file system open: ' + fs.name);
        //    fs.root.getFile("newPersistentFile.txt", { create: true, exclusive: false }, function (fileEntry) {

        //        console.log("fileEntry is file?" + fileEntry.isFile.toString());
        //        // fileEntry.name == 'someFile.txt'
        //        // fileEntry.fullPath == '/someFile.txt'
        //        writeFile(fileEntry, null);

        //    }, onErrorCreateFile);

        //}, onErrorLoadFs);

    } catch (err) {
        alert(err.message);
    }
}

$('#btn_pruebas').on('click', function () {

});


$(location).attr('href', 'inicio.html');

document.addEventListener('backbutton', onBackKeyDown, false);
//si presionan el botón Back del dispositivo móvil cerramos la aplicación
function onBackKeyDown() {
    navigator.app.exitApp();
}

document.addEventListener('deviceready', function () {
    document.addEventListener('beforeuninstall', function () {
        // Código para limpiar el almacenamiento de la aplicación
        eliminaBDLocal();
    });
});



document.addEventListener('deviceready', function () {
    //$(document).ready(function () {

    //
    //creaBannerAd();

    //creaBDLocal();
    //creaBDSQLite();

    //si no hay usuarios registrados redireccionamos al inicio de la app
    if (n_usuarios() === 0) {
        $(location).attr('href', 'inicio.html');
        return;
    }

    //consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)

    $('#txt_usuario').val(usuario_logueado);

    ////validamos si el dispositivo tiene o no conexión a internet

    //if(consultaInfoConexion() === 'NoNetwork'){
    //    vibraAlerta(1000);
    //    deshabilita_controles();
    //    MuestraAlerta1('Algunas funciones de la aplicación requieren conexión a Internet, para continuar verifíque que su dispositivo se encuentre conectado a Internet e inicie nuevamente la aplicación.');
    //    return;
    //}
    //alert(version_actual);
    ////limpia_campos();

});
