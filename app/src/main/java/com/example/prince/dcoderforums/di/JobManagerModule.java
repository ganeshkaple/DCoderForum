package com.example.prince.dcoderforums.di;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.CustomLogger;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 5/2/18
 */
@Module
@Deprecated
public class JobManagerModule {

    AppComponent component;

    @NonNull
    @Provides
    @Singleton
    public JobManager jobManager(Application application, @NonNull Context context) {
        component = DaggerAppComponent.builder().application(application)
                .build();
        Configuration.Builder builder = new Configuration.Builder(context)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";

                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(@NonNull String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, @NonNull String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(@NonNull String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }

                    @Override
                    public void v(String text, Object... args) {

                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(30)//wait 1 minute
                .injector(job -> {
                    if (job instanceof JobManagerInjectable) {
                        ((JobManagerInjectable) job).inject(component);
                    }
                });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.scheduler(
                    FrameworkJobSchedulerService.createSchedulerFor(context,
                            SchedulerJobService.class),
                    true);
        }

        return new JobManager(builder.build());
    }
}