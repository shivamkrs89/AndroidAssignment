package com.example.fun_with_flags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Country_Adapter extends ArrayAdapter<Country> {

    ArrayList<Country> items_list;
    int custom_layout_id;

    public Country_Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Country> objects) {
        super(context, resource, objects);
        custom_layout_id = resource;
        items_list = objects;
    }

    @Override
    public int getCount() {
        return items_list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);
        }
        // initializing the imageview,textviews and
        // setting data
        ImageView imageView = v.findViewById(R.id.image);
        TextView name = v.findViewById(R.id.name);
        TextView capital = v.findViewById(R.id.capital);
        TextView region = v.findViewById(R.id.region);
        TextView subregion = v.findViewById(R.id.subregion);
        TextView languages = v.findViewById(R.id.language);
        TextView borders = v.findViewById(R.id.boders);
        TextView population = v.findViewById(R.id.population);
        // get the item using the position param
        Country item = items_list.get(position);

        //imageView.setImageResource(item.image);
        Picasso.get().load(item.image).into(imageView);
        name.setText(item.getName());
        capital.setText(item.getCapital());
        region.setText(item.getRegion());
        subregion.setText(item.getSubregion());
        languages.setText(item.getLanguages());
        borders.setText(item.getBorders());
        population.setText(item.getPopulation());
        return v;

    }

   /* @NonNull
    @NotNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_layout, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);

        return categoriesViewHolder;
    }

    public Country_Adapter(ArrayList<Country> items_list) {
        this.items_list = items_list;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoriesViewHolder holder, int position) {
        Country country = items_list.get(position);
        Picasso.get().load(country.getImage()).into(holder.imageView);
        holder.name.setText(country.getName());
        holder.capital.setText(country.getCapital());
        holder.region.setText(country.getRegion());
        holder.subregion.setText(country.getSubregion());
        holder.languages.setText(country.getLanguages());
        holder.borders.setText(country.getBorders());
        holder.population.setText(country.getPopulation());
    }

    @Override
    public int getItemCount() {
        return items_list.size();
    }
    public static  class CategoriesViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView ;
        TextView name;
        TextView capital;
        TextView region;
        TextView subregion;
        TextView languages;
        TextView borders;
        TextView population;
        public CategoriesViewHolder(@NonNull View v){
            super(v);

            imageView = v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
            capital = v.findViewById(R.id.capital);
            region = v.findViewById(R.id.region);
            subregion = v.findViewById(R.id.subregion);
            languages = v.findViewById(R.id.language);
            borders = v.findViewById(R.id.boders);
            population = v.findViewById(R.id.population);
        }
    }*/
}
