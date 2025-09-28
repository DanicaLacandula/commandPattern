public class PlayMusicCommand implements Command {
    private MusicPlayer player;
    private String playlist;

    public PlayMusicCommand(MusicPlayer player, String playlist) {
        this.player = player;
        this.playlist = playlist;
    }

    public void execute() {
        player.play(playlist);
    }

    public void undo() {
        player.stop();
        System.out.println("Undo: stopped music");
    }
}
