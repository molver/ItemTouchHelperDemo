package com.zhengqk.itemtouchhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import com.zhengqk.itemtouchhelperdemo.helper.MyItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.Collections;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView.setHasFixedSize(true);
        String[] items = getResources().getStringArray(R.array.items);
        ArrayList<String> itemsArrayList = new ArrayList<>();
        Collections.addAll(itemsArrayList, items);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, itemsArrayList);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new GridDividerDecoration(this);
        recyclerView.addItemDecoration(itemDecoration);
        MyItemTouchHelperCallback callback = new MyItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
