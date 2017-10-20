
package com.luoxiang.reader.bean;

import com.luoxiang.reader.bean.base.Base;

import java.util.List;

public class DiscussionList extends Base {


    /**
     * _id : 57c564e9818f568675624358
     * title : 【活动预告】9月2-4日三天两觉《惊悚乐园》签名书抢楼
     * author : {"_id":"52f840b982cfcc3a74031693",
     * "avatar":"/avatar/56/a9/56a96462a50ca99f9cf83440899e46f3","nickname":"追书首席打杂",
     * "type":"official","lv":9,"gender":"male"}
     * type : vote
     * likeCount : 651
     * block : ramble
     * state : hot
     * updated : 2016-09-01T12:30:52.286Z
     * created : 2016-08-30T10:50:17.927Z
     * commentCount : 5366
     * voteCount : 6337
     */

    public List<PostsBean> posts;

    public static class PostsBean {
        public String _id;
        public String title;
        /**
         * _id : 52f840b982cfcc3a74031693
         * avatar : /avatar/56/a9/56a96462a50ca99f9cf83440899e46f3
         * nickname : 追书首席打杂
         * type : official
         * lv : 9
         * gender : male
         */

        public AuthorBean author;
        public String type;
        public int likeCount;
        public String block;
        public String state;
        public String updated;
        public String created;
        public int commentCount;
        public int voteCount;

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
