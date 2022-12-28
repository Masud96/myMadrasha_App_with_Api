package com.masud.masudmyproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masud.masudmyproject.NoticeData;
import com.masud.masudmyproject.R;

import java.util.ArrayList;

public class DeleteNoticeAdapter extends RecyclerView.Adapter<DeleteNoticeAdapter.NoticeViewHolder> {
    private ArrayList<NoticeData> list;
    private Context context;

    public DeleteNoticeAdapter(ArrayList<NoticeData> list, Context context){
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_sample_layout,parent,false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        NoticeData data = list.get(position);
        holder.dateText.setText(data.getPostDate());
        holder.timeText.setText(data.getPostTime());
        holder.postText.setText(data.getPostTitle());
        try {
            Glide.with(context).load(data.getPostImage()).into(holder.postImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText,dateText,timeText,postText;
        private ImageView circleImageProfile,postImage;
        private AppCompatButton deleteBtn;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameTxt);
            dateText = itemView.findViewById(R.id.dateTxt);
            timeText = itemView.findViewById(R.id.timeTxt);
            postText = itemView.findViewById(R.id.postTxt);
            circleImageProfile = itemView.findViewById(R.id.circleImageProfile);
            postImage = itemView.findViewById(R.id.imagePost);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

        }
    }
}
