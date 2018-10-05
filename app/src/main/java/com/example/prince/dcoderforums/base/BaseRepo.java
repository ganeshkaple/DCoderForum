package com.example.prince.dcoderforums.base;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Copyright (C) 2018
 *
 * @author Ganesh Kaple
 * @since 4/10/18
 */
public interface BaseRepo<T> {


    Observable<List<T>> loadItems();

    /*Observable<T> loadItem(int t);

    Completable saveItems(List<T> items);
*/
    Completable saveItem(T t);

/*

	Completable updateItem(T t);

	Completable deleteItem(T t);
*/
/*

	Completable updateItem(T t);

	Completable deleteItem(T t);
*/
}
