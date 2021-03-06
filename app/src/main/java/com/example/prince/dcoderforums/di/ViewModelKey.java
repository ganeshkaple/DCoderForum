package com.example.prince.dcoderforums.di;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
@interface ViewModelKey {
    @NonNull Class<? extends ViewModel> value();
}
