interface AudioPlayer{
    audioVolume: number;
    songDuration: number;
    song: string;
    details: Details;
}

interface Details{
    author: string;
    year: number;
}

const audioPlayer: AudioPlayer = {
    audioVolume: 90,
    songDuration: 36,
    song: "Riptide",
    details: {
        author: "Vance Joy",
        year: 2013
    }
}

const song = 'New Song';
const {song:anotherSong, songDuration:duration, details} = audioPlayer; //ctrl + espacio en las llaves vacías
const {author} = details; //podrímos arriba dejarlo como details:{author}

//console.log('Song: ', anotherSong); //en vez de audioPlayer.song
//console.log('Duration: ',duration);
//console.log('Author: ', author); //en vez de audioPlayer.details.author

const [, , trunks = 'Not found']: string[]=['Goku','Vegeta', ]; //'Trunks'
//const trunks = dbz[3] || 'No hay personaje';
console.log('Personaje 3: ', trunks);

export{};