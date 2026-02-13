var url_previa = 'inicio.html';

function consultaCatalogoDepartamentos() {

    try {
        MuestraLoader('');
        var datosSesion = consultaDatoSesionActual();
        //alert(JSON.stringify(datosSesion));
        //si no hay datos de sesión guardados cerramos la sesión
        if (datosSesion.length === 0) {
            cierraSesion();
        }
        var inventarioSeleccionado = datosSesion[0].inventarioSeleccionado;
        var phpArchivo = ruta_php + 'departamentosInventariadosCatalogo.php';
        //alert('phpArchivo: ' + phpArchivo);
        var datos = 'id=' + inventarioSeleccionado;

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
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');

                        break;
                    case 'danger':
                        muestraAlerta3('<div class="alert alert-' + status + ' fade show"><i class="far fa-warning fa-lg"></i> ' + mensaje + '.</div>', 'warning');

                        break;
                    case 'success':
                        //predefinimos una lista de ubicaciones 
                        var ubicacionesPredeterminadas = [
                            'Peso Libre',
                            'Peso Integrado',
                            'Shape y Box',
                            'Cardio',
                            'Salón de Clases',
                            'Site', 'Gerencia',
                            'Recepción',
                            'Bodega',
                            'Vestidores',
                            'Staff',
                            'Cuarto de Limpieza',
                            'Cuarto de Mantenimiento',
                            'Cabinas (Colágeno y Bronceado)'
                        ];

                        var almacenes = [];

                        if (datosRecibidos.length > 0) {
                            //insertamos las ubicaciones existentes en la bd al arreglo 
                            datosRecibidos.forEach(function (element) {
                                if (!ubicacionesPredeterminadas.includes(element.nombre_almacen)) {
                                    //si el registro aún no está agregado en el arreglo lo agregamos
                                    ubicacionesPredeterminadas.push(element.nombre_almacen);
                                }
                            });

                        }
                        // ordenamos todos los registros del arreglo y los insertamos en un arreglo de objetos para que lo reconozca el combobox
                        ubicacionesPredeterminadas.sort().forEach(function (element) {
                            almacenes.push({ 'id': element, 'text': element });
                        });

                        // //método para establecer un valor en un select2 y asignarle el estilo de Bootstrap
                        $('#txtAlmacen').select2({
                            data: almacenes,
                            tags: true,
                            insertTag: function (data, tag) {
                                // Insertamos el tag al final de los resultados
                                data.push(tag);
                            },
                            dropdownCssClass: 'font-weight-bold',
                            // theme: 'bootstrap'
                        }).trigger('change');

                        $('#txtAlmacen').val(null).trigger('change'); //cambiamos el valor seleccionado a null
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
        muestraAlerta1('Error consultaCatalogoDepartamentos: ' + err.message);
    }
}

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
    $(location).attr('href', url_previa);
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
        muestraAlerta3(mensaje, 'error');
    }
}

function inicia_conteo() {

    var almacen_conteo = $('#txtAlmacen').val();
    if (almacen_conteo === '') {
        var dialog = confirm('No ha capturado el nombre del almacén donde se realizará el conteo.\n¿Desea continuar?');
        if (dialog === false) {
            $('#txtAlmacen').val('').focus();
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
        muestraAlerta1(mensaje);
    }
}

//botones
$("#btn_iniciar_conteo").click(function (e) {

    var nConteo = 1;
    var almacen_conteo = $('#txtAlmacen').val();
    if (almacen_conteo === '' || almacen_conteo === null || almacen_conteo.length === 0) {
        // var dialog = confirm('No ha capturado el nombre del almacén donde se realizará el conteo.\n¿Desea continuar?');
        // if (dialog === false) {
        //     $('#txtAlmacen').val('').focus();
        //     return;
        // }
        suenaError();
        muestraAlerta3('Captura o selecciona el departamento donde se realizará el inventario', 'warning');
        return;
    }

    //if(usuario_conteo !== ''){
    guarda_datos_conteo(usuario_conteo);
    //}
    //if(almacen_conteo !== ''){
    guarda_datos_almacen(almacen_conteo, nConteo);
    //}
    $(location).attr('href', 'inventario_captura.html?almacen_conteo=' + almacen_conteo);


});

//$('#txtAlmacen').select2().data('select2').$container.addClass(''); //agrega una nueva clase al contenedor

//MuestraLoader('');

//document.addEventListener('deviceready', function () {
$(document).ready(function () {

    //$('#txtAlmacen').select2();
    //$('#modalUbicaciones').modal('show');
    consultaDatosServidor(); //consultamos los datos de conexión del servidor
    // consulta_datos_sesiones();

    //carga_valores();
    consultaCatalogoDepartamentos();


    //

});
