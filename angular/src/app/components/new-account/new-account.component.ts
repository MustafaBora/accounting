import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { NewAccount } from 'src/app/models/new-account';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css']
})
export class NewAccountComponent implements OnInit {
  public autoResize: boolean = true;


  constructor(private readonly fb: FormBuilder,
    private readonly service: AccountService,
    private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  newAccountForm = this.fb.group({
    customerID: [null, Validators.required],
    initialCredit: [null, Validators.required]
  });

  save() {
    const userInfo: NewAccount = <NewAccount>{};
    userInfo.customerID = this.newAccountForm.value['customerID'];
    userInfo.initialCredit = this.newAccountForm.value['initialCredit'];

    this.service.newAccount(userInfo).subscribe({
      next: (val) => {
        this.messageService.add({ severity: 'success', summary: 'New account complete', detail: val + " id new account is done." });
        this.newAccountForm.reset();
      },
      error: (err) => {
        this.messageService.add({ severity: 'error', summary: 'New account error', detail: JSON.stringify(err) });
      },
      complete: () => { }
    });
  }

}
