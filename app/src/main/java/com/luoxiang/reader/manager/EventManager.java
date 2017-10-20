
package com.luoxiang.reader.manager;

import com.luoxiang.reader.bean.support.RefreshCollectionIconEvent;
import com.luoxiang.reader.bean.support.RefreshCollectionListEvent;
import com.luoxiang.reader.bean.support.SubEvent;

import org.greenrobot.eventbus.EventBus;

public class EventManager {

    public static void refreshCollectionList() {
        EventBus.getDefault().post(new RefreshCollectionListEvent());
    }

    public static void refreshCollectionIcon() {
        EventBus.getDefault().post(new RefreshCollectionIconEvent());
    }

    public static void refreshSubCategory(String minor, String type) {
        EventBus.getDefault().post(new SubEvent(minor, type));
    }

}
