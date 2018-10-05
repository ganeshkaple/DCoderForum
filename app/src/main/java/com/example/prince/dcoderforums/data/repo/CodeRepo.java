package com.example.prince.dcoderforums.data.repo;

import com.example.prince.dcoderforums.base.BaseRepo;
import com.example.prince.dcoderforums.data.model.Code;
import com.example.prince.dcoderforums.data.remote.WebService;
import com.example.prince.dcoderforums.utils.multithread.AppExecutors;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class CodeRepo implements BaseRepo<Code> {
    private final WebService webService;
    private final AppExecutors appExecutors;

    public CodeRepo(WebService webService, AppExecutors appExecutors) {
        this.webService = webService;
        this.appExecutors = appExecutors;
    }

    @Override
    public Observable<List<Code>> loadItems() {
        return webService.getCodes();
    }

    @Override
    public Completable saveItem(Code code) {
        return null;
    }
}
