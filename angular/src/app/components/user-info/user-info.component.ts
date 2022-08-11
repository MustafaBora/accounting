import { Component, OnInit } from '@angular/core';
import { UserInformation } from 'src/app/models/user-information';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  userInfo = Array<UserInformation>();

  constructor(private readonly accountService: AccountService) {
  }

  ngOnInit(): void {
    this.getUserInfo();
  }

  getUserInfo() {
    this.accountService.getUserInfo().subscribe((val) => {
      this.userInfo = this.userInfo.concat(val);
    });
  }

}
