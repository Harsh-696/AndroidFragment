package com.example.fragment_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Details_Adapter extends RecyclerView.Adapter<Details_Adapter.viewHolder> {

    Context context;
    private List<String> comments;
    private List<Integer> images;

    public Details_Adapter(Context context, List<String> comments, List<Integer> images) {
        this.context = context;
        this.comments = comments;
        this.images = images;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.blog_content, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.textView.setText(comments.get(position));
        holder.imageView.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.contentImages);
            textView = itemView.findViewById(R.id.comments);
        }
    }
}
