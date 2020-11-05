import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowBookdetailComponent } from './show-bookdetail.component';

describe('ShowBookdetailComponent', () => {
  let component: ShowBookdetailComponent;
  let fixture: ComponentFixture<ShowBookdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowBookdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowBookdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
