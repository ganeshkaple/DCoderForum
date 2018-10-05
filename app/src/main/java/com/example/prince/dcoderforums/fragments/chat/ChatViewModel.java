package com.example.prince.dcoderforums.fragments.chat;

import com.example.prince.dcoderforums.base.BaseViewModel;
import com.example.prince.dcoderforums.data.model.Chat;
import com.example.prince.dcoderforums.data.repo.ChatRepo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class ChatViewModel extends BaseViewModel<Chat> {

    private final ChatRepo chatRepo;

    public ChatViewModel(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }


    @Override
    protected Observable<List<Chat>> getItemList() {
        return chatRepo.loadItems();
    }

    @Override
    protected Completable postItem(Chat chat) {
        return null;
    }

    @Override
    protected Completable postItems(List<Chat> n) {
        return null;
    }
}