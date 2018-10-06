package com.example.prince.dcoderforums.fragments.thread;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.data.model.Thread;
import com.example.prince.dcoderforums.utils.ui.DateUtils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.ThreadHolder> {

    private final Context context;
    private List<Thread> threads;

    public ThreadAdapter(Context context, List<Thread> threads) {
        this.context = context;
        this.threads = threads;
    }

    @NonNull
    @Override
    public ThreadHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_thread_layout, viewGroup, false);
        return new ThreadHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreadHolder threadHolder, int position) {
        Thread thread = threads.get(position);
        threadHolder.bind(thread);

    }


    @Override
    public int getItemCount() {
        return threads.size();
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
        notifyDataSetChanged();
    }

    class ThreadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.message_text_view)
        TextView messageTextView;
        @BindView(R.id.tag_one_button)
        TextView tagOneButton;
        @BindView(R.id.tag_two_button)
        TextView tagTwoButton;
        @BindView(R.id.tag_three_button)
        TextView tagThreeButton;
        @BindView(R.id.time_text_view)
        TextView timeTextView;
        @BindView(R.id.username_text_view)
        TextView usernameTextView;

        DateUtils dateUtils = new DateUtils();


        public ThreadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind(Thread thread) {
            titleTextView.setText(thread.getTitle());
            messageTextView.setText(thread.getText());
            usernameTextView.setText(thread.getUserName());
            //Tags cannot be fixed, so this is not a feasible solution here we've to create views dynamically
            tagOneButton.setText(thread.getTags().get(0));
            tagTwoButton.setText(thread.getTags().get(1));
            tagThreeButton.setText(thread.getTags().get(2));

            //Converting Date, Haven't tested
            timeTextView.setText(dateUtils.getFormattedDate(new Date(thread.getTime()), "yyyy-MM-dd HH:mm:ss"));

        }
    }
}
