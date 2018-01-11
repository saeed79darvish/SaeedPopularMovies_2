package com.example.saeed.saeedpopularmovies_2.Adapters;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.saeed.saeedpopularmovies_2.R;
import com.example.saeed.saeedpopularmovies_2.REST.APIService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemViewHolder> {
    private final static String TAG = MovieAdapter.class.getSimpleName();
    private List<Movie> mMovieList;
    private ItemClickHandler itemClickHandler;
    public MovieAdapter(ItemClickHandler itemClickHandler) {
        this.itemClickHandler = itemClickHandler;
        mMovieList = new ArrayList<Movie>();
    }

    @Override
    public MovieItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieItemViewHolder holder, int position) {
        holder.bind(getMovieList().get(position));
    }

    @Override
    public int getItemCount() {
        return (mMovieList != null) ? mMovieList.size() : 0;
    }

    private List<Movie> getMovieList() {
        return mMovieList;
    }

    public void setmMovieList(List<Movie> mMovieList) {
        this.mMovieList = mMovieList;
        notifyDataSetChanged();
    }

    public interface ItemClickHandler {
        void onItemClick(Movie movie);
    }

    public class MovieItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView movieItemImageView;

        public MovieItemViewHolder(View itemView) {
            super(itemView);
            movieItemImageView = (ImageView) itemView.findViewById(R.id.imv_movie_item);
            itemView.setOnClickListener(this);
        }

        void bind(Movie movie) {
            Picasso.with(itemView.getContext())
                    .load(APIService.IMAGE_URL+movie.getPoster_path())
                    .placeholder(R.drawable.placeholdercinema)
                    .into(movieItemImageView);
        }

        @Override
        public void onClick(View v) {
            itemClickHandler.onItemClick(mMovieList.get(getAdapterPosition()));
        }
    }
}
