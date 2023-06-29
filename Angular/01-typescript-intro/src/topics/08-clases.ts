export class Person{
    //public name: string; //? o | undefyned
    //private address: string; //public, private, el private va a jalar cuando se compile como JS, pero en angular podemos indicar que no acceda a privates
//
    //constructor(name: string, address: string){
    //    this.name= name;
    //    this.address= 'No address';
    //}
//}

constructor( 
    public firstName: string,
    public lastName: string,  
    private address: string = 'No address'
    ){}
}

export class Hero { //extends Person

    //public person: Person;

    constructor(
        public alterEgo: string,
        public age: number,
        public realName: string,
        public person: Person,
    ){
        //super(realName, 'New York');
        //this.person = new Person(realName);
    }
};

const tony = new Person('Tony','Stark', 'New York');
const ironman = new Hero('Ironman',45,'Tony', tony);

console.log(ironman);

