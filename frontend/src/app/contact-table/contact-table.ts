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
}
