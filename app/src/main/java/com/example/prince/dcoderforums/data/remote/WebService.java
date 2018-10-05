package com.example.prince.dcoderforums.data.remote;

import android.support.annotation.NonNull;

import com.example.prince.dcoderforums.data.model.Chat;
import com.example.prince.dcoderforums.data.model.Code;
import com.example.prince.dcoderforums.data.model.QnA;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/5/18
 */
public interface WebService {
/*
    @NonNull
    @FormUrlEncoded
    @DebugLog
    @POST("/mobile/registerusercid")
    Observable<Chat> getChat(@Field("chat_id") int chatId);
*/

    @NonNull

    @GET("/chat.json")
    Observable<List<Chat>> getChats();

    /* @NonNull
     @DebugLog
     @POST("/mobile/lastinsertnewuserthread_id")
     Observable<Thread> getThread(@Field("thread") int threadId);
 */
    @NonNull

    @GET("/threads.json")
    Observable<List<Thread>> getThreads();


    @NonNull

    @GET("/qna.json")
    Observable<List<QnA>> getQnAs();


   /* @NonNull
    @DebugLog
    @GET("/mobile/getexpenditureid/{id}")
    Observable<QnA> getQnA(@Path("id") int qnANo);

*/

/*
    @NonNull
    @DebugLog
    @GET("/mobile/codethread/{codeNo}")
    Observable<Code> getCode(@Path("codeNo") int codeNo);
*/

    @NonNull

    @GET("/codes.json")
    Observable<List<Code>> getCodes();


}
