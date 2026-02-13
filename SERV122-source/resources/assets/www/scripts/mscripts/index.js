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
    try {

        var usuario = $('#txt_usuario').val().trim();
        var password = $('#txt_password').val().trim();
        var fecha_hora = strFecha(0);

        var datos_tabla = northwind.queryAll('usuarios');
        console.log("Tabla usuarios: " + JSON.stringify(datos_tabla));

        if (usuario.length === 0) {
            vibraAlerta(500);
            MuestraAlerta3('Capture su nombre de usuario para continuar', 'warning');
            $('#txt_usuario').val('').focus();
            return;
        }
        if (password.length === 0) {
            vibraAlerta(500);
            MuestraAlerta3('Capture su contraseña para continuar', 'warning');
            $('#txt_password').val('').focus();
            return;
        }

        password = sha256(password);

        MuestraLoader('');

        datos_tabla = northwind.queryAll('usuarios', {
            query: { usuario: usuario, password: password }
        });

        OcultaLoader();
        console.log(JSON.stringify(datos_tabla));
        var x = datos_tabla.length;
        if (x === 0) {
            suenaError();
            //vibraAlerta(500);
            MuestraAlerta3('Usuario o contraseña inválidos.', 'error');
            $('#txt_password').focus();
            return;
        }

        //var id_usuario = datos_tabla[0].ID;
        var usuario = datos_tabla[0].usuario;
        var nombre_usuario = datos_tabla[0].nombre_usuario;
        var rol = datos_tabla[0].rol;
        console.log('rol: ' + rol);
        var esAdministrador = 1;
        if (rol == 1) {
            esAdministrador = 0;
        }

        var expiracion_sesion = datos_tabla[0].expiracion_sesion;
        if (expiracion_sesion < strFecha(0)) {
            suenaError();
            MuestraAlerta3('Usuario sin permiso de acceso.', 'warning');
            return;
        }

        GuardaDatosSesion(0, usuario, nombre_usuario, esAdministrador, fecha_hora);
        $(location).attr('href', 'inicio.html');

    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

//botones
$('#btn_login').on('click', function () {
    iniciar_sesion();
});




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


// $(location).attr('href', 'inicio.html');

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

    validaBDLocal();
    consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)
    consultaDatosServidor(); //consultamos los datos de conexión del servidor
    consulta_datos_sesiones(); //consultamos los datos del último usuario logueado en la aplicación y la fecha del último acceso


    if (n_usuarios() === 0) {
        $(location).attr('href', 'inicio.html');
        return;
    }

    //consultaInfoDispositivo(); //consultamos los datos del dispositivo (id, serie, fabricante, etc.)

    $('#txt_usuario').val(usuario_logueado);


    //si la fecha es mayor a 30 de mayo de 2025 cambiar la propiedad hidden a true de btnAcercaDe
    if (strFecha(0) > '2025-05-30') {
        $('#btnAcercaDe').prop('hidden', false);
    }

});
