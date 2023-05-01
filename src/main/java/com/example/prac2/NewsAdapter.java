package com.example.prac2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    int[] set_images;
    String[] set_titles;
    String[] titles;
    int[] images;

    public NewsAdapter (Context context, int[] images, String[] titles){
        this.context = context;
        this.set_images = images;
        this.set_titles = titles;
        this.titles = new String[100];
        this.images = new int[100];
        int random_number;
        for (int i = 0; i <= 99; i++){
            random_number = (int) (Math.random() *  (5));
            this.titles[i] = set_titles[random_number];
            this.images[i] = set_images[random_number];
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private static final String TAG = "MyApp";

        ImageView image;
        TextView title;
        AdapterView.OnItemClickListener mItemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_news);
            title = itemView.findViewById(R.id.text_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() + 1;
                    Log.i(TAG, "Клик " + pos + " элемента");
                    Toast.makeText(image.getContext(), "Клик " + pos + " элемента", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.res_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.title.setText(titles[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}


