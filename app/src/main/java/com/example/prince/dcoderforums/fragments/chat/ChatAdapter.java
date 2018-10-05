package com.example.prince.dcoderforums.fragments.chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prince.dcoderforums.R;
import com.example.prince.dcoderforums.data.model.Chat;
import com.example.prince.dcoderforums.utils.ui.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class ChatAdapter extends RecyclerView.Adapter {


    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    private Context mContext;
    private List<Chat> messageList;

    public ChatAdapter(Context mContext, List<Chat> messageList) {
        this.mContext = mContext;
        this.messageList = messageList;
    }

    public void setMessageList(List<Chat> messageList) {
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.sent_message_layout, viewGroup, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.received_message_layout, viewGroup, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }


    // Determines the appropriate ViewType according to the sender of the message.
    @Override
    public int getItemViewType(int position) {
        Chat message = messageList.get(position);

        if (message.getIsSentByMe()) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat message = messageList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.message_body)
        TextView messageBody;
        @BindView(R.id.avatar)
        View avatar;

        SentMessageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind(Chat message) {
            messageBody.setText(message.getText());

            // Format the stored timestamp into a readable String using method.
            //  timeText.setText(Utils.formatDateTime(message.getCreatedAt()));
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.message_body)
        TextView messageBody;

        ImageUtils imageUtils = new ImageUtils(itemView.getContext());

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind(Chat message) {
            messageBody.setText(message.getText());

            // Format the stored timestamp into a readable String using method.
            //  timeText.setText(Utils.formatDateTime(message.getCreatedAt()));

            name.setText(message.getUserName());


            int ic_person = R.drawable.ic_person_black_24dp;
            // Insert the profile image from the URL into the ImageView.
            imageUtils.loadImageIntoImageView(avatar, message.getUserImageUrl(), ic_person);

        }
    }
}
