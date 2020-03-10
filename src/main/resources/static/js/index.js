$(document).ready (() => {
    console.log($(window).width());
    if(($(window).width() > 1800) && ($(window).width() < 2000)) {
        $('.main-photo').height(1015);
    }else if(($(window).width() > 1300) && ($(window).width() === 1400)) {
        $('.main-photo').height(700);
    }else if(($(window).width() > 1170) && ($(window).width() < 1290)) {
        $('.main-photo').height(674);
    }else if(($(window).width() > 964) && ($(window).width() < 1124)) {
        $('.main-photo').height(533);
    }else if(($(window).width() > 710) && ($(window).width() < 820)) {
        $('.main-photo').height(393);
    }else if($(window).width() == 720) {
        $('.main-photo').height(393);
    }else if(($(window).width() > 410) && ($(window).width() < 600)) {
        $('.main-photo').height(198);
    }else if(($(window).width() > 345) && ($(window).width() < 410)) {
        $('.main-photo').height(170);
    }else if(($(window).width() > 300) && ($(window).width() < 340)) {
        $('.main-photo').height(143);
    }
});

window.onload =  () => {
    jQuery(".selected_city").text(ymaps.geolocation.city);
};

$(window).on('scroll', () => {
    let scrollCoef = 0.0002;
    let r = 1 - $(window).scrollTop() * scrollCoef;
    $('.head').css ({
        backgroundColor: "rgba(14,26,100,"+r+')'})
});

$(function () {
    $(".navbar-collapse>ul>li>a").click(() => {
        if (!$(this).hasClass("dropdown-toggle"))
            $(".navbar-collapse").collapse('hide');
    });
});

$(function () {
    $(".navbar-collapse>ul>li>select").change(() => {
        $(".navbar-collapse").collapse('hide');
    });
});

$(function () {
    $('#select').change(function() {
        let city = $(this).val();
        $('.selected_city').text(city);
    });
});

$(function () {
    $('#sign_in').click(function() {
        $("#modalIn").modal("toggle");
    });
});

$(function () {
    $(".checked").click(function() {
        let book = $(this).parent().text();
        let username = $("#userLogin").text();
        console.log(book);
        $.ajax({
            type: "POST",
            url: "/add_book",
            dataType: "text",
            data: {
                book: book,
                username: username
            }
        }).done((msg) => {
            if(msg) {
                console.log("OK!");
            }else
                console.log("Error!");
        });
    });
});

