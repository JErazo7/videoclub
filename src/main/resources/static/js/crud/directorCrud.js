// Call the dataTables jQuery plugin
$(document).ready(function () {

    editor = new $.fn.dataTable.Editor({
        table: '#directoresTable',
        idSrc: 'id',
        fields: [
            {label: 'Id', name: 'id', type: "hidden"},
            {label: 'Nombre', name: 'nombre'},
        ],
        ajax: {
            dataSrc: "",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            type: 'POST',
            url: '/director/service',
            data: function (d) {
                return JSON.stringify(d);
            }
        },
        i18n: {
            "create": {
                "button": "Nuevo",
                "title": "Registrar Director",
                "submit": "Registrar"
            },
            "edit": {
                "button": "Editar",
                "title": "Editar Director",
                "submit": "Actualizar"
            },

            "remove": {
                "button": "Eliminar",
                "title": "Eliminar",
                "submit": "Eliminar",
                "confirm": {
                    "_":"Estás seguro de que deseas eliminar %d registros?",
                    "1": "Estás seguro de que deseas eliminar este registro?"
                }
            },
            "error": {
                "system": "Se ha producido un error del sistema (Más información)"
            }
            , "multi":
                {
                    "title":
                        "Multiple valores",


                    "info":
                        "Los elementos seleccionados contienen diferentes valores para esta entrada. Para editar y configurar todos los elementos para esta entrada con el mismo valor, haga clic o toque aquí, de lo contrario mantendrán sus valores individuales.",
                    "restore":
                        "Deshacer cambios",
                    "noMulti":
                        "Esta entrada se puede editar individualmente, pero no es parte de un grupo."
                }
            ,
            "datetime":
                {
                    "previous":
                        'Anterior',
                    "next":
                        'Siguiente',

                    "months":
                        ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],

                    "weekdays":
                        ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
                    "amPm":
                        ['am', 'pm'],
                    "unknown":
                        '-'
                }
        }


    });




    var table = $('#directoresTable').DataTable({
        ajax: "/director/list",
        ajaxDataProp: "",
        dom: 'Bfrtip',
        order: [[0, "asc"]],
        columns: [
            {data: "id"},
            {data: "nombre"},
        ],
        select: true,
        buttons: [
            {extend: "create", editor: editor},
            {extend: "edit", editor: editor},
            {extend: "remove", editor: editor},
            {
                extend: 'collection',
                text: 'Exportar',
                buttons: [
                    'copy',
                    'excel',
                    'csv',
                    'pdf',
                    'print'
                ]
            }
        ],

        language: {
            "select": {
                "rows": {
                    "0": "      No hay filas seleccionadas",
                    "_": " Seleccionaste %d filas",
                    "1": " Seleccionaste 1 fila"
                }
            },
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros.",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }
    });


    var openVals;
    editor
        .on( 'open', function () {
            // Store the values of the fields on open
            openVals = JSON.stringify( editor.get() );

            editor.on( 'preClose', function ( e ) {
                // On close, check if the values have changed and ask for closing confirmation if they have
                if ( openVals !== JSON.stringify( editor.get() ) ) {
                    return confirm('Usted tiene cambios no guardados. ¿Seguro que quieres salir?' );
                }
            } )
        } )
        .on( 'postCreate postEdit close', function () {
            editor.off( 'preClose' );
        } );


    editor.on( 'preSubmit', function ( e, o, action ) {
        if ( action !== 'remove' ) {

            var nombre = this.field( 'nombre' );

            if ( !nombre.val() ) {
                nombre.error( 'Debe ingresar un nombre' );
            }

        }

        if ( this.inError() ) {
                return false;
        }

    } );
});

