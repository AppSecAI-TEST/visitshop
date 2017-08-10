package com.bdqn.shopvisit.resultbean;

import java.util.List;



public class InfoResult {

    /**
     * code : 0
     * msg : 资讯获取成功
     * body : [{"title":"公司动态","summary":"资讯摘要","imgurl":"http://xxxxx.jpg","detail":"http:xxxxxx.html"},{"title":"公司动态","summary":"资讯摘要","imgurl":"http://xxxxx.jpg","detail":"http:xxxxxx.html"},{"title":"公司动态","summary":"资讯摘要","imgurl":"http://xxxxx.jpg","detail":"http:xxxxxx.html"},{"title":"公司动态","summary":"资讯摘要","imgurl":"http://xxxxx.jpg","detail":"http:xxxxxx.html"},{"title":"公司动态","summary":"资讯摘要","imgurl":"http://xxxxx.jpg","detail":"http:xxxxxx.html"}]
     */

    private int code;
    private String msg;
    /**
     * title : 公司动态
     * summary : 资讯摘要
     * imgurl : http://xxxxx.jpg
     * detail : http:xxxxxx.html
     */

    private List<BodyBean> body;

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

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        private String title;
        private String summary;
        private String imgurl;
        private String detail;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
