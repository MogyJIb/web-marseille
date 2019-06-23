
var goods = new Map();
var cart = new Map();

function getGoods() {
    $.ajax({
        url: '/goods',
        type: 'GET',
        contentType: "application/json",
        success: function (goodsList) {
            var rows = "";
            $.each(goodsList,
                function(index, good) {
                    // добавляем полученные элементы в таблицу
                    rows += row(good);
                    goods.set(good.name, good)
                });
            $("table tbody").append(rows);
        }
    });
}

function addToCart(goodsName) {
    var good = goods.get(goodsName);
    var v = {};
    if (cart.has(goodsName)) {
        v = cart.get(goodsName);
        v.count = v.count + 1;
    } else {
        v.good = good;
        v.count = 1;
        cart.set(goodsName, v);
    }
}

function countDown(goodsName) {
    var cartV = cart.get(goodsName);
    if (cartV.count > 1)
        cartV.count = cartV.count - 1;
    document.getElementById(goodsName+"_count").value = cartV.count;
    updateTotalPrice()
}

function countUp(goodsName) {
    var cartV = cart.get(goodsName);
    cartV.count = cartV.count + 1;
    document.getElementById(goodsName+"_count").value = cartV.count;
    updateTotalPrice()
}

function deleteGoods(goodsName) {
    cart.remove(goodsName);
    var image_x = document.getElementById(goodsName+"_image");
    image_x.parentNode.removeChild(image_x);
    var row = document.getElementById(goodsName+"_tr");
    row.parentNode.removeChild(row);
    updateTotalPrice()
}

function updateTotalPrice() {
    var totalPrice = document.getElementById("totalPrice");
    var amount = 0;
    $.each(cart.values(),
        function(index, cartV) {
            amount = amount + cartV.count * cartV.good.price;
        });
    totalPrice.innerText = amount + "";
}

function cancelDialog() {
    $(this).closest('.ui-dialog-content').dialog('close');
}

function nextDialog() {
    $(this).closest('.ui-dialog-content').dialog('close');
    alert("Данные успешно отправлены")
}


var row = function (good) {
    var name = good.name;
    return "<tr>" +
        "<td>" +
        "<div class=\"imageUrl\"> <img src=\"" + good.imageUrl + "\"> </div>" +
        "</td>" +
        "<td>" +
        "<div class=\"name\">" + good.name + "</div>" +
        "<div class=\"description\">" + good.description +"</div>" +
        "<div class=\"price\">" + good.price + " BYN</div>" +
        "<div class=\"ingredients\">" + good.ingredients + "</div>" +
        "<div class=\"formats\">" + good.formats + "</div>" +
        "<div class=\"use\">" + good.use + "</div>" +
        "<div> <button class=\"toOrder\" onclick=\"addToCart('"+name+"')\">Заказать</button> </div>" +
        "</td>" +
        "</tr>"
};

var cartRow = function (cartV) {
    var good = cartV.good;
    var name = good.name;
    var count = cartV.count;
    return         '<tr class="cartTr" id="'+name+'_tr">' +
        '    <td class="cartTd">' +
        '        <img class="cartImg" id="'+name+'_image" src=\"' + good.imageUrl + '\">' +
        '    </td>' +
        '    <td class="cartTd">' +
        good.name +
        '    </td>\n' +
        '    <td class="cartTd">\n' +
        '        <input id="minusButton" type="button" value="&ndash;" class="buttonCount" onclick="countDown(\''+name+'\')">\n' +
        '        <input  id="'+name+'_count" type="text" value="'+count+'" class="numberCount">\n' +
        '        <input id="plusButton" type="button" value="+" class="buttonCount" onclick="countUp(\''+name+'\')">\n' +
        '    </td>\n' +
        '    <td class="productPrice">\n' +
        good.price +
        ' BYN    </td>\n' +
        '    <td class="cartTd">\n' +
        '        <input type="button" value="Х" class="buttonDelete" onclick="deleteGoods(\''+name+'\')">\n' +
        '    </td>\n' +
        '</tr>\n'
};


function cartClick() {
    var rows = "";
    $.each(cart.values(),
        function(index, cartV) {
            // добавляем полученные элементы в таблицу
            rows += cartRow(cartV);
        });

    $('<div />').html(
        '<div class="cart">\n' +
        '    <div class="goods">\n' +
        '        <table class="cartTable">\n' +
        rows +
        '        </table>\n' +
        '    </div>\n' +
        '\n' +
        '    <hr>\n' +
        '\n' +
        '    <div  class="totalPrice">\n' +
        '        Сумма: <span id="totalPrice">317</span>BYN\n' +
        '    </div>\n' +
        '\n' +
        '    <form>\n' +
        '        <div class="input">\n' +
        '            <div>\n' +
        '                <label for="name">Имя</label>\n' +
        '                <input type="text" class="name" ></input>\n' +
        '            </div>\n' +
        '            <div>\n' +
        '                <label for="email">Email</label>\n' +
        '                <input type="email" class="email" ></input>\n' +
        '            </div>\n' +
        '            <div>\n' +
        '                <label for="phone">Телефон</label>\n' +
        '                <input type="text" class="phone" ></input>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div>\n' +
        '            <button class="cancel" onclick="cancelDialog()">Отмена</button>\n' +
        '            <button class="next" onclick="nextDialog()">Продолжить</button>\n' +
        '        </div>\n' +
        '    </form>\n' +
        '\n' +
        '\n' +
        '</div>\n').dialog({
        height: 600,
        width: 1000,
        modal: true,
        resizable: false,
        dialogClass: 'cartDialog',
        open: function (event, ui) {
            $('.ui-widget-overlay').addClass('override');
        }
    });

    updateTotalPrice();
};