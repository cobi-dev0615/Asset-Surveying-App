var urlPrevia = 'productos_catalogo.html';
var exceljson = [];
var nRegistros = 0;
var z = 0;

//forzamos al botón regresar de android a que si se preciona regrese a la página que le digamos
document.addEventListener("backbutton", onBackKeyDown, false);

$('#btnRegresar').on('click', function () {
    onBackKeyDown();
});

function onBackKeyDown() {
    //eliminaBannerAd();
    $(location).attr('href', urlPrevia);
}


function cargaXLSX(event) {
    try {
        //var archivo = $('#txt_archivo').val();

        //alasql.promise('SELECT * FROM FILE(?, {headers:true})').then(function (data) {
        //    alert(data);
        //}).catch(function (err) {
        //    alert('Error:', err);
        //});
        MuestraLoader('');

        var archivoNombre = $('#txt_archivo').val().split("\\").pop();
        $('#txt_archivo').siblings('#lbl_archivo').addClass('selected').html(archivoNombre);


        MuestraAlerta3('Preparando vista previa del catálogo, espere por favor...', 'warning');

        exceljson = [];
        alasql('SELECT * FROM FILE(?, {headers:true})', [event], function (data) {
            exceljson = data;
            //if (exceljson.length === 0) {
            //    MuestraAlerta3('No hay datos en el archivo seleccionado');
            //    OcultaLoader();
            //    return;
            //}
            //alert(JSON.stringify(exceljson));
            carga_tabla();

        }).catch(function (err) {
            OcultaLoader();
            alert('Error:' + err);
        });

    }
    catch (err) {
        //OcultaLoader();
        //alert(err.message);
    }
}


