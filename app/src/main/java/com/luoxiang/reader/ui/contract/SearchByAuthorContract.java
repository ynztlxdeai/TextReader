
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BooksByTag;

import java.util.List;

public interface SearchByAuthorContract {

    interface View extends BaseContract.BaseView {
        void showSearchResultList(List<BooksByTag.TagBook> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getSearchResultList(String author);
    }

}
