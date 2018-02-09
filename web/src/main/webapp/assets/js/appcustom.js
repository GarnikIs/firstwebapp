/**
 * Created by Gor on 11/16/2017.
 */

$(function () {

//  Switching menu and show active button
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
            if (category != "") {
                $("#" + category).addClass("active");
            }
            break;
        case ("View Cart"):
            $("#userCart").addClass("active");
            break;
        case ("Login"):
            $("#login").addClass("active");
            break;
        case ("Registration"):
            $("#register").addClass("active");
            break;
        default:
            $("#products").addClass("active");
            break;
    }
    /*----------------------------------------------*/

//    setting csrf token and header for ajax calls
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    if ((token != undefined && header != undefined)
        && (token.length > 0 && header.length > 0)) {
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }
    /*----------------------------------------------*/

//  Jquery dataTable for user
    var $table = $("#actualProductList");
    // TODO later - must be changed
    if ($table.length) {
        var jsonUrl = '';
        if (window.categoryId == '') {
            jsonUrl = window.contextRoot + "/json/data/all/products";
        } else {
            jsonUrl = window.contextRoot + "/json/data/category/" + window.categoryId + "/products";
        }

        var tableColumns = [
            {
                data: 'code',
                mRender: function (data, type, row) {
                    var image = "<img class='dataTableImg' alt='Image ot available' src='" +
                                window.contextRoot + "/resources/images/" + data + ".jpg'/>";
                    return image;
                }
            },
            {data: 'productName'},
            {data: 'productDescription'},
            {
                data: 'unitPrice',
                mRender: function (data, type, row) {
                    return '&#8381; ' + data
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
            }
        ];

        if (userRole == 'ADMIN') {
            tableColumns.push(
                {
                    data: 'productType',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var src = "<a href='" + window.contextRoot + "/manage/" + data.productTypeId + "/product'" +
                                    "class='btn btn-warning' title='Edit " + row.productName +
                                    "'><span class='glyphicon glyphicon-pencil'></span></a>";
                        return src;
                    }
                }
            )
        }

        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ["3 Records", "5 Records", "10 Records", "All Records"]],
            pageLength: 3,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: tableColumns,
        });
    }
    /*-----------------------------------------------------------------------------------*/

    // Automatically close success dialog box after 3 seconds
    var $alert = $(".alert");
    if ($alert.length) {
        $alert.css("background-image", "none");
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000);
    }
    /*------------------------------*/

//    JQuery dataTable for admin
    var $adminProductsTable = $("#adminProductsTable");
    // TODO later - must be changed
    if ($adminProductsTable.length) {
        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';


        $adminProductsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ["10 Records", "30 Records", "50 Records", "All Records"]],
            pageLength: 30,
            "order": [[0, "asc"]],
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'productType',
                    mRender: function (data, type, row) {
                        var productTypeId = data.productTypeId;
                        return productTypeId;
                    }
                },
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var image = "<img class='adminDataTableImg' alt='Image not available' src='"
                            + window.contextRoot + "/resources/images/" + data + ".jpg'/>";
                        return image;
                    }
                },
                {
                    data: 'productName',
                    mRender: function (data, type, row) {
                        var pName = "<span name='" + data + "' id='" + row.productType.productTypeId + "'>" + data + "</span>";
                        return pName;
                    }
                },
                {data: 'productDescription'},
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8381; ' + data
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += "<label class='switch'>";
                        if (data) {
                            str += "<input type='checkbox' checked value='" + row.productType.productTypeId + "' />";
                        } else {
                            str += "<input type='checkbox' value='" + row.productType.productTypeId + "' />";
                        }
                        str += "<div class='slider round'></div></label>";

                        return str;
                    }
                },
                {
                    data: 'productType',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += "<a href='" + window.contextRoot + "/manage/" + data.productTypeId + "/product' title='Edit "
                            + row.productName + "' class='btn btn-warning'>";
                        str += "<span class='glyphicon glyphicon-pencil'></span></a>";
                        return str;
                    }
                }
            ],
            initComplete: function () {
                var api = this.api();
                api.$(".switch input[type='checkbox']").on("change", function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop("checked");
                    var value = checkbox.prop("value");
                    var pName = $adminProductsTable.find("#" + value + "").attr('name');
                    var dMsg = (checked) ? "Do you want to activate '" + pName + "' ?" :
                        "Do you want to deactivate '" + pName + "' ?";
                    bootbox.confirm({
                        size: "medium",
                        title: "Activate or Deactivate Product",
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                var activationUrl = window.contextRoot + "/manage/product/" + value + "/activation";
                                $.post(activationUrl, function (data) {
                                    bootbox.alert({
                                        size: "medium",
                                        title: "Information",
                                        message: data
                                    });
                                });
                            } else {
                                checkbox.prop("checked", !checked);
                            }
                        }
                    });
                });
            }
        });
    }
    /*-----------------------------------------------------------------------------------*/

//  JQuery validation for adding category

    var $categoryForm = $("#categoryForm");
    if ($categoryForm.length) {
        $categoryForm.validate({
            rules: {
                categoryNameEn: {
                    required: true,
                    minlength: 2
                },
                categoryNameRu: {
                    required: true,
                    minlength: 2
                },
            },
            messages: {
                categoryNameEn: {
                    required: "Please add the Category name in English",
                    minlength: "The Category name should not be less then 2 characters"
                },
                categoryNameRu: {
                    required: "Please add the Category name in Russian",
                    minlength: "The Category name should not be less then 2 characters"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }
    /*-----------------------------------------------------------*/

    //  JQuery validation for login form

    var $loginForm = $("#loginForm");
    if ($loginForm.length) {
        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                }
            },
            messages: {
                username: {
                    required: "Username must not be blank",
                    email: "Please enter valid email address"
                },
                password: {
                    required: "Password must not be blank",
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }
    /*-----------------------------------------------------------*/

//    Refreshing cart product info
//     $("button[name = 'refreshCartProduct']").click(function () {
//
//         var cartLineId = $(this).attr('value');
//         var modifiableProduct = $('#count_' + cartLineId);
//         var productOriginalCount = modifiableProduct.attr('value');
//         var actualProductCount = modifiableProduct.val();
//         if (productOriginalCount !== actualProductCount) {
//             if (actualProductCount < 1 || actualProductCount >3) {
//                 modifiableProduct.val(productOriginalCount);
//                 bootbox.alert({
//                     size: "medium",
//                     title: "Error",
//                     message: "Product count can not be less than 1 and more than 3"
//                 });
//             } else {
//                 var updateUrl = window.contextRoot + "/cart/" + cartLineId + "/update?productCount=" + actualProductCount;
//                 window.location.href = updateUrl;
//             }
//         }
//
//     });


});
