package com.acrobat.jpatest.constant;

import com.acrobat.jpatest.web.BaseResult;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务错误码定义
 * @author xutao
 * @date 2018-12-24 14:41
 */
public enum FailureCode {

    ERR_FAIL(1000, "操作失败"),
    ERR_ERROR_PARAMS(1001, "参数错误"),
    ERR_MISSING_PARAMS(1002, "参数不全"),

    ERR_DATA_EXIST(1010, "数据已存在");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String message;

    FailureCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public <T> BaseResult<T> fail() {
        return BaseResult.fail(code, message);
    }
}
