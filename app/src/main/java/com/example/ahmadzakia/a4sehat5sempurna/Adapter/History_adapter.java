package com.example.ahmadzakia.a4sehat5sempurna.Adapter;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.ahmadzakia.a4sehat5sempurna.FoodDescription_;
//import com.example.ahmadzakia.a4sehat5sempurna.FoodHistory_;
import com.example.ahmadzakia.a4sehat5sempurna.FoodHistory_;
import com.example.ahmadzakia.a4sehat5sempurna.History;
import com.example.ahmadzakia.a4sehat5sempurna.R;
import com.example.ahmadzakia.a4sehat5sempurna.object.Food;

import java.util.List;

/**
 * Created by ahmadzakia on 26/10/2017.
 */

public class History_adapter extends RecyclerView.Adapter<History_adapter.HistoryViewHolder> {
    List<Food> foods;

    @Override
    public History_adapter.HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_food_item, parent, false);
        History_adapter.HistoryViewHolder pvh = new History_adapter.HistoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(History_adapter.HistoryViewHolder holder, int position) {
        holder.nama.setText(foods.get(position).getNama());
        holder.berat.setText(foods.get(position).getBerat()+" gr");
        holder.suhu.setText(""+foods.get(position).getSuhu()+" c");
        if(foods.get(position).getLast_eaten()!=null){
            holder.last_eaten.setText(""+foods.get(position).getLast_eaten().toString());
        }else{
            holder.last_eaten.setText("Belum Pernah");
        }
        holder.current_food= foods.get(position);
        holder.food_pic.setImageResource(foods.get(position).getPhoto_url());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        Food current_food;

        CardView cv;

        TextView nama;
        TextView berat;
        TextView suhu;
        TextView last_eaten;
        ImageView food_pic;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nama = (TextView)itemView.findViewById(R.id.nama);
            berat= (TextView)itemView.findViewById(R.id.berat);
            suhu = (TextView)itemView.findViewById(R.id.suhu);
            last_eaten = (TextView)itemView.findViewById(R.id.last_eaten);
            food_pic= (ImageView)itemView.findViewById(R.id.food_pic);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Snackbar.make(view, "Food "+current_food.getNama()+" is clicked", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                    Intent newIntent = new Intent(view.getContext(), FoodHistory_.class);
                    newIntent.putExtra("currentFood",current_food);
                    view.getContext().startActivity(newIntent);
                }
            });
        }
    }
    public History_adapter(List<Food> foods){
        this.foods= foods;
    }
}
