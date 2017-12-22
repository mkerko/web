import { Observable } from 'rxjs/Rx'; 
import { Component, Input, OnInit } from '@angular/core'; 
import { User } from '../entities/user'; 
import { UserService } from '../services/user.service'; 

@Component({ 
    selector: 'error', 
    templateUrl: '../pages/error.component.html', 
    styleUrls: ['../app.component.css']
})

export class ErrorComponent { 

}