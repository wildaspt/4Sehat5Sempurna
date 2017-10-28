package com.example.ahmadzakia.a4sehat5sempurna;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ahmadzakia.a4sehat5sempurna.Adapter.History_adapter;
import com.example.ahmadzakia.a4sehat5sempurna.object.Food;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_history)
public class History extends AppCompatActivity {
    List<Food> foods = new ArrayList<Food>();
    History_adapter food_adapter;

    @ViewById(R.id.rv_history)
    RecyclerView rv_history;

    @AfterViews
    protected void init(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_history.setLayoutManager(llm);
        rv_history.setHasFixedSize(true);

        initData(4);
        initializeAdapter();
        rv_history.setAdapter(food_adapter);

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
        food_adapter = new History_adapter(foods);
    }
}
