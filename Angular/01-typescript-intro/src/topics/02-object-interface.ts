let skills: string[] = ['Bash', 'Counter', 'Healing']; //true, 123 ya no se podrían agregar

interface Character{
    name: string;
    hp: number;
    skills: string[];
    hometown?: string; //o string | undefined
};

const strider: Character = {
    name: 'Strider',
    hp: 100,
    skills: ['Bash', 'Counter'],
};

strider.hometown = 'Rivendell';

console.table(strider);
export {};