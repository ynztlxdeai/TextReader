package com.luoxiang.txtreader.base;

/**
 * packageName:	    com.luoxiang.txtreader.base
 * className:	    BaseContract
 * author:	        Luoxiang
 * time:	        2017/10/19	19:28
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/10/19
 * upDateDesc:      TODO
 */
public interface BaseContract {

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }
}
