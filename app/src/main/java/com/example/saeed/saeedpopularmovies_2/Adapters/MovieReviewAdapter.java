package com.example.saeed.saeedpopularmovies_2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saeed.saeedpopularmovies_2.Models.Review;
import com.example.saeed.saeedpopularmovies_2.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.ReviewViewHolder> {
    private List<Review> reviewList;
    private Context context;

    public MovieReviewAdapter(Context context) {
        reviewList = new ArrayList<>();
        this.context = context;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        this.notifyDataSetChanged();
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movie_review_item, parent, false);
        return new ReviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        holder.bind(reviewList.get(position).getAuthor(), reviewList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (reviewList != null)?reviewList.size():0;
    }


    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView authorTextView;
        ExpandableTextView expTv1;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            authorTextView = (TextView) itemView.findViewById(R.id.tv_review_author);
            expTv1 = (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);
        }

        public void bind(String author, String content) {
            authorTextView.setText(author);
            expTv1.setText(content);
        }
    }
}