$(function () {
    $("#sign_up").click(function () {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let username = $("#upUsername").val();
        let password = $("#upPassword").val();
        let email = $("#mail").val();
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
            }
            alert(msg);
        });
    });
});

