/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $.ajax({
            url: 'http://localhost:8080/advs/getAndUpdateWebSite' ,
            dataType: 'json',
            type:"POST",
            success: function (data) {


                if (data==null)
                {
                   
					alert("שגיאה");
  // console.log("error:" + data.status + " " + data.statusInfo);
                }
                else
                {
                    var list=data;
                    for(i=0;i<data.length;i++)
                    {
                    	var adv=data[i];
                    	var area=adv.areaCode;
                    	var file=adv.file;
                    	document.getElementById("img"+area).src="data:image/png;base64,"+file;
                    	document.getElementById("a"+area).isConnected=false
                    }
                }


            },
            error: function () {
                $("#errorDiv").html("לא ניתן להתחבר עם הפרטים לעיל")
            }
        });
    });

