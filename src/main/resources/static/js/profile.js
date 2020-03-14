$(document).ready (() => {
   let username = $("#userLogin").text();
   $.ajax({
       type: "POST",
       url: "/getFullName",
       dataType: "text",
       data: {
           username : username
       }
   }).done((msg) => {
       if(msg != null) {
           $("#firstName").text(JSON.parse(msg).firstName);
           $("#lastName").text(JSON.parse(msg).lastName);
       }else{
           alert("Incorrect post request");
       }
   });
   $.ajax({
       type: "POST",
       url: "/get_book",
       dataType: "text",
       data: {
            username : username
       }
   }).done((msg) => {
       let message = JSON.parse(msg);
       let uniqueMsg = message.filter((item) => itemCheck(item));
       $(".myLibrary")
           .append("<div class = 'container-fluid'>" +
               "        <div class='row'>" +
               "            <div class='col'>" +
               "                <ul></ul>" +
               "            </div>" +
               "        </div>"
           );
       for(let i = 0; i < uniqueMsg.length; i++)
           render(uniqueMsg[i]);
   })
});

let tmpArray = [];

function itemCheck(item) {
    if (tmpArray.indexOf(item.name) === -1) {
        tmpArray.push(item.name);
        return true
    }
    return false;
}

function render(item) {
    return  $(".myLibrary>div>div>div>ul")
        .append(
            "<li class='shelf'>" + item.name + "<button id='deleteBook' type='button' class='close bd-dark' data-dismiss='modal' aria-label='Close' style='color:white'>\n" +
            "                            <span aria-hidden='true'>×</span></li>"
        )
}

$(function () {
    $('body').on('click', '#deleteBook', function () {
        let nameBook = $(this).closest('li.shelf').text();
        let string = [];
        for(let i = 0; i < nameBook.length; i++) {
            if(nameBook[i] === '\n') {
               string = nameBook.slice(0,i);
            }
        }
        string.toString();
        let user = $("#userLogin").text();
        $(this).parent().remove();
        $.ajax({
            type: "POST",
            url: "/deleteBook",
            dataType: "text",
            data: {
                user: user,
                nameBook: string
            }
        }).done((msg) => {
            msg = JSON.parse(msg);
        })
    })
});
