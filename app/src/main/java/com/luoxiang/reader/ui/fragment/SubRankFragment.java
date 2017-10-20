
package com.luoxiang.reader.ui.fragment;

import android.os.Bundle;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseRVFragment;
import com.luoxiang.reader.bean.BooksByCats;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.component.DaggerFindComponent;
import com.luoxiang.reader.ui.activity.BookDetailActivity;
import com.luoxiang.reader.ui.contract.SubRankContract;
import com.luoxiang.reader.ui.easyadapter.SubCategoryAdapter;
import com.luoxiang.reader.ui.presenter.SubRankPresenter;

/**
 * 二级排行榜
 */
public class SubRankFragment extends BaseRVFragment<SubRankPresenter, BooksByCats.BooksBean> implements SubRankContract.View {

    public final static String BUNDLE_ID = "_id";

    public static SubRankFragment newInstance(String id) {
        SubRankFragment fragment = new SubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String id;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void initDatas() {
        id = getArguments().getString(BUNDLE_ID);
    }

    @Override
    public void configViews() {
        initAdapter(SubCategoryAdapter.class, true, false);

        onRefresh();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void showRankList(BooksByCats data) {
        mAdapter.clear();
        mAdapter.addAll(data.books);
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {
        BookDetailActivity.startActivity(activity, mAdapter.getItem(position)._id);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getRankList(id);
    }

}
