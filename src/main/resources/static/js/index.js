$(document).ready (() => {
    console.log($(window).width());
    if($(window).width() === 1920) {
        $('.main-photo').height(1015);
    }else if($(window).width() === 1280) {
        $('.main-photo').height(674);
    }else if($(window).width() === 1351) {
        $('.main-photo').height(700);
    }else if($(window).width() === 1024) {
        $('.main-photo').height(533);
    }else if($(window).width() === 768) {
        $('.main-photo').height(393);
    }else if($(window).width() === 425) {
        $('.main-photo').height(201);
    }else if($(window).width() === 375) {
        $('.main-photo').height(170);
    }else if($(window).width() === 320) {
        $('.main-photo').height(143);
    }
});

window.onload = function () {
    jQuery(".selected_city").text(ymaps.geolocation.city);
};

$(window).on('scroll', () => {
    let scrollCoef = 0.0002;
    let r = 1 - $(window).scrollTop() * scrollCoef;
    $('.head').css ({
        backgroundColor: "rgba(14,26,100,"+r+')'})
});

//при нажатии на ссылку
$(".navbar-collapse>ul>li>a").click(() => {
    //если она не имеет класс dropdown-toggle
    if (!$(this).hasClass("dropdown-toggle")) {
        //то закрыть меню
        $(".navbar-collapse").collapse('hide');
    }
});

$(".navbar-collapse>ul>li>select").change(() => {
    $(".navbar-collapse").collapse('hide');
});

$('#select').change(function() {
    let city = $(this).val();
    $('.selected_city').text(city);
});