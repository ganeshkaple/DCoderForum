package com.example.prince.dcoderforums.fragments.code;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.base.BaseFragment;
import com.example.prince.dcoderforums.base.BaseViewModel;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class CodeTabFragment extends BaseFragment {

    @BindView(R.id.section_label)
    TextView sectionLabel;


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
        sectionLabel.setText(getString(R.string.section_format));

        return rootView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_code;
    }

    @Override
    protected void subscribeToLiveData() {

    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }


}