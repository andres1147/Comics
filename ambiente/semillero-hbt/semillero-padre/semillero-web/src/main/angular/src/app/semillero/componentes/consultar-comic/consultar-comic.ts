import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'consultar-comic',
  templateUrl: './consultar-comic.html',
  styleUrls: ['./consultar-comic.css']
})
export class ConsultarComicComponent implements OnInit {

  constructor(private activatedRoute : ActivatedRoute) { }

  ngOnInit() {

   let data = this.activatedRoute.snapshot.params;
  }

}
