
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookReview;
import com.luoxiang.reader.bean.CommentList;


public interface BookReviewDetailContract {

    interface View extends BaseContract.BaseView {

        void showBookReviewDetail(BookReview data);

        void showBestComments(CommentList list);

        void showBookReviewComments(CommentList list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getBookReviewDetail(String id);

        void getBestComments(String bookReviewId);

        void getBookReviewComments(String bookReviewId, int start, int limit);

    }

}
