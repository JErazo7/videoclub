(function (document) {
    var
        head = document.head = document.getElementsByTagName('head')[0] || document.documentElement,
        elements = 'article aside audio bdi canvas data datalist details figcaption figure footer header hgroup mark meter nav output picture progress section summary time video x'.split(' '),
        elementsLength = elements.length,
        elementsIndex = 0,
        element;

    while (elementsIndex < elementsLength) {
        element = document.createElement(elements[++elementsIndex]);
    }

    element.innerHTML = 'x<style>' +
        'article,aside,details,figcaption,figure,footer,header,hgroup,nav,section{display:block}' +
        'audio[controls],canvas,video{display:inline-block}' +
        '[hidden],audio{display:none}' +
        'mark{background:#FF0;color:#000}' +
        '</style>';
    return head.insertBefore(element.lastChild, head.firstChild);
})(document);

/* Prototyping
/* ========================================================================== */

(function (window, ElementPrototype, ArrayPrototype, polyfill) {
    function NodeList() { [polyfill] }
    NodeList.prototype.length = ArrayPrototype.length;

    ElementPrototype.matchesSelector = ElementPrototype.matchesSelector ||
        ElementPrototype.mozMatchesSelector ||
        ElementPrototype.msMatchesSelector ||
        ElementPrototype.oMatchesSelector ||
        ElementPrototype.webkitMatchesSelector ||
        function matchesSelector(selector) {
            return ArrayPrototype.indexOf.call(this.parentNode.querySelectorAll(selector), this) > -1;
        };

    ElementPrototype.ancestorQuerySelectorAll = ElementPrototype.ancestorQuerySelectorAll ||
        ElementPrototype.mozAncestorQuerySelectorAll ||
        ElementPrototype.msAncestorQuerySelectorAll ||
        ElementPrototype.oAncestorQuerySelectorAll ||
        ElementPrototype.webkitAncestorQuerySelectorAll ||
        function ancestorQuerySelectorAll(selector) {
            for (var cite = this, newNodeList = new NodeList; cite = cite.parentElement;) {
                if (cite.matchesSelector(selector)) ArrayPrototype.push.call(newNodeList, cite);
            }

            return newNodeList;
        };

    ElementPrototype.ancestorQuerySelector = ElementPrototype.ancestorQuerySelector ||
        ElementPrototype.mozAncestorQuerySelector ||
        ElementPrototype.msAncestorQuerySelector ||
        ElementPrototype.oAncestorQuerySelector ||
        ElementPrototype.webkitAncestorQuerySelector ||
        function ancestorQuerySelector(selector) {
            return this.ancestorQuerySelectorAll(selector)[0] || null;
        };
})(this, Element.prototype, Array.prototype);

/* Helper Functions
/* ========================================================================== */
var id = "";
$( "#inputCedula" ).focusout(function() {
    cedula = $( "#inputCedula" ).val();
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/socio/view/"+cedula, // replace 'PHP-FILE.php with your php file
        success: function(data) {
            id = data.id;
            $('#inputNombre').val(data.nombre);
            $('#inputNombre').prop('disabled', true);
            $('#inputDireccion').val(data.direccion);
            $('#inputDireccion').prop('disabled', true);
            $('#inputTelefono').val(data.telefono);
            $('#inputTelefono').prop('disabled', true);
            $('#inputCorreo').val(data.correo);
            $('#inputCorreo').prop('disabled', true);

        },
        error : function(){
            id = "";
            $('#inputNombre').val("");
            $('#inputNombre').prop('disabled', false);
            $('#inputDireccion').val("");
            $('#inputDireccion').prop('disabled', false);
            $('#inputTelefono').val("");
            $('#inputTelefono').prop('disabled', false);
            $('#inputCorreo').val("");
            $('#inputCorreo').prop('disabled', false);

        }
    });
})

var h = 0;
var costos = [];
var idname ="";
var idcosto ="";
var idfecha ="";
function generateTableRow() {
    idname="pelis"+h;
    idcosto="costo"+h;
    idfecha="fecha"+h;
    var emptyColumn = document.createElement('tr');
    emptyColumn.innerHTML = '<td><a class="cut">-</a><select id="'+idname+'" onchange="myFunction()"></select></td>' +
        '<td><p id="'+idcosto+'"></p></td>' +
        '<td><input type="date" id="'+idfecha+'"></span></td>' +
        '<td><span data-prefix>$</span><span>0.00</span></td>';
    h++;
    $.ajax({
        type: "GET",
        url: '/pelicula/list',
        dataType: "json",
        success: function(data){
            $("#"+idname).append('<option value="0">Seleccione</option>');
            $.each(data,function(key, registro) {
                costos.push(registro.costo)
                $("#"+idname).append('<option value='+registro.id+'>'+registro.nombre+'</option>');
            });

        },
        error: function(data) {
            alert('error');
        }
    });

    return emptyColumn;
}

function myFunction(){
    $("#"+idcosto).text(costos[$("#"+idname).val()-1]);

}

function parseFloatHTML(element) {
    return parseFloat(element.innerHTML.replace(/[^\d\.\-]+/g, '')) || 0;
}

function parsePrice(number) {
    return number.toFixed(2).replace(/(\d)(?=(\d\d\d)+([^\d]|$))/g, '$1,');
}

/* Update Number
/* ========================================================================== */

