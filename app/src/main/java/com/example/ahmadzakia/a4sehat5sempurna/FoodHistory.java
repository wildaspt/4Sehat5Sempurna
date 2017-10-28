package com.example.ahmadzakia.a4sehat5sempurna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ahmadzakia.a4sehat5sempurna.object.Food;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_food_history)
public class FoodHistory extends AppCompatActivity {

    String[] histories;

    @ViewById (R.id.food_pic)
    ImageView food_pic;

    @ViewById (R.id.nama)
    TextView nama;

    @ViewById (R.id.berat)
    TextView berat;

    @ViewById (R.id.suhu)
    TextView suhu;

    @ViewById (R.id.last_eaten)
    TextView last_eaten;

    @ViewById (R.id.list_history)
    ListView list_history;

    @AfterViews
    protected void init(){
        Intent newIntent = getIntent();
        Food currentFood = (Food) newIntent.getSerializableExtra("currentFood");

        food_pic.setImageResource(currentFood.getPhoto_url());
        nama.setText(currentFood.getNama());
        berat.setText(currentFood.getBerat()+" gr");
        suhu.setText(currentFood.getSuhu()+" c");
        last_eaten.setText(currentFood.getLast_eaten()==null?"Belum pernah":currentFood.getLast_eaten().toString());

        int length = 10;
        histories = new String[length];
        for(int i=0; i<length;i++){
            histories[i] = (1+i)+" Oktober 2017. Pukul 13.00";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, histories);

        list_history.setAdapter(adapter);
    }

}
