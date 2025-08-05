import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from '../model/contact';
import {ContactDto} from '../model/contact-dto';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private apiUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getAllContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(this.apiUrl + 'contacts');
  }

  addContact(dto: ContactDto): Observable<any> {
    return this.http.post(this.apiUrl + 'add', dto);
  }

}
