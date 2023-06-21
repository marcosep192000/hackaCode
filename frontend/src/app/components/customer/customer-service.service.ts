import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerModel } from './customer-model';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService implements OnInit {
  expURL = "http://localhost:8080/api/v1/customers/";
  constructor(private httpClient: HttpClient, private router: Router) {

  }
  ngOnInit(): void {
  }

  public all(): Observable<[]> {
    return this.httpClient.get<[]>(this.expURL + 'filters');
  }

  public save(customer: CustomerModel): Observable<any> {
    return this.httpClient.post(this.expURL + `create`, customer);
  }

  public update(id: number, customer: CustomerModel): Observable<any> {
    return this.httpClient.put(this.expURL + `update/${id}`, customer);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete(this.expURL + `delete/${id}`);
  }

  public findId(id: number): Observable<any> {
    return this.httpClient.get<CustomerModel>(this.expURL + `find/${id}`)
  }


}
