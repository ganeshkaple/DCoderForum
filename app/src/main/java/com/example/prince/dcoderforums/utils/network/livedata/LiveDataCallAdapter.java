package com.example.prince.dcoderforums.utils.network.livedata;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.data.remote.ApiResponse;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Copyright (C) 2018
 *
 * @since 4/5/18
 */

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 */
public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<ApiResponse<R>>> {
    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @NonNull
    @Override
    public LiveData<ApiResponse<R>> adapt(@NonNull Call<R> call) {
        return new LiveData<ApiResponse<R>>() {
            @NonNull
            AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(@NonNull Call<R> call,
                                               @NonNull Response<R> response) {
                            Timber.d(response + "");
                            postValue(new ApiResponse<>(response));
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            Timber.e(
                                    throwable.getMessage() + " THis is where I Crash " + throwable
                                            .fillInStackTrace() + " " + throwable
                                            .getCause()
                                            + " ");
                            postValue(new ApiResponse<R>(throwable));
                        }
                    });
                }
            }
        };
    }
}

