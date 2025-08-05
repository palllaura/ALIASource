import { Component, EventEmitter, Output, Input } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContactDto } from '../model/contact-dto';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-add-contact-modal',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './add-contact-modal.html',
  styleUrl: './add-contact-modal.css'
})
export class AddContactModal {
  @Input() visible = false;
  @Output() closed = new EventEmitter<void>();
  @Output() contactAdded = new EventEmitter<void>();

  dto: ContactDto = {
    firstName: '',
    lastName: '',
    alias: '',
    phoneNumber: ''
  };

  constructor(private contactService: ContactService) {}

  submit() {
    this.contactService.addContact(this.dto).subscribe({
      next: () => {
        this.contactAdded.emit();
        this.dto = {
          firstName: '',
          lastName: '',
          alias: '',
          phoneNumber: ''
        };
      },
      error: (err) => {
        alert('Lisamine ebaõnnestus');
        console.error(err);
      }
    });
  }

  close() {
    this.dto = {
      firstName: '',
      lastName: '',
      alias: '',
      phoneNumber: ''
    };
    this.closed.emit();
  }
}
