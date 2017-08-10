package com.bdqn.shopvisit.resultbean;


import java.util.List;


public class ShopResult {

    /**
     * code : 0
     * msg : 门店信息获取成功
     * shoplists : [{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"西安雁塔西校区","id":"DDDDDDDDDDD"},{"name":"北京唐城校区","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"},{"name":"北京海淀区研究院","id":"DDDDDDDDDDD"}]
     */

    private int code;
    private String msg;
    /**
     * name : 北京海淀区研究院
     * id : DDDDDDDDDDD
     */

    private List<ShoplistsBean> shoplists;

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

    public List<ShoplistsBean> getShoplists() {
        return shoplists;
    }

    public void setShoplists(List<ShoplistsBean> shoplists) {
        this.shoplists = shoplists;
    }

    public static class ShoplistsBean {
        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
