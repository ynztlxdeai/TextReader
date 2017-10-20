
package com.luoxiang.reader.ui.easyadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.Constant;
import com.luoxiang.reader.bean.SearchDetail;
import com.luoxiang.reader.view.recyclerview.adapter.BaseViewHolder;
import com.luoxiang.reader.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * 查询
 */
public class SearchAdapter extends RecyclerArrayAdapter<SearchDetail.SearchBooks> {


    public SearchAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<SearchDetail.SearchBooks>(parent, R.layout.item_search_result_list) {
            @Override
            public void setData(SearchDetail.SearchBooks item) {
                holder.setRoundImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.cover, R.drawable.cover_default)
                        .setText(R.id.tvBookListTitle, item.title)
                        .setText(R.id.tvLatelyFollower, String.format(mContext.getString(R.string.search_result_lately_follower), item.latelyFollower))
                        .setText(R.id.tvRetentionRatio, (TextUtils.isEmpty(item.retentionRatio) ? String.format(mContext.getString(R.string.search_result_retention_ratio), "0")
                                : String.format(mContext.getString(R.string.search_result_retention_ratio), item.retentionRatio)))
                        .setText(R.id.tvBookListAuthor, String.format(mContext.getString(R.string.search_result_author), item.author));
            }
        };
    }
}
