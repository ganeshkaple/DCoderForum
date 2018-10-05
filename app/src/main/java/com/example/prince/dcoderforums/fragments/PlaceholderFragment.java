package com.example.prince.dcoderforums.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.base.BaseFragment;
import com.example.prince.dcoderforums.base.BaseViewModel;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends BaseFragment {

    @BindView(R.id.section_label)
    TextView sectionLabel;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance() {
        PlaceholderFragment fragment = new PlaceholderFragment();

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
        return R.layout.fragment_main;
    }

    @Override
    protected void subscribeToLiveData() {

    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
    @Override
    public BaseViewModel getViewModel() {
        return null;
    }


}
