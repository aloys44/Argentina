import { starRatingComponent } from './../../base/star-rating/star-rating.component';
import { Component, OnInit, Input } from '@angular/core';
import { TokenStorageService } from './../../../services/user/connectionService/tokenStorage/token-storage.service';


import { EcommerceService } from './../../../services/commerce/eCommerce/EcommerceService';
import { Notice } from './../../../services/commerce/notice/notice.model'

import * as uuid from 'uuid';


@Component({
  selector: 'app-add-notice',
  templateUrl: './add-notice.component.html',
  styleUrls: ['./add-notice.component.scss']
})
export class AddNoticeComponent implements OnInit {
    form: any = {};
    errorMessage = '';
    starRating = 0; 
    notice: Notice;
    isSuccessful = false;
    isSignUpFailed = false;
    isLoggedIn = false;
    isLoginFailed = false;
    roles: string[] = [];

    @Input() user;


  constructor(private ecommerceService: EcommerceService, 
  private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.user = this.tokenStorage.getUser();

           }
  }

  onSubmit(){
    const user = this.tokenStorage.getUser();

    this.form.user = user.id;
    this.ecommerceService.saveNotice(this.form).subscribe(
      data => {
        console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      );
    }

}
