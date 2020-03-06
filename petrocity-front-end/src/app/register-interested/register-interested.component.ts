import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { InterestedService } from '../services/interested.service';
import { Interested } from '../model/interested';
import { City } from '../model/city';
import { State } from '../model/state';
import { StateAndCityService } from '../services/stateAndCity.service';

@Component({
    templateUrl: 'register-interested.component.html',
    styleUrls: ['register-interested.component.css']
})
export class RegisterInterestedComponent {
    @Input() interested: Interested = {} as Interested;

    public stateObj: State;

    public statesObj: State[] = [];

    public citiesObj: City[] = [];

    public cityObj: City;

    constructor(
        private interestedService: InterestedService,
        private stateAndCityService: StateAndCityService,
        private router: Router) { }

    ngOnInit() {
        this.stateAndCityService.getStates()
            .subscribe((states: State[]) => {
                this.statesObj = states;
            });
    }

    getListCitys() {
        this.interested.state = this.stateObj.name;

        this.stateAndCityService.getCities(this.stateObj.code)
            .subscribe((cities: City[]) => {
                this.citiesObj = cities;
            });
    }

    selectCity() {
        this.interested.city = this.cityObj.name;
    }

    onSubmit() {
        this.interestedService.addInterested(this.interested)
            .subscribe(
                () => { this.router.navigateByUrl('/obrigado'); }
            );
    }
}
