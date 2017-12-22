import { Observable } from 'rxjs/Rx'; 
import { Component, Input, OnInit } from '@angular/core'; 
import { User } from '../entities/user'; 
import { UserService } from '../services/user.service'; 

@Component({ 
    selector: 'app-users', 
    templateUrl: '../pages/users.component.html', 
    styleUrls: ['../app.component.css']
})

export class UsersComponent implements OnInit { 
    users: User[] = []; 

    constructor(private userService: UserService) {} 

    ngOnInit(): void { 
        this.userService.getUsers().subscribe(data =>{ this.users = data; console.log(this.users)}, 
        error => console.log(error)); 
    } 
}