package com.luoxiang.txtreader.bean.support;

import java.io.Serializable;

/**
 * packageName:	    com.luoxiang.txtreader.bean.support
 * className:	    BookMark
 * author:	        Luoxiang
 * time:	        2017/10/19	19:35
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/10/19
 * upDateDesc:      TODO
 */
public class BookMark
        implements Serializable
{

    public int chapter;

    public String title;

    public int startPos;

    public int endPos;

    public String desc = "";
}
