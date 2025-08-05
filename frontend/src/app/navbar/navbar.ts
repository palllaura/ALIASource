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
  @Output() addClicked = new EventEmitter<void>();

  searchTerm: string = '';

  emitSearch(value: string) {
    this.searchTerm = value;
    this.searchTermChanged.emit(this.searchTerm);
  }

  onAddClick() {
    this.addClicked.emit();
  }

  protected readonly input = input;
}
