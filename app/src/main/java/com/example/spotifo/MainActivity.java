package com.example.spotifo;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mymusiconly.R;
import com.example.mymusiconly.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<AudioFile> songs = new ArrayList<AudioFile>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.INTERNET}, 1);
        this.showStartup();
    }
    public void showStartup() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        AudioFileListFragment audioFileFragment = new AudioFileListFragment();
        ControlMusicFragment controlMusicFragment = new ControlMusicFragment();
        controlMusicFragment.setControlListener(this.createControlListener());
        getExtStorage();
        setMusicOnFragment(audioFileFragment);
        transaction.replace(R.id.fragment_container_music,audioFileFragment);
        transaction.replace(R.id.fragment_container_control,controlMusicFragment);
        transaction.commit();
    }
    public ControlListener createControlListener(){
        MainActivity activity = this;
        ServicePlayer servicePlayer = new ServicePlayer();
        return new ControlListener() {
            @Override
            public void onPlayPauseButtonClick() {
                Log.e("evenement", "play/break");
                // Si la musique est en cours de lecture on break
                if (servicePlayer.isPlaying()){
                    servicePlayer.breakMusic();
                }
                else{
                    if (servicePlayer.getIsBreak()){
                        servicePlayer.playMusic();
                    }
                    else{
                        servicePlayer.playPlaylist(songs, activity);
                    }
                }
            }

            public void onNextMusicButtonClick(){
                servicePlayer.next();
            }

            public void onPreviousMusicButtonClick(){
                servicePlayer.previous();
            }

            public void onMusicButtonClick(){ servicePlayer.playMusicWithNumber(); }
        };
    }

    public void getExtStorage(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI; // La carte SD
        ContentResolver contentResolver = getContentResolver();
        String[] projection = {MediaStore.Audio.Media.DATA, MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DURATION};
        Cursor cursor = contentResolver.query(uri,projection,null,null,null);
        System.out.println("value of cursor: " + cursor.getCount());

        if (cursor == null) {
            System.out.println("FATAL ERROR");
        } else if (!cursor.moveToFirst()) {
            System.out.println("NO MEDIA ON DEVICE");
        } else {
            // la duration m'affiche un grand chiffre, je ne sais pas pourquoi
            AudioFile music = new AudioFile(cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getString(0));
            songs.add(music);
            while (cursor.moveToNext()){
                music = new AudioFile(cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getString(0));
                songs.add(music);
            }
        }
    }

    public void setMusicOnFragment(AudioFileListFragment audioFileFragment){
        audioFileFragment.setPlaylist(songs);
    }

    public static String url = "http://www.last.fm/api/auth/?api_key=xxxxxxxxxx&token=yyyyyy";

    User user = new User("Rivière", "Charles");
    public void sendUserInfo(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostMethod post = retrofit.create(PostMethod.class);
        Call<MainActivity> call = post.sendUser(user);
    }
}
