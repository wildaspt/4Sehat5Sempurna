package com.example.ahmadzakia.a4sehat5sempurna;

/**
 * Created by FirmanHP on 10/28/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Recipe;
import com.fatsecret.platform.model.Serving;
import com.fatsecret.platform.services.Response;
import com.fatsecret.platform.services.android.Request;
import com.fatsecret.platform.services.android.ResponseListener;

import org.androidannotations.annotations.App;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView();

        String key = "851fb8e0baa54f2fb7004882f83ef19f";
        String secret = "2a28688f307245a099bffa79cbc4d922";
        String query = ""; //Get from image processing nama makanannya
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Listener listener = new Listener();
        Request req = new Request(key, secret, listener);
        req.getFoods(requestQueue, query);

    }

    class Listener implements ResponseListener {

        @Override
        public void onFoodsResponse(List<Food> foods) {
            long food_Id = foods.get(0).getId();
            String foodDescription = foods.get(0).getDescription();

            //Implementasi view kedalam app android
        }
    }
}
