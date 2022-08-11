import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewAccount } from '../models/new-account';
import { UserInformation } from '../models/user-information';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private readonly BASE_URL = 'http://localhost:8090/api/v1/account/';

  constructor(private readonly httpClient: HttpClient) {
  }

  getUserInfo():Observable<UserInformation> {
      return <Observable<UserInformation>>this.httpClient.get(`${this.BASE_URL}getByCustomerId/1BIL`);
  }

  newAccount(code:any):Observable<any> {
    return this.httpClient.post(`${this.BASE_URL}`, code);
  }

}
