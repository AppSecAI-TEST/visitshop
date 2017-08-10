package com.bdqn.shopvisit.resultbean;

import java.util.List;


public class TaskResult {

    /**
     * code : 0
     * msg : 任务获取成功
     * body : [{"title":"任务1","detail":"任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。","publishdate":"2016-06-01","executedate":"2016-06-01 至 2016-09-01","state":1},{"title":"任务1","detail":"任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。","publishdate":"2016-06-01","executedate":"2016-06-01 至 2016-09-01","state":1},{"title":"任务1","detail":"任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。","publishdate":"2016-06-01","executedate":"2016-06-01 至 2016-09-01","state":1},{"title":"任务1","detail":"任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。","publishdate":"2016-06-01","executedate":"2016-06-01 至 2016-09-01","state":1},{"title":"任务1","detail":"任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。","publishdate":"2016-06-01","executedate":"2016-06-01 至 2016-09-01","state":1}]
     */

    private int code;
    private String msg;
    /**
     * title : 任务1
     * detail : 任务描述：针对公司新产品XXX的市场调研。需要来店里咨询的客户填写问卷，并留联系方式。问卷已发送至各位邮箱，请下载并打印。
     * publishdate : 2016-06-01
     * executedate : 2016-06-01 至 2016-09-01
     * state : 1
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
        private String detail;
        private String publishdate;
        private String executedate;
        private int state;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPublishdate() {
            return publishdate;
        }

        public void setPublishdate(String publishdate) {
            this.publishdate = publishdate;
        }

        public String getExecutedate() {
            return executedate;
        }

        public void setExecutedate(String executedate) {
            this.executedate = executedate;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
