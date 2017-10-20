
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BooksByCats;

public interface SubRankContract {

    interface View extends BaseContract.BaseView {
        void showRankList(BooksByCats data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRankList(String id);
    }
}
