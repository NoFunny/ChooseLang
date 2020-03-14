$(function () {
    $("#sign_up").click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let username = $("#upUsername").val();
        let password = $("#upPassword").val();
        let passwd = $('#repeat_pass').val();
        let email = $("#mail").val();
        if (password !== passwd) {
            alert("Пароли не совпадают!");
        }
        $.ajax({
            type: "POST",
            url: '/add_user',
            dataType: "text",
            data: {
                firstName: firstName,
                lastName: lastName,
                email: email,
                username: username,
                password: password
            }
        }).done((msg) => {
            if (msg == 0) {
                alert("Регистрация успешно завершена!");
                $("#modalUp").modal("toggle")
            } else if(msg == 1) {
                alert('Пользователь с такой почтой уже существует');
            } else if(msg == 2) {
                alert('Пользователь с таким логином уже существует');
            } else if(msg == 3) {
                alert('Пользователь с таким логином и почтой уже существует');
            }
        });
    });
});
