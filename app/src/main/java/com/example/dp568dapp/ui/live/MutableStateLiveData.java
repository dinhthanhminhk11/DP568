package com.example.dp568dapp.ui.live;

import androidx.lifecycle.MutableLiveData;

public class MutableStateLiveData <T> extends MutableLiveData<StateData<T>> {

    public void postLoading() {
        postValue(new StateData<T>().loading());
    }

    public void postError(String errorMsg) {
        postValue(new StateData<T>().error(errorMsg));
    }

    public void postErrorData(T errorData) {
        postValue(new StateData<T>().error(errorData));
    }

    public void postSuccess(T data) {
        postValue(new StateData<T>().success(data));
    }
}