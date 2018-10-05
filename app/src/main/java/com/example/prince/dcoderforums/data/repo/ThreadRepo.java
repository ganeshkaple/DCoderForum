package com.example.prince.dcoderforums.data.repo;

import com.example.prince.dcoderforums.base.BaseRepo;
import com.example.prince.dcoderforums.data.remote.RemotePostEndpoint;
import com.example.prince.dcoderforums.data.remote.WebService;
import com.example.prince.dcoderforums.utils.multithread.AppExecutors;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class ThreadRepo implements BaseRepo<Thread> {
    private final WebService webService;
    private final AppExecutors appExecutors;
    private final RemotePostEndpoint postEndpoint;

    public ThreadRepo(WebService webService, AppExecutors appExecutors, RemotePostEndpoint postEndpoint) {
        this.webService = webService;
        this.appExecutors = appExecutors;
        this.postEndpoint = postEndpoint;
    }

    @Override
    public Observable<List<Thread>> loadItems() {
        return webService.getThreads();
    }

    @Override
    public Completable saveItem(Thread thread) {
        return null;
    }
}
