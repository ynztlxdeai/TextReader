
package com.luoxiang.txtreader.bean.support;


import com.luoxiang.txtreader.bean.base.Base;

import java.io.Serializable;
import java.util.List;

/**
 * packageName:	    com.luoxiang.txtreader.bean.support
 * className:	    BookMixAToc
 * author:	        Luoxiang
 * time:	        2017/10/19	19:43
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/10/19
 * upDateDesc:      TODO
 */


public class BookMixAToc
        extends Base
{

    /**
     * _id:577e528e2160421a02d7380d
     * name:优质书源
     * link:http://vip.zhuishushenqi.com/toc/577e528e2160421a02d7380d
     */
    public mixToc mixToc;
    public static class mixToc implements Serializable {
        public String         _id;
        public String         book;
        public String         chaptersUpdated;
        /**
         * title : 第一章 死在万花丛中
         * link : http://vip.zhuishushenqi.com/chapter/577e5290260289ff64a29213?cv=1467896464908
         * id : 577e5290260289ff64a29213
         * currency : 15
         * unreadble : false
         * isVip : false
         */

        public List<Chapters> chapters;

        public static class Chapters implements Serializable {
            public String  title;
            public String  link;
            public String  id;
            public int     currency;
            public boolean unreadble;
            public boolean isVip;

            public Chapters() {
            }

            public Chapters(String title, String link) {
                this.title = title;
                this.link = link;
            }
        }
    }

}
