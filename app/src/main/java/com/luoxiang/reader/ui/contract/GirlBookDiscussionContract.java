
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.DiscussionList;

import java.util.List;

public interface GirlBookDiscussionContract {

    interface View extends BaseContract.BaseView {
        void showGirlBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getGirlBookDisscussionList(String sort, String distillate, int start, int limit);
    }

}
