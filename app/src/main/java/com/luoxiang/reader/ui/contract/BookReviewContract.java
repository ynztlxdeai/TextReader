
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookReviewList;

import java.util.List;


public interface BookReviewContract {

    interface View extends BaseContract.BaseView {
        void showBookReviewList(List<BookReviewList.ReviewsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookReviewList(String sort, String type, String distillate, int start, int limit);
    }

}
