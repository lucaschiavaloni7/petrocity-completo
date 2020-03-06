import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { State } from '../model/state';
import { City } from '../model/city';


@Injectable({
    providedIn: 'root'
})
export class StateAndCityService {

    constructor(private http: HttpClient) { }

    getStates(): Observable<State[]> {
        const url = `${environment.statesAndCityApiUrl}/statesAPI`;
        return this.http.get<State[]>(url);
    }

    getCities(state: string): Observable<City[]> {
        const url = `${environment.statesAndCityApiUrl}/citiesAPI/${state}`;
        return this.http.get<City[]>(url);
    }

}
