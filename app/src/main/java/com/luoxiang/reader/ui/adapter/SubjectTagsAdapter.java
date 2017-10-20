
package com.luoxiang.reader.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.bean.BookListTags;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVAdapter;
import com.luoxiang.reader.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

public class SubjectTagsAdapter extends EasyRVAdapter<BookListTags.DataBean> {

    private OnRvItemClickListener listener;

    public SubjectTagsAdapter(Context context, List<BookListTags.DataBean> list) {
        super(context, list, R.layout.item_subject_tags_list);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, BookListTags.DataBean item) {
        RecyclerView rvTagsItem = viewHolder.getView(R.id.rvTagsItem);
        rvTagsItem.setHasFixedSize(true);
        rvTagsItem.setLayoutManager(new GridLayoutManager(mContext, 4));
        TagsItemAdapter adapter = new TagsItemAdapter(mContext, item.tags);
        rvTagsItem.setAdapter(adapter);

        viewHolder.setText(R.id.tvTagGroupName, item.name);
    }

    class TagsItemAdapter extends EasyRVAdapter<String> {

        public TagsItemAdapter(Context context, List<String> list) {
            super(context, list, R.layout.item_subject_tag_list);
        }

        @Override
        protected void onBindData(EasyRVHolder viewHolder, final int position, final String item) {
            viewHolder.setText(R.id.tvTagName, item);
            viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(v, position, item);
                    }
                }
            });
        }
    }

    public void setItemClickListener(OnRvItemClickListener<String> listener) {
        this.listener = listener;
    }
}
