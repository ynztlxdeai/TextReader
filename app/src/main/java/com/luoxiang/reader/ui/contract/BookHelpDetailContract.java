
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookHelp;
import com.luoxiang.reader.bean.CommentList;

public interface BookHelpDetailContract {

    interface View extends BaseContract.BaseView {

        void showBookHelpDetail(BookHelp data);

        void showBestComments(CommentList list);

        void showBookHelpComments(CommentList list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getBookHelpDetail(String id);

        void getBestComments(String helpId);

        void getBookHelpComments(String helpId, int start, int limit);

    }

}
