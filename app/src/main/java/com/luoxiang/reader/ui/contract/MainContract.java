
package com.luoxiang.reader.ui.contract;


import com.luoxiang.reader.base.BaseContract;

public interface MainContract {

    interface View extends BaseContract.BaseView {

        void syncBookShelfCompleted();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void syncBookShelf();
    }

}
