
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookSource;

import java.util.List;

public interface BookSourceContract {

    interface View extends BaseContract.BaseView {
        void showBookSource(List<BookSource> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookSource(String view, String book);
    }

}
