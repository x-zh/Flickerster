package com.codepath.flickerster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickerster.R;
import com.codepath.flickerster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by charlie_zhou on 5/17/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context c, List<Movie> movies) {
        super(c, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        return convertView;
    }
}
