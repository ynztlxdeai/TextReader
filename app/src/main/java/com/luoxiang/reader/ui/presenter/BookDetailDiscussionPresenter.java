
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.DiscussionList;
import com.luoxiang.reader.ui.contract.BookDetailDiscussionContract;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.utils.RxUtil;
import com.luoxiang.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class BookDetailDiscussionPresenter extends RxPresenter<BookDetailDiscussionContract.View> implements BookDetailDiscussionContract.Presenter<BookDetailDiscussionContract.View> {

    private BookApi bookApi;

    @Inject
    public BookDetailDiscussionPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookDetailDiscussionList(String bookId, String sort, final int start, int limit) {
        String key = StringUtils.creatAcacheKey("book-detail-discussion-list", bookId, sort, start, limit);
        Observable<DiscussionList> fromNetWork = bookApi.getBookDetailDisscussionList(bookId, sort, "normal,vote", start + "", limit + "")
                .compose(RxUtil.<DiscussionList>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, DiscussionList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscussionList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDetailDiscussionList:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(DiscussionList list) {
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showBookDetailDiscussionList(list.posts, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
