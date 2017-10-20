
package com.luoxiang.reader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseActivity;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.view.pdfview.PDFViewPager;

import java.io.File;

import butterknife.Bind;

public class ReadPDFActivity extends BaseActivity {

    public static void start(Context context, String filePath) {
        Intent intent = new Intent(context, ReadPDFActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.fromFile(new File(filePath)));
        context.startActivity(intent);
    }

    @Bind(R.id.llPdfRoot)
    LinearLayout llPdfRoot;
    private int startX = 0;
    private int startY = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_read_pdf;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {
        String filePath = Uri.decode(getIntent().getDataString().replace("file://", ""));
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."));
        mCommonToolbar.setTitle(fileName);
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
            String filePath = Uri.decode(getIntent().getDataString().replace("file://", ""));

            PDFViewPager pdfViewPager = new PDFViewPager(this, filePath);
            llPdfRoot.addView(pdfViewPager);
        }
    }

    @Override
    public void configViews() {

    }
}
