package com.xmut.pmserver.wrapper;

public class ResponseWrapperForBack {

    private int code;

    private String msg;

    private int count;

    private Object data;

    public static ResponseWrapperForBack markSuccess(int count, Object data){

        ResponseWrapperForBack pageWrapperForLayui = new ResponseWrapperForBack();


        pageWrapperForLayui.setCode(0);

        pageWrapperForLayui.setData("");

        pageWrapperForLayui.setCount(count);

        pageWrapperForLayui.setData(data);

        return pageWrapperForLayui;

    }


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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageWrapperForLayui{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
