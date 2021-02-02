import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import { starRatingComponent } from './../../base/star-rating/star-rating.component';

import { EcommerceService } from './../../../services/commerce/eCommerce/EcommerceService';
import { Notice } from './../../../services/commerce/notice/notice.model'

@Component({
  selector: 'app-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.scss']
})
export class NoticeComponent implements OnInit {
    notice: Notice;
    notices: Notice[] = [];
    sub: Subscription;
    private noticeCart: Notice;
    value;
    selectedValue;
    element;





  constructor(private ecommerceService: EcommerceService) {
   }

  ngOnInit(): void {
    this.loadNotices();
  }

  loadNotices(){
    return this.ecommerceService.getAllNotices().subscribe(
      list => {
        this.notices = list;
      }
    );
  }
  countStar(star) {
      this.selectedValue = star;
      console.log('Value of star', star);
  }
    
}
