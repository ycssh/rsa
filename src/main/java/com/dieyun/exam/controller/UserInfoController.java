package com.dieyun.exam.controller;

import com.dieyun.exam.util.HttpParamUtils;
import com.dieyun.exam.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchao
 * @date 2017/7/11
 * @desc：学考个人中心用户查看自己的云桌面剩余时间
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserInfoController {

    @RequestMapping(value = "/hours", method = RequestMethod.POST)
    public @ResponseBody
    Result userhours(HttpServletRequest request) {
        Map<String, String> params = null;
        try {
            params = HttpParamUtils.getParams(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求参数解析错误");
            return new Result(0, "请求参数解析错误");
        }
        /************以下部分替换成实际代码************/
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        return new Result(1, "", 15);
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public @ResponseBody
    Result info(HttpServletRequest request) {
        Map<String, String> params = null;
        try {
            params = HttpParamUtils.getParams(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求参数解析错误");
            return new Result(0, "请求参数解析错误");
        }
        /************以下部分替换成实际代码************/
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", "189099");
        map.put("token", "MIICdwIBADANBgkqhkiG9w0BAQ");
        return new Result(1, "", map);
    }
}

