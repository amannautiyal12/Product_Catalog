import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  userName: string="";
  userEmail: string="";
  userPassword: string="";
 
  constructor(private router:Router,private http:HttpClient){ }

  save(){
    let bodyData={
      "name": this.userName,
      "email": this.userEmail,
      "password": this.userPassword,
    };

    this.http.post("http://localhost:8088/api/user/save",bodyData,{responseType:'text'}).subscribe((resultData:any)=>{
      console.warn(resultData);
      alert("User Registered Successfully");
      this.router.navigateByUrl('/login');
    });


  }



}
