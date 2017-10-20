
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.RankingList;


public interface TopRankContract {

    interface View extends BaseContract.BaseView {
        void showRankList(RankingList rankingList);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRankList();
    }

}
