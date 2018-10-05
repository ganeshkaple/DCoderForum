package com.example.prince.dcoderforums.data.repo;

import com.example.prince.dcoderforums.base.BaseRepo;
import com.example.prince.dcoderforums.data.model.Chat;
import com.example.prince.dcoderforums.data.remote.WebService;
import com.example.prince.dcoderforums.utils.multithread.AppExecutors;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class ChatRepo implements BaseRepo<Chat> {


    private final WebService webService;
    private final AppExecutors appExecutors;

    @Inject
    public ChatRepo(
            final WebService webService,
            final AppExecutors appExecutors) {

        this.webService = webService;
        this.appExecutors = appExecutors;
    }


    @Override
    public Observable<List<Chat>> loadItems() {
        return webService.getChats();
    }

/*
    @Override
    public Observable<Chat> loadItem(int t) {
        return null;
    }

    @Override
    public Completable saveItems(List<Chat> items) {
        return null;
    }
*/

    @Override
    public Completable saveItem(Chat chat) {
        return null;
    }

  /*  @Override
    public Completable updateItem(Chat chat) {
        return null;
    }

    @Override
    public Completable deleteItem(Chat chat) {
        return null;
    }*/
}
