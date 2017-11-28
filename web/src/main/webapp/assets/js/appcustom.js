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
            $("#" + category).addClass("active");
            break;
        default:
            $("#products").addClass("active");
            break;
    };
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

        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ["3 Records", "5 Records", "10 Records", "All Records"]],
            pageLength: 3,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        var image = "<img class='dataTableImg' src='" + window.contextRoot + "/resources/images/" + data + ".jpg'/>";
                        return image;
                    }
                },
                {data: 'productName'},
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

    /*-----------------------------------------------------------------------------------*/

    // Automatically close success dialog box after 3 seconds
    var $alert = $(".alert");
    if ($alert.length) {
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000);
    };
    /*------------------------------*/

//    JQuery dataTable for admin
    var $adminProductsTable = $("#adminProductsTable");
    // TODO later - must be changed
    if ($adminProductsTable.length) {
        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';


        $adminProductsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ["10 Records, 30 Records", "50 Records", "All Records"]],
            pageLength: 30,
            "order": [[0, "asc"]],
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'productId',
                },
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var image = "<img class='adminDataTableImg' src='" + window.contextRoot + "/resources/images/" + data + ".jpg'/>";
                        return image;
                    }
                },
                {data: 'productName',
                    mRender: function (data, type, row) {
                    var pName = "<span name='" + data + "' id='" + row.productId + "'>" + data +"</span>";
                    return pName;
                }
                },
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
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += "<label class='switch'>";
                        if (data) {
                            str += "<input type='checkbox' checked value='" + row.productId + "' />";
                        } else {
                            str += "<input type='checkbox' value='" + row.productId + "' />";
                        }
                        str += "<div class='slider round'></div></label>";

                        return str;
                    }
                },
                {
                    data: 'productId',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += "<a href='" + window.contextRoot + "/manage/" + data + "/product' title='Edit product' class='btn btn-warning'>";
                        str += "<span class='glyphicon glyphicon-pencil'></span></a>";
                        return str;
                    }
                }
            ],
            initComplete: function() {
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
                categoryName: {
                    required: true,
                    minlength: 2
                },
                categoryDescription: {
                    required:true,
                }
            },
            messages: {
                categoryName: {
                    required: "Please add the Category name",
                    minlength: "The Category name should not be less then 2 characters"
                },
                categoryDescription: {
                    required: "Please add the Category description",
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                error.addClass("help-block");
                error.insertAfter(element);
            }
        });
    };
    /*-----------------------------------------------------------*/


});
