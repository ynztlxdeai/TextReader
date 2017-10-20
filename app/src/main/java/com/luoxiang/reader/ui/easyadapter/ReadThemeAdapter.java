
package com.luoxiang.reader.ui.easyadapter;

import android.content.Context;

import com.luoxiang.reader.R;
import com.luoxiang.reader.bean.support.ReadTheme;
import com.luoxiang.reader.manager.ThemeManager;
import com.luoxiang.reader.utils.LogUtils;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVAdapter;
import com.luoxiang.reader.easyadapter.abslistview.EasyLVHolder;

import java.util.List;

public class ReadThemeAdapter extends EasyLVAdapter<ReadTheme> {

    private int selected = 0;

    public ReadThemeAdapter(Context context, List<ReadTheme> list, int selected) {
        super(context, list, R.layout.item_read_theme);
        this.selected = selected;
    }

    @Override
    public void convert(EasyLVHolder holder, int position, ReadTheme readTheme) {
        if (readTheme != null) {
            ThemeManager.setReaderTheme(readTheme.theme, holder.getView(R.id.ivThemeBg));
            if (selected == position) {
                holder.setVisible(R.id.ivSelected, true);
            } else {
                holder.setVisible(R.id.ivSelected, false);
            }
        }
    }

    public void select(int position) {
        selected = position;
        LogUtils.i("curtheme=" + selected);
        notifyDataSetChanged();
    }
}
