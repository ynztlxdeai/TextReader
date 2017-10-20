
package com.luoxiang.reader.view.epubview;


public interface ReaderCallback {

    String getPageHref(int position);

    void toggleToolBarVisible();

    void hideToolBarIfVisible();


}
