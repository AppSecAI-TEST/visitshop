package com.bdqn.shopvisit.resultbean;


import java.util.List;


public class HistoryVisitImg {

    /**
     * code : 0
     * msg : 历史巡店图片获取成功
     * id : 121
     * body : {"imgs":["http://1270.0.0.1:8080/","http://1270.0.0.1:8080/","http://1270.0.0.1:8080/"]}
     */

    private int code;
    private String msg;
    private int id;
    private BodyBean body;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private List<String> imgs;

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }
}
