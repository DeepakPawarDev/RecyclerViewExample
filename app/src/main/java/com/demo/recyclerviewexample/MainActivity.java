package com.demo.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.demo.recyclerviewexample.adapter.RecyclerAdapter;
import com.demo.recyclerviewexample.model.Animal;

public class MainActivity extends AppCompatActivity implements  Toolbar.OnMenuItemClickListener {
    Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        setUpRecyclerView();
    }


    private void setUpRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Animal.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.linearViewHorizontal:
                LinearLayoutManager mLinearLayoutManagerHorizontal = new LinearLayoutManager(this);
                mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mLinearLayoutManagerHorizontal);
                break;

            case R.id.linearViewVertical:
                LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
                mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
                break;
            case R.id.gridView:
                GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2); // (Context context, int spanCount)
                recyclerView.setLayoutManager(mGridLayoutManager);
                break;
            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager mStaggeredHorizontalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
                recyclerView.setLayoutManager(mStaggeredHorizontalLayoutManager);
                break;
            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
                recyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
                break;
        }
        return true;
    }



}
