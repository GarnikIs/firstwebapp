$(document).ready(function () {

    // --- language dropdown --- //

    // turn select into dl
    createDropDown();
    var $dropTrigger = $(".dropdown dt a");
    var $languageList = $(".dropdown dd ul");

    $dropTrigger.on("click", function () {
        $languageList.slideToggle();
        if ($(this).data("clicked")) {
            $dropTrigger.addClass("active");
        } else {
            $(this).removeAttr("class");
        }
    });

    // close list when anywhere else on the screen is clicked
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdown"))
            $languageList.slideUp(200);
        $dropTrigger.removeAttr("class");
    });

    // when a language is clicked, make the selection and then hide the list
    $(".dropdown dd ul li a").click(function () {
        var oldValue = $("#country-options option:selected").val();
        var clickedValue = $(this).parent().attr("class");
        var clickedTitle = $(this).find("em").html();
        $("#country-options option[value='" + oldValue + "']").attr("selected", false);
        $("#country-options option[value='" + clickedValue + "']").attr("selected", true);
        window.currentLang = $("#country-options option:selected").attr("data-lang-id");
        $("#target dt").removeClass().addClass(clickedValue);
        $("#target dt em").html(clickedTitle);
        $languageList.hide();
        $dropTrigger.removeAttr("class");
    });

    // actual function to transform select to definition list
    function createDropDown() {
        $("div#country-select form").hide();
        var source = $("#country-options");
        source.removeAttr("autocomplete");
        if (window.currentLang == 1) {
            $("#country-options option[value='en']").attr("selected", true);
        } else {
            $("#country-options option[value='arm']").attr("selected", true);
        }
        var selected = source.find("option:selected");
        var options = $("option", source);
        $("#country-select").append('<dl id="target" class="dropdown"></dl>');
        // $("#target").append('<span class="ddArrow"></span>');
        $("#target").append('<dt class="' + selected.val() + '"><a>' +
            '<span class="flag"></span><em>' + selected.text() + '</em><span class="ddArrow"></span></a></dt>');
        $("#target").append('<dd><ul></ul></dd>');
        if (selected.val() == "en") {
            $("#target dd ul").append('<li class="arm"><a href="' + window.currentUrl + '?language=arm"><span class="flag"></span><em>Armenian</em></a></li>');
        } else if (selected.val() == "arm") {
            $("#target dd ul").append('<li class="en"><a href="' + window.currentUrl + '?language=en"><span class="flag"></span><em>English</em></a></li>');
        } /*else if (selected.val() == "ru") {
            $("#target dd ul").append('<li class="en"><a href="' + window.currentUrl + '?language=en"><span class="flag"></span><em>Russian</em></a></li>');
        }*/
    }

});


