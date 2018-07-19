import {Component, Input, OnInit} from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { HeroService } from '../hero.service';
import { Hero } from '../hero';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  id = + this.route.snapshot.paramMap.get('id');
  heroForm: FormGroup;
  powers: Array<string> = ['Really Smart', 'Super Flexible', 'Super Hot', 'Weather Changer'];

  constructor(private route: ActivatedRoute,
    private heroService: HeroService,
    private location: Location,
    private formBuilder: FormBuilder) {}

  ngOnInit() {
    if (this.id) {
      this.getHero();
    }

    this.heroForm = this.formBuilder.group({
      'name': [null, Validators.required],
      'power': [null, Validators.required],
      'alterEgo': ''
    });
  }

  getHero(): void {
    this.heroService.getHero(this.id)
      .subscribe(hero => this.heroForm.patchValue(hero));
  }

  save(hero): void {
    if (this.id) {
      hero.id = this.id;
      this.heroService.updateHero(hero as Hero)
        .subscribe(() => this.goBack());
    } else {
      this.heroService.addHero(hero as Hero)
        .subscribe(() => this.goBack());
    }

  }

  goBack(): void {
    this.location.back();
  }
}
