package com.example.prince.dcoderforums.utils.network;


/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/5/18
 * <p>
 * Status of a resource that is provided to the UI.
 * <p>
 * These are usually created by the Repository classes where they return {@code
 * LiveData<Resource<T>>} to pass back the latest data to the UI with its fetch status.
 */
public enum Status {
    SUCCESS,
    ERROR,
    LOADING
}
