/*
 class for use in html

 - required
 - password
 - passwordConf
 - email
 - number

*/


$(document).ready(function(){
    
   var TextBok = "form-control input-sm";
   var Btn = "btn btn-primary";

   //var email = "/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/";
   //var number = "/^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/";
   //var phone = "[0-9]+";


//add class to input tag
   var input = [
        "input[type='text']",
        "input[type='number']",
        "input[type='password']",
        "input[type='email']",
        "input[type='date']",
        "select"
   ];

   $.each(input,function(index,value){

        $(value).addClass(TextBok);
   }); // the end add class from bootstrap  input tag dynamic

   
   
   $("input[type='submit']").addClass(Btn);

   $("input[name='phone']").attr("pattern",phone);
   //$("input[name='email']").attr("pattern",email);
   
//   ------------------------------------------


 
  $("form").submit(function(){

    var abort = false;
    $("div.error").remove();
    $("div.check").remove();

    $(".required").each(function(){

      var personalClass = $(this).attr('id');

      if($(this).val()===''){

        $(this).after('<div class="error ' +personalClass+' " style="color:red" ><small>This field is required *</small></div>');
            
      }

      abort = true;

    });

      if( abort ) { return false; } else { return true;}

  }); //end submit form


   $(".required").blur(function(){

        var getId = $(this).attr("id");

        if( $(this).val() !== '' ) {

            $("div."+getId).remove();

        }
        else if ( $(this).val() == '' && $("div."+getId).empty() ) {

            $(this).after('<div class="error ' +getId+' " style="color:red" ><small>This field is required *</small></div>');

        }

   });// end of reqired class


   // confirm password
   $(document).on('focusout','.passwordConf',function(){

        var password        = $(".password").val();
        var passwordConf    = $(this).val();

        $('div .passConf').remove();

        if(password !== passwordConf){

            $('div.error').remove();
            $(this).after('<div class="passConf" style="color:red" ><small>The confirm password not corrent.</small></div>');
        } 
        
        if( $(this).val() === '' ) {

            $('div .passConf').remove();
        }
   });// end confirm password


   // check email 
    $(document).on('focusout','.email',function(){

        var email = $(this).val();
        $("div.myemail").remove();

        if(email.indexOf('@') <= 0 ){

            $(this).after('<div class="myemail" style="color:red" ><small>The email must include @ .</small></div>');
            
        }else {
            $("div.myemail").remove();
        }
        if( email === '' ){
            
            $("div.myemail").remove();
        }

    });// end check email

    //validate phone number
    $(document).on('keyup','.phone',function(){

        var number      = $(this).val();
        var conToInt    = parseInt(number);
        var conToString = conToInt.toString();
        var lengNum = number.length;
        
        if(number === '0'){
            $(this).val("");
        }
        
        if(number !== conToString){

            var cutStr  = number.substring(lengNum-1,0);
            $(this).val(cutStr); 
        }

        if(lengNum >= 10){
            var cutStr  = number.substring(lengNum-1,0);
            $(this).val(cutStr);   
        }
       
    }); // the end of validate of phone number


});


