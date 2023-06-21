import { Component, OnInit } from '@angular/core';
import { CustomerModel } from '../customer-model';
import { CustomerServiceService } from '../customer-service.service';
import { TokenService } from '../../login/token.service';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
    

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
})
  
export class ListCustomerComponent implements OnInit{
  customer:CustomerModel[] = [] 

  dataSource = this.customer;
  displayedColumns: string[] = ['lastName','firstName','dni', 'phone','email','birthdate','acciones'];
 constructor(private customerService:  CustomerServiceService , private tokenService: TokenService,private router:Router) { }
  isLogued = false; 
  ngOnInit(): void {
    this.all();
   if (this.tokenService.getToken()) {
      this.isLogued =true;
    }
    else {
      this.isLogued = false;
        this.router.navigate([''])
    }
  }
  ngAfterViewInit() {
 
  }
public all(): void {
  this.customerService.all().subscribe(data => { this.customer = data; })
  console.log(this.customer)
  }
}
function ViewChild(MatPaginator: any): (target: ListCustomerComponent, propertyKey: "paginator") => void {
  throw new Error('Function not implemented.');
}

