/**
 * Created by Gor on 11/16/2017.
 */

$(function() {

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
        case "Contact":
            $("#contact").addClass("active");
            break;
        case (category):
            $("#products").addClass("active");
            $("#"+category).addClass("active");
            break;
        default:
            $("#products").addClass("active");
            break;
    }

});
