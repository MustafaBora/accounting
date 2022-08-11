import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewAccount } from '../models/new-account';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private readonly BASE_URL = 'http://localhost:8090/api/v1/account/';

  constructor(private readonly httpClient: HttpClient) {
  }

  getUserInfo():Observable<NewAccount> {
      return <Observable<NewAccount>>this.httpClient.get(`${this.BASE_URL}getByCustomerId`);
  }

  newAccount(code:any):Observable<any> {
    return this.httpClient.post(`${this.BASE_URL}`, code);
  }

}
