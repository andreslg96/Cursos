import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Character } from '../../interfaces/character.interface';

@Component({
  selector: 'dbz-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {

  @Input()
  public characterList: Character[] = [{
    name: 'Trunks',
    power: 10
  }];

  @Output()
  public onDelete: EventEmitter<number> = new EventEmitter(); //public onDelete = new EventEmitter<number>();
  
  @Output()
  public onDelete2: EventEmitter<string> = new EventEmitter();
  //onDelete = Index value : number
  /* onDelete():void{
    this.delete.emit(index);
  } */

  onDeleteCharacter(index: number): void {
    //TODO: Emitir el ID del personaje
    console.log({index});
    this.onDelete.emit(index);
  };

  deleteCharacterById(id: string):void{
    this.onDelete2.emit(id);
    console.log({id});
  }

}
