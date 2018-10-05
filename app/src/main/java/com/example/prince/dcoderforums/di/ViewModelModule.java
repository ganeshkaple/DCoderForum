package com.example.prince.dcoderforums.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.fragments.chat.ChatViewModel;
import com.example.prince.dcoderforums.fragments.code.CodeViewModel;
import com.example.prince.dcoderforums.fragments.qna.QnAViewModel;
import com.example.prince.dcoderforums.fragments.thread.ThreadViewModel;
import com.example.prince.dcoderforums.utils.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */

@Module
public abstract class ViewModelModule {
    @NonNull
    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel.class)
    abstract ViewModel bindChatViewModel(ChatViewModel userViewModel);

    @NonNull
    @Binds
    @IntoMap
    @ViewModelKey(CodeViewModel.class)
    abstract ViewModel bindCodeViewModel(CodeViewModel expenseViewModel);

    @NonNull
    @Binds
    @IntoMap
    @ViewModelKey(QnAViewModel.class)
    abstract ViewModel bindQnAViewModel(QnAViewModel loanDetailsViewModel);

    @NonNull
    @Binds
    @IntoMap
    @ViewModelKey(ThreadViewModel.class)
    abstract ViewModel bindPeopleViewModel(ThreadViewModel peopleViewModel);



    @NonNull
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
