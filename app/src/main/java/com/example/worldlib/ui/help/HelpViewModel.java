package com.example.worldlib.ui.help;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpViewModel extends ViewModel {

    boolean FragmentActivation = true;
    private MutableLiveData<String> mText;

    public HelpViewModel() {
        mText = new MutableLiveData<>();
        if (FragmentActivation) {
            mText.setValue("No news yet. Come back later.");
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
}