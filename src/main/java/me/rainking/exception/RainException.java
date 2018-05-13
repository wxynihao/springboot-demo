package me.rainking.exception;

import me.rainking.enums.ResultEnum;

public class RainException extends RuntimeException {
    private Integer code;
    public RainException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
