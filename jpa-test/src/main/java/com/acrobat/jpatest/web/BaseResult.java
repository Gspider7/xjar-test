package com.acrobat.jpatest.web;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author xutao
 * @date 2018-12-29 13:59
 */
@Data
public class BaseResult<T> {

    @JsonView(BaseResultView.class)
    private int code;
    @JsonView(BaseResultView.class)
    private String msg;
    @JsonView(BaseResultView.class)
    private String traceId;
    @JsonView(BaseResultView.class)
    private T data;

    public static interface BaseResultView {

    }

    public BaseResult(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public BaseResult() {
        this.code = 0;
        this.msg = "success";
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResult fail() {
        return fail(-1, "系统异常，请联系管理员");
    }

    public static <T> BaseResult<T> fail(String msg) {
        return fail(-1, msg);
    }

    public static <T> BaseResult<T> fail(int code, String msg) {
        BaseResult<T> r = new BaseResult<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<>();
    }

    public static <T> BaseResult<T> success(T t) {
        BaseResult<T> r = new BaseResult<>();
        r.setData(t);
        return r;
    }
}
