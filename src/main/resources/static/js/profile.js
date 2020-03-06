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
       type: "GET",
       url: "/getBook",
       dataType: "text",
       data: {

       }
   })
});