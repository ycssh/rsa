package com.dieyun.exam.controller;

import com.dieyun.exam.util.HttpParamUtils;
import com.dieyun.exam.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：
 */
@RestController
@Slf4j
public class PayRegistController {

    @RequestMapping(value = "/payRegist")
    public
    Result payRegist(HttpServletRequest request) {
        Map<String, String> params = null;
        try {
            params = HttpParamUtils.getParams(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求参数解析错误");
            return new Result(0, "请求参数解析错误");
        }
        /************以下部分替换成实际代码************/
        for(Map.Entry<String,String> entry:params.entrySet()){
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

        return new Result(1,"注册成功");
    }
}
