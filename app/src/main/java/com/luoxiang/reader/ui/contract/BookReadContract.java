
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.BookMixAToc;
import com.luoxiang.reader.bean.ChapterRead;

import java.util.List;

public interface BookReadContract {

    interface View extends BaseContract.BaseView {
        void showBookToc(List<BookMixAToc.mixToc.Chapters> list);

        void showChapterRead(ChapterRead.Chapter data, int chapter);

        void netError(int chapter);//添加网络处理异常接口
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookMixAToc(String bookId, String view);

        void getChapterRead(String url, int chapter);
    }

}
