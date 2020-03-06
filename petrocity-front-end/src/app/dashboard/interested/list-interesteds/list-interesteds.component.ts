import { Component, OnInit } from '@angular/core';

import { Interested } from '../../../model/interested';
import { InterestedService } from '../../../services/interested.service';

@Component({
    templateUrl: './list-interesteds.component.html',
    styleUrls: ['./list-interesteds.component.css']
})
export class ListInterestedsComponent implements OnInit {

    public page = 1;

    public interesteds: Interested[] = [];

    constructor(private interestedService: InterestedService) { }

    ngOnInit() {
        this.getListInteresteds();
    }

    getListInteresteds() {
        this.interestedService.getListInteresteds()
            .subscribe((interesteds: Interested[]) => {
                this.interesteds = interesteds;
            });
    }
}
