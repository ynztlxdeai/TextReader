
package com.luoxiang.reader.bean.support;

import com.luoxiang.reader.bean.BookMixAToc;

import java.io.Serializable;
import java.util.List;

/**
 * 下载队列实体
 */
public class DownloadQueue implements Serializable {

    public String bookId;

    public List<BookMixAToc.mixToc.Chapters> list;

    public int start;

    public int end;

    /**
     * 是否已经开始下载
     */
    public boolean isStartDownload = false;

    /**
     * 是否中断下载
     */
    public boolean isCancel = false;

    /**
     * 是否下载完成
     */
    public boolean isFinish = false;

    public DownloadQueue(String bookId, List<BookMixAToc.mixToc.Chapters> list, int start, int end) {
        this.bookId = bookId;
        this.list = list;
        this.start = start;
        this.end = end;
    }

    /**
     * 空事件。表示通知继续执行下一条任务
     */
    public DownloadQueue() {
    }
}
