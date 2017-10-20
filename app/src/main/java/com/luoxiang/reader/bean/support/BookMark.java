
package com.luoxiang.reader.bean.support;

import java.io.Serializable;


public class BookMark implements Serializable {

    public int chapter;

    public String title;

    public int startPos;

    public int endPos;

    public String desc = "";
}
