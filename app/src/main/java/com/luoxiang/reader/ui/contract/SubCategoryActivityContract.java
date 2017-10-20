
package com.luoxiang.reader.ui.contract;

import com.luoxiang.reader.base.BaseContract;
import com.luoxiang.reader.bean.CategoryListLv2;

public interface SubCategoryActivityContract {

    interface View extends BaseContract.BaseView {
        void showCategoryList(CategoryListLv2 data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCategoryListLv2();
    }

}
