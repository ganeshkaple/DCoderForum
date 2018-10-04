package com.example.prince.dcoderforums.data.remote.services.jobs.sync;

import com.scleroid.financematic.base.BaseJob;
import com.scleroid.financematic.data.local.model.Loan;
import com.scleroid.financematic.data.remote.RemotePostEndpoint;

import timber.log.Timber;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 5/2/18
 */
public class SyncLoanJob extends BaseJob<Loan> {

    private static final String TAG = SyncLoanJob.class.getCanonicalName();

    public SyncLoanJob(final RemotePostEndpoint service,
                       Loan loan) {
        super(TAG, loan, service);

    }


    @Override
    public void onRun() {
        Timber.d("Executing onRun() for loan " + t);


        // if any exception is thrown, it will be handled by shouldReRunOnThrowable()
        service.addLoan(t);

        // remote call was successful--the Loan will be updated locally to reflect that sync
        // is no longer pending
        //       Loan updatedLoan = LoanUtils.clone(loan, false);
        //   SyncLoanRxBus.getInstance().post(SyncResponseEventType.SUCCESS, updatedLoan);
    }


}
