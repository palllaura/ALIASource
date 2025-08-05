import { Component, ViewChild } from '@angular/core';
import {Navbar} from '../navbar/navbar';
import {ContactTable} from '../contact-table/contact-table';
import {AddContactModal} from '../add-contact-modal/add-contact-modal';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [Navbar, ContactTable, AddContactModal],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  searchTerm = '';
  modalVisible = false;

  @ViewChild(ContactTable) contactTable!: ContactTable;

  onSearch(term: string) {
    this.searchTerm = term.toLowerCase();
  }

  openAddModal() {
    this.modalVisible = true;
  }

  closeAddModal() {
    this.modalVisible = false;
  }

  onContactAdded() {
    this.refreshContacts();
    this.closeAddModal();
  }

  refreshContacts() {
    this.contactTable?.loadContacts();
  }

}
