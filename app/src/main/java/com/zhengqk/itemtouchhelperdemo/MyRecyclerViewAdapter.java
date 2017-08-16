package com.zhengqk.itemtouchhelperdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhengqk.itemtouchhelperdemo.helper.ItemTouchHelperAdapter;
import com.zhengqk.itemtouchhelperdemo.helper.ItemTouchHelperViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by zqk on 17-8-16.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements ItemTouchHelperAdapter {

    private final Context context;
    private final List<String> items;

    public MyRecyclerViewAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvItem.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(items, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(items, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        public TextView tvItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }

        @Override
        public void onItemSelected(int actionState) {
            if (actionState == ItemTouchHelper.ACTION_STATE_DRAG || actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                tvItem.setBackgroundColor(Color.GREEN);
            }
        }

        @Override
        public void onItemClear() {
            tvItem.setBackgroundColor(Color.WHITE);
        }
    }
}
