
package com.luoxiang.reader.api;

import com.luoxiang.reader.base.Constant;
import com.luoxiang.reader.bean.AutoComplete;
import com.luoxiang.reader.bean.BookDetail;
import com.luoxiang.reader.bean.BookHelp;
import com.luoxiang.reader.bean.BookHelpList;
import com.luoxiang.reader.bean.BookListDetail;
import com.luoxiang.reader.bean.BookListTags;
import com.luoxiang.reader.bean.BookLists;
import com.luoxiang.reader.bean.BookMixAToc;
import com.luoxiang.reader.bean.BookReview;
import com.luoxiang.reader.bean.BookReviewList;
import com.luoxiang.reader.bean.BookSource;
import com.luoxiang.reader.bean.BooksByCats;
import com.luoxiang.reader.bean.BooksByTag;
import com.luoxiang.reader.bean.CategoryList;
import com.luoxiang.reader.bean.CategoryListLv2;
import com.luoxiang.reader.bean.ChapterRead;
import com.luoxiang.reader.bean.CommentList;
import com.luoxiang.reader.bean.DiscussionList;
import com.luoxiang.reader.bean.Disscussion;
import com.luoxiang.reader.bean.HotReview;
import com.luoxiang.reader.bean.HotWord;
import com.luoxiang.reader.bean.RankingList;
import com.luoxiang.reader.bean.Rankings;
import com.luoxiang.reader.bean.Recommend;
import com.luoxiang.reader.bean.RecommendBookList;
import com.luoxiang.reader.bean.SearchDetail;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import rx.Observable;

public class BookApi {

    public static BookApi instance;

    private BookApiService service;

    public BookApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(BookApiService.class);
    }

    public static BookApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new BookApi(okHttpClient);
        return instance;
    }

    public Observable<Recommend> getRecommend(String gender) {
        return service.getRecomend(gender);
    }

    public Observable<HotWord> getHotWord() {
        return service.getHotWord();
    }

    public Observable<AutoComplete> getAutoComplete(String query) {
        return service.autoComplete(query);
    }

    public Observable<SearchDetail> getSearchResult(String query) {
        return service.searchBooks(query);
    }

    public Observable<BooksByTag> searchBooksByAuthor(String author) {
        return service.searchBooksByAuthor(author);
    }

    public Observable<BookDetail> getBookDetail(String bookId) {
        return service.getBookDetail(bookId);
    }

    public Observable<HotReview> getHotReview(String book) {
        return service.getHotReview(book);
    }

    public Observable<RecommendBookList> getRecommendBookList(String bookId, String limit) {
        return service.getRecommendBookList(bookId, limit);
    }

    public Observable<BooksByTag> getBooksByTag(String tags, String start, String limit) {
        return service.getBooksByTag(tags, start, limit);
    }

    public Observable<BookMixAToc> getBookMixAToc(String bookId, String view) {
        return service.getBookMixAToc(bookId, view);
    }

    public synchronized Observable<ChapterRead> getChapterRead(String url) {
        return service.getChapterRead(url);
    }

    public synchronized Observable<List<BookSource>> getBookSource(String view, String book) {
        return service.getABookSource(view, book);
    }

    public Observable<RankingList> getRanking() {
        return service.getRanking();
    }

    public Observable<Rankings> getRanking(String rankingId) {
        return service.getRanking(rankingId);
    }

    public Observable<BookLists> getBookLists(String duration, String sort, String start, String limit, String tag, String gender) {
        return service.getBookLists(duration, sort, start, limit, tag, gender);
    }

    public Observable<BookListTags> getBookListTags() {
        return service.getBookListTags();
    }

    public Observable<BookListDetail> getBookListDetail(String bookListId) {
        return service.getBookListDetail(bookListId);
    }

    public synchronized Observable<CategoryList> getCategoryList() {
        return service.getCategoryList();
    }

    public Observable<CategoryListLv2> getCategoryListLv2() {
        return service.getCategoryListLv2();
    }

    public Observable<BooksByCats> getBooksByCats(String gender, String type, String major, String minor, int start, @Query("limit") int limit) {
        return service.getBooksByCats(gender, type, major, minor, start, limit);
    }

    public Observable<DiscussionList> getBookDisscussionList(String block, String duration, String sort, String type, String start, String limit, String distillate) {
        return service.getBookDisscussionList(block, duration, sort, type, start, limit, distillate);
    }

    public Observable<Disscussion> getBookDisscussionDetail(String disscussionId) {
        return service.getBookDisscussionDetail(disscussionId);
    }

    public Observable<CommentList> getBestComments(String disscussionId) {
        return service.getBestComments(disscussionId);
    }

    public Observable<CommentList> getBookDisscussionComments(String disscussionId, String start, String limit) {
        return service.getBookDisscussionComments(disscussionId, start, limit);
    }

    public Observable<BookReviewList> getBookReviewList(String duration, String sort, String type, String start, String limit, String distillate) {
        return service.getBookReviewList(duration, sort, type, start, limit, distillate);
    }

    public Observable<BookReview> getBookReviewDetail(String bookReviewId) {
        return service.getBookReviewDetail(bookReviewId);
    }

    public Observable<CommentList> getBookReviewComments(String bookReviewId, String start, String limit) {
        return service.getBookReviewComments(bookReviewId, start, limit);
    }

    public Observable<BookHelpList> getBookHelpList(String duration, String sort, String start, String limit, String distillate) {
        return service.getBookHelpList(duration, sort, start, limit, distillate);
    }

    public Observable<BookHelp> getBookHelpDetail(String helpId) {
        return service.getBookHelpDetail(helpId);
    }

    public Observable<DiscussionList> getBookDetailDisscussionList(String book, String sort, String type, String start, String limit) {
        return service.getBookDetailDisscussionList(book, sort, type, start, limit);
    }

    public Observable<HotReview> getBookDetailReviewList(String book, String sort, String start, String limit) {
        return service.getBookDetailReviewList(book, sort, start, limit);
    }

    public Observable<DiscussionList> getGirlBookDisscussionList(String block, String duration, String sort, String type, String start, String limit, String distillate) {
        return service.getBookDisscussionList(block, duration, sort, type, start, limit, distillate);
    }

}
