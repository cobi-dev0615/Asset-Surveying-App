var urlPrevia = 'inicio.html';
//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {
    if ($('#modalUbicaciones').hasClass('show')) {
        $('#modalUbicaciones').modal('hide');
        return;
    }
    $(location).attr('href', urlPrevia);
}

//

function guarda_datos_almacen(almacen_conteo, nConteo) {
    try {
        //si esxite un registro con el id 1 se actualiza de lo contrario lo guarda como un nuevo registro
        northwind.insertOrUpdate('almacenes', { ID: 1 }, {
            nombre_almacen: almacen_conteo,
            n_conteo: nConteo,
            inventario: id_inventario,
            eliminado: 0
        });

        northwind.commit();
    }
    catch (err) {
        MuestraAlerta3(mensaje, 'error');
    }
}

function inicia_conteo() {
    var usuario_conteo = $('#txt_usuario').val().trim();
    if (usuario_conteo.length === 0) {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('Capture el nombre del usuario para continuar.', 'warning');
        $('#txt_usuario').val('').focus();
        return;
    }
    var almacen_conteo = $('#txt_almacen').val();
    if (almacen_conteo === '') {
        var dialog = confirm('No ha capturado el nombre del almacén donde se realizará el conteo.\n¿Desea continuar?');
        if (dialog === false) {
            $('#txt_almacen').val('').focus();
            return;
        }
    }

    $(location).attr('href', 'inventario_captura.html?ubicacion=');
}

$("#btnSiguiente").click(function (e) {
    //e.preventDefault();
    inicia_conteo();
});


function guarda_datos_conteo(usuario_conteo) {
    try {
        northwind.update('sesionesSSM', { ID: 1 }, function (row) {
            row.usuario_conteo = usuario_conteo;
            // the update callback function returns to the modified record
            return row;
        });

        northwind.commit();
    }
    catch (err) {
        MuestraAlerta1(mensaje);
    }
}

//botones
$("#btn_iniciar_conteo").click(function (e) {

    var usuario_conteo = $('#txt_usuario').val().trim();
    if (usuario_conteo.length === 0) {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('Capture el nombre del usuario para continuar.', 'warning');
        $('#txt_usuario').val('').focus();
        return;
    }
    var almacen_conteo = $('#txt_almacen').val();
    if (almacen_conteo === '') {
        var dialog = confirm('No ha capturado el nombre del almacén donde se realizará el conteo.\n¿Desea continuar?');
        if (dialog === false) {
            $('#txt_almacen').val('').focus();
            return;
        }
    }
    var nConteo = Number($('#txtNConteo').val());
    if (nConteo === '' || nConteo <= 0) {
        var dialog = confirm('No ha capturado el número de conteo.\n¿Desea continuar?');
        if (dialog === false) {
            $('#txtNConteo').val('').focus();
            return;
        }
        nConteo == 0;
    }
    if (nConteo < 0) {
        MuestraAlerta3('El número de conteo debe ser mayor a cero.', 'warning');
        $('#txtNConteo').val('').focus();
        return;
    }
    //if(usuario_conteo !== ''){
    guarda_datos_conteo(usuario_conteo);
    //}
    //if(almacen_conteo !== ''){
    guarda_datos_almacen(almacen_conteo, nConteo);
    //}

    var datos_tabla = northwind.queryAll('registros', {
        query: { nombre_almacen: almacen_conteo }
    });

    if (datos_tabla.length > 0) {
        datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, ROUND(SUM(cantidad)*precio_venta, 3) AS importe, nombre_almacen, ubicacion FROM ? GROUP BY nombre_almacen, ubicacion', [datos_tabla]);
        //console.log(datos_tabla.length);
        //console.log(JSON.stringify(datos_tabla));

        var lista = $('#listaUbicaciones');
        lista.empty();

        var fila = '';
        $.each(datos_tabla, function (index, dato_tabla) {

            fila += '<a href="inventario_captura.html?ubicacion=' + dato_tabla.ubicacion + '&nConteo=' + nConteo + '" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center waves-effect">'
                + '<div>'
                + '<div class="d-flex w-100 justify-content-between align-items-center m-0">'
                + '<h6>Ubicación: ' + dato_tabla.ubicacion + '</h6>'
                + '</div>'
                + '<p class="m-0 text-secondary small">'
                + 'Conteo total: ' + dato_tabla.cantidad.toLocaleString()
                + '</p>'
                + '</div >'
                + '<i class="fas fa-chevron-right fa-2x"></i>'
                + '</a >';


        });

        lista.append(fila);
        $('#modalUbicaciones').modal('show');

    }
    else {

        $(location).attr('href', 'inventario_captura.html?ubicacion=&nConteo=' + nConteo);
    }

});


function carga_valores() {
    MuestraLoader('');
    //si el usuario no es administrador deshabilitamos el campo de nombre de usuario

    $('#txt_usuario').val(nombre_usuario_logueado);

    if (usuario_conteo !== '') {
        $('#txt_usuario').val(usuario_conteo);
    }

    // var rol = consulta_datos_sesiones()[0].rol;
    console.log('es_administrador: ' + es_administrador);
    if (es_administrador == 0) {
        $('#txt_usuario').prop('disabled', true);
    }
    $('#txtNConteo').val(NConteoGuardado);

    var datos_tabla = northwind.queryAll('registros', {
        distinct: ['nombre_almacen']
    });

    if (datos_tabla.length === 0) {
        datos_tabla.push({ id: nombre_almacen, text: nombre_almacen }); //si no hay registros insertamos uno en el array
    } else {
        datos_tabla = alasql('SELECT nombre_almacen AS id, nombre_almacen AS text FROM ? GROUP BY nombre_almacen', [datos_tabla]);
    }


    $('#txt_almacen').select2({
        //tags: true,
        data: datos_tabla
        //insertTag: function (data, tag) {
        //    // Insertamos el tag al final de los resultados
        //    data.push(tag);
        //}
        //,
        //dropdownCssClass: 'font-weight-bold',
        //theme: 'bootstrap'
    });

    //método para establecer un valor en un select2 y asignarle el estilo de Bootstrap

    $('#txt_almacen').select2({
        tags: true,
        insertTag: function (data, tag) {
            // Insertamos el tag al final de los resultados
            data.push(tag);
        },
        dropdownCssClass: 'font-weight-bold',
        theme: 'bootstrap'
    }).val(nombre_almacen).trigger('change');
    OcultaLoader();
}


MuestraLoader('');

//document.addEventListener('deviceready', function () {
$(document).ready(function () {

    //$('#modalUbicaciones').modal('show');
    consulta_datos_sesiones();
    consulta_almacenes();
    carga_valores();


    //

});
