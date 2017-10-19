
package com.luoxiang.txtreader.view.readview;

/**
 * packageName:	    com.luoxiang.txtreader.view.readview
 * className:	    OnReadStateChangeListener
 * author:	        Luoxiang
 * time:	        2017/10/19	19:40
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/10/19
 * upDateDesc:      TODO
 */


public interface OnReadStateChangeListener {

    void onChapterChanged(int chapter);

    void onPageChanged(int chapter, int page);

    void onLoadChapterFailure(int chapter);

    void onCenterClick();

    void onFlip();
}
