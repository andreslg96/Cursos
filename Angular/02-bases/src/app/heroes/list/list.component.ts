import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  public heroNames: string[] = ['Spiderman', 'Ironman', 'Hulk', 'SheHulk', 'Thor'];
  public deletedHero?: string; //así podemos sacar el valor que solo tiene vida en el scope del método removeLastHero

  removeLastHero():void{
    this.deletedHero = this.heroNames.pop();
  }

}
