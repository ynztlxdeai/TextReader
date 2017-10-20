
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.BookSource;
import com.luoxiang.reader.ui.contract.BookSourceContract;
import com.luoxiang.reader.utils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BookSourcePresenter extends RxPresenter<BookSourceContract.View> implements BookSourceContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookSourcePresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookSource(String viewSummary, String book) {
        Subscription rxSubscription = bookApi.getBookSource(viewSummary, book).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookSource>>() {
                    @Override
                    public void onNext(List<BookSource> data) {
                        if (data != null && mView != null) {
                            mView.showBookSource(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: " + e);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
