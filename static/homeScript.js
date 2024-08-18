/**
 * 
 */
 /*
 const handleImageUpload = event => {
  const files = event.target.files
  const formData = new FormData()
  formData.append('myFile', files[0]);
  var avd;
  if
  fetch('/advs', {
    method: 'POST',
    body: formData
  })
  .then(response => response.json())
  .then(data => {
    console.log(data.path)
  })
  .catch(error => {
    console.error(error)
  })
}

document.querySelector('#fileUpload').addEventListener('change', event => {
  handleImageUpload(event)
})
*/
$(document).ready(function () {
    $("#btnAdd").click(function () {
    var adv;
      adv= {};
      adv.areaCode=parseInt($("#placeSelect").val());
      adv.customerCode=parseInt(sessionStorage["accountNum"]);
      var path;
      var file = $("#fileUploader")[0].files[0];
      formData = new FormData()
  formData.append('file', file);
      
    if($("#typeAdv").val()=="1"){
  
    adv.minutes=parseInt($("#num").val()+"");
    path="/advs/addTimeAdv";
    }
    else
    {
    adv.wantedViews=$("#num").val();
       adv.amountViews=0;
    path="/advs/addViewsAdv";
    }
    
    
   adv.code= 0;
    //"areaCode": 0,
    adv.active= false;
    //"customerCode": 0,
    adv.orderDate= null;
   // adv.area= null;
   // adv.customer=null;
   // "minutes": 0
    formData.append('adv',JSON.stringify(adv));
    var arr=[];
    arr[0]=formData;
    arr[1]=adv;
        $.ajax({
            url: path,
           // dataType: 'json',
            //data:formData,
            type:"POST",
            data:formData,
            processData:false,
           contentType:false,
            
            
            success: function (data) {


                if (data==false)
                {
                alert("האזור כבר תפוס");
             //       $("#errorDiv").html("לא ניתן להתחבר עם הפרטים לעיל");
                   // console.log("error:" + data.status + " " + data.statusInfo);
                }
                else
                {
                    /*sessionStorage["account"] = account;
                    sessionStorage["password"] = password;
                    sessionStorage["accountNum"] = data.accountNumber;



                    window.location.href = "home.html";*/
                    alert("הצליח");
                }


            },
            error: function (err) {
               console.log(JSON.stringify(adv))
            }
        });
    });
});
