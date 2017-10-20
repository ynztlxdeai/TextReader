
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookMixAToc;
import com.luoxiang.reader.bean.Recommend;

import java.util.List;


public interface RecommendContract {

    interface View extends BaseContract.BaseView {
        void showRecommendList(List<Recommend.RecommendBooks> list);

        void showBookToc(String bookId, List<BookMixAToc.mixToc.Chapters> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRecommendList();
    }

}
