package com.example.spotifo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mymusiconly.R;

public class ControlMusicFragment extends Fragment {

    private ControlListener controlListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.control_music_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        this.registerListener();
    }

    public void registerListener() {
        ImageButton buttonPlay = (ImageButton)getView().findViewById(R.id.play);
        buttonPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (buttonPlay.getTag().equals("play")) {
                    buttonPlay.setImageResource(R.drawable.pausebutton);
                    buttonPlay.setTag("pause");
                } else {
                    buttonPlay.setImageResource(R.drawable.playbutton);
                    buttonPlay.setTag("play");
                }
                controlListener.onPlayPauseButtonClick();
            }
        });
        ImageButton nextButton = getView().findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonPlay.getTag().equals("play")) {
                    buttonPlay.setImageResource(R.drawable.pausebutton);
                    buttonPlay.setTag("pause");
                }
                controlListener.onNextMusicButtonClick();
            }
        });
        ImageButton previousButton = getView().findViewById(R.id.previous);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonPlay.getTag().equals("play")) {
                    buttonPlay.setImageResource(R.drawable.pausebutton);
                    buttonPlay.setTag("pause");
                }
                controlListener.onPreviousMusicButtonClick();
            }
        });
    }

    public void setControlListener(ControlListener listener){
        this.controlListener = listener;
    }
}
