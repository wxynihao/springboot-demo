package me.rainking.handle;

import me.rainking.exception.RainException;
import me.rainking.model.Result;
import me.rainking.util.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof RainException) {
            RainException rainException = (RainException) e;
            return ResultUtil.error(rainException.getCode(), rainException.getMessage());
        } else {
            logger.error("系统异常：", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
