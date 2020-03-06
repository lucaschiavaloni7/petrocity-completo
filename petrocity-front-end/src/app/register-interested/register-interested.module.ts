import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';
import { DropdownModule } from 'primeng/dropdown';

import { RegisterInterestedComponent } from './register-interested.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SuccessFormComponent } from './success-form/success-form.component';

@NgModule({
    declarations: [
        RegisterInterestedComponent,
        NavbarComponent,
        SuccessFormComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        CardModule,
        InputTextModule,
        InputMaskModule,
        DropdownModule,
        BrowserAnimationsModule
    ]
})
export class RegisterInterestedModule {

}
