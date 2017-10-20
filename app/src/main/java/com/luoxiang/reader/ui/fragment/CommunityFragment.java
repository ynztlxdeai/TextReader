
package com.luoxiang.reader.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseFragment;
import com.luoxiang.reader.bean.support.FindBean;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.ui.activity.BookDiscussionActivity;
import com.luoxiang.reader.ui.activity.BookReviewActivity;
import com.luoxiang.reader.ui.activity.BookHelpActivity;
import com.luoxiang.reader.ui.activity.GirlBookDiscussionActivity;
import com.luoxiang.reader.ui.adapter.FindAdapter;
import com.luoxiang.reader.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CommunityFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private FindAdapter mAdapter;
    private List<FindBean> mList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initDatas() {
        mList.clear();
        mList.add(new FindBean("综合讨论区", R.drawable.discuss_section));
        mList.add(new FindBean("书评区", R.drawable.comment_section));
        mList.add(new FindBean("书荒互助区", R.drawable.helper_section));
        mList.add(new FindBean("女生区", R.drawable.girl_section));
        mList.add(new FindBean("原创区",R.drawable.yuanchuang));
    }

    @Override
    public void configViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void attachView() {

    }

    @Override
    public void onItemClick(View view, int position, FindBean data) {
        switch (position) {
            case 0:
                BookDiscussionActivity.startActivity(activity,true);
                break;
            case 1:
                BookReviewActivity.startActivity(activity);
                break;
            case 2:
                BookHelpActivity.startActivity(activity);
                break;
            case 3:
                GirlBookDiscussionActivity.startActivity(activity);
                break;
            case 4:
                BookDiscussionActivity.startActivity(activity,false);
                break;
            default:
                break;
        }
    }

}
