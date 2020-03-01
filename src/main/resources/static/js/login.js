$(function () {
    $("#sign_in").click(function () {
        let username = $("#inUsername").val();
        let password = $("#inPassword").val();
        $.ajax({
            type: "POST",
            url: '/log_in',
            dataType: "text",
            data: {
                username: username,
                password: password,
            }
        }).done((msg) => {
            if (msg == 0)
                $("#modalIn").modal("toggle");
                alert(msg);
            // document.location.replace("/");
        });
    });
});

