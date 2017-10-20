
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.BookListTags;
import com.luoxiang.reader.ui.contract.SubjectBookListContract;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.utils.RxUtil;
import com.luoxiang.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class SubjectBookListPresenter extends RxPresenter<SubjectBookListContract.View> implements SubjectBookListContract.Presenter<SubjectBookListContract.View> {

    private BookApi bookApi;

    @Inject
    public SubjectBookListPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookListTags() {
        String key = StringUtils.creatAcacheKey("book-list-tags");
        Observable<BookListTags> fromNetWork = bookApi.getBookListTags()
                .compose(RxUtil.<BookListTags>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookListTags.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookListTags>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookListTags:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookListTags tags) {
                        mView.showBookListTags(tags);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
