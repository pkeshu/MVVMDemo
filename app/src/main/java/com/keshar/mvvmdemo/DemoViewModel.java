package com.keshar.mvvmdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DemoViewModel extends ViewModel {
    private MutableLiveData<String> username = null;
    private MutableLiveData<String> password = null;

    public MutableLiveData<String> getUsername() {
        if (username == null) {
            username = new MutableLiveData<>();
        }
        return username;
    }

    public MutableLiveData<String> getPassword() {
        if (password == null) {
            password = new MutableLiveData<>();
        }
        return password;
    }

    public void setData(String name,String pass){
        username.setValue(name);
        password.setValue(pass);
    }
}
