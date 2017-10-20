
package com.luoxiang.reader.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseActivity;
import com.luoxiang.reader.bean.BooksByTag;
import com.luoxiang.reader.common.OnRvItemClickListener;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.component.DaggerBookComponent;
import com.luoxiang.reader.ui.adapter.BooksByTagAdapter;
import com.luoxiang.reader.ui.contract.BooksByTagContract;
import com.luoxiang.reader.ui.presenter.BooksByTagPresenter;
import com.luoxiang.reader.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;


public class BooksByTagActivity extends BaseActivity implements BooksByTagContract.View,
        OnRvItemClickListener<BooksByTag.TagBook> {

    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Inject
    BooksByTagPresenter mPresenter;

    private BooksByTagAdapter mAdapter;
    private List<BooksByTag.TagBook> mList = new ArrayList<>();

    private String tag;
    private int current = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_books_by_tag;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerBookComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle(getIntent().getStringExtra("tag"));
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        tag = getIntent().getStringExtra("tag");
    }

    @Override
    public void configViews() {
        refreshLayout.setOnRefreshListener(new RefreshListener());

        mRecyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        mAdapter = new BooksByTagAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RefreshListener());

        mPresenter.attachView(this);
        mPresenter.getBooksByTag(tag, current + "", (current + 10) + "");
    }


    @Override
    public void showBooksByTag(List<BooksByTag.TagBook> list, boolean isRefresh) {
        if (isRefresh)
            mList.clear();
        mList.addAll(list);
        current = mList.size();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadComplete(boolean isSuccess, String msg) {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(View view, int position, BooksByTag.TagBook data) {
        startActivity(new Intent(BooksByTagActivity.this, BookDetailActivity.class)
                .putExtra("bookId", data._id));
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        refreshLayout.setRefreshing(false);
    }

    private class RefreshListener extends RecyclerView.OnScrollListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            current = 0;
            mPresenter.getBooksByTag(tag, current + "", "10");
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (lastVisibleItemPosition + 1 == mAdapter.getItemCount()) { // 滑到倒数第二项就加载更多

                boolean isRefreshing = refreshLayout.isRefreshing();
                if (isRefreshing) {
                    mAdapter.notifyItemRemoved(mAdapter.getItemCount());
                    return;
                }
                mPresenter.getBooksByTag(tag, current + "", "10");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
