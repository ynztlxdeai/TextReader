
package com.luoxiang.reader.bean;

import com.luoxiang.reader.bean.base.Base;

import java.io.Serializable;
import java.util.List;


public class BookLists extends Base {

    /**
     * _id : 57a83783c9b799011623ecff
     * title : 【追书盘点】男频类型文（六）体育类竞技文
     * author : 追书白小生
     * desc : 在体育竞技的赛场上！
     运动员们，因为一个坚定的信念，而不断前行，努力，付出。
     他们的目标只有一个：升级！
     当冠军，收小弟，在体育的大道上，走向人生的巅峰！

     本次就让我们来盘点一下，那些正值火热的体育类竞技文吧。
     【排名不分先后】
     * gender : male
     * collectorCount : 2713
     * cover : /agent/http://image.cmfu.com/books/3623405/3623405.jpg
     * bookCount : 20
     */

    public List<BookListsBean> bookLists;

    public class BookListsBean implements Serializable {
        public String _id;
        public String title;
        public String author;
        public String desc;
        public String gender;
        public int collectorCount;
        public String cover;
        public int bookCount;
    }
}
