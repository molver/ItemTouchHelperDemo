package com.zhengqk.itemtouchhelperdemo.helper;

/**
 * Created by zqk on 17-8-16.
 */

public interface ItemTouchHelperAdapter {
    void onItemDismiss(int position);
    void onItemMove(int fromPosition, int toPosition);
}
