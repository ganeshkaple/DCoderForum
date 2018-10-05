package com.example.prince.dcoderforums.base;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Copyright (C) 2018
 *
 * @param <N> generic viewmodel object
 * @author Ganesh Kaple
 * @since 4/6/18
 * <p>
 * It's actually unnecessary
 * its base class for all viewmodels
 */
public abstract class BaseViewModel<N> extends ViewModel {

    /**
     * returns livedata object to be used in further places
     *
     * @return list of item in livedata wrapper
     */
    protected abstract Observable<List<N>> getItemList();

    protected abstract Completable postItem(N n);

    protected abstract Completable postItems(List<N> n);

}
