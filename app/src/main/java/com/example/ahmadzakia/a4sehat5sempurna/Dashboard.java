package com.example.ahmadzakia.a4sehat5sempurna;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ahmadzakia.a4sehat5sempurna.Adapter.Dashboard_adapter;
import com.example.ahmadzakia.a4sehat5sempurna.object.Food;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_dashboard)
public class Dashboard extends AppCompatActivity {
    List<Food> foods = new ArrayList<Food>();
    Dashboard_adapter food_adapter;

    @ViewById(R.id.rv)
    RecyclerView rv;

    @AfterViews
    protected void init(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initData(4);
        initializeAdapter();
        rv.setAdapter(food_adapter);
    }


    @Click
    void fab_history(View clickedView){
//        Snackbar.make(clickedView, "History is Still Unable", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        Intent newIntent = new Intent(clickedView.getContext(), History_.class);
        clickedView.getContext().startActivity(newIntent);
    }

    private final int REQUEST_IMAGE_CAPTURE = 11;

    @Click
    void fab_camera(View clickedView){
//        Snackbar.make(clickedView, "Camera is Still Unable", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
       /* Intent newIntent = new Intent(clickedView.getContext(), Camera_.class);
        clickedView.getContext().startActivity(newIntent);*/
    }

    private static final String TAG = "Dashboard";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.i(TAG, "onActivityResult: " + imageBitmap.getHeight());
            // tinggal mo diapain imageBitmapnya
        }
    }
    public void initData(int i){
        for (int j=0; j<i; j++){
            String nama="";
            int url =0;
            if (Math.random()>0.5){
                url = R.drawable.food1;
                nama = "Nasi Goreng";
            }else{
                url = R.drawable.food2;
                nama = "Burger";
            }
            Food newFood = new Food(j,nama,url);

            newFood.setBerat(720);
            newFood.setSuhu(30);

            foods.add(newFood);
        }
    }

    private void initializeAdapter(){
        food_adapter = new Dashboard_adapter(foods);
    }

}
