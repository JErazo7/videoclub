// Call the dataTables jQuery plugin
$(document).ready(function () {

        editor = new $.fn.dataTable.Editor({
        table: '#actoresTable',
        idSrc: 'id',
        fields: [
            {label: 'Id', name: 'id', type: "hidden"},
            {label: 'Nombre', name: 'nombre'},
            {label: 'Sexo', name : 'sexo.id', type:"select", placeholder:"Seleccione un sexo", placeholderValue:"" }

        ],
        ajax: {
            dataSrc: "",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            type: 'POST',
            url: '/actor/service',
            data: function (d) {
                return JSON.stringify(d);
            }
        },
        i18n: {
            "create": {
                "button": "Nuevo",
                "title": "Registrar Actor",
                "submit": "Registrar"
            },
            "edit": {
                "button": "Editar",
                "title": "Editar Actor",
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


    var optionsA = [];
    $.getJSON("/sexo/list", {
            term: "-1"
        },
        function(data) {
            var option = {};
            $.each(data, function(i, e) {
                option.label = e.nombre;
                option.value = e.id;
                optionsA.push(option);
                option = {};
            });
        }
    ).done(function() {
        editor.field('sexo.id').update(optionsA);
    });

    var table = $('#actoresTable').DataTable({
        ajax: "/actor/list",
        ajaxDataProp: "",
        dom: 'Bfrtip',
        order: [[0, "asc"]],
        //ocultar columnas de la tabla
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 2 ],
                "visible": false,
                "searchable": false
            },

        ],
        columns: [
            {data: "id"},
            {data: "nombre"},
            {data: "sexo.id"},
            {data: "sexo.nombre"}
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

            var socio = this.field( 'nombre' );
            var fecha_desde = this.field('sexo.id');
            if ( !socio.val()) {
                socio.error( 'Debe seleccionar un actor' );
            }
            if ( !fecha_desde.val()) {
                fecha_desde.error( 'Debe seleccionar un sexo' );
            }


        }

        if ( this.inError() ) {
                return false;
        }

    } );
});

