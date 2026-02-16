var urlPrevia = 'inicio.html';
//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    if ($('#modalUbicaciones').hasClass('show')) {
        $('#modalUbicaciones').modal('hide');
        return;
    }
    $(location).attr('href', urlPrevia);
}

//

function guarda_datos_almacen(almacen_conteo){
    try{
        //si esxite un registro con el id 1 se actualiza de lo contrario lo guarda como un nuevo registro
        northwind.insertOrUpdate('almacenes', { ID: 1 }, {	
            nombre_almacen: almacen_conteo,
            inventario:id_inventario,
            eliminado:0
        });
        
        northwind.commit();
    }
    catch (err) {
        MuestraAlerta3(mensaje, 'error');
    }
}

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
    var n_conteo = $('#comboNConteo').val();

    $(location).attr('href', 'inventario_cruzado_captura.html?n_conteo=' + n_conteo + '&ubicacion=');
}

//botones
$("#btnSiguiente").click(function (e) {
    //e.preventDefault();
    inicia_conteo();
});

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
    var n_conteo = $('#comboNConteo').val();
    //if(usuario_conteo !== ''){
    guarda_datos_conteo(usuario_conteo);
    //}
    //if(almacen_conteo !== ''){
    guarda_datos_almacen(almacen_conteo);
    //}

    var datos_tabla = northwind.queryAll('registros_cruzados', {
        query: { nombre_almacen: almacen_conteo, n_conteo: n_conteo }
    });

    if (datos_tabla.length > 0) {
        datos_tabla = alasql('SELECT SUM(cantidad) AS cantidad, ROUND(SUM(cantidad)*precio_venta, 2) AS importe, nombre_almacen, ubicacion, n_conteo FROM ? GROUP BY nombre_almacen, ubicacion, n_conteo', [datos_tabla]);
        //console.log(datos_tabla.length);
        //console.log(JSON.stringify(datos_tabla));

        var lista = $('#listaUbicaciones');
        lista.empty();
        
        var fila = '';
        $.each(datos_tabla, function (index, dato_tabla) {

            fila += '<li class="list-group-item d-flex justify-content-between align-items-center">'
                + '<div>'
                + '<h6 class="my-0">Ubicación: ' + dato_tabla.ubicacion + '</h6>'
                + '<label for="chk_forzados" class="text-primary small my-0">'
                + 'Conteo total: ' + dato_tabla.cantidad
                + '</label>'
                + '</div>'
                + '<div>'
                + '<a href="inventario_cruzado_captura.html?ubicacion=' + dato_tabla.ubicacion + '&n_conteo=' + n_conteo + ' "class="btn btn-sm btn-primary text-center rounded-circle text-center float" id="">'
                + '<i class="fa fa-arrow-right"></i>'
                + '</a>'
                + '</div>'
                + '</li >';

        });

        lista.append(fila);
        $('#modalUbicaciones').modal('show');

    }
    else {

        $(location).attr('href', 'inventario_cruzado_captura.html?n_conteo=' + n_conteo + '&ubicacion=');
    }

});


function carga_valores() {
    MuestraLoader('');
    //si el usuario no es administrador deshabilitamos el campo de nombre de usuario
    if (es_administrador === 0) {
        //$('#txt_usuario').prop('disabled', true);
    }
    $('#txt_usuario').val(nombre_usuario_logueado);

    if (usuario_conteo !== '') {
        $('#txt_usuario').val(usuario_conteo);
    }

    var datos_tabla = northwind.queryAll('registros_cruzados', {
        distinct: ['nombre_almacen']
    });
    //console.log(JS ON.stringify(datos_tabla));
    //alert(JSON.stringify(datos_tabla));
    if (datos_tabla.length === 0) {
        datos_tabla.push({ id: nombre_almacen, text: nombre_almacen }); //si no hay registros insertamos uno en el array
    } else {
        datos_tabla = alasql('SELECT nombre_almacen AS id, nombre_almacen AS text FROM ? GROUP BY nombre_almacen', [datos_tabla]);
    }

    //alert(JSON.stringify(datos_tabla));

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
    $('#txt_almacen').val(nombre_almacen);
    $('#txt_almacen').select2({
        tags: true,
        insertTag: function (data, tag) {
            // Insertamos el tag al final de los resultados
            data.push(tag);
        },
        dropdownCssClass: 'font-weight-bold',
        theme: 'bootstrap'
    }).trigger('change'); 
    OcultaLoader();
}

    //$('#txt_almacen').select2().data('select2').$container.addClass(''); //agrega una nueva clase al contenedor




//document.addEventListener('deviceready', function () {
$(document).ready(function () {

    //$('#modalUbicaciones').modal('show');
    consulta_datos_sesiones();
    consulta_almacenes();
    carga_valores();

    
    //

    //$('#txt_usuario').jQueryClearButton();
    //$('#txt_almacen').jQueryClearButton();
    //$('#txt_almacen').focus();

});
