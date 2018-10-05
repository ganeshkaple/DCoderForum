package com.example.prince.dcoderforums.fragments.code;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.base.BaseFragment;
import com.example.prince.dcoderforums.base.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class CodeTabFragment extends BaseFragment {
    private CodeViewModel codeViewModel;


    public CodeTabFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CodeTabFragment newInstance() {
        CodeTabFragment fragment = new CodeTabFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = getRootView();

        return rootView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_code;
    }


    /**
     * Override so you can observe your viewModel
     */
    @Override
    protected void subscribeToLiveData() {
        codeViewModel.getItemList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chatList -> {

                }, error -> {

                });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * Override for set view model
     *
     * @return view model instance
     */
    @Override
    public BaseViewModel getViewModel() {
        codeViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(CodeViewModel.class);

        return codeViewModel;
    }


}
