$(function () {
    $("#sign_up").click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let username = $("#username").val();
        let password = $("#password").val();
        let email = $("#mail").val();
        // console.log(lastName);
        $.ajax({
            type: "POST",
            url: '/add_user',
            dataType: "text",
            data: {
                firstName: firstName,
                lastName: lastName,
                username: username,
                password: password,
                email: email
            }
        }).done((msg) => {
            if (msg == 0) {
                $("#modalUp").modal("toggle")
                // $(".bd-signUp-modal").css("display:none");
            }

                // alert("Данные успешно отправлены");
            alert(msg);
        });
    });
});

