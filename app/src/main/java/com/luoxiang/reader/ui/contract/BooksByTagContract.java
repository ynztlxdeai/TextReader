
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BooksByTag;

import java.util.List;

public interface BooksByTagContract {

    interface View extends BaseContract.BaseView {
        void showBooksByTag(List<BooksByTag.TagBook> list, boolean isRefresh);

        void onLoadComplete(boolean isSuccess, String msg);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBooksByTag(String tags, String start, String limit);
    }

}
