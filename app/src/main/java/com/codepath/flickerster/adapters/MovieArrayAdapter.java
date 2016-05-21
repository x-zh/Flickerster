package com.codepath.flickerster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by charlie_zhou on 5/17/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    static class ViewHolder {
        @BindView(R.id.ivMovieImage) ImageView ivImage;
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvOverview) TextView tvOverview;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public MovieArrayAdapter(Context c, List<Movie> movies) {
        super(c, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivImage.setImageResource(0);

        int displayMode = convertView.getResources().getConfiguration().orientation;
        if (displayMode == Configuration.ORIENTATION_LANDSCAPE ) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).fit()
                    .transform(new RoundedCornersTransformation(10, 10))
                    .placeholder(R.drawable.placeholder_land)
                    .error(R.drawable.placeholder_land)
                    .into(viewHolder.ivImage);

        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).fit()
                    .transform(new RoundedCornersTransformation(10, 10))
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(viewHolder.ivImage);
        }
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());
        return convertView;
    }
}
