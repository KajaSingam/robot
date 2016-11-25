package com.uottawa.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        Spinner categoryDropdown = (Spinner) findViewById(R.id.categoryDropdown);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Quick Meal", "Baking"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        categoryDropdown.setAdapter(adapter);
    }


    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), RecipePhotoSelection.class);   //Application Context and Activity
        startActivityForResult(intent, 0);//, ProfileActivity.REQUEST_NEW_TEAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID",R.id.italianFoodIcon)) {
            case R.id.italianFoodIcon:
                drawableName = "ic_logo_01";
                break;
            case R.id.dessertIcon:
                drawableName = "ic_logo_02";
                break;
            case R.id.mexicanFoodIcon:
                drawableName = "ic_logo_04";
                break;
            case R.id.chineseFoodIcon:
                drawableName = "ic_logo_05";
                break;
            case R.id.westernFoodIcon:
                drawableName = "ic_logo_03";
                break;
            case R.id.breakfastFoodIcon:
                drawableName = "ic_logo_06";
                break;
            default:
                drawableName = "ic_logo_01";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        avatarImage.setImageResource(resID);
    }
}
