import { Component, Input, OnInit } from '@angular/core'; 
import { User } from '../entities/user'; 
import { ActivatedRoute, ParamMap } from '@angular/router'; 
import { ExchangeRatesService } from '../services/exchange-rates.service'; 
import 'rxjs/add/operator/switchMap'; 

import { Location } from '@angular/common'; 
import { ExchangeRates } from '../entities/exchange-rates';

@Component({
    selector: 'app-exchange', 
    templateUrl: '../pages/exchange-rates.component.html', 
    styleUrls: ['../app.component.css']
})

export class ExchangeRatesComponent implements OnInit { 
    exchangeRates: ExchangeRates; 
    firstExchange = 'GBP';
    secondExchange = 'USD';
    constructor(private exchangeRatesService: ExchangeRatesService) { } 

    ngOnInit(): void { 
        this.exchangeRatesService.getRates(this.firstExchange, this.secondExchange) 
        .subscribe(data => this.exchangeRates = data); 
    }
}
