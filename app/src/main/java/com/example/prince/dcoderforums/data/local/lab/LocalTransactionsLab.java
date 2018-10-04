package com.example.prince.dcoderforums.data.local.lab;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.scleroid.financematic.data.local.AppDatabase;
import com.scleroid.financematic.data.local.LocalDataSource;
import com.scleroid.financematic.data.local.dao.TransactionDao;
import com.scleroid.financematic.data.local.model.TransactionModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/5/18
 */
public class LocalTransactionsLab implements LocalDataSource<TransactionModel> {
    private final TransactionDao transactionDao;

    @Inject
    LocalTransactionsLab(final AppDatabase appDatabase) {
        this.transactionDao = appDatabase.transactionDao();
    }


    /**
     * gets a list of all items
     */
    @Override
    public LiveData<List<TransactionModel>> getItems() {
        /* Alternate Method for same purpose
        Runnable runnable = () -> {
            final LiveData<List<Transaction>> transactions= transactionDao.getAllTransactionLive();
            appExecutors.mainThread().execute(() -> {
                if (transactions.getValue().isEmpty()){
                    callback.onDataNotAvailable();
                }
                else callback.onLoaded(transactions);
            });


        };
        appExecutors.diskIO().execute(runnable);*/

        Timber.d("getting all transactions");
        return transactionDao.getAllTransactionsLive();
    }

    /**
     * gets a single item provided by id
     *
     * @param itemId the id of the item to be get
     */
    @Override
    public LiveData<TransactionModel> getItem(final int itemId) {
        Timber.d("getting transaction with id %d", itemId);
        return transactionDao.getTransaction(itemId);
    }

    /**
     * Saves item to data source
     *
     * @param item item object to be saved
     */
    @Override
    public Single<TransactionModel> saveItem(@NonNull final TransactionModel item) {
        Timber.d("creating new transaction ");

        return Single.fromCallable(() -> {
            long rowId = transactionDao.saveTransaction(item);
            Timber.d("transaction stored " + rowId);
            return item;
        }).subscribeOn(Schedulers.io());
    }

    /**
     * adds a list of objects to the data source
     *
     * @param items list of items
     */
    @Override
    public Completable addItems(@NonNull final List<TransactionModel> items) {
        Timber.d("creating new transaction ");

        return Completable.fromRunnable(() -> {
            long[] rowId = transactionDao.saveTransactions(items);
            Timber.d("transaction stored " + rowId.length);
        }).subscribeOn(Schedulers.io());
    }

    /**
     * adds network items to local database
     *
     * @param items list of generic items
     */
    @Override
    public void addNetworkItems(@NonNull final List<TransactionModel> items) {
        Timber.d("Storing data");
        long[] rowId = transactionDao.saveTransactions(items);
        Timber.d("transaction stored " + rowId.length);
    }

    /**
     * adds network item to local database,
     * single value
     *
     * @param item generic object
     */
    @Override
    public void addNetworkItem(@NonNull final TransactionModel item) {
        Timber.d("Storging single data");
        long rowId = transactionDao.saveTransaction(item);
        Timber.d("transaction stored " + rowId);
    }


    /**
     * Deletes all the data source
     */
    @Override
    public Completable deleteAllItems() {
        Timber.d("Deleting all transactions");
        return Completable.fromRunnable(transactionDao::nukeTable)
                .subscribeOn(Schedulers.io());

    }

    /**
     * deletes a single item from the database
     *
     * @param item item to be deleted
     */
    @Override
    public Single<TransactionModel> deleteItem(@NonNull final TransactionModel item) {
        Timber.d("deleting transaction with id %d", item.getTransactionId());

        return Single.fromCallable(() -> {
            transactionDao.delete(item);

            return item;
        }).subscribeOn(Schedulers.io());
    }

    /**
     * Updates a transaction object with new values
     *
     * @param transactionModel to be updated
     * @return after updating
     */
    @Nullable
    @Override
    public Single<TransactionModel> updateItem(final TransactionModel transactionModel) {
        //TODO implement this

        return null;
    }

    /**
     * gets a list of all items for a particular value of customer no
     */

    public LiveData<List<TransactionModel>> getItemsForLoan(int acNo) {
        /* Alternate Method for same purpose
        Runnable runnable = () -> {
            final LiveData<List<Transaction>> transactions= transactionDao.getAllTransactionLive();
            appExecutors.mainThread().execute(() -> {
                if (transactions.getValue().isEmpty()){
                    callback.onDataNotAvailable();
                }
                else callback.onLoaded(transactions);
            });


        };
        appExecutors.diskIO().execute(runnable);*/

        Timber.d("getting all transactions");
        return transactionDao.getTransactionsForLoanLive(acNo);
    }
}
