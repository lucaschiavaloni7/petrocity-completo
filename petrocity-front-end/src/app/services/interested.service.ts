import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { Interested } from '../model/interested';

@Injectable({
    providedIn: 'root'
})
export class InterestedService {

    constructor(private http: HttpClient) { }

    addInterested(interested: Interested): Observable<Interested> {
        const url = `${environment.interestedUrl}`;
        return this.http.post<Interested>(url, interested);
    }

    getListInteresteds(): Observable<Interested[]> {
        const url = `${environment.interestedUrl}`;
        return this.http.get<Interested[]>(url);
    }

    getInterestedForId(id: number): Observable<Interested> {
        const url = `${environment.interestedUrl}/${id}`;
        return this.http.get<Interested>(url);
    }

    updateInterested(interested: Interested): Observable<Interested> {
        const url = `${environment.interestedUrl}/${interested.id}`;
        return this.http.put<Interested>(url, interested);
    }

}
