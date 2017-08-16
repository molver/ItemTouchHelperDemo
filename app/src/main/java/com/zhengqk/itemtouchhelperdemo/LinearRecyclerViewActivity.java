package com.zhengqk.itemtouchhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initViews();
    }

    private void initViews() {
        recyclerView.setHasFixedSize(true);
        String[] items = getResources().getStringArray(R.array.items);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, items);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}
