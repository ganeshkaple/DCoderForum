package com.example.prince.dcoderforums.fragments.thread;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.base.BaseFragment;
import com.example.prince.dcoderforums.base.BaseViewModel;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class ThreadTabFragment extends BaseFragment {

    @BindView(R.id.section_label)
    TextView sectionLabel;
    private ThreadViewModel viewModel;

    public ThreadTabFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ThreadTabFragment newInstance() {
        ThreadTabFragment fragment = new ThreadTabFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = getRootView();
        sectionLabel.setText(getString(R.string.section_format));
        return rootView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_threads;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                ViewModelProviders.of(this, viewModelFactory).get(ThreadViewModel.class);

        return viewModel;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
