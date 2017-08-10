package com.bdqn.shopvisit.resultbean;



public class AppInfoResult {

    /**
     * code : 0
     * msg : APP版本获取成功
     * body : {"version":"1.0.1","address":"http://xxxxxx/zzz.apk","publishdate":"2016-09-09","updateinfo":"1:界面优化;2:新增培训模块"}
     */

    private int code;
    private String msg;
    /**
     * version : 1.0.1
     * address : http://xxxxxx/zzz.apk
     * publishdate : 2016-09-09
     * updateinfo : 1:界面优化;2:新增培训模块
     */

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

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String version;
        private String address;
        private String publishdate;
        private String updateinfo;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPublishdate() {
            return publishdate;
        }

        public void setPublishdate(String publishdate) {
            this.publishdate = publishdate;
        }

        public String getUpdateinfo() {
            return updateinfo;
        }

        public void setUpdateinfo(String updateinfo) {
            this.updateinfo = updateinfo;
        }
    }
}
