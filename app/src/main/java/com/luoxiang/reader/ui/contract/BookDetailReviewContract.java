
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.HotReview;

import java.util.List;

public interface BookDetailReviewContract {

    interface View extends BaseContract.BaseView {
        void showBookDetailReviewList(List<HotReview.Reviews> list, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetailReviewList(String bookId, String sort, int start, int limit);
    }
}
