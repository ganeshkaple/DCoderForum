package com.example.prince.dcoderforums.fragments.code;

import com.example.prince.dcoderforums.base.BaseViewModel;
import com.example.prince.dcoderforums.data.model.Code;
import com.example.prince.dcoderforums.data.repo.CodeRepo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class CodeViewModel extends BaseViewModel<Code> {


    private final CodeRepo codeRepo;

    public CodeViewModel(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    @Override
    protected Observable<List<Code>> getItemList() {
        return codeRepo.loadItems();
    }

    @Override
    protected Completable postItem(Code code) {
        return null;
    }

    @Override
    protected Completable postItems(List<Code> n) {
        return null;
    }
}