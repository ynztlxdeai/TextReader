
package com.luoxiang.reader.component;

import com.luoxiang.reader.ui.activity.BookDetailActivity;
import com.luoxiang.reader.ui.activity.BookSourceActivity;
import com.luoxiang.reader.ui.activity.BooksByTagActivity;
import com.luoxiang.reader.ui.activity.ReadActivity;
import com.luoxiang.reader.ui.activity.SearchActivity;
import com.luoxiang.reader.ui.activity.SearchByAuthorActivity;
import com.luoxiang.reader.ui.fragment.BookDetailDiscussionFragment;
import com.luoxiang.reader.ui.fragment.BookDetailReviewFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface BookComponent {
    BookDetailActivity inject(BookDetailActivity activity);

    ReadActivity inject(ReadActivity activity);

    BookSourceActivity inject(BookSourceActivity activity);

    BooksByTagActivity inject(BooksByTagActivity activity);

    SearchActivity inject(SearchActivity activity);

    SearchByAuthorActivity inject(SearchByAuthorActivity activity);

    BookDetailReviewFragment inject(BookDetailReviewFragment fragment);

    BookDetailDiscussionFragment inject(BookDetailDiscussionFragment fragment);
}