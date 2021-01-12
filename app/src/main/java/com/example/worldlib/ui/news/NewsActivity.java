package com.example.worldlib.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldlib.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private static final String TAG = "NewsActivity";
    private List<NewsItem> mItems = new ArrayList<>();
    private RecyclerView objectRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objectRecyclerView = objectRecyclerView.findViewById(R.id.photo);
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.photo);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<NewsActivity.PhotoHolder> {
        private List<NewsItem> mNewsItems;

        public PhotoAdapter(List<NewsItem> items) {
            mNewsItems = items;
        }
        @NonNull
        @Override
        public NewsActivity.PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(NewsActivity.this);
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            NewsItem newsItem = mNewsItems.get(position);
            Picasso.get().load(newsItem.getUrl()).into(holder.itemImageView);
        }

        @Override
        public int getItemCount() {
            return mNewsItems.size();
        }
    }
}
