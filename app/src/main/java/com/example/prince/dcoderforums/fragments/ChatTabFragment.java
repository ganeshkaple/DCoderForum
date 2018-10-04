package com.example.prince.dcoderforums.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.base.BaseFragment;
import com.example.prince.dcoderforums.base.BaseViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChatTabFragment extends BaseFragment {


    public ChatTabFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ChatTabFragment newInstance() {
        ChatTabFragment fragment = new ChatTabFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = getRootView();
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format));
        return rootView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void subscribeToLiveData() {

    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }
}
