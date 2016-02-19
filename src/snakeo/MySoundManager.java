/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import audio.Track;
import java.util.ArrayList;

/**
 *
 * @author theme
 */
public class MySoundManager extends SoundManager{
    
    public static MySoundManager getSoundManager() {
        ArrayList<Track> tracks = new ArrayList<>();
        Playlist playlist = new Playlist(tracks);
        tracks.add(new Track(MySoundManager.FART_SOUND, Source.RESOURCE, "/snakeo/audio/MP5.wav"));
        tracks.add(new Track(MySoundManager.SMG_SOUND, Source.RESOURCE, "/snakeo/audio/MP5.wav"));
        tracks.add(new Track(MySoundManager.HELL_O_SONG, Source.RESOURCE, "/snakeo/audio/MP5.wav"));
        return new MySoundManager(playlist);
    }
    
    public MySoundManager(Playlist playlist) {
        super(playlist);
    }
    
    public static final String FART_SOUND = "FART";
    public static final String SMG_SOUND = "SMG";
    public static final String HELL_O_SONG = "HELLO";
}
