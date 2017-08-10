package com.bdqn.shopvisit.resultbean;


import java.util.List;


public class HistoryVisit {


    /**
     * code : 0
     * msg : 历史信息获取成功
     * page : 1
     * datelist : [{"id":120,"visitdate":"2016-06-01","shopid":"DDDDDDDDD","shoplocation":"成府路888号","userid":"333333","shoplevel":"kkkkkkkkk","feedback":"有部分意见需要指正，希望正确对待","name":"北京市海淀区北大青鸟","imgpath":"d://test","imgname":"1.jpg;2.jpg;3.jpg"},{"id":120,"visitdate":"2016-06-01","shopid":"DDDDDDDDD","shoplocation":"成府路888号","userid":"333333","shoplevel":"kkkkkkkkk","feedback":"有部分意见需要指正，希望正确对待","name":"北京市海淀区北大青鸟","imgpath":"d://test","imgname":"1.jpg;2.jpg;3.jpg"},{"id":120,"visitdate":"2016-06-01","shopid":"DDDDDDDDD","shoplocation":"成府路888号","userid":"333333","shoplevel":"kkkkkkkkk","feedback":"有部分意见需要指正，希望正确对待","name":"北京市海淀区北大青鸟","imgpath":"d://test","imgname":"1.jpg;2.jpg;3.jpg"},{"id":120,"visitdate":"2016-06-01","shopid":"DDDDDDDDD","shoplocation":"成府路888号","userid":"333333","shoplevel":"kkkkkkkkk","feedback":"有部分意见需要指正，希望正确对待","name":"北京市海淀区北大青鸟","imgpath":"d://test","imgname":"1.jpg;2.jpg;3.jpg"}]
     */

    private int code;
    private String msg;
    private int page;
    /**
     * id : 120
     * visitdate : 2016-06-01
     * shopid : DDDDDDDDD
     * shoplocation : 成府路888号
     * userid : 333333
     * shoplevel : kkkkkkkkk
     * feedback : 有部分意见需要指正，希望正确对待
     * name : 北京市海淀区北大青鸟
     * imgpath : d://test
     * imgname : 1.jpg;2.jpg;3.jpg
     */

    private List<DatelistBean> datelist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DatelistBean> getDatelist() {
        return datelist;
    }

    public void setDatelist(List<DatelistBean> datelist) {
        this.datelist = datelist;
    }

    public static class DatelistBean {
        private int id;
        private String visitdate;
        private String shopid;
        private String shoplocation;
        private String userid;
        private String shoplevel;
        private String feedback;
        private String name;
        private String imgpath;
        private String imgname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVisitdate() {
            return visitdate;
        }

        public void setVisitdate(String visitdate) {
            this.visitdate = visitdate;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
        }

        public String getShoplocation() {
            return shoplocation;
        }

        public void setShoplocation(String shoplocation) {
            this.shoplocation = shoplocation;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getShoplevel() {
            return shoplevel;
        }

        public void setShoplevel(String shoplevel) {
            this.shoplevel = shoplevel;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgpath() {
            return imgpath;
        }

        public void setImgpath(String imgpath) {
            this.imgpath = imgpath;
        }

        public String getImgname() {
            return imgname;
        }

        public void setImgname(String imgname) {
            this.imgname = imgname;
        }
    }
}
