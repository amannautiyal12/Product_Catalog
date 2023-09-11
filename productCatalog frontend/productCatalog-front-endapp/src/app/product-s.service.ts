import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductSService {

  url="http://localhost:8088/api/product"

  constructor(private http:HttpClient) { }

  
  getProducts()
  {
    return this.http.get(this.url+"/getProducts");

  }

  getCode(code: any)
  {
    return this.http.get(this.url+"/code/"+code);
  }

  getPrice(price: any)
  {
    return this.http.get(this.url+"/price/"+price);
  }

  getName(name: any)
  {
    return this.http.get(this.url+"/name/"+name);
  }

  getBrand(brand: any)
  {
    return this.http.get(this.url+"/brand/"+brand);
  }

  getID(id: any)
  {
    console.log(id);
    return this.http.get(this.url+"/id/"+id);
  }

  getpincode(id: any,pincode: any)
  {
    return this.http.get(this.url+"/serviceability/"+id+"/"+pincode);
  }



}
