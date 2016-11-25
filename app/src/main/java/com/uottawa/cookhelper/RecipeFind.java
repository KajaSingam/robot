package com.uottawa.recipefind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class RecipeFind extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_find);

        // Get ListView object from xml layout
        ListView listView = (ListView) findViewById(R.id.listRecipes);
        String[] recipe={"Cake", "cookie"};

        RecipeAdapter adapter = new RecipeAdapter(this, recipe);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

            }
        }
        );
    }
}

