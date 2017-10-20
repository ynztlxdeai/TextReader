
package com.luoxiang.reader.bean;

import com.luoxiang.reader.bean.base.Base;

import java.util.List;

/**
 * 书荒区帖子列表
 */
public class BookHelpList extends Base{


    /**
     * _id : 57c63a9e641e6d0b762e3ac1
     * title : 【追书读书会】第一期·那些该死的快穿文
     * author : {"_id":"56e903c1febd4661455a0692",
     * "avatar":"/avatar/7b/e1/7be142f47d8ef8834727b1dd2c7bbbc1","nickname":"追书家的眼镜娘",
     * "type":"official","lv":8,"gender":"female"}
     * likeCount : 17
     * state : hot
     * updated : 2016-09-01T13:57:22.643Z
     * created : 2016-08-31T02:02:06.227Z
     * commentCount : 183
     */

    public List<HelpsBean> helps;

    public static class HelpsBean {
        public String _id;
        public String title;
        /**
         * _id : 56e903c1febd4661455a0692
         * avatar : /avatar/7b/e1/7be142f47d8ef8834727b1dd2c7bbbc1
         * nickname : 追书家的眼镜娘
         * type : official
         * lv : 8
         * gender : female
         */

        public AuthorBean author;
        public int likeCount;
        public String state;
        public String updated;
        public String created;
        public int commentCount;

        public static class AuthorBean {
            public String _id;
            public String avatar;
            public String nickname;
            public String type;
            public int lv;
            public String gender;
        }
    }
}
