import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Interested } from '../../../model/interested';
import { InterestedService } from '../../../services/interested.service';

@Component({
    templateUrl: 'detail-interested.component.html',
    styleUrls: ['detail-interested.component.css']
})
export class DetailInterestedComponent implements OnInit {

    public editLabel = 'Editar';

    public interested: Interested = new Interested();
    public edit = true;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private interestedService: InterestedService
    ) { }

    ngOnInit() {
        this.route.params.subscribe(param => {
            this.getInterested(param.id);
        });
    }

    getInterested(id: number) {
        this.interestedService.getInterestedForId(id)
            .subscribe((interested: Interested) => {
                this.interested = interested;
            });
    }

    enableEdit() {
        this.edit = !this.edit;
        if (!this.edit) {
            this.editLabel = 'Cancelar';
        } else {
            this.editLabel = 'Editar';
        }
    }

    updateInterested() {
        this.interestedService.updateInterested(this.interested)
            .subscribe(
                () => { this.router.navigateByUrl('/dashboard/lista-interessados'); }
            );
    }

}
