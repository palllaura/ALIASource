import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
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
  filteredContacts: Contact[] = [];

  @Input() searchTerm: string = '';

  constructor(private contactService: ContactService) {}

  ngOnInit(): void {
    this.contactService.getAllContacts().subscribe((data) => {
      this.contacts = data;
      this.filterContacts();
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['searchTerm']) {
      this.filterContacts();
    }
  }

  loadContacts() {
    this.contactService.getAllContacts().subscribe({
      next: (contacts) => {
        this.contacts = contacts;
        this.filterContacts();
      },
      error: (err) => console.error('Failed to load contacts', err)
    });
  }

  filterContacts() {
    this.filteredContacts = this.contacts.filter(contact =>
      contact.firstName.toLowerCase().includes(this.searchTerm) ||
      contact.lastName.toLowerCase().includes(this.searchTerm) ||
      contact.alias.toLowerCase().includes(this.searchTerm)
    );
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

    this.filteredContacts.sort((a: Contact, b: Contact) => {
      const valueA = (a as any)[field]?.toLowerCase() || '';
      const valueB = (b as any)[field]?.toLowerCase() || '';

      if (valueA < valueB) return this.sortDirection === 'asc' ? -1 : 1;
      if (valueA > valueB) return this.sortDirection === 'asc' ? 1 : -1;
      return 0;
    });
  }

  deleteContact(id: number) {
    const confirmed = confirm('Kas oled kindel, et soovid kontakti kustutada?');
    if (!confirmed) return;

    this.contactService.deleteContact(id).subscribe({
      next: () => {
        this.loadContacts();
      },
      error: (err) => {
        alert('Kustutamine ebaõnnestus');
        console.error('Delete failed', err);
      }
    });
  }


}
