package radio;

import java.util.Random;

/**
 * Created by chronoes on 10/15/15.
 */
public class ImprovedCarRadio extends CarRadio {
    private String currentSong;
    private String currentArtist;

    ImprovedCarRadio(String name, double baseFrequency) {
        super(name, baseFrequency);
    }

    public String getCurrentlyPlaying() {
        if (currentArtist != null && currentSong != null) {
            return String.format("Currently playing: %s - %s.", currentArtist, currentSong);
        } else {
            return "Currently playing: None";
        }
    }

    public void setCurrentlyPlaying() {
        Random rng = new Random();
        currentArtist = randomString(rng.nextInt(20));
        currentSong = randomString(rng.nextInt(20));
    }

    public void setCurrentlyPlaying(String artist, String song) {
        currentArtist = artist;
        currentSong = song;
    }

    private String randomString(int length) {
        char[] text = new char[length];
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random rng = new Random();
        characters += characters.toUpperCase();
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    @Override
    public String toString() {
        String output = String.format("ImprovedCarRadio 1.0: %s@%.1fMHz", name, frequency);
        if (emergency) {
            output += "\nRadio cannot be played due to antenna issues";
        } else {
            output += "\n" + getCurrentlyPlaying();
        }
        return output;
    }

}
