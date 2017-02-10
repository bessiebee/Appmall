package com.example.bessie.appmall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bessie on 02/02/2017.
 */
public class ListViewAdapter extends ArrayAdapter<Product> {
    public ListViewAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_items, null);

        }

        Product product = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.Imageview);
        TextView textTitle = (TextView) v.findViewById(R.id.texttitle);
        TextView txtDescription = (TextView) v.findViewById(R.id.textDescription);

        img.setImageResource(product.getImageId());
        textTitle.setText(product.getTitle());
        txtDescription.setText(product.getDescription());


        return v;
    }
}
