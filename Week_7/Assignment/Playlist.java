package Week_7.Assignment;
import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    // Returns a safe copy containing only the songs added so far
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Modify the copy array

        // Verify original playlist contents remain untouched
        System.out.println("p.getSongs()[0] is still: \"" + p.getSongs()[0] + "\"");
        System.out.println("Song count: " + p.getSongCount());
    }
}