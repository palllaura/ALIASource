import { Component } from '@angular/core';
import {Navbar} from '../navbar/navbar';
import {ContactTable} from '../contact-table/contact-table';

@Component({
  selector: 'app-home',
  imports: [Navbar, ContactTable],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

}
