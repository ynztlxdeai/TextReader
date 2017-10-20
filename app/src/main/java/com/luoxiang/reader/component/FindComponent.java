
package com.luoxiang.reader.component;

import com.luoxiang.reader.ui.activity.SubCategoryListActivity;
import com.luoxiang.reader.ui.activity.SubOtherHomeRankActivity;
import com.luoxiang.reader.ui.activity.SubRankActivity;
import com.luoxiang.reader.ui.activity.SubjectBookListActivity;
import com.luoxiang.reader.ui.activity.SubjectBookListDetailActivity;
import com.luoxiang.reader.ui.activity.TopCategoryListActivity;
import com.luoxiang.reader.ui.activity.TopRankActivity;
import com.luoxiang.reader.ui.fragment.SubCategoryFragment;
import com.luoxiang.reader.ui.fragment.SubRankFragment;
import com.luoxiang.reader.ui.fragment.SubjectFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface FindComponent {

    /** 分类 **/
    TopCategoryListActivity inject(TopCategoryListActivity activity);

    SubCategoryListActivity inject(SubCategoryListActivity activity);

    SubCategoryFragment inject(SubCategoryFragment fragment);

    /** 排行 **/
    TopRankActivity inject(TopRankActivity activity);

    SubRankActivity inject(SubRankActivity activity);

    SubOtherHomeRankActivity inject(SubOtherHomeRankActivity activity);

    SubRankFragment inject(SubRankFragment fragment);

    /** 主题书单 **/
    SubjectBookListActivity inject(SubjectBookListActivity subjectBookListActivity);

    SubjectFragment inject(SubjectFragment subjectFragment);

    SubjectBookListDetailActivity inject(SubjectBookListDetailActivity categoryListActivity);
}
