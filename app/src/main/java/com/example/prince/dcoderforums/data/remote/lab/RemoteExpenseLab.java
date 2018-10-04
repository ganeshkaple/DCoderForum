package com.example.prince.dcoderforums.data.remote.lab;

import com.birbit.android.jobqueue.JobManager;
import com.example.prince.dcoderforums.data.remote.RemotePostEndpoint;
import com.example.prince.dcoderforums.data.remote.services.jobs.delete.DeleteExpenseJob;
import com.example.prince.dcoderforums.data.remote.services.jobs.sync.SyncExpenseJob;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
public class RemoteExpenseLab implements RemoteDataSource<Expense> {
    private final JobManager jobManager;
    private RemotePostEndpoint service;

    @Inject
    public RemoteExpenseLab(JobManager jobManager,
                            final RemotePostEndpoint service) {
        this.jobManager = jobManager;
        this.service = service;
    }

    @Override
    public Completable sync(final Expense expense) {
        return Completable.fromAction(() ->
                jobManager
                        .addJobInBackground(new SyncExpenseJob(expense, service)));
    }

    @Override
    public Completable delete(final Expense expense) {
        return Completable.fromAction(() ->
                jobManager
                        .addJobInBackground(new DeleteExpenseJob(expense, service)));
    }

}
