import { Component, OnInit } from '@angular/core';
import { Contact } from '../model/contact';
import { ContactService } from '../services/contact.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-contact-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './contact-table.html',
  styleUrl: 'contact-table.css'
})
export class ContactTable implements OnInit {

  contacts: Contact[] = [];

  constructor(private contactService: ContactService) {}

  ngOnInit(): void {
    this.contactService.getAllContacts().subscribe((data) => {
      this.contacts = data;
    });
  }

  sortField: string = '';
  sortDirection: 'asc' | 'desc' = 'asc';

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }

    this.contacts.sort((a: Contact, b: Contact) => {
      const valueA = (a as any)[field]?.toLowerCase() || '';
      const valueB = (b as any)[field]?.toLowerCase() || '';

      if (valueA < valueB) return this.sortDirection === 'asc' ? -1 : 1;
      if (valueA > valueB) return this.sortDirection === 'asc' ? 1 : -1;
      return 0;
    });
  }


}
