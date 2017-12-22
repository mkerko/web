import { Component, Input, OnInit } from '@angular/core'; 
import { User } from '../entities/user'; 
import { UserService } from '../services/user.service'; 

@Component({ 
    selector: 'app-registration', 
    templateUrl: '../pages/registration.component.html', 
    styleUrls: ['../app.component.css']
})

export class RegistrationComponent{ 
    email: string;
    password: string;
    role: string;

    constructor(private userService: UserService) {} 

    registerUser(){
        const body = JSON.stringify({
            email: this.email,
            password: this.password,
            role: this.role
        });
        console.log('New user: ' + body);
        this.userService.registerUser(body);
    }
}