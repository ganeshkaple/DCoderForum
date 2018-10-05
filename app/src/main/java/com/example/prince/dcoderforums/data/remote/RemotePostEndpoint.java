package com.example.prince.dcoderforums.data.remote;


import android.support.annotation.NonNull;

import hugo.weaving.DebugLog;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RemotePostEndpoint {

    @NonNull
    @DebugLog
    @POST("/mobile/newregister")
    Call<Customer> addCustomer(@Body Customer customer);

    @NonNull
    @DebugLog
    @POST("/mobile/newloanusers")
    Call<Loan> addLoan(@Body Loan loan);

    @NonNull
    @DebugLog
    @POST("/mobile/posts")
    Call<TransactionModel> addTransaction(@Body TransactionModel transaction);

    @NonNull
    @DebugLog
    @POST("/mobile/insertmydate")
    Call<Installment> addInstallment(@Body Installment installment);

    @NonNull
    @DebugLog
    @POST("/mobile/expand")
    Call<Expense> addExpense(@Body Expense expense);

    @NonNull
    @DebugLog
    @POST("/posts")
    Call<Customer> addCustomer(@Body List<Customer> customer);

    @NonNull
    @DebugLog
    @POST("/posts")
    Call<Loan> addLoan(@Body List<Loan> loan);

    @NonNull
    @DebugLog
    @POST("/posts")
    Call<TransactionModel> addTransaction(@Body List<TransactionModel> transaction);

    @NonNull
    @DebugLog
    @POST("/posts")
    Call<Installment> addInstallment(@Body List<Installment> installment);

    @NonNull
    @DebugLog
    @POST("/posts")
    Call<Expense> addExpense(@Body List<Expense> expense);


    @DebugLog
    //Done
    @FormUrlEncoded
    @POST("delete/{installment_id}")
    void deleteInstallment(@Body int installment);

    @DebugLog
    @FormUrlEncoded
    void deleteCustomer(int customerId);

    @DebugLog
    @FormUrlEncoded
    void deleteExpense(int expenseId);

    @DebugLog
    @FormUrlEncoded
    void deleteLoan(int accountNo);

    @DebugLog
    @FormUrlEncoded
    void deleteTransaction(int transactionId);
}
