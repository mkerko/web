export class ExchangeRates {
    firstExchange: string;
    secondExchange: string;
    rate: number;

    constructor( 
        firstExchange: string,
        secondExchange: string,
        rate: number) {
            this.firstExchange = firstExchange;
            this.secondExchange = secondExchange;
            this.rate = rate;
        }
}
