/**
 * Created by Gor on 11/16/2017.
 */

$(function () {

//  Switching menu and show active button
    switch (menu) {

        case "Home":
            $("#home").addClass("active");
            break;
        case "Главная":
            $("#home").addClass("active");
            break;
        case "About Us":
            $("#about").addClass("active");
            break;
        case "О Нас":
            $("#about").addClass("active");
            break;
        case "Products":
            $("#products").addClass("active");
            break;
        case "Продукты":
            $("#products").addClass("active");
            break;
        case "Manage Products":
            $("#manageProducts").addClass("active");
            break;
        case "Управление Продуктами":
            $("#manageProducts").addClass("active");
            break;
        case "Contacts":
            $("#contact").addClass("active");
            break;
        case "Контакты":
            $("#contact").addClass("active");
            break;
        case (category):
            $("#products").addClass("active");
            if (category != "") {
                $("#" + category).addClass("active");
            }
            break;
        // case ("View Cart"):
        //     $("#userCart").addClass("active");
        //     break;
        case ("Login"):
            $("#login").addClass("active");
            break;
        case ("Войти"):
            $("#login").addClass("active");
            break;
        case ("Registration"):
            $("#register").addClass("active");
            break;
        case ("Регистрация"):
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
                data: 'productType',
                bSortable: false,
                mRender: function (data, type, row) {
                    var src = '';
                    src += "<a href='" + window.contextRoot + "/product/" + data.productTypeId + "/details'" +
                        "class='btn btn-primary' title='Product Details'><span class='glyphicon glyphicon-eye-open'></span></a>";
                    return src;
                }
            }
        ];

        if (userRole == 'USER') {
            tableColumns.push(
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8381; ' + data
                    }
                }
            )
        }

        if (userRole == 'ADMIN') {
            tableColumns.push(
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#8381; ' + data
                    }
                },
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
                    var dMsg = (checked) ? popup_active_question + " " + pName + "' ?" :
                        popup_deactive_question + " " + pName + "' ?";
                    bootbox.confirm({
                        size: "medium",
                        // title: "Activate or Deactivate Product",
                        title: popup_title,
                        message: dMsg,
                        callback: function (confirmed) {
                            if (confirmed) {
                                console.log(value);
                                var activationUrl = window.contextRoot + "/manage/product/" + value + "/activation";
                                $.post(activationUrl, function (data) {
                                    bootbox.alert({
                                        size: "medium",
                                        // title: "Information",
                                        title: popup_title_info,
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
                    required: error_add_prop_en,
                    minlength: error_min_length
                },
                categoryNameRu: {
                    required: error_add_prop_ru,
                    minlength: error_min_length
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

    //  JQuery validation for adding product

    var $productForm = $("#productForm");
    if ($productForm.length) {
        $productForm.validate({
            rules: {
                productNameEn: {
                    required: true,
                    minlength: 2
                },
                productNameRu: {
                    required: true,
                    minlength: 2
                },
                productDescriptionEn: {
                    required: true,
                    minlength: 2
                },
                productDescriptionRu: {
                    required: true,
                    minlength: 2
                },
                unitPrice: {
                    required: true,
                    minlength: 2
                },
            },
            messages: {
                productNameEn: {
                    required: error_add_prop_en,
                    minlength: error_min_length
                },
                productNameRu: {
                    required: error_add_prop_ru,
                    minlength: error_min_length
                },
                productDescriptionEn: {
                    required: error_add_prop_en,
                    minlength: error_min_length
                },
                productDescriptionRu: {
                    required: error_add_prop_ru,
                    minlength: error_min_length
                },
                unitPrice: {
                    required: error_add_price,
                    minlength: error_price_min_value
                },
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }
    /*-----------------------------------------------------------*/

    //  JQuery validation for register-personal form

    var $registerForm = $("#registerForm");
    if ($registerForm.length) {
        $registerForm.validate({
            rules: {
                firstName: {
                    required: true,
                },
                lastName: {
                    required: true,
                },
                email: {
                    required: true,
                },
                phoneNumber: {
                    required: true,
                },
                password: {
                    required: true,
                },
                confirmPassword: {
                    required: true,
                },
            },
            messages: {
                firstName: {
                    required: error_blank_first_name,
                },
                lastName: {
                    required: error_blank_last_name,
                },
                email: {
                    required: error_blank_email
                },
                phoneNumber: {
                    required: error_blank_phone
                },
                password: {
                    required: error_blank_password
                },
                confirmPassword: {
                    required: error_blank_confirm_password
                },
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    }
    /*-----------------------------------------------------------*/

    //  JQuery validation for register-billing form

    var $billingForm = $("#billingForm");
    if ($billingForm.length) {
        $billingForm.validate({
            rules: {
                addressLine: {
                    required: true,
                },
                city: {
                    required: true,
                },
                zipCode: {
                    required: true,
                },
                state: {
                    required: true,
                },
                country: {
                    required: true,
                },
            },
            messages: {
                addressLine: {
                    required: error_blank_address_line,
                },
                city: {
                    required: error_blank_city,
                },
                zipCode: {
                    required: error_blank_zip_code
                },
                state: {
                    required: error_blank_state
                },
                country: {
                    required: error_blank_country
                },
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
                },
                password: {
                    required: true,
                }
            },
            messages: {
                username: {
                    required: error_blank_email
                },
                password: {
                    required: error_blank_password
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
