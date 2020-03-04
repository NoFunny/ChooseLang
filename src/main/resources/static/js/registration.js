$(function () {
    $("#sign_up").click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let username = $("#upUsername").val();
        let password = $("#upPassword").val();
        let email = $("#mail").val();
        // console.log(lastName);
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
                $("#modalUp").modal("toggle")
                // $(".bd-signUp-modal").css("display:none");
            }

                // alert("Данные успешно отправлены");
            alert(msg);
        });
    });
});