function updateNumber(e) {
    var
        activeElement = document.activeElement,
        value = parseFloat(activeElement.innerHTML),
        wasPrice = activeElement.innerHTML == parsePrice(parseFloatHTML(activeElement));

    if (!isNaN(value) && (e.keyCode == 38 || e.keyCode == 40 || e.wheelDeltaY)) {
        e.preventDefault();

        value += e.keyCode == 38 ? 1 : e.keyCode == 40 ? -1 : Math.round(e.wheelDelta * 0.025);
        value = Math.max(value, 0);

        activeElement.innerHTML = wasPrice ? parsePrice(value) : value;
    }

    updateInvoice();
}

/* Update Invoice
/* ========================================================================== */


var price=0;
var total = 0;
function updateInvoice() {
    total = 0;
    var cells, a, i;

    // update inventory cells
    // ======================

    for (var a = document.querySelectorAll('table.inventory tbody tr'), i = 0; a[i]; ++i) {
        // get inventory row cells
        cells = a[i].querySelectorAll('span:last-child');
        price = 0;
        // set price as cell[2] * cell[3]
        var actual = moment(new Date());
        var final = moment(new Date($("#fecha"+i).val()));

        var numdias = final.diff(actual,'days')+1;
        price = parseFloat($("#costo"+i).text())*numdias;

        // add price to total

        total += price;


        // set row total
        cells[0].innerHTML = price;
    }

    // update balance cells
    // ====================

    // get balance cells
    cells = document.querySelectorAll('table.balance td:last-child span:last-child');

    // set total
    cells[0].innerHTML = total;


    // update prefix formatting
    // ========================

    var prefix = document.querySelector('#prefix').innerHTML;
    for (a = document.querySelectorAll('[data-prefix]'), i = 0; a[i]; ++i) a[i].innerHTML = prefix;

    // update price formatting
    // =======================

    for (a = document.querySelectorAll('span[data-prefix] + span'), i = 0; a[i]; ++i) if (document.activeElement != a[i]) a[i].innerHTML = parsePrice(parseFloatHTML(a[i]));
}

/* On Content Load
/* ========================================================================== */
$("#btnRegistrar").click(function () {
    var date = new Date()

    var day = date.getDate()
    var month = date.getMonth() + 1
    var year = date.getFullYear()
    var fecha_desde ="";
    if(month < 10){
        fecha_desde = year+"-0"+month+"-"+day;
    }else{
        fecha_desde = year+"-"+month+"-"+day;
    }


    var alquiler = {};
    var cedula = $("#inputCedula").val();
    var nombre = $("#inputNombre").val();
    var direccion = $("#inputDireccion").val();
    var telefono = $("#inputTelefono").val();
    var email = $("#inputCorreo").val();


    var options = {};
    options.id = id;
    options.cedula = cedula;
    options.nombre = nombre;
    options.direccion = direccion;
    options.telefono = telefono;
    options.correo = email;
    //alquiler.socio = options;
    alquiler.action ="create";
    alquiler.data = {};


    for (var i=0; i<h; i++){
        var peliculas = {};
        peliculas.id = $("#pelis"+i).val();
        optionsAlq = {};
         optionsAlq.id = "";
        optionsAlq.socio = options;
        optionsAlq.pelicula = peliculas;
        optionsAlq.fecha_desde = fecha_desde;
         optionsAlq.fecha_hasta = $("#fecha"+i).val();
         optionsAlq.valor = price;
         optionsAlq.fecha_entrega = "";


         alquiler.data[i] = optionsAlq;
    }
    console.log(JSON.stringify(alquiler))
    $.ajax({
        type: "POST",
        url: '/alquiler/service',
        dataSrc: "",
        dataType: "json",
        contentType: "application/json; charset=utf-8",

        data: JSON.stringify(alquiler),
        success: function(data){
            window.location.href ="/alquiler/"
        },
        error: function(data) {
            alert('error');
        }
    });

});

function onContentLoad() {


    updateInvoice();

    var
        input = document.querySelector('input'),
        image = document.querySelector('img');
    document.querySelector('table.inventory tbody').appendChild(generateTableRow());

    function onClick(e) {
        var element = e.target.querySelector('[contenteditable]'), row;

        element && e.target != document.documentElement && e.target != document.body && element.focus();

        if (e.target.matchesSelector('.add')) {
            document.querySelector('table.inventory tbody').appendChild(generateTableRow());
        }
        else if (e.target.className == 'cut') {
            row = e.target.ancestorQuerySelector('tr');

            row.parentNode.removeChild(row);
        }

        updateInvoice();
    }

    function onEnterCancel(e) {
        e.preventDefault();


    }

    function onLeaveCancel(e) {
        e.preventDefault();


    }

    function onFileInput(e) {
        image.classList.remove('hover');

        var
            reader = new FileReader(),
            files = e.dataTransfer ? e.dataTransfer.files : e.target.files,
            i = 0;

        reader.onload = onFileLoad;

        while (files[i]) reader.readAsDataURL(files[i++]);
    }

    function onFileLoad(e) {
        var data = e.target.result;

        image.src = data;
    }

    if (window.addEventListener) {
        document.addEventListener('click', onClick);

        document.addEventListener('mousewheel', updateNumber);
        document.addEventListener('keydown', updateNumber);

        document.addEventListener('keydown', updateInvoice);
        document.addEventListener('keyup', updateInvoice);

        input.addEventListener('focus', onEnterCancel);
        input.addEventListener('mouseover', onEnterCancel);
        input.addEventListener('dragover', onEnterCancel);
        input.addEventListener('dragenter', onEnterCancel);

        input.addEventListener('blur', onLeaveCancel);
        input.addEventListener('dragleave', onLeaveCancel);
        input.addEventListener('mouseout', onLeaveCancel);

        input.addEventListener('drop', onFileInput);
        input.addEventListener('change', onFileInput);
    }
}

window.addEventListener && document.addEventListener('DOMContentLoaded', onContentLoad);
