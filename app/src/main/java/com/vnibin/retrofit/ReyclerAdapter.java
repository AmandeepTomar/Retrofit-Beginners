package com.vnibin.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vnibin on 6/7/18.
 */

public class ReyclerAdapter extends RecyclerView.Adapter<ReyclerAdapter.MyViewHolder> {

    private List<WorldPopulation>worldPopulations;
    private Context context;

    public ReyclerAdapter(List<WorldPopulation> worldPopulations,Context context) {
        this.worldPopulations = worldPopulations;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final WorldPopulation worldPopulation=worldPopulations.get(position);
        holder.rank.setText(worldPopulation.getRank()+"");

        holder.country.setText(worldPopulation.getCountry());
        holder.population.setText(worldPopulation.getPopulation());
        Picasso.get()
                .load(worldPopulation.getFlag())
                .into(holder.flag);


    }

    @Override
    public int getItemCount() {
        return worldPopulations.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView rank,population,country;
        ImageView flag;

        public MyViewHolder(View itemView) {
            super(itemView);
            rank=(TextView)itemView.findViewById(R.id.tvRank);
            population=(TextView)itemView.findViewById(R.id.population);
            country=(TextView)itemView.findViewById(R.id.country);
            flag=(ImageView)itemView.findViewById(R.id.flag);
        }
    }
}
