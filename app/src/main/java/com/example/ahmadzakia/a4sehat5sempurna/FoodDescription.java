package com.example.ahmadzakia.a4sehat5sempurna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmadzakia.a4sehat5sempurna.object.Food;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_food_description)
public class FoodDescription extends AppCompatActivity {

    @ViewById (R.id.food_pic)
    ImageView food_pic;

    @ViewById (R.id.nama_makanan)
    TextView nama_makanan;

    @ViewById (R.id.berat_makanan)
    TextView berat_makanan;

    @ViewById (R.id.suhu_makanan)
    TextView suhu_makanan;

    @ViewById (R.id.last_eaten)
    TextView last_eaten;

    @ViewById (R.id.gizi_makanan)
    TextView gizi_makanan;

    @AfterViews
    protected void init(){
        Intent newIntent = getIntent();
        Food currentFood = (Food) newIntent.getSerializableExtra("currentFood");
        food_pic.setImageResource(currentFood.getPhoto_url());
        nama_makanan.setText(currentFood.getNama());
        berat_makanan.setText(currentFood.getBerat()+" gram");
        suhu_makanan.setText(currentFood.getSuhu()+" celcius");
        last_eaten.setText(currentFood.getLast_eaten()==null?"Belum pernah":currentFood.getLast_eaten().toString());
        gizi_makanan.setText(currentFood.getInfo_gizi()==null?"Unknown":currentFood.getLast_eaten().toString());
    }


}
