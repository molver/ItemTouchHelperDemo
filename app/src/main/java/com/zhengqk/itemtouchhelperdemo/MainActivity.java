package com.zhengqk.itemtouchhelperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_linear).setOnClickListener(this);
        findViewById(R.id.btn_grid).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_linear:
                Intent intent = new Intent(this, LinearRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_grid:
                Intent intent2 = new Intent(this, GridRecyclerViewActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
