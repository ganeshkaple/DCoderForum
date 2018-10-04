package com.example.prince.dcoderforums.data.remote.lab;

import com.birbit.android.jobqueue.JobManager;
import com.example.prince.dcoderforums.data.remote.RemotePostEndpoint;
import com.example.prince.dcoderforums.data.remote.services.jobs.delete.DeleteTransactionJob;
import com.example.prince.dcoderforums.data.remote.services.jobs.sync.SyncTransactionJob;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
public class RemoteTransactionLab implements RemoteDataSource<TransactionModel> {
    private final JobManager jobManager;
    private RemotePostEndpoint service;

    @Inject
    public RemoteTransactionLab(JobManager jobManager,
                                final RemotePostEndpoint service) {
        this.jobManager = jobManager;
        this.service = service;
    }

    @Override
    public Completable sync(final TransactionModel transactionModel) {
        return Completable.fromAction(() ->
                jobManager
                        .addJobInBackground(new SyncTransactionJob(transactionModel, service)));
    }

    @Override
    public Completable delete(final TransactionModel transactionModel) {
        return Completable.fromAction(() ->
                jobManager
                        .addJobInBackground(new DeleteTransactionJob(transactionModel, service)));
    }


}
