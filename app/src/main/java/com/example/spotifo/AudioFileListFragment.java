package com.example.spotifo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mymusiconly.R;
import com.example.mymusiconly.databinding.AudioFileListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AudioFileListFragment extends Fragment {

    private List<AudioFile> playlist = new ArrayList<AudioFile>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AudioFileListFragmentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.audio_file_list_fragment,container,false);
        binding.audioFileList.setLayoutManager(new LinearLayoutManager(
                binding.getRoot().getContext()));
        addMusic(binding, this.playlist);
        return binding.getRoot();
    }
    public void addMusic(AudioFileListFragmentBinding binding, List<AudioFile> playlist){
        binding.audioFileList.setAdapter(new AudioFileListAdapter(playlist));
    }

    public void setPlaylist(List<AudioFile> playlist){
        this.playlist = playlist;
    }

}
