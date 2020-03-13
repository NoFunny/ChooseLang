$(function () {
    $("#sign_up").click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let username = $("#upUsername").val();
        let password = $("#upPassword").val();
        let passwd = $('#repeat_pass').val();
        let email = $("#mail").val();
        if(firstName == null || lastName == null || username == null || password == null || email == null) {
            alert("Не все поля заполнены!");
            return;
        }
        if(password !== passwd) {
            alert("Пароли не совпадают!");
            return;
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
            if (msg === 0) {
                $("#modalUp").modal("toggle")
            }
            alert(msg);
        });
    });
});

