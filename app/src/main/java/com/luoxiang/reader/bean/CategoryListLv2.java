
package com.luoxiang.reader.bean;

import com.luoxiang.reader.bean.base.Base;

import java.util.List;

public class CategoryListLv2 extends Base{

    /**
     * major : 玄幻
     * mins : ["东方玄幻","异界大陆","异界争霸","远古神话"]
     */

    public List<MaleBean> male;
    /**
     * major : 古代言情
     * mins : ["穿越时空","古代历史","古典架空","宫闱宅斗","经商种田"]
     */

    public List<MaleBean> female;

    public static class MaleBean {
        public String major;
        public List<String> mins;
    }
}
