$(document).ready (() => {
    $('#sign_up').click(() => {
        let firstName = $('#firstName').val;
        let lastName = $('#lastName').val;
        let username = $('#username').val;
        let password = $('#password').val;
        let email = $('#mail').val;
        console.log("12123123123");
        setTimeout(10000);
        $.ajax({
            type: "POST",
            utl: "/add_user",
            dataType: "text",
            data: {
                firstName: firstName,
                lastName: lastName,
                username: username,
                password: password,
                email: email
            }
        }).done((msg) => {
            if (msg === 0)
                alert("Данные успешно отправлены");
            alert("чото не так");
        });
    });
});