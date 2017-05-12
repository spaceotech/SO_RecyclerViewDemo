package com.spaceo.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NewsModel> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mAdapter = new NewsAdapter(newsList, new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NewsModel item) {
                //Click on item will open NewsDetail screen
                startActivity(new Intent(MainActivity.this,NewsDetailActivity.class).putExtra("title",item.getTitle()).putExtra("date",item.getDate()));
            }
        });
        //Set Layout to recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        //Set divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(mLayoutManager);
        //Give animation
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        setNewsData();
    }

    private void setNewsData() {
        //Set news data
        NewsModel news = new NewsModel("Gupshup brings Microsoft Cognitive Services Intelligent APIs to InterBot","05-12-2017");
        newsList.add(news);

        news = new NewsModel("Decks cleared for Snapdeal to land in Flipkart's basket","05-11-2017");
        newsList.add(news);

        news = new NewsModel("The Apple Watch could help doctors spot the leading cause of hear","05-10-2017");
        newsList.add(news);

        news = new NewsModel("Microsoft's new strategy: A deeper meaning","05-10-2017");
        newsList.add(news);

        news = new NewsModel("Mario Andretti vs. semi-autonomous tech on the track","05-09-2017");
        newsList.add(news);

        news = new NewsModel("What to bring on a plane if your laptop is banned","05-08-2017");
        newsList.add(news);

        news = new NewsModel("Risky to chase growth over unit economics: Liew, Lightspeed Venture Partners","05-07-2017");
        newsList.add(news);

        news = new NewsModel("OnePlus 5 shows up on GeekBench, beats Galaxy S8+ and iPhone 7 Plus","05-06-2017");
        newsList.add(news);

        news = new NewsModel("Google Pixel smartphone available at discount of Rs 13,000","05-05-2017");
        newsList.add(news);

        news = new NewsModel("Oppo planning to export handsets from India","05-04-2017");
        newsList.add(news);

        news = new NewsModel("OnePlus 5 smartphone is arriving this summer","05-04-2017");
        newsList.add(news);

        news = new NewsModel("Decoupled solutions with Hybris","05-03-2017");
        newsList.add(news);

        mAdapter.notifyDataSetChanged();

    }
}
