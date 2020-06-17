package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.adapter.RecyclerItemClickListener;
import com.example.recyclerview.activity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private List<Movie> movieList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewHolder.recyclerView = findViewById(R.id.recyclerView);
        this.createMovies();
        //Adapter
        Adapter adapter = new Adapter(movieList);
        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mViewHolder.recyclerView.setLayoutManager(layoutManager);
        mViewHolder.recyclerView.setHasFixedSize(true);
        mViewHolder.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Return the format and the layout

        mViewHolder.recyclerView.setAdapter(adapter);

        //Enable Click Event
        mViewHolder.recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), mViewHolder.recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Pressed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(MainActivity.this, movie.getTitle()+" from "+movie.getYear(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));


    }

    public static class ViewHolder{
        RecyclerView recyclerView;
    }

    public void createMovies(){
        Movie movie = new Movie("blablablac", "2010", "Genre");
        this.movieList.add(movie);
        movie = new Movie("Titl3123e", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("asda", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("132", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("xc", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("asd", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("aa", "2010", "Genre");
        this.movieList.add(movie);
         movie = new Movie("a", "2010", "Genre");
        this.movieList.add(movie);
    }
}