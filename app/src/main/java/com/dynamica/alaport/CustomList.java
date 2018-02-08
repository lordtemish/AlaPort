package com.dynamica.alaport;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dynamica.alaport.R;

/**
 * Created by 17-n008ur on 06.08.2017.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private final int[] imageId;

    public CustomList(Activity context,
                      String[] web, int[] imageId) {
        super(context, R.layout.list_main, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_main, null, true);
        TextView txtTitle=(TextView) rowView.findViewById(R.id.textt);
        ImageView imageView=(ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);

        return rowView;
    }
}
