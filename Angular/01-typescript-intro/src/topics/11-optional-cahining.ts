
export interface Passanger{
    name: string;
    children?: string[];
}

const passenger1: Passanger = {
    name: 'Andrés',
}

const passenger2: Passanger = {
    name: 'Fernando',
    children: ['Natalia', 'Elizabeth']
}

const returnChildrenNumber = (passenger: Passanger) =>{

    //if(!passenger.children) return 0;
    const howManyChildren = passenger.children?.length || 0;
    //const howManyChildren = passenger.children!.length; //! not null assertion operator

    console.log( passenger.name, howManyChildren);

    return howManyChildren;
}

returnChildrenNumber(passenger2);