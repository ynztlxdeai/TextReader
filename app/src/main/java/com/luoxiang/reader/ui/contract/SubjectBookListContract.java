
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookListTags;

public interface SubjectBookListContract {

    interface View extends BaseContract.BaseView {
        void showBookListTags(BookListTags data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookListTags();
    }
}
