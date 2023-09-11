import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdDetailPageComponent } from './prod-detail-page.component';

describe('ProdDetailPageComponent', () => {
  let component: ProdDetailPageComponent;
  let fixture: ComponentFixture<ProdDetailPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdDetailPageComponent]
    });
    fixture = TestBed.createComponent(ProdDetailPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
