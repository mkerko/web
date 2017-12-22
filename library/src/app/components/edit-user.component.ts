import { Component, Input , OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { LowerCasePipe } from '@angular/common';
import 'rxjs/add/operator/switchMap';

import { Location } from '@angular/common';
import { User } from '../entities/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-edit-training',
  templateUrl: '../pages/edit-user.component.html',
  styleUrls: ['../app.component.css']
})

export class EditUserComponent implements OnInit {
    user: User;

    id: number;
    email: string;
    password: string;
    name: string;
    surname: string;
    faculty: string;
    course: number;
    group: number;

    constructor(private userService: UserService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.paramMap.switchMap((params: ParamMap) =>
            this.userService.getSingleUser(+params.get('id')))
            .subscribe(data => {this.user = data;
                this.email = data.email;
                this.password = data.password;
                this.name = data.name;
                this.surname = data.surname;
                this.faculty = data.faculty;
                this.course = data.course;
                this.group = data.group;
            });
        this.id = +this.route.snapshot.params['id'];
    }

    goBack() {
        this.location.back();
    }

    editUser() {
        const params =  JSON.stringify({
            id: this.id,
            email: this.email === null ? this.user.email : this.email,
            password: this.password,
            name: this.name === null ? this.user.name : this.name,
            surname: this.surname === null ? this.user.surname : this.surname,
            faculty: this.faculty === null ? this.user.faculty : this.faculty,
            course:  this.course  === null ? this.user.course : this.course,
            group: this.group  === null ? this.user.group : this.group
          });
        console.log('USER TO UPDATE:' + params);
        this.userService.updateUser(params, this.id);
    }
}
