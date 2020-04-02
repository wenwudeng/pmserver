
package com.xmut.pmserver.result;


/**
 * Created by lightClouds917
 * <p>
 * Date 2017/11/10
 * <p>
 * Description:接口返回码和返回值
 * <p>
 * 结合返回数据封装类ResponseWrapper，统一接口的数据返回格式
 */

public enum ReturnCode {

    LOGIN_SUCCESS("3000", "登陆成功"),
    LOGIN_FAIL("3001", "账号或密码错误"),
    LOGIN_NOTNULL("3002", "账户不存在"),

    REGISTER_SUCCESS("3003", "注册成功"),
    REGISTER_FAIL("3004", "注册失败"),

    EDIT_MY_INFO("3005", "修改成功"),

    PUBLISH_ARTICLE_SUCCESS("3006", "发贴成功"),
    PUBLISH_ARTICLE_FAIL("3007", "发贴失败"),

    DELETE_SUCCESS("3008", "删除成功"),

    COMMENT_SUCCESS("3009", "评论成功"),

    SUCCESS("0000", "查询成功"),

    NODATA("0001", "查询成功无记录"),

    FEAILED("0002", "查询失败"),

    ACCOUNT_ERROR("1000", "账户不存在或被禁用"),

    API_NOT_EXISTS("1001", "请求的接口不存在"),

    API_NOT_PER("1002", "没有该接口的访问权限"),

    PARAMS_ERROR("1004", "参数为空或格式错误"),

    SIGN_ERROR("1005", "数据签名错误"),

    AMOUNT_NOT_QUERY("1010", "余额不够，无法进行查询"),

    API_DISABLE("1011", "查询权限已被限制"),

    UNKNOWN_IP("1099", "非法IP请求"),

    SYSTEM_ERROR("9999", "系统异常"),
    ;


    private String code;

    private String msg;


    public String getCode() {

        return code;

    }


    public String getMsg() {

        return msg;

    }


    ReturnCode(String code, String msg) {

        this.code = code;

        this.msg = msg;

    }


}
