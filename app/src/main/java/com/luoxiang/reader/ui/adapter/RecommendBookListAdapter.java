
package com.luoxiang.reader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.Constant;
import com.luoxiang.reader.bean.RecommendBookList;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.manager.SettingManager;
import com.luoxiang.reader.utils.NoDoubleClickListener;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVAdapter;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;


public class RecommendBookListAdapter extends EasyRVAdapter<RecommendBookList.RecommendBook> {

    private OnRvItemClickListener itemClickListener;

    public RecommendBookListAdapter(Context context, List<RecommendBookList.RecommendBook> list,
                                    OnRvItemClickListener listener) {
        super(context, list, R.layout.item_book_detail_recommend_book_list);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final RecommendBookList.RecommendBook item) {
        if (!SettingManager.getInstance().isNoneCover()) {
            holder.setRoundImageUrl(R.id.ivBookListCover, Constant.IMG_BASE_URL + item.cover, R.drawable.cover_default);
        }

        holder.setText(R.id.tvBookListTitle, item.title)
                .setText(R.id.tvBookAuthor, item.author)
                .setText(R.id.tvBookListTitle, item.title)
                .setText(R.id.tvBookListDesc, item.desc)
                .setText(R.id.tvBookCount, String.format(mContext.getString(R.string
                        .book_detail_recommend_book_list_book_count), item.bookCount))
                .setText(R.id.tvCollectorCount, String.format(mContext.getString(R.string
                        .book_detail_recommend_book_list_collector_count), item.collectorCount));
        holder.setOnItemViewClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View view) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }

}