
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.SearchDetail;

import java.util.List;
public interface SearchContract {

    interface View extends BaseContract.BaseView {
        void showHotWordList(List<String> list);

        void showAutoCompleteList(List<String> list);

        void showSearchResultList(List<SearchDetail.SearchBooks> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getHotWordList();

        void getAutoCompleteList(String query);

        void getSearchResultList(String query);
    }

}
