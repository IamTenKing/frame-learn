package com.example.framelearn.oauth2.v2;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfoController {
    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping("/v1/sso/userInfo")
    @ResponseBody
    public Object userInfo(HttpServletRequest request) {
        logger.info("访问userInfo接口  获取账号信息");

        String header = request.getHeader("authorization");
        String[] split = header.split(" ");
        String accesstoken = split[1].trim();
        // 1.验证token
        //1.1验证token的过期时间

//        String username = commonUtils.getUsernameByToken(accesstoken);
//        if (StringUtils.isBlank(username)) {
//            return "";
//        }
        // 2.取到账号信息返回
        Map<String, Object> resultMap = new HashMap<String, Object>();
//        if ("zhangsan".equals(username)) {
            resultMap.put("id", "333");
            resultMap.put("name", "name");
            resultMap.put("nickname", "nickname");
            resultMap.put("email", "1111@163.com");
//        } else if ("lisi".equals(username)) {
//            resultMap.put("id", "112");
//            resultMap.put("name", "lisi");
//            resultMap.put("nickname", "lisi");
//            resultMap.put("email", "lisi@163.com");
//        }
        logger.info(JSON.toJSONString(resultMap));
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(resultMap, HttpStatus.valueOf(200));
        return responseEntity;
    }
}