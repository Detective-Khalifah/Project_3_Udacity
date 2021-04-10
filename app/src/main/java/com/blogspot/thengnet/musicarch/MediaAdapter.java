package com.blogspot.thengnet.musicarch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link ArrayAdapter} subclass for lazily parsing media tracks in a {@link android.widget.ListView}.
 */
public class MediaAdapter extends ArrayAdapter<Media> {

    private TextView tvTitle, tvLength;

    public MediaAdapter (Context context, List<Media> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item, parent,
                false);

        tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        tvLength = (TextView) convertView.findViewById(R.id.tv_length);

        Media currentMediaIte = getItem(position);

        tvTitle.setText(currentMediaIte.getMediaTitle());
        tvLength.setText(currentMediaIte.getMediaLength());

        return convertView;
    }
}
