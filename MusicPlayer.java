public class MusicPlayer {
    private String playlist;
    private boolean isPlaying;
    private int volume; // 0-100

    public MusicPlayer() {
        this.playlist = "";
        this.isPlaying = false;
        this.volume = 50;
    }

    public void play(String playlist) {
        this.playlist = playlist;
        isPlaying = true;
        System.out.println("Playing playlist: " + playlist);
    }

    public void stop() {
        isPlaying = false;
        System.out.println("Music stopped");
    }

    public void setVolume(int vol) {
        volume = Math.max(0, Math.min(100, vol));
        System.out.println("Volume set to " + volume);
    }

    public boolean isPlaying() { return isPlaying; }
}
