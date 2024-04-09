package com.example.assignment;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel {
    private MutableLiveData<Boolean> isSelected = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsSelected() {
        return isSelected;
    }
}
