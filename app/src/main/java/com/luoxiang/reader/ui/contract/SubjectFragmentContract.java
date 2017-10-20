
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookLists;

import java.util.List;


public interface SubjectFragmentContract {

    interface View extends BaseContract.BaseView {
        void showBookList(List<BookLists.BookListsBean> bookLists, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookLists(String duration, String sort, int start, int limit, String tag, String gender);
    }
}
