import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { NgxPaginationModule } from 'ngx-pagination';

import { ListInterestedsComponent } from './interested/list-interesteds/list-interesteds.component';
import { DetailInterestedComponent } from './interested/detail-interested/detail-interested.component';
import { LoginComponent } from '../login/login.component';
import { DashboardComponent } from './dashboard.component';
import { DashboardRoutingModule } from './dashboard.routing.module';

@NgModule({
    declarations: [
        DashboardComponent,
        LoginComponent,
        ListInterestedsComponent,
        DetailInterestedComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        DashboardRoutingModule,
        RouterModule,
        FormsModule,
        NgxPaginationModule
    ],
    exports: [

    ],
    providers: []
})
export class DashboardModule {

}
