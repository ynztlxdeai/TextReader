
package com.luoxiang.reader.view.recyclerview.adapter;

import android.view.View;

public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

    void setMore(View view, OnLoadMoreListener listener);
    void setNoMore(View view);
    void setErrorMore(View view);
}
