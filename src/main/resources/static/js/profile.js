$(document).ready (() => {
   let username = $("#userLogin").text();
   console.log(username);
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
       console.log(msg);
       let message = JSON.parse(msg);
       console.log(message);
       let uniqueMsg = message.filter((item) => itemCheck(item));
       console.log(uniqueMsg);
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
    console.log(item.name);
    return  $(".myLibrary>div>div>div>ul")
        .append(
            "<li>" + item.name + "</li>"
        )
}
