package com.example.saeed.saeedpopularmovies_2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saeed.saeedpopularmovies_2.Models.Trailer;
import com.example.saeed.saeedpopularmovies_2.R;

import java.util.ArrayList;
import java.util.List;

public class MovieTrailerAdapter extends RecyclerView.Adapter<MovieTrailerAdapter.TrailerViewHolder> {

    private ItemClickListener itemClickListener;
    private Context context;
    private List<Trailer> trailerList;

    public MovieTrailerAdapter(Context context) {
        this.context = context;
        itemClickListener = (ItemClickListener) context;
        trailerList = new ArrayList<> ();
    }

    public void setTrailerList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
        this.notifyDataSetChanged ();

    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (context).inflate (R.layout.movie_trailer_item, parent, false);
        return new TrailerViewHolder (v);
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {
        holder.bind (trailerList.get (position).getSite (), trailerList.get (position).getName ());
    }

    @Override
    public int getItemCount() {
        return (trailerList != null) ? trailerList.size () : 0;
    }

    public interface ItemClickListener {
        void onItemClick(String key);
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView siteTextView, nameTextView;

        public TrailerViewHolder(View itemView) {
            super (itemView);
            siteTextView = (TextView) itemView.findViewById (R.id.tv_trailer_site);
            nameTextView = (TextView) itemView.findViewById (R.id.tv_trailer_name);
            itemView.setOnClickListener (this);
        }

        public void bind(String site, String name) {
            siteTextView.setText (site);
            nameTextView.setText (name);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick (trailerList.get (getAdapterPosition ()).getKey ());
        }
    }
}
