package com.example.worldlib.ui.otherOrders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OtherOrdersViewModel extends ViewModel {

    boolean FragmentActivation = false;
    private MutableLiveData<String> mText;

    public OtherOrdersViewModel() {
        mText = new MutableLiveData<>();
        if (FragmentActivation) {
            mText.setValue("This is gallery fragment");
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
}