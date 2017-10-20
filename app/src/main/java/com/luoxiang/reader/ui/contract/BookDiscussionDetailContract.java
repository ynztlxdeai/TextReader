
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.CommentList;
import com.luoxiang.reader.bean.Disscussion;

public interface BookDiscussionDetailContract {

    interface View extends BaseContract.BaseView {

        void showBookDisscussionDetail(Disscussion disscussion);

        void showBestComments(CommentList list);

        void showBookDisscussionComments(CommentList list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getBookDisscussionDetail(String id);

        void getBestComments(String disscussionId);

        void getBookDisscussionComments(String disscussionId, int start, int limit);

    }

}
