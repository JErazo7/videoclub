// Call the dataTables jQuery plugin
$(document).ready(function () {

        editor = new $.fn.dataTable.Editor({
        table: '#alquileresTable',
        idSrc: 'id',
        fields: [
            {label: 'Id', name: 'id', type: "hidden"},
            {label: 'Socio', name : 'socio.id', type:"select", placeholder:"Seleccione un socio", placeholderValue:"" },
            {label: 'Pelicula', name: 'pelicula.id', type:"select",placeholder:"Seleccione una pelicula", placeholderValue:"" },
            {label: 'F. Inicio', name: 'fecha_desde', type:"date"},
            {label: 'F. Fin', name: 'fecha_hasta', type:"date"},
            {label: 'Valor', name: 'valor'},
            {label: 'F. Entrega', name: 'fecha_entrega', type:"date"}
        ],
        ajax: {
            dataSrc: "",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            type: 'POST',
            url: '/alquiler/service',
            data: function (d) {
                return JSON.stringify(d);
            }
        },
        i18n: {
            "create": {
                "button": "Nuevo",
                "title": "Registrar Alquiler",
                "submit": "Registrar"
            },
            "edit": {
                "button": "Editar",
                "title": "Editar Alquiler",
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
    $.getJSON("/socio/list", {
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
        console.log(optionsA)
        editor.field('socio.id').update(optionsA);
    });

    var optionsB = [];
    $.getJSON("/pelicula/list", {
            term: "-1"
        },
        function(data) {
            var option = {};
            $.each(data, function(i, e) {
                option.label = e.nombre;
                option.value = e.id;
                optionsB.push(option);
                option = {};
            });
        }
    ).done(function() {
        editor.field('pelicula.id').update(optionsB);
    });

    $('#alquileresTable').on('init.dt', function() {
        $('.data-new_workorder')
            .attr('data-toggle', 'modal')
            .attr('data-target', '#exampleModal');
    });

    var table = $('#alquileresTable').DataTable({
        ajax: "/alquiler/list",
        ajaxDataProp: "",
        dom: 'Bfrtip',
        order: [[0, "asc"]],
        //ocultar columnas de la tabla
        "columnDefs": [
            {
                "targets": [ 1 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 3 ],
                "visible": false,
                "searchable": false
            },

        ],
        columns: [
            {data: "id"},
            {data: "socio.id"},
            {data: "socio.nombre"},
            {data: "pelicula.id"},
            {data: "pelicula.nombre"},
            {data: "fecha_desde"},
            {data: "fecha_hasta"},
            {data: "valor"},
            {data: "fecha_entrega"}
        ],
        select: true,
        buttons: [
            {text:"Nuevo",className: "data-new_workorder"},

            {extend: "edit", editor: editor},
            {extend: "remove", editor: editor},
            {
                extend: "selectedSingle",
                text: "Finalizar",
                action: function ( e, dt, node, config ) {
                    // Immediately add `250` to the value of the salary and submit
                    editor
                        .edit( table.row( { selected: true } ).index(), false )
                        .set( 'fecha_entrega', "2019-07-17")
                        .submit();
                }
            },
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

            var socio = this.field( 'socio.id' );
            var pelicula = this.field('pelicula.id')
            var fecha_desde = this.field('fecha_desde');
            var fecha_hasta = this.field('fecha_hasta');
            var fecha_entrega = this.field('fecha_entrega');
            var valor = this.field('valor')
            if ( !socio.val()) {
                socio.error( 'Debe seleccionar un socio' );
            }
            if ( !pelicula.val()) {
                pelicula.error( 'Debe seleccionar una pelicula' );
            }
            if ( !fecha_desde.val()) {
                fecha_desde.error( 'Debe seleccionar una fecha de inicio' );
            }
            if ( !fecha_hasta.val()) {
                fecha_hasta.error( 'Debe seleccionar una fecha de fin' );
            }
            if ( !fecha_entrega.val()) {
                fecha_entrega.error( 'Debe seleccionar una fecha de entrega' );
            }
            if ( !valor.val()) {
                valor.error( 'Debe ingresar un valor' );
            }

        }

        if ( this.inError() ) {
                return false;
        }

    } );
});

