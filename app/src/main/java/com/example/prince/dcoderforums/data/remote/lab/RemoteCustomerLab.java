package com.example.prince.dcoderforums.data.remote.lab;

import com.birbit.android.jobqueue.JobManager;
import com.example.prince.dcoderforums.data.remote.RemotePostEndpoint;
import com.example.prince.dcoderforums.data.remote.services.jobs.delete.DeleteCustomerJob;
import com.example.prince.dcoderforums.data.remote.services.jobs.sync.SyncCustomerJob;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/6/18
 */
public class RemoteCustomerLab implements RemoteDataSource<Customer> {
    private final JobManager jobManager;
    private RemotePostEndpoint service;

    @Inject
    public RemoteCustomerLab(JobManager jobManager,
                             final RemotePostEndpoint service) {
        this.jobManager = jobManager;
        this.service = service;
    }

    @Override
    public Completable sync(final Customer customer) {
        return Completable.fromAction(() ->
                jobManager
                        .addJobInBackground(new SyncCustomerJob(customer, service)));
    }


    @Override
    public Completable delete(final Customer t) {
        return Completable.fromAction(() -> jobManager
                .addJobInBackground(new DeleteCustomerJob(t, service)));
    }
}
