import { Component, Input, OnInit, transition } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { LowerCasePipe } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Location } from '@angular/common';
import { UserService } from '../services/user.service';
import { User } from '../entities/user';
import { Observable } from 'rxjs/Observable';


@Component({
  selector: 'app-login',
  templateUrl: '../pages/login.component.html',
  styleUrls: ['../app.component.css']
})

export class LoginComponent {
    email: string;
    password: string;
    name: string;
    user: User;

    constructor(private userService: UserService,
        private location: Location,
        private router: Router) {
     }

    login() {
        this.userService.tryLogin(this.email, this.password)
        .subscribe(data => { 
            this.findUser();
            this.router.navigate(["/users"]);    
        })
        };

    findUser() {
       this.userService.getUserByEmail(this.email)
        .subscribe(data => {
            console.log("get by email");
            console.log(data);
            this.user = data;
            sessionStorage.setItem("username", data.name);
        });
        this.password = null;
    }

    goBack() {
        this.location.back();
    }
}
