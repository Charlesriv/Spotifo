package com.example.spotifo;

import android.media.MediaPlayer;
import android.net.Uri;

import java.util.List;

public class ServicePlayer {

    MediaPlayer mediaPlayer = new MediaPlayer();
    MainActivity mainActivity;
    List<AudioFile> playlist;
    boolean pause = false;
    int order = 0;

    public void playPlaylist(List<AudioFile> playlist, MainActivity mainActivity){
        this.playlist = playlist;
        this.mainActivity= mainActivity;
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(mainActivity, Uri.parse(playlist.get(order).getFilePath()));
        mediaPlayer.start();
        // il ne joue qu'une seule musique, il faut ajouter le service pour que ça fonctionne
    }

    public void breakMusic(){
        mediaPlayer.pause();
        pause = true;
    }

    public void playMusic(){
        mediaPlayer.start();
        pause = false;
    }

    public boolean isInBreak(){
        return true;
    }

    public boolean isPlaying(){
        if (mediaPlayer.isPlaying()){
            return true;
        }
        return false;
    }

    public boolean getIsBreak(){
        return pause;
    }

    public void next(){
        if (order < playlist.size()-1){
            order++;
        }
        else{
            order = 0;
        }
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(mainActivity, Uri.parse(playlist.get(order).getFilePath()));
        mediaPlayer.start();
    }

    public void previous(){
        if (order > 0 && playlist.size() > 0){
            order--;
        }
        else{
            order = playlist.size()-1;
        }
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(mainActivity, Uri.parse(playlist.get(order).getFilePath()));
        mediaPlayer.start();
    }

    public void playMusicWithNumber(){

    }
}
