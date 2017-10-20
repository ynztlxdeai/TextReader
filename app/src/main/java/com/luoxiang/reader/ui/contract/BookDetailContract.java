
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookDetail;
import com.luoxiang.reader.bean.HotReview;
import com.luoxiang.reader.bean.RecommendBookList;

import java.util.List;

public interface BookDetailContract {

    interface View extends BaseContract.BaseView {
        void showBookDetail(BookDetail data);

        void showHotReview(List<HotReview.Reviews> list);

        void showRecommendBookList(List<RecommendBookList.RecommendBook> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetail(String bookId);

        void getHotReview(String book);

        void getRecommendBookList(String bookId, String limit);
    }

}
