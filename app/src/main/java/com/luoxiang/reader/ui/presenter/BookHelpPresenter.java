
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.BookHelpList;
import com.luoxiang.reader.ui.contract.BookHelpContract;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.utils.RxUtil;
import com.luoxiang.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class BookHelpPresenter extends RxPresenter<BookHelpContract.View> implements BookHelpContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookHelpPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookHelpList(String sort, String distillate, final int start, int limit) {
        String key = StringUtils.creatAcacheKey("book-help-list", "all", sort, start + "", limit + "", distillate);
        Observable<BookHelpList> fromNetWork = bookApi.getBookHelpList("all", sort, start + "", limit + "", distillate)
                .compose(RxUtil.<BookHelpList>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookHelpList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookHelpList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookHelpList:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookHelpList list) {
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showBookHelpList(list.helps, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
