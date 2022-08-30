package com.example.dp568dapp.ui.live;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StateData<T> {
    @NonNull
    private DataStatus status;

    @Nullable
    private T data;

    @Nullable
    private T errorData;

    @Nullable
    private String errorMsg;

    public StateData() {
        this.status = DataStatus.CREATED;
        this.data = null;
        this.errorMsg = null;
        this.errorData = null;
    }

    public StateData<T> loading() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.errorMsg = null;
        return this;
    }

    public StateData<T> success(@NonNull T data) {
        this.status = DataStatus.SUCCESS;
        this.data = data;
        this.errorMsg = null;
        return this;
    }

    public StateData<T> error(@NonNull String errorMsg) {
        this.status = DataStatus.ERROR;
        this.data = null;
        this.errorMsg = errorMsg;
        return this;
    }

    public StateData<T> error(@NonNull T errorData) {
        this.status = DataStatus.ERROR;
        this.data = null;
        this.errorData = errorData;
        return this;
    }

    @NonNull
    public DataStatus getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public String getErrorMsg() {
        return errorMsg;
    }

    @Nullable
    public T getErrorData() {
        return errorData;
    }

    public enum DataStatus {
        CREATED,
        SUCCESS,
        ERROR,
        LOADING
    }
}
