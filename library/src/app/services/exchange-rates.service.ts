import { Component, Input, Injectable } from '@angular/core'; 
import { Headers, Http, Response, RequestOptions } from '@angular/http'; 
import { Router } from '@angular/router'; 
import 'rxjs/add/operator/toPromise'; 
// tslint:disable-next-line:import-blacklist 
import {Observable} from 'rxjs/Rx'; 
import 'rxjs/add/operator/map'; 
import 'rxjs/add/operator/catch'; 

@Injectable() 
export class ExchangeRatesService { 
private exchangeUrl = 'api/exchangeRates?first='; //
private errorUrl = ['/error']; 

private jsonHeaders = new Headers({'Content-Type': 'application/json'}); 

constructor(private http: Http, 
    private router: Router) { 
} 

getRates(first: String, second: String): Observable<any> { 
    return this.http.get(this.exchangeUrl + first + '&second=' + second) //
    .map((res: any) => res.json()).catch(this.handleError); 
} 

private handleError = (error: any) => { 
    console.error(error); 
    this.router.navigate(this.errorUrl); 
    return Observable.of([]); 
    } 
}