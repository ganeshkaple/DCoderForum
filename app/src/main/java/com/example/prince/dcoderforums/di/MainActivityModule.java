package com.example.prince.dcoderforums.di;

import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
@Module
public abstract class MainActivityModule {
    @NonNull
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();


}
