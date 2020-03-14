$(document).ready (() => {
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
        if(this.checked === true) {
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
                if (msg) {
                    console.log("OK!");
                } else
                    console.log("Error!");
            });
        }else {
            console.log("Отмена");
        }
    });
});


$(function () {
    $(".updateSalary").click(function () {
        $.ajax({
            type: "POST",
            url: "/updateSalary",
            dataType: "text"
        }).done(console.log("salary update"))
    })
});

$(function () {
    $('#select').change(function() {
        let city = $(this).val();
        $.ajax({
            type: "POST",
            url: "/getSalary",
            dataType: "text",
            data: {
                city: city
            }
        }).done((msg) => {
            let message = JSON.parse(msg);
            for(let i = 0; i < message.langs.length; i++) {
                if(message.langs[i].name == "Python") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".python_salary>div").remove();
                    $(".python_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "Java") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".java_salary>div").remove();
                    $(".java_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "C") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".ci_salary>div").remove();
                    $(".ci_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")

                }else if(message.langs[i].name == "PHP") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".php_salary>div").remove();
                    $(".php_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "CPP") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".cpp_salary>div").remove();
                    $(".cpp_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "JS") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".js_salary>div").remove();
                    $(".js_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "CSH") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".csh_salary>div").remove();
                    $(".csh_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "Ruby") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".ruby_salary>div").remove();
                    $(".ruby_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }else if(message.langs[i].name == "Objective+C") {
                    for(let prop in message.langs[0].levels) {
                        if (message.langs[i].levels[prop] == -1) {
                            message.langs[i].levels[prop] = "Нету данных";
                        }
                    }
                    $(".obci_salary>div").remove();
                    $(".obci_salary")
                        .append("<div class='container-fluid'>" +
                            "           <div class='row'>" +
                            "                    <div class='col'>" +
                            "                           <ul>" +
                            "                                <li> З/П Джун " + message.langs[i].levels.junior + "</li>" +
                            "                                <li> З/П Миддл " + message.langs[i].levels.middle + "</li>" +
                            "                                <li> З/П Сеньор " + message.langs[i].levels.senior + "</li>" +
                            "                           </ul>" +
                            "                   </div>" +
                            "           </div>" +
                            "   </div>")
                }
            }
        })
    });
});
