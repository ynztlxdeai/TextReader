
package com.luoxiang.reader.ui.adapter;

import android.content.Context;

import com.luoxiang.reader.R;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVAdapter;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVHolder;

import java.util.List;

public class SearchHistoryAdapter extends EasyLVAdapter<String> {

    public SearchHistoryAdapter(Context context, List<String> list) {
        super(context, list, R.layout.item_search_history);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, String s) {
        holder.setText(R.id.tvTitle, s);
    }
}
