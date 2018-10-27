import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RestaService {

constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';
  public memberid : Number ;

  getAllRestaurant(): Observable<any> {
    return this.http.get('//localhost:8080/restaurants');
  }

  getRestaurant(rid){
    return this.http.get('//localhost:8080/restaurants/'+rid);
  }

  getCommentByRid(rid): Observable<any>{
    return this.http.get('//localhost:8080/commentbyrid/'+rid);
  }

     getMembers(): Observable<any>{
    return this.http.get('//localhost:8080/members');
  }

  getRatingByRid(rid){
    return this.http.get('//localhost:8080/restaurant/rating/'+rid);
  }

  setMemberId(id){
    this.memberid = id;
  }

  getMemberById(id){
    return this.http.get('//localhost:8080/member/'+id);
  }
}
