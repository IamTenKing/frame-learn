package com.example.framelearn.oauth2.v2;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.www.http.HttpClient;

import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * @author jt
 * @date 2020-8-16
 */

@Controller
public class DirectController {


    @RequestMapping("/toGitlabUrl")
    public String test(){
        String url ="http://192.168.145.203:8081/users/auth/Satorix/callback?code=10f41184e992765a404f48bfd43ac6d6&state=9472df98518760b69afd49055f0bef0b226ac00501c6f68a";

        HttpResponse execute = HttpUtil.createGet( url ).execute();
        List<HttpCookie> cookies = execute.getCookies();
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie.getName()+"    ################");
        }
            return  "redirect:"+"http://192.168.145.203:8081/dashboard/groups";

    }
}
