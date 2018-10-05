package com.example.prince.dcoderforums.fragments.qna;

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
public class QnATabFragment extends BaseFragment {
    private QnAViewModel viewModel;


    public QnATabFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static QnATabFragment newInstance() {
        QnATabFragment fragment = new QnATabFragment();

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
        return R.layout.fragment_qna;
    }


    /**
     * Override so you can observe your viewModel
     */
    @Override
    protected void subscribeToLiveData() {
        viewModel.getItemList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chatList -> {

                }, error -> {

                });

    }


    /**
     * Override for set view model
     *
     * @return view model instance
     */
    @Override
    public BaseViewModel getViewModel() {
        viewModel =
                ViewModelProviders.of(this, viewModelFactory).get(QnAViewModel.class);

        return viewModel;
    }

}
