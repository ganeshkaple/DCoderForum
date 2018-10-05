package com.example.prince.dcoderforums.utils;

/**
 * Copyright (C) 2018
 *
 * @since 4/4/18
 */

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.data.repo.ChatRepo;
import com.example.prince.dcoderforums.data.repo.CodeRepo;
import com.example.prince.dcoderforums.data.repo.QnARepo;
import com.example.prince.dcoderforums.data.repo.ThreadRepo;
import com.example.prince.dcoderforums.fragments.chat.ChatViewModel;
import com.example.prince.dcoderforums.fragments.code.CodeViewModel;
import com.example.prince.dcoderforums.fragments.qna.QnAViewModel;
import com.example.prince.dcoderforums.fragments.thread.ThreadViewModel;

import javax.inject.Inject;

/**
 * A creator is used to inject the product ID into the ViewModel
 * <p>
 * This creator is to showcase how to inject dependencies into ViewModels. It's not actually
 * necessary in this case, as the product ID can be passed in a public method.
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private ChatRepo chatRepo;
    private CodeRepo codeRepo;


    private ThreadRepo threadRepo;
    private QnARepo qnARepo;

    @Inject
    public ViewModelFactory(ChatRepo chatRepo, CodeRepo codeRepo, ThreadRepo threadRepo, QnARepo qnARepo) {
        this.chatRepo = chatRepo;
        this.codeRepo = codeRepo;
        this.threadRepo = threadRepo;
        this.qnARepo = qnARepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ChatViewModel.class)) {
            //noinspection unchecked
            return (T) new ChatViewModel(chatRepo);
        } else if (modelClass.isAssignableFrom(CodeViewModel.class)) {
            //noinspection unchecked
            return (T) new CodeViewModel(codeRepo);

        } else if (modelClass.isAssignableFrom(ThreadViewModel.class)) {
            //noinspection unchecked
            return (T) new ThreadViewModel(threadRepo);
        } else if (modelClass.isAssignableFrom(QnAViewModel.class)) {
            //noinspection unchecked
            return (T) new QnAViewModel(qnARepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}