import { Component } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';

import { CoreService } from './_services';

interface IProduct {
  productId: number,
  productName: string,
  shortDesc: string,
  description: string,
  category: string,
  startingPrice: number,
  bidEndDate: string,
  seller?: ISeller,
  bidsList?: Array<IBid>
}
interface ISeller {
  sellerId: number,
  firstName: string,
  lastName: string,
  address: string,
  city: string,
  state: string,
  pin: number,
  phone: number,
  email: string
}
interface IBuyer {
  buyerId: number,
  firstName: string,
  lastName: string,
  address: string,
  city: string,
  state: string,
  pin: number,
  phone: number,
  email: string
}
interface IBid {
  bidId: number,
  productId: number,
  bidAmount: number,
  buyer: IBuyer
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private subscriptions: Subscription = new Subscription();
  isProductsLoading: boolean = true;
  isDetailLoading: boolean = false;
  productsList: Array<IProduct> = [];
  selectedProduct: IProduct = null;
  bidsList: Array<IBid> = [];

  constructor(private coreService: CoreService) { }

  ngOnInit() {
    this.subscriptions.add(
      this.coreService.getProductsList()
        .subscribe((response: Array<IProduct>) => this.productsList = response)
        .add(() => this.isProductsLoading = false)
    )
  }

  getProductData(): void {
    this.isDetailLoading = true;
    this.subscriptions.add(
      this.coreService.getProductDetail(this.selectedProduct.productId)
        .subscribe((response: Array<IBid>) => this.bidsList = response)
        .add(() => this.isDetailLoading = false)
    )
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
}
