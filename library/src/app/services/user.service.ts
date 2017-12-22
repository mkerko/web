import { Component, Input, Injectable } from '@angular/core'; 
import { Headers, Http, Response, RequestOptions } from '@angular/http'; 
import { Router } from '@angular/router'; 
import 'rxjs/add/operator/toPromise'; 
import {Observable} from 'rxjs/Rx'; 
import { User } from '../entities/user'; 

import 'rxjs/add/operator/map'; 
import 'rxjs/add/operator/catch'; 


@Injectable()
export class UserService { 
private usersUrl = 'api/users'; 
private userUrl = 'api/user?email='; 
private separator = '/'; 
private errorUrl = ['/error'];
private usersRoutingUrl = ['/users'];  
private loginUrl = '/login';

private headers = new Headers({'Content-Type': 'application/json'}); 
private authHeaders = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
private gzipHeaders = new Headers({'Accept-encoding': 'gzip'});

constructor(private http: Http, private router: Router) {} 

    getUsers(): Observable<any> { 
        return this.http.get(this.usersUrl) 
        .map((res: any) => res.json()).catch(this.handleError); 
    }

    getSingleUser(id: number): Observable<User> { 
        return this.http.get(this.usersUrl + this.separator + id) 
        .map((res: any) => res.json()).catch(this.handleError); 
    }

    getUserByEmail(email: string): Observable<User> { 
        return this.http.get(this.userUrl+email) 
        .map((res: any) => res.json()).catch(this.handleError); 
    }

    registerUser(params: string){ 
        this.http.post(this.usersUrl, params, { headers: this.headers}).subscribe(
            data => JSON.stringify(data),
            error => this.handleError);
    this.router.navigate(this.usersRoutingUrl);
    }

    deleteUser(id: number) {
        this.http.delete(this.usersUrl + this.separator + id, { headers: this.headers}).subscribe( 
            data => JSON.stringify(data), 
            error => this.handleError); 
        this.router.navigate(this.usersRoutingUrl); 
    }
    
    tryLogin(email: string, password: string): Observable<any> {
        const body = 'email=' + email + '&password=' + password;
        return this.http.post(this.loginUrl, body, {headers: this.authHeaders})
        .map((res: any) => {
            if (res.status === 200){ 
            console.log("Logged in!")
        } res
    }).catch(this.handleError);
    }

    updateUser(params: string, id: number) {
        this.http.patch(this.usersUrl + this.separator + id, params,
            { headers: this.headers}).subscribe(
                data => JSON.stringify(data),
                error => this.handleError);
        this.router.navigate(this.usersRoutingUrl);
    }

    tryLogoutUser(){
        sessionStorage.removeItem('username');
    }

    private handleError = (error: any) => { 
        if (error.status === 401 || error.status === 403) {
            this.router.navigate(this.errorUrl); 
            return Observable.throw(new Error(error.status));
        }
        console.error(error); 
        this.router.navigate(this.errorUrl); 
        return Observable.of([]); 
    } 

}