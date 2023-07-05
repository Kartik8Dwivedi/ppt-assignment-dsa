
const audioPlayer = new Audio();
const playBtn = document.querySelector('.play-btn');
const pauseBtn = document.querySelector('.pause-btn');
const prevBtn = document.querySelector('.prev-btn');
const nextBtn = document.querySelector('.next-btn');
const trackTitle = document.querySelector('.track-title');
const trackArtist = document.querySelector('.track-artist');
const progressBar = document.querySelector('.progress');

const tracks = [
  {
    title: 'Go Down Deh',
    artist: 'Artist 1',
    source: './freemp3.plus-Vietsub _ Go Down Deh - Spice, Sean Paul, Shaggy _ Nhạc Hot TikTok _ Lyrics Video-320.mp3',
  },
  {
    title: 'John Wick',
    artist: 'Artist 2',
    source: './JOHN WICK (THEME SONG) (320 kbps).mp3',
  },
  {
    title: 'Levitating',
    artist: 'Artist 3',
    source: './Levitating - Dua Lipa (Lyrics Video) 🐬-320.mp3',
  },
];

let currentTrackIndex = 0;

function playTrack() {
  const currentTrack = tracks[currentTrackIndex];
  audioPlayer.src = currentTrack.source;
  audioPlayer.play();
  trackTitle.textContent = currentTrack.title;
  trackArtist.textContent = currentTrack.artist;
}

playBtn.addEventListener('click', () => {
  audioPlayer.play();
});

pauseBtn.addEventListener('click', () => {
  audioPlayer.pause();
});

prevBtn.addEventListener('click', () => {
  currentTrackIndex = (currentTrackIndex - 1 + tracks.length) % tracks.length;
  playTrack();
});

nextBtn.addEventListener('click', () => {
  currentTrackIndex = (currentTrackIndex + 1) % tracks.length;
  playTrack();
});

audioPlayer.addEventListener('timeupdate', () => {
  const progress = (audioPlayer.currentTime / audioPlayer.duration) * 100;
  progressBar.style.width = `${progress}%`;
});
