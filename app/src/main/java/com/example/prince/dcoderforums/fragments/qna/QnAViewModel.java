package com.example.prince.dcoderforums.fragments.qna;

import com.example.prince.dcoderforums.base.BaseViewModel;
import com.example.prince.dcoderforums.data.model.QnA;
import com.example.prince.dcoderforums.data.repo.QnARepo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class QnAViewModel extends BaseViewModel<QnA> {
    private final QnARepo qnARepo;

    public QnAViewModel(QnARepo qnARepo) {
        this.qnARepo = qnARepo;
    }

    @Override
    protected Observable<List<QnA>> getItemList() {
        return qnARepo.loadItems();
    }

    @Override
    protected Completable postItem(QnA qnA) {
        return null;
    }

    @Override
    protected Completable postItems(List<QnA> n) {
        return null;
    }
}
