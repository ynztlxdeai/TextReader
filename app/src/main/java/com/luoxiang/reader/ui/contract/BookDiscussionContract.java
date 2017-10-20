
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.DiscussionList;

import java.util.List;

public interface BookDiscussionContract {

    interface View extends BaseContract.BaseView {
        void showBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookDisscussionList(String block, String sort, String distillate, int start, int limit);
    }

}
