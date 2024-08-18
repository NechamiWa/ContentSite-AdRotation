/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#btn").click(function () {
        var account = $("#account").val();
        var password = $("#password").val();
        $.ajax({
            url: '/customers/login?email=' + account + "&password=" + password,
            dataType: 'json',
            success: function (data) {


                if (data==null)
                {
                    $("#errorDiv").html("לא ניתן להתחבר עם הפרטים לעיל");
                   // console.log("error:" + data.status + " " + data.statusInfo);
                }
                else
                {
                    sessionStorage["account"] = account;
                    sessionStorage["password"] = password;
                    sessionStorage["accountNum"] = data.code;



                    window.location.href = "home.html";
                }


            },
            error: function () {
                $("#errorDiv").html("לא ניתן להתחבר עם הפרטים לעיל")
            }
        });
    });
});
