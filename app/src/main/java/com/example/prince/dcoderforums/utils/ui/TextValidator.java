package com.example.prince.dcoderforums.utils.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public abstract class TextValidator implements TextWatcher {
    private final TextView textView;

    public TextValidator(TextView textView) {
        this.textView = textView;
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count,
                                        int after) { /* Don't care */ }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before,
                                    int count) { /* Don't care */}

    @Override
    final public void afterTextChanged(Editable s) {
        String text = textView.getText().toString();
        validate(textView, text);
    }

    public abstract void validate(TextView textView, String text);
}
