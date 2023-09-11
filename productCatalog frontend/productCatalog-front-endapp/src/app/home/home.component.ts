import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductSService } from '../product-s.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{


  Homepage = new FormGroup({
    search: new FormControl('', Validators.required),
    filter: new FormControl('name', Validators.required)

      //  imageData: SafeResourceUrl | undefined;
    

  })
  error = false

  user=false;


  get search() { return this.Homepage.get('search') }



  constructor(private product: ProductSService, private router: Router) { }

  products: any
  
  ngOnInit(): void {
 
    // this.loadImage();

    if(localStorage.getItem("logged")=="true"){
      this.user=true;
    }
    this.product.getProducts().subscribe((result) => {
      console.warn(result)
      this.products = result
      this.createImages();
      console.log(this.products)

    })
  }

  createImages(){
 
    for(let p of this.products){
     this.createImageFromByteArray(p);
    }
   }
   createImageFromByteArray(p: any) {
 
     const byteCharacters = atob(p.image);
 
     const byteNumbers = new Array(byteCharacters.length);
 
     for (let i = 0; i < byteCharacters.length; i++) {
 
       byteNumbers[i] = byteCharacters.charCodeAt(i);
 
     }
 
     const byteArray = new Uint8Array(byteNumbers);
 
     const imageBlob = new Blob([byteArray], { type: 'image/jpeg' });
 
     p.imageUrl = URL.createObjectURL(imageBlob);
 
   }

  logout()
  {
    localStorage.setItem("logged","false")
    this.router.navigate(['/login']);
  }
  details(id: any) {
    this.router.navigate(['/productDetails/' + id]);
  }

  login() {
    this.router.navigate(['/login']);
  }

  Search() {
    console.log(this.Homepage.value)
    if (this.Homepage.value.filter == "name") {
      this.product.getName(this.Homepage.value.search).subscribe((result) => {
        console.warn(result)
        this.products = result
        console.log(this.products)

      })

    }

    if (this.Homepage.value.filter == "brand") {
      this.product.getBrand(this.Homepage.value.search).subscribe((result) => {
        console.warn(result)
        this.products = result
        console.log(this.products)

      })

    }

    if (this.Homepage.value.filter == "code") {
      this.product.getCode(this.Homepage.value.search).subscribe((result) => {
        console.warn(result)
        this.products = result
        console.log(this.products)

      })

    }

    if (this.Homepage.value.filter == "price") {
      this.product.getPrice(this.Homepage.value.search).subscribe((result) => {
        console.warn(result)
        this.products = result
        console.log(this.products)

      })

    }
  }


}
