package com.example.prince.dcoderforums.data.remote.services.jobs.sync;

import com.scleroid.financematic.base.BaseJob;
import com.scleroid.financematic.data.local.model.Expense;
import com.scleroid.financematic.data.remote.RemotePostEndpoint;

import timber.log.Timber;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 5/2/18
 */
public class SyncExpenseJob extends BaseJob<Expense> {
    private static final String TAG = SyncExpenseJob.class.getCanonicalName();

    public SyncExpenseJob(Expense expense,
                          final RemotePostEndpoint service) {
        super(TAG, expense, service);

    }

    @Override
    public void onRun() {
        Timber.d("Executing onRun() for expense " + t);


        // if any exception is thrown, it will be handled by shouldReRunOnThrowable()
        service.addExpense(t);

        // remote call was successful--the Expense will be updated locally to reflect that sync
        // is no longer pending
        //       Expense updatedExpense = ExpenseUtils.clone(expense, false);
        //   SyncExpenseRxBus.getInstance().post(SyncResponseEventType.SUCCESS, updatedExpense);
    }

}
