
package com.luoxiang.reader.ui.adapter;

import android.content.Context;

import com.luoxiang.reader.R;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVAdapter;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVHolder;

import java.util.List;


public class AutoCompleteAdapter extends EasyLVAdapter<String> {

    public AutoCompleteAdapter(Context context, List<String> list) {
        super(context, list, R.layout.item_auto_complete_list);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, String s) {
        holder.setText(R.id.tvAutoCompleteItem, s);
    }
}
