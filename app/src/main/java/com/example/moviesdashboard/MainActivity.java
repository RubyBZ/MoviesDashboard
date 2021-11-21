package com.example.moviesdashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager() {
        ViewPager2 moviesViewPager = findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }


    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie batman = new Movie();
        batman.poster = R.drawable.batman_v_superman_dawn_of_justice;
        batman.name = "Batman v Superman: Dawn of Justice";
        batman.category = "Action";
        batman.releaseDate = "03/25/2016";
        batman.rating = 4.6f;
        movies.add(batman);

        Movie f9 = new Movie();
        f9.poster = R.drawable.f9;
        f9.name = "F9 (2021)";
        f9.category = "Action";
        f9.releaseDate = "06/17/2021";
        f9.rating = 4.3f;
        movies.add(f9);

        Movie knock = new Movie();
        knock.poster = R.drawable.knock_knock;
        knock.name = "Knock Knock (2015)";
        knock.category = "Thriller";
        knock.releaseDate = "12/03/2015";
        knock.rating = 3.2f;
        movies.add(knock);

        Movie naruto = new Movie();
        naruto.poster = R.drawable.naruto_shippuden_the_movie_the_will_of_fire;
        naruto.name = "Naruto Shippuden the Movie: The Will of Fire";
        naruto.category = "Animation";
        naruto.releaseDate = "08/01/2009";
        naruto.rating = 4.2f;
        movies.add(naruto);

        Movie notime = new Movie();
        notime.poster = R.drawable.no_time_to_die;
        notime.name = "No Time To Die";
        notime.category = "Adventure";
        notime.releaseDate = "09/30/2021";
        notime.rating = 4.8f;
        movies.add(notime);

        Movie peter = new Movie();
        peter.poster = R.drawable.peter_rabbit_2_the_runaway;
        peter.name = "Peter Rabbit 2: The Runaway";
        peter.category = "Family";
        peter.releaseDate = "06/18/2021";
        peter.rating = 4.1f;
        movies.add(peter);

        Movie notice = new Movie();
        notice.poster = R.drawable.red_notice;
        notice.name = "Red Notice";
        notice.category = "Action";
        notice.releaseDate = "11/05/2021";
        notice.rating = 3.6f;
        movies.add(notice);

        Movie road = new Movie();
        road.poster = R.drawable.the_ice_road;
        road.name = "The Ice Road";
        road.category = "Thriller";
        road.releaseDate = "06/24/2021";
        road.rating = 4.1f;
        movies.add(road);

        Movie little = new Movie();
        little.poster = R.drawable.the_little_things;
        little.name = "The Little Things";
        little.category = "Crime";
        little.releaseDate = "01/29/2021";
        little.rating = 3.8f;
        movies.add(little);

        return movies;
    }
}