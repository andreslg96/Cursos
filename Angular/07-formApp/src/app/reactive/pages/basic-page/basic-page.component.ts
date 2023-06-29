import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

const rx6750 ={
  name: 'RX 6750',
  price: 600,
  inStorage: 6,
} 

@Component({
  templateUrl: './basic-page.component.html',
  styles: [
  ]
})
export class BasicPageComponent implements OnInit{

  //Esta es una forma de crear el formulario, este FormGroup o FormArray requieren de importar ReactiveFormsModule en
  //el componente o módulo donde lo estemos utilizando: ReactiveFormsModule 
 /*  public myForm: FormGroup = new FormGroup({
    name: new FormControl(''),
    price: new FormControl(0),
    inStorage: new FormControl(0),
  }); */
  //['', [], []] -> '' = valor inicial, [] = validadores sincronos, [] = validadores asincronos
  public myForm: FormGroup = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    price: [0, [Validators.required, Validators.min(0)]],
    inStorage: [0, [Validators.required, Validators.min(0)]],
  })

  //Otra forma de generar el formulario (lo de arriba también en el public myForm en 19)
  constructor( private fb: FormBuilder){}

  ngOnInit(): void {
    /* this.myForm.reset(rx6750); */
  }

  //Para la forma "simplificada"
  isValidField( field:string): boolean | null{
    return this.myForm.controls[field].errors 
    && this.myForm.controls[field].touched;
  }

  getFieldError(field: string): string | null{
    if(!this.myForm.controls[field]) return null;
    const errors = this.myForm.controls[field].errors || {};

    for(const key of Object.keys(errors)){
      /* console.log(key); */
      switch(key){
        case 'required':
          return 'Este campo es requerido';
        
        case 'minlength':
          return `Mínimo ${errors['minlength'].requiredLength} caracteres.`;
      }
    }
    return null;
  }

  onSave():void {

    if (this.myForm.invalid){
      this.myForm.markAllAsTouched();
      return;
    } 

    console.log(this.myForm.value);

    this.myForm.reset({price: 10, inStorage: 0});
  }

}
