package com.example.prince.dcoderforums.fragments.thread;

import com.example.prince.dcoderforums.base.BaseViewModel;
import com.example.prince.dcoderforums.data.repo.ThreadRepo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class ThreadViewModel extends BaseViewModel<Thread> {

    private final ThreadRepo threadRepo;

    public ThreadViewModel(ThreadRepo threadRepo) {
        this.threadRepo = threadRepo;
    }

    @Override
    protected Observable<List<Thread>> getItemList() {
        return threadRepo.loadItems();
    }

    @Override
    protected Completable postItem(Thread thread) {
        return null;
    }

    @Override
    protected Completable postItems(List<Thread> n) {
        return null;
    }
}
