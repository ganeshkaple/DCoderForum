package com.example.prince.dcoderforums.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scleroid.financematic.BuildConfig;
import com.scleroid.financematic.data.local.AppDatabase;
import com.scleroid.financematic.data.local.dao.CustomerDao;
import com.scleroid.financematic.data.local.dao.ExpenseDao;
import com.scleroid.financematic.data.local.dao.InstallmentDao;
import com.scleroid.financematic.data.local.dao.LoanDao;
import com.scleroid.financematic.data.local.dao.TransactionDao;
import com.scleroid.financematic.data.remote.RemotePostEndpoint;
import com.scleroid.financematic.data.remote.WebService;
import com.scleroid.financematic.data.remote.services.jobs.utils.GcmJobService;
import com.scleroid.financematic.data.repo.CustomerRepo;
import com.scleroid.financematic.data.repo.ExpenseRepo;
import com.scleroid.financematic.data.repo.InstallmentRepo;
import com.scleroid.financematic.data.repo.LoanRepo;
import com.scleroid.financematic.data.repo.TransactionsRepo;
import com.scleroid.financematic.utils.multithread.AppExecutors;
import com.scleroid.financematic.utils.multithread.DiskIOThreadExecutor;
import com.scleroid.financematic.utils.network.livedata.LiveDataCallAdapterFactory;
import com.scleroid.financematic.utils.rx.AppSchedulerProvider;
import com.scleroid.financematic.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Copyright (C)
 *
 * @author ganesh This is used by Dagger to inject the required arguments into the {@link }.
 * @since 3/10/18
 */
@Module(includes = {ViewModelModule.class, /*JobManagerModule.class*/})
abstract public class RepositoryModule {

    private static final int THREAD_COUNT = 3;


    @Singleton
    @Provides
    static AppDatabase provideDb(@NonNull Application context) {


        return Room.databaseBuilder(context, AppDatabase.class, "financeMatic.db")

                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    static SharedPreferences provideSharedPreferences(@NonNull Application context) {


        return context.getSharedPreferences("financeMaticPref", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    static SharedPreferences.Editor provideSharedPreferencesEditor(
            @NonNull SharedPreferences sharedPreferences) {


        return sharedPreferences.edit();
    }


    @Singleton
    @Provides
    static EventBus providesGlobalBus() {
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    static LoanDao provideLoanDao(AppDatabase db) {
        return db.loanDao();
    }

    @Singleton
    @Provides
    static ExpenseDao provideExpenseDao(AppDatabase db) {
        return db.expenseDao();
    }

    @Singleton
    @Provides
    static CustomerDao provideCustomerDao(AppDatabase db) {
        return db.customerDao();
    }

    @Singleton
    @Provides
    static TransactionDao provideTransactionsDao(AppDatabase db) {
        return db.transactionDao();
    }

    @Singleton
    @Provides
    static InstallmentDao provideInstallmentDao(AppDatabase db) {
        return db.installmentDao();
    }

    @NonNull
    @Provides
    @Singleton
    static Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkhttpClient(Cache cache, @NonNull Interceptor interceptor,
                                            @NonNull HttpLoggingInterceptor
                                                    httpLoggingInterceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        client.addInterceptor(httpLoggingInterceptor);
        client.addNetworkInterceptor(interceptor);

        return client.build();
    }

    @Provides
    @Singleton
    static Retrofit providesRetrofit(@NonNull Gson gson, @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build();
    }


    @Singleton
    @Provides
    static WebService provideWebService(Retrofit retrofit) {

        return retrofit
                .create(WebService.class);
    }


    @Singleton
    @Provides
    static RemotePostEndpoint providePostWebService(Retrofit retrofit) {
        //return   retrofit.create(RemotePostEndpoint.class);
        return retrofit
                .create(RemotePostEndpoint.class);
    }

    @Singleton
    @Provides
    static SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Singleton
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new AppExecutors.MainThreadExecutor());
    }

    @Singleton
    @Provides
    static GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }

    @NonNull
    @Provides
    static public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor =
                new HttpLoggingInterceptor(
                        message -> Timber.tag("OkHttp").d("Retrofit Logging " + message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    static public Interceptor headerInterceptor() {

        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
    }

    @NonNull
    @Singleton
    abstract LoanRepo provideLoanRepo(AppDatabase db);

    @NonNull
    @Singleton
    abstract ExpenseRepo provideExpenseRepo(AppDatabase db);

    @NonNull
    @Singleton
    abstract CustomerRepo provideCustomerRepo(AppDatabase db);

    @NonNull
    @Singleton
    abstract InstallmentRepo provideInstallmentRepo(AppDatabase db);

    @NonNull
    @Singleton
    abstract TransactionsRepo provideTransactionsRepo(AppDatabase db);


}
