package com.bdqn.shopvisit.resultbean;

import java.util.List;


public class HistoryInterviewResult {

    /**
     * code : 0
     * msg : 拜访列表获取成功
     * body : [{"id":1024,"title":"关于X公司的订单拜访","visitdate":"2016-09-09","person":"李大大","phone":"13199998888","company":"xxx公司","job":"总经理","aim":"商讨订单详情","summary":"拜访很顺利"},{"id":1025,"title":"关于X公司的订单拜访","visitdate":"2016-09-09","person":"李大大","phone":"13199998888","company":"xxx公司","job":"总经理","aim":"商讨订单详情","summary":"拜访很顺利"},{"id":1026,"title":"关于X公司的订单拜访","visitdate":"2016-09-09","person":"李大大","phone":"13199998888","company":"xxx公司","job":"总经理","aim":"商讨订单详情","summary":"拜访很顺利"}]
     */

    private int code;
    private String msg;
    /**
     * id : 1024
     * title : 关于X公司的订单拜访
     * visitdate : 2016-09-09
     * person : 李大大
     * phone : 13199998888
     * company : xxx公司
     * job : 总经理
     * aim : 商讨订单详情
     * summary : 拜访很顺利
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
        private int id;
        private String title;
        private String visitdate;
        private String person;
        private String phone;
        private String company;
        private String job;
        private String aim;
        private String summary;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVisitdate() {
            return visitdate;
        }

        public void setVisitdate(String visitdate) {
            this.visitdate = visitdate;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getAim() {
            return aim;
        }

        public void setAim(String aim) {
            this.aim = aim;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
