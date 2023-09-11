import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userEmail: string="";
  userPassword: string="";
 
  constructor(private router :Router,private http:HttpClient) { }

  login() {
    // console.log(this.userEmail);
    // console.log(this.userPassword);

    let bodyData = {
      email: this.userEmail,
      password: this.userPassword,
    };
        this.http.post("http://localhost:8088/api/user/login", bodyData).subscribe(  (resultData: any) => {
        console.warn(resultData);

        if (resultData.message == "Email not exits")
        {
      
          alert("Email not exits");
    
        }
        else if(resultData.message == "Login Success")
        {
          this.router.navigateByUrl('/home');
        }
        else
        {
          alert("Incorrect Email and Password not match");
        }
 
      });
    }




}
