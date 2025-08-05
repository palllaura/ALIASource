import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddContactModal } from './add-contact-modal';

describe('AddContactModal', () => {
  let component: AddContactModal;
  let fixture: ComponentFixture<AddContactModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddContactModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddContactModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
