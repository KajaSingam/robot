package com.uottawa.recipefind;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class RecipeAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    public RecipeAdapter(Context context, String[] values) {
        super(context, R.layout.activity_recipe_adapter, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_recipe_adapter, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.txtRecipeName);
        textView.setText(values[position]);

        String s = values[position];

        return rowView;
    }
}

