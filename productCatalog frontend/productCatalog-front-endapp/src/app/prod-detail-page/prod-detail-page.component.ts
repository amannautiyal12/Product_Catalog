import { Component, OnInit  } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductSService } from '../product-s.service';

@Component({
  selector: 'app-prod-detail-page',
  templateUrl: './prod-detail-page.component.html',
  styleUrls: ['./prod-detail-page.component.css']
})
export class ProdDetailPageComponent implements OnInit{ 

  pincode = new FormGroup({
    Pincode: new FormControl('', Validators.required),
  })

  error = false

  constructor(private routers: ActivatedRoute, private product: ProductSService, private router: Router) { }

  products: any
  r: any
  yes=false;
  no=false;
  days:any;
  ngOnInit(): void {

    // this.loadImage();

    console.warn(this.routers.snapshot.params['id'])
    this.product.getID(this.routers.snapshot.params['id']).
      subscribe((result) => {

        this.products = result
        // alert(this.products)
       console.log(this.products)
       this.createImageFromByteArray(this.products);

      }
      )
  }

  back() {
    this.router.navigate(['']);
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

  Pcode() {
   

    this.yes=false
    this.no=false
    this.product.getpincode(this.routers.snapshot.params['id'], this.pincode.value.Pincode).
      subscribe((result) => {

       console.log(result)
       
       this.r=result
      if(this.r.length>0){
        this.yes=true;
        this.days=this.r[0].estimateddays;

      }
      else{
        this.no=true;
      }

      })
  }

}
