
package com.luoxiang.reader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.bean.support.FindBean;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVAdapter;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

public class FindAdapter extends EasyRVAdapter<FindBean> {
    private OnRvItemClickListener itemClickListener;

    public FindAdapter(Context context, List<FindBean> list, OnRvItemClickListener
            listener) {
        super(context, list, R.layout.item_find);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final FindBean item) {

        holder.setText(R.id.tvTitle, item.getTitle());
        holder.setImageResource(R.id.ivIcon,item.getIconResId());

        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }
}
