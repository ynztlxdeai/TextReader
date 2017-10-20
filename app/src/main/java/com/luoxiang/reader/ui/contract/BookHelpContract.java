
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookHelpList;

import java.util.List;

public interface BookHelpContract {

    interface View extends BaseContract.BaseView {
        void showBookHelpList(List<BookHelpList.HelpsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookHelpList(String sort, String distillate, int start, int limit);
    }

}
