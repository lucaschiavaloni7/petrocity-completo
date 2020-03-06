import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ListInterestedsComponent } from './interested/list-interesteds/list-interesteds.component';
import { DetailInterestedComponent } from './interested/detail-interested/detail-interested.component';
import { DashboardComponent } from './dashboard.component';

const dashboardRoutes = [
    {
        path: 'dashboard', component: DashboardComponent, children: [
            { path: 'lista-interessados', component: ListInterestedsComponent },
            { path: 'detalhes-interessado/:id', component: DetailInterestedComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(dashboardRoutes)],
    exports: [RouterModule]
})
export class DashboardRoutingModule {

}
