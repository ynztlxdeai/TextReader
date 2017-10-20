
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookListDetail;


public interface SubjectBookListDetailContract {

    interface View extends BaseContract.BaseView {
        void showBookListDetail(BookListDetail data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookListDetail(String bookListId);
    }
}
