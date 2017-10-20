
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BooksByCats;

public interface SubCategoryFragmentContract {

    interface View extends BaseContract.BaseView {
        void showCategoryList(BooksByCats data, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCategoryList(String gender, String major, String minor, String type, int start, int limit);
    }

}
