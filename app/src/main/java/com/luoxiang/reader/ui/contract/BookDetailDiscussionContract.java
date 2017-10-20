
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.DiscussionList;

import java.util.List;


public interface BookDetailDiscussionContract {

    interface View extends BaseContract.BaseView {
        void showBookDetailDiscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetailDiscussionList(String bookId, String sort, int start, int limit);
    }
}
