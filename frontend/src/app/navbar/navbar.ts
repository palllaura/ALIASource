import {Component, EventEmitter, input, Output} from '@angular/core';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {
  @Output() searchTermChanged = new EventEmitter<string>();

  searchTerm: string = '';

  emitSearch(value: string) {
    this.searchTerm = value;
    this.searchTermChanged.emit(this.searchTerm);
  }

  protected readonly input = input;
}
