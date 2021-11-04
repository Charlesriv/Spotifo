package com.example.mymusiconly.databinding;
import com.example.mymusiconly.R;
import com.example.mymusiconly.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AudioFileItemBindingImpl extends AudioFileItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.dummy, 5);
        sViewsWithIds.put(R.id.separator, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AudioFileItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private AudioFileItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            );
        this.album.setTag(null);
        this.artist.setTag(null);
        this.duration.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.audioFileViewModel == variableId) {
            setAudioFileViewModel((com.example.spotifo.AudioFileViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAudioFileViewModel(@Nullable com.example.spotifo.AudioFileViewModel AudioFileViewModel) {
        updateRegistration(0, AudioFileViewModel);
        this.mAudioFileViewModel = AudioFileViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.audioFileViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAudioFileViewModel((com.example.spotifo.AudioFileViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAudioFileViewModel(com.example.spotifo.AudioFileViewModel AudioFileViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.title) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.album) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.artist) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.duration) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String audioFileViewModelTitle = null;
        java.lang.String audioFileViewModelArtist = null;
        com.example.spotifo.AudioFileViewModel audioFileViewModel = mAudioFileViewModel;
        java.lang.String audioFileViewModelDuration = null;
        java.lang.String audioFileViewModelAlbum = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x23L) != 0) {

                    if (audioFileViewModel != null) {
                        // read audioFileViewModel.title
                        audioFileViewModelTitle = audioFileViewModel.getTitle();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (audioFileViewModel != null) {
                        // read audioFileViewModel.artist
                        audioFileViewModelArtist = audioFileViewModel.getArtist();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (audioFileViewModel != null) {
                        // read audioFileViewModel.duration
                        audioFileViewModelDuration = audioFileViewModel.getDuration();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (audioFileViewModel != null) {
                        // read audioFileViewModel.album
                        audioFileViewModelAlbum = audioFileViewModel.getAlbum();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.album, audioFileViewModelAlbum);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.artist, audioFileViewModelArtist);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.duration, audioFileViewModelDuration);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, audioFileViewModelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): audioFileViewModel
        flag 1 (0x2L): audioFileViewModel.title
        flag 2 (0x3L): audioFileViewModel.album
        flag 3 (0x4L): audioFileViewModel.artist
        flag 4 (0x5L): audioFileViewModel.duration
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}