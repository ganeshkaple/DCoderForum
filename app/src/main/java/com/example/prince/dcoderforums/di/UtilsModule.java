package com.example.prince.dcoderforums.di;

import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.utils.ui.DateUtils;
import com.example.prince.dcoderforums.utils.ui.SnackBarUtils;
import com.example.prince.dcoderforums.utils.ui.TextViewUtils;

import javax.inject.Singleton;

import dagger.Module;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
@Module
public abstract class UtilsModule {

    @NonNull
    @Singleton
    abstract DateUtils getDateUtils();

    @NonNull
    @Singleton
    abstract TextViewUtils getTextViewUtils();


    @NonNull
    @Singleton
    abstract SnackBarUtils getSnackBarUtils();

}
