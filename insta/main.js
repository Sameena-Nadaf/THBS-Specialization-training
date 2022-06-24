function validate(){
var u=document.f1.username.value;
var p=document.f1.password.value;
var res;

if(u==null||u==""){
	alert("kindly provide username");
    return false;
   }else if(u.match(".*[A-Z].*") && u.match(".*[a-z].*")){
	   alert("valid name");
   return true;
   }else {
	   alert('in-valid user name or name does not contains numbers');
   }
   


   
   {					
					
if(p.match(".*[A-Z].*") && p.match(".*[a-z].*") && p.match(".*[0-9].*")&& p.match(".*[!@#$%^*$].*") && p.length>=7 )
				{
					res = "TRUE";
					alert('valid password');
					}
            else
			{ res = "FALSE";
		     alert('In-valid password');
	
					}
   
   }
 
}