import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AccordionModule } from 'primeng/accordion';
import { ButtonModule } from 'primeng/button';
import { SplitButtonModule } from 'primeng/splitbutton';
import { AppComponent } from './app.component';
import { ToolbarModule } from 'primeng/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { DropdownModule } from 'primeng/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { NewAccountComponent } from './components/new-account/new-account.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { AccountService } from './services/account.service';
import { TransactionService } from './services/transaction.service';



@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    UserInfoComponent,
    NewAccountComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    AccordionModule,
    ToolbarModule,
    ButtonModule,
    SplitButtonModule,
    AppRoutingModule,
    InputTextModule,
    InputTextareaModule,
    DropdownModule,
    HttpClientModule,
    TableModule,
    ToastModule
  ],
  providers: [MessageService,
    AccountService,
    TransactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
