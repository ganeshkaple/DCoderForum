package com.example.prince.dcoderforums.data.repo;

import com.example.prince.dcoderforums.base.BaseRepo;
import com.example.prince.dcoderforums.data.model.QnA;
import com.example.prince.dcoderforums.data.remote.RemotePostEndpoint;
import com.example.prince.dcoderforums.data.remote.WebService;
import com.example.prince.dcoderforums.utils.multithread.AppExecutors;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class QnARepo implements BaseRepo<QnA> {
    private final WebService webService;
    private final AppExecutors appExecutors;
    private RemotePostEndpoint postEndpoint;

    public QnARepo(WebService webService, AppExecutors appExecutors, RemotePostEndpoint postEndpoint) {
        this.webService = webService;
        this.appExecutors = appExecutors;
        this.postEndpoint = postEndpoint;
    }

    @Override
    public Observable<List<QnA>> loadItems() {
        return webService.getQnAs();
    }

    @Override
    public Completable saveItem(QnA qnA) {
        return null;
    }
}
