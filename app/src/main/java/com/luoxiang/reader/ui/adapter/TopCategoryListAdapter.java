
package com.luoxiang.reader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.bean.CategoryList;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVAdapter;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

public class TopCategoryListAdapter extends EasyRVAdapter<CategoryList.MaleBean> {
    private OnRvItemClickListener itemClickListener;

    public TopCategoryListAdapter(Context context, List<CategoryList.MaleBean> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_top_category_list);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final CategoryList.MaleBean item) {
        holder.setText(R.id.tvName, item.name)
                .setText(R.id.tvBookCount, String.format(mContext.getString(R.string
                        .category_book_count), item.bookCount));

        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }

}
