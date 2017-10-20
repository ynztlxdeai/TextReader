
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.CategoryList;
import com.luoxiang.reader.ui.contract.TopCategoryListContract;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.utils.RxUtil;
import com.luoxiang.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class TopCategoryListPresenter extends RxPresenter<TopCategoryListContract.View> implements TopCategoryListContract.Presenter<TopCategoryListContract.View> {

    private BookApi bookApi;

    @Inject
    public TopCategoryListPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getCategoryList() {
        String key = StringUtils.creatAcacheKey("book-category-list");
        Observable<CategoryList> fromNetWork = bookApi.getCategoryList()
                .compose(RxUtil.<CategoryList>rxCacheBeanHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, CategoryList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryList>() {
                    @Override
                    public void onNext(CategoryList data) {
                        if (data != null && mView != null) {
                            mView.showCategoryList(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        LogUtils.i("complete");
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mView.complete();
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
