package com.example.framelearn.oauth2;

import com.alibaba.fastjson.JSON;
import com.example.framelearn.rpc.serialize.JsonDemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jt
 * @date 2020-8-15
 */
@Controller
@RequestMapping
public class Test11Controller {


    /**
     *
     *
     * user_response_structure: {
     *         root_path: ['data', 'user'], # i.e. if attributes are returned in JsonAPI format (in a 'user' node nested under a 'data' node)
     *         attributes: { nickname: 'username' } # if the nickname attribute of a user is called 'username'
     *       },
     *
     *       /api/path/to/fetch/current_user/info
     * @return
     */
    @GetMapping("/api/path/to/fetch/current_user/info")
    @ResponseBody
    public Map<String,String> test(){
        System.out.println("查询userinfo.....");
        HashMap<String, String> map = new HashMap<>();
        map.put("username","ten1");
        map.put("EmailAddress","93834973111@qq.com");
//        Notification
        return map;
    }

    @GetMapping("/oauth/authorize")
    @CrossOrigin
    public String test1(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        System.out.println(request.getQueryString());
            String redirect_uri = request.getParameter("redirect_uri");
        String state = request.getParameter("state");
        String s = redirect_uri.replaceAll("http://192.168.145.203/", "http://192.168.145.203:8081/");

        model.put("redirectURI",s+"?code=testestestcode112ssf22&state="+state);
        return "redirect";
    }


    @PostMapping("/oauth/token")
    @CrossOrigin
    @ResponseBody
    public Map<String,String> test2(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        System.out.println("token接口："+request.getQueryString());
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(JSON.toJSONString(parameterMap));

        HashMap<String, String> map = new HashMap<>();
        map.put("access_token","fsfafagkagkpewasfafg[wk");
//        String string = "{\n" +
//                "    \"access_token\": \"e7f223c4-7543-43c0-b5a6-5011743b5af4\"," +
//                "    \"token_type\": \"bearer\",\n" +
//                "    \"refresh_token\": \"aafc167b-a112-456e-bbd8-58cb56d915dd\"," +
//                "    \"expires_in\": 7199," +
//                "    \"scope\": \"all\"\n" +
//                "}";
        return map;
    }

//    /users/auth/Satorix/callback

//    @GetMapping("/users/auth/Satorix/callback")
//    public Map<String,String> test3(){
//        HashMap<String, String> map = new HashMap<>();
//        return map;
//    }
}
