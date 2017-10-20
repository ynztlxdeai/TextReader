
package com.luoxiang.reader.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseCommuniteActivity;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.view.SelectionLayout;

import java.util.List;

import butterknife.Bind;

/**
 * 女生区
 */
public class GirlBookDiscussionActivity extends BaseCommuniteActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, GirlBookDiscussionActivity.class));
    }

    @Bind(R.id.slOverall)
    SelectionLayout slOverall;

    @Override
    public int getLayoutId() {
        return R.layout.activity_community_girl_book_discussion;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("女生区");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        super.initDatas();
    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
    }

    @Override
    public void configViews() {
    }
}
