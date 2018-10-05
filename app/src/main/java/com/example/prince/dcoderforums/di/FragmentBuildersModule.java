package com.example.prince.dcoderforums.di;

import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.fragments.PlaceholderFragment;
import com.example.prince.dcoderforums.fragments.chat.ChatTabFragment;
import com.example.prince.dcoderforums.fragments.code.CodeTabFragment;
import com.example.prince.dcoderforums.fragments.qna.QnATabFragment;
import com.example.prince.dcoderforums.fragments.thread.ThreadTabFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
@Module
public abstract class FragmentBuildersModule {
    @NonNull
    @ContributesAndroidInjector
    abstract ChatTabFragment contributeChatFragment();

    @NonNull
    @ContributesAndroidInjector
    abstract CodeTabFragment contributeCodeTabFragment();

    @NonNull
    @ContributesAndroidInjector
    abstract PlaceholderFragment contributePlaceholderFragment();

    @NonNull
    @ContributesAndroidInjector
    abstract QnATabFragment contributeQnATabFragment();


    @NonNull
    @ContributesAndroidInjector
    abstract ThreadTabFragment contributeThreadFragment();


}
