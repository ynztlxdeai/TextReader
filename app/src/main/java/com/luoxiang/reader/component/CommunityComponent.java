
package com.luoxiang.reader.component;

import com.luoxiang.reader.ui.activity.BookDiscussionDetailActivity;
import com.luoxiang.reader.ui.activity.BookHelpDetailActivity;
import com.luoxiang.reader.ui.activity.BookReviewDetailActivity;
import com.luoxiang.reader.ui.fragment.BookDiscussionFragment;
import com.luoxiang.reader.ui.fragment.BookHelpFragment;
import com.luoxiang.reader.ui.fragment.BookReviewFragment;
import com.luoxiang.reader.ui.fragment.GirlBookDiscussionFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface CommunityComponent {

    BookDiscussionFragment inject(BookDiscussionFragment fragment);

    BookDiscussionDetailActivity inject(BookDiscussionDetailActivity activity);

    BookReviewFragment inject(BookReviewFragment fragment);

    BookReviewDetailActivity inject(BookReviewDetailActivity activity);

    BookHelpFragment inject(BookHelpFragment fragment);

    BookHelpDetailActivity inject(BookHelpDetailActivity activity);

    GirlBookDiscussionFragment inject(GirlBookDiscussionFragment fragment);
}
