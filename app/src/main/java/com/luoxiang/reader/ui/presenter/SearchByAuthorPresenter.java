
package com.luoxiang.reader.ui.presenter;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.base.RxPresenter;
import com.luoxiang.reader.bean.BooksByTag;
import com.luoxiang.reader.ui.contract.SearchByAuthorContract;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.utils.RxUtil;
import com.luoxiang.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class SearchByAuthorPresenter extends RxPresenter<SearchByAuthorContract.View> implements SearchByAuthorContract.Presenter {

    private BookApi bookApi;

    @Inject
    public SearchByAuthorPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getSearchResultList(String author) {
        String key = StringUtils.creatAcacheKey("search-by-author", author);
        Observable<BooksByTag> fromNetWork = bookApi.searchBooksByAuthor(author)
                .compose(RxUtil.<BooksByTag>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BooksByTag.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BooksByTag>() {
                    @Override
                    public void onNext(BooksByTag booksByTag) {
                        if (mView != null)
                            mView.showSearchResultList(booksByTag.books);
                    }

                    @Override
                    public void onCompleted() {
                        LogUtils.i("complete");
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getSearchResultList:" + e.toString());
                        if (mView != null)
                            mView.showError();
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
