package com.bdqn.shopvisit.resultbean;


public class TrainDetailResult {

    /**
     * code : 0
     * msg : 培训详情获取成功
     * body : {"score":3,"feedback":"培训很棒，学到了很多东西","imgPath":"http://xxxxxx","imgName":"1.jpg;2.jpg;3.jpg"}
     */

    private int code;
    private String msg;
    /**
     * score : 3
     * feedback : 培训很棒，学到了很多东西
     * imgPath : http://xxxxxx
     * imgName : 1.jpg;2.jpg;3.jpg
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
        private String score;
        private String feedback;
        private String imgPath;
        private String imgName;

    
        public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getImgName() {
            return imgName;
        }

        public void setImgName(String imgName) {
            this.imgName = imgName;
        }
    }
}
