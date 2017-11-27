/**
 * Created by Gor on 11/16/2017.
 */

$(function () {

    switch (menu) {

        case "Home":
            $("#home").addClass("active");
            break;
        case "About Us":
            $("#about").addClass("active");
            break;
        case "Products":
            $("#products").addClass("active");
            break;
        case "Manage Products":
            $("#manageProducts").addClass("active");
            break;
        case "Contact":
            $("#contact").addClass("active");
            break;
        case (category):
            $("#products").addClass("active");
            $("#" + category).addClass("active");
            break;
        default:
            $("#products").addClass("active");
            break;
    }
    ;

    var $table = $("#actualProductList");
    // TODO later - must be changed
    if ($table.length) {
        var jsonUrl = '';
        if (window.categoryId == '') {
            jsonUrl = window.contextRoot + "/json/data/all/products";
        } else {
            jsonUrl = window.contextRoot + "/json/data/category/" + window.categoryId + "/products";
        }

        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ["3 Records", "5 Records", "10 Records", "All Records"]],
            pageLength: 3,
            "order": [[ 1, "asc" ]],
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'code',
                    sSortIcon:false,
                    mRender: function (data, type, row) {
                        var image = "<img class='dataTableImg' src='" + window.contextRoot + "/resources/images/" + data + ".jpg'/>"
                        return image;
                    }
                },
                {data: 'name'},
                {data: 'brand'},
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8377; ' + data
                    }
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return "<span style='color:red'>Out of Stock</span>";
                        }
                        return data;
                    }
                },
                {
                    data: 'productId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var src = '';
                        src += "<a href='" + window.contextRoot + "/product/" + data + "/details'" +
                            "class='btn btn-primary' title='Product Details'><span class='glyphicon glyphicon-eye-open'></span></a>";
                        return src;
                    }
                },
                {
                    data: 'productId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var src = '';
                        if (row.quantity < 1) {
                            src += "<a href='javascript:void(0)' class='btn btn-success disabled'>" +
                                "<span class='glyphicon glyphicon-shopping-cart'></span></a>";
                        } else {
                            src += "<a href='" + window.contextRoot + "/cart/add/" + data + "/product'" +
                                "class='btn btn-success' title='Add to Cart'><span class='glyphicon glyphicon-shopping-cart'></span></a>";
                        }
                        return src;
                    }
                }
            ]
        });
    };

    // Automatically close success dialog box after 3 seconds
    var $alert = $(".alert");
    if ($alert.length){
        setTimeout(function () {
            $alert.fadeOut('slow');
        },3000);
    };
});
