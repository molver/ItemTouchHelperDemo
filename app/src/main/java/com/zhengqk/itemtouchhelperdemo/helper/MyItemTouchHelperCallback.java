package com.zhengqk.itemtouchhelperdemo.helper;

import android.content.ClipData;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by zqk on 17-8-16.
 */

public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private boolean isLongPressDragEnabled = true;
    private boolean isItemViewSwipeEnabled = true;

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int dragFlag = 0;
        int swipeFlag = 0;
        if (layoutManager instanceof GridLayoutManager) {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP
                    | ItemTouchHelper.START | ItemTouchHelper.END;
        } else if (layoutManager instanceof LinearLayoutManager) {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP; //设置上下方向为拖放
            swipeFlag = ItemTouchHelper.START | ItemTouchHelper.END; //设置左右方向为滑动删除
        }
        return makeMovementFlags(dragFlag, swipeFlag);
    }


    private final ItemTouchHelperAdapter adapter;

    public MyItemTouchHelperCallback(ItemTouchHelperAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return isLongPressDragEnabled;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return isItemViewSwipeEnabled;
    }

    public void setLongPressDragEnabled(boolean longPressDragEnabled) {
        this.isLongPressDragEnabled = longPressDragEnabled;
    }

    public void setItemViewSwipeEnabled(boolean itemViewSwipeEnabled) {
        this.isItemViewSwipeEnabled = itemViewSwipeEnabled;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (viewHolder instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) viewHolder).onItemSelected(actionState);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) viewHolder).onItemClear();
        }
    }
}
