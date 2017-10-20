
package com.luoxiang.reader.ui.fragment;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseRVFragment;
import com.luoxiang.reader.base.Constant;
import com.luoxiang.reader.bean.BookReviewList;
import com.luoxiang.reader.bean.support.SelectionEvent;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.component.DaggerCommunityComponent;
import com.luoxiang.reader.ui.activity.BookReviewDetailActivity;
import com.luoxiang.reader.ui.contract.BookReviewContract;
import com.luoxiang.reader.ui.easyadapter.BookReviewAdapter;
import com.luoxiang.reader.ui.presenter.BookReviewPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 书评区Fragment
 */
public class BookReviewFragment extends BaseRVFragment<BookReviewPresenter, BookReviewList.ReviewsBean> implements BookReviewContract.View {

    private String sort = Constant.SortType.DEFAULT;
    private String type = Constant.BookType.ALL;
    private String distillate = Constant.Distillate.ALL;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void configViews() {
        initAdapter(BookReviewAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void showBookReviewList(List<BookReviewList.ReviewsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        type = event.type;
        distillate = event.distillate;
        start = 0;
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
    }

    @Override
    public void onItemClick(int position) {
        BookReviewList.ReviewsBean data = mAdapter.getItem(position);
        BookReviewDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