function carga_excel() {
    try {
        var archivo = $('#txt_archivo');
        //var archivo = ruta_archivo;
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.xlsx|.xls)$/;
        exceljson = [];
        ///*Comprobamos si el archivo es un archivo válido de excel*/
        //if (!regex.test(archivo.val().toLowerCase())) {
        //    vibraAlerta(500);
        //    MuestraAlerta1("Seleccione un archivo de excel válido");
        //    return;
        //}
        var xlsxflag = false; /*Bandera para comprobar si el archivo tiene un formato .xls o .xlsx*/
        if (archivo.val().toLowerCase().indexOf(".xlsx") > 0) {
            //if (archivo.toLowerCase().indexOf(".xlsx") > 0) {
            xlsxflag = true;
        }
        /*Comprobamos si el navegador soporta HTML5*/
        if (typeof (FileReader) === 'undefined') {
            alert("Lo sentimos, tu dispositivo no es compatible con esta función.");
            return;
        }

        //MuestraLoader('Preparando vista previa del catálogo, espere por favor...');

        var reader = new FileReader();
        reader.onload = function (e) {
            var data = e.target.result;
            /*Convertimos los datos de excel en un arreglo de objetos*/
            var workbook;
            if (xlsxflag) {
                workbook = XLSX.read(data, { type: 'binary' });
            }
            else {
                workbook = XLS.read(data, { type: 'binary' });
            }
            /*Gets all the sheetnames of excel in to a variable*/
            var sheet_name_list = workbook.SheetNames;

            var cnt = 0; /*This is used for restricting the script to consider only first sheet of excel*/
            sheet_name_list.forEach(function (y) { /*Iterate through all sheets*/
                /*Convert the cell value to Json*/

                if (xlsxflag) {
                    exceljson = XLSX.utils.sheet_to_json(workbook.Sheets[y]);
                }
                else {
                    exceljson = XLS.utils.sheet_to_row_object_array(workbook.Sheets[y]);
                }
                if (exceljson.length > 0 && cnt === 0) {

                    //carga_datos(exceljson, accion);
                    carga_tabla();
                    cnt++;
                }
            });

            OcultaLoader();

        };
        /*If excel file is .xlsx extension than creates a Array Buffer from excel*/
        if (xlsxflag) {
            reader.readAsArrayBuffer(archivo[0].files[0]);
        }
        else {
            reader.readAsBinaryString(archivo[0].files[0]);
        }
    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


function remueveDuplicadosArray() {
    var obj = {};
    for (var i = 0, len = exceljson.length; i < len; i++) {
        if (!obj[exceljson[i]['Codigo1']]) obj[exceljson[i]['Codigo1']] = exceljson[i];
    }
    var newArr = [];
    for (var key in obj) newArr.push(obj[key]);
    return newArr;
}



/*Función para convertir un arreglo JSON a un tabla HTML*/
function carga_tabla() {
    try {

        var n_original = exceljson.length;


        exceljson = remueveDuplicadosArray(); //eliminamos los códigos duplicados de la columna Codigo1



        var filas = exceljson.length;
        nRegistros = filas;
        //$('.progress-bar').attr('aria-valuemax', nRegistros);  
        $('.progress-bar').css('width', 0 + '%').attr('aria-valuenow', 0);

        var codigo_1 = '';
        var codigo_2 = '';
        var codigo_3 = '';
        var descripcion = '';
        var um = '';
        var precio_venta = 0;
        var cantidad_teorica = 0;

        //si el archivo tiene más de 50 registros solo mostramos los primeros 50
        //con el fin de no alentar la carga de la tabla y saturar la memoria del dispositivo
        var x = filas;
        if (filas > 50) {
            x = 30;
        }

        //alert(JSON.stringify(exceljson)); 
        tabla.clear().draw();

        $.each(exceljson, function (i, dato_tabla) {
            codigo_1 = dato_tabla.Codigo1 || '';
            codigo_2 = dato_tabla.SKU || '';
            // codigo_3 = dato_tabla.Codigo3 || '';
            descripcion = dato_tabla.Descripcion || dato_tabla.undefined || 'Producto sin descripción';
            precio_venta = dato_tabla.PrecioVenta || 0;
            cantidad_teorica = dato_tabla.CantidadTeorica || 0;
            um = dato_tabla.UnidadMedida || '';


            tabla.row.add(
                [
                    codigo_1,
                    codigo_2,
                    codigo_3,
                    descripcion,
                    um,
                    precio_venta,
                    cantidad_teorica
                ]
            ).draw();

            return i < 30; //solamente insertamos los primeros 30 resultados

        });

        tabla.columns.adjust().draw(false);
        calcula_totales(filas);
        //exceljson = null;
        OcultaLoader();

        var diferenciaTablas = n_original - filas;
        if (diferenciaTablas > 0) {
            vibraAlerta(500);
            suenaAlerta();
            MuestraAlerta1('Se han eliminado ' + diferenciaTablas + ' productos repetidos del catálogo.');
        }



    }
    catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}

function elimina_productos() {
    try {
        base_datos.transaction(function (ts) {
            ts.executeSql('DELETE FROM catalogos;');
        }, function (error) {
            alert(error.message);
        });
    } catch (err) {
        alert(err.message);
    }
}

$('#btn_importar').on('click', function () {
    //validamos si ya fue cargado el archivo de excel en la tabla
    if (tabla.rows().count() === 0) {
        suenaError();
        vibraAlerta(500);
        MuestraAlerta3('Seleccione el archivo del catálogo para continuar.', 'warning');
        return;
    }

    var dialog = confirm("El catálogo anterior será eliminado y se importará el nuevo.\n¿Desea continuar?");
    if (dialog === false) {
        //OcultaLoader();
        return;
    }
    //eliminamos los datos de la tabla
    elimina_productos();
    insertaJSONDespuesDeDelay();

});


function datosGuardados() {

    tabla.clear().draw();
    $('#txt_archivo').siblings('#lbl_archivo').removeClass('selected').html('');
    calcula_totales(0);
    $('#txt_archivo').prop('disabled', false);
    $('#btn_importar').prop('disabled', false);

    //// 

    MuestraAlerta3('El catálogo fue importado exitosamente, se importaron ' + nRegistros + ' registros.', 'success');
    MuestraAlerta1('El catálogo fue importado exitosamente, se importaron ' + nRegistros + ' registros.');
    OcultaLoader();
    $(location).attr('href', 'productos_catalogo.html');
}



function insertaJSONDespuesDeDelay() {

    try {

        $('#txt_archivo').prop('disabled', true);
        $('#btn_importar').prop('disabled', true);

        //var barra_progreso = $('#barra_progreso');
        //barra_progreso.attr('aria-valuenow', 0);
        //barra_progreso.attr('aria-valuemax', filas);

        var codigo_1 = '';
        var codigo_2 = '';
        var codigo_3 = '';
        var descripcion = '';
        var precio_venta = 0;
        var cantidad_teorica = 0;
        var cantidad_real = 0;
        var um = '';
        var cantidadLote = 5000;

        var filas = exceljson.length || 0;

        if (filas === 0) {
            //OcultaLoader();
            datosGuardados();
            return;
        }

        //MuestraLoader('El proceso puede tardar varios minutos, espere por favor...');

        MuestraAlerta3('Faltan ' + filas + ' registros...', 'warning');

        base_datos.transaction(function (ts) {

            $.each(exceljson, function (i, dato_tabla) {

                codigo_1 = dato_tabla.Codigo1 || 'error';
                codigo_1 = codigo_1.toString().trim();
                codigo_2 = dato_tabla.SKU || '';
                codigo_2 = codigo_2.toString().trim();

                // codigo_3 = dato_tabla.Codigo3 || '';
                // codigo_3 = codigo_3.toString().trim();

                descripcion = dato_tabla.Descripcion || dato_tabla.undefined || 'Producto sin descripción';
                descripcion = descripcion.toString().trim().replace(/'/g, '');

                precio_venta = dato_tabla.PrecioVenta || 0;
                cantidad_teorica = dato_tabla.CantidadTeorica || 0;

                um = dato_tabla.UnidadMedida || '';
                var factor = dato_tabla.Factor || 1;
                //inventario, id_producto, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, modelo, marca, categoria, subcategoria, precio_compra, unidad_medida, observaciones, cantidad_teorica, forzado, sincronizado, eliminado, cantidad_real
                ts.executeSql('INSERT INTO catalogos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                    [id_inventario, z, codigo_1, codigo_2, codigo_3, descripcion, precio_venta, '', '', '', '', '', um, '', cantidad_teorica, 0, 0, 0, cantidad_real, factor]);

                updateProgress(z);
                z++;

                return i < cantidadLote;

            });
        }, function (error) {
            OcultaLoader();

            $('#txt_archivo').prop('disabled', false);
            $('#btn_importar').prop('disabled', false);
            tabla.clear().draw();
            $('#txt_archivo').val('');
            calcula_totales(0);

            vibraAlerta(500);
            suenaAlerta();
            alert(error.message);


        }, function () {

            //exceljson.slice(0, 5000); devuelve un JSON con N elementos de otro JSON 
            exceljson.splice(0, cantidadLote + 1); //elimina n elementos a partir del index cero
            //exceljson.shift(); //elimina el primer elemento del JSON
            insertaJSONDespuesDeDelay();
            OcultaLoader();
            //datosGuardados();

        });

        //});
    } catch (err) {
        OcultaLoader();
        alert(err.message);
    }
}


function updateProgress(n) {

    var avance = (n / nRegistros) * 100;

    $('.progress-bar').css('width', avance + '%').attr('aria-valuenow', avance);

}

function BindTableHeader(jsondata, tableid) {/*Function used to get all column names from JSON and bind the html table header*/
    var columnSet = [];
    var headerTr$ = $('<th/>');
    for (var i = 0; i < jsondata.length; i++) {
        var rowHash = jsondata[i];
        for (var key in rowHash) {
            if (rowHash.hasOwnProperty(key)) {
                if ($.inArray(key, columnSet) === -1) {/*Adding each unique column names to a variable array*/
                    columnSet.push(key);
                    headerTr$.append($('<th/>').html(key));
                }
            }
        }
    }
    //$(tableid).append(headerTr$);
    return columnSet;
}

$('#lbl_tutorial').on('click', function () {
    abreUrlLocal('tutorial/index.html');
});


function calcula_totales(n_registros) {
    if (n_registros > 0) {
        MuestraAlerta3('Se encontraron ' + n_registros + ' productos en el catálogo', 'success');
    }
    $('#lbl_total').html('N° de productos encontrados: <strong>' + n_registros + '</strong>');
}

$('#tablaDatos tbody').on('click', 'tr', function () {

    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected');
    }
    else {
        $('#tablaDatos').DataTable().$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    }

});


function onPause() {
    // TODO: esta aplicación se ha suspendido. Guarde el estado de la aplicación aquí.
}

function onResume() {
    // TODO: esta aplicación se ha reactivado. Restaure el estado de la aplicación aquí.
}

document.addEventListener('deviceready', function () {
    AbreConexionBD();
});