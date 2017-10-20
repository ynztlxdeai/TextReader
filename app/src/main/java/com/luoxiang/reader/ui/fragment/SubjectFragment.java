
package com.luoxiang.reader.ui.fragment;

import android.os.Bundle;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseRVFragment;
import com.luoxiang.reader.bean.BookLists;
import com.luoxiang.reader.bean.support.TagEvent;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.component.DaggerFindComponent;
import com.luoxiang.reader.manager.SettingManager;
import com.luoxiang.reader.ui.activity.SubjectBookListDetailActivity;
import com.luoxiang.reader.ui.contract.SubjectFragmentContract;
import com.luoxiang.reader.ui.easyadapter.SubjectBookListAdapter;
import com.luoxiang.reader.ui.presenter.SubjectFragmentPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 主题书单
 */
public class SubjectFragment extends BaseRVFragment<SubjectFragmentPresenter, BookLists.BookListsBean> implements SubjectFragmentContract.View {

    public final static String BUNDLE_TAG = "tag";
    public final static String BUNDLE_TAB = "tab";

    public String currendTag;
    public int currentTab;

    public String duration = "";
    public String sort = "";

    public static SubjectFragment newInstance(String tag, int tab) {
        SubjectFragment fragment = new SubjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TAG, tag);
        bundle.putInt(BUNDLE_TAB, tab);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);

        currentTab = getArguments().getInt(BUNDLE_TAB);
        switch (currentTab) {
            case 0:
                duration = "last-seven-days";
                sort = "collectorCount";
                break;
            case 1:
                duration = "all";
                sort = "created";
                break;
            case 2:
            default:
                duration = "all";
                sort = "collectorCount";
                break;
        }
    }

    @Override
    public void configViews() {
        initAdapter(SubjectBookListAdapter.class, true, true);
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
    public void showBookList(List<BookLists.BookListsBean> bookLists, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
            start = 0;
        }
        mAdapter.addAll(bookLists);
        start = start + bookLists.size();
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
    public void initCategoryList(TagEvent event) {
        currendTag = event.tag;
        if (getUserVisibleHint()) {
            mPresenter.getBookLists(duration, sort, 0, limit, currendTag, SettingManager.getInstance().getUserChooseSex());
        }
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Override
    public void onItemClick(int position) {
        SubjectBookListDetailActivity.startActivity(activity, mAdapter.getItem(position));
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookLists(duration, sort, 0, limit, currendTag, SettingManager.getInstance().getUserChooseSex());
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookLists(duration, sort, start, limit, currendTag, SettingManager.getInstance().getUserChooseSex());
    }
}
