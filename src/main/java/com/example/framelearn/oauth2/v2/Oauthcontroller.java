package com.example.framelearn.oauth2.v2;

import java.net.URI;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * 三个接口
 * 1、请求code
 * 2、code 换取 token(code只能用一次)
 * 3、token换取用户信息
 *
 *
 */
@Controller
public class Oauthcontroller{
    private static Logger logger = LoggerFactory.getLogger(Oauthcontroller.class);


    @RequestMapping("/v1/sso/cookie")
    @ResponseBody
    public Object cookie(Model model, HttpServletRequest request,HttpServletResponse response) {
        response.addCookie(new Cookie("session","sdfasdfasdfasdfasdf"));
        return null;
    }


    /**
     *
     * sonar用
     * @param model
     * @param request
     * @return
     */
    //带code重定向
    //获取cookie,校验token
    @RequestMapping("/oauth/oauth/authorize")
    public Object toShowUser1(Model model, HttpServletRequest request) {
        logger.info("访问responseCode接口，获取状态码");

        String queryString = request.getQueryString();
        System.out.println("url:"+queryString);
        //浏览器同一个域名或者ip下面有cookie，调用次接口时会传递过来实现识别是哪个用户
        //一般是sessionid
       Cookie[] cookies1 = request.getCookies();
        System.out.println();


        String state = request.getParameter("state");

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                System.out.println("请求cookie:########  "+cookie.getName()+":"+cookie.getValue());
            }
        }


        try {
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            //1.验证clientId
//            if ("oauth_client_app_id".equals(oauthRequest.getClientId())) {
                String authCode = null;
                String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
                logger.info("responseType:" + responseType);
                // ResponseType仅支持CODE和TOKEN
                if (responseType.equals(ResponseType.CODE.toString())) {
                    OAuthIssuerImpl oAuthIssuer = new OAuthIssuerImpl(new MD5Generator());
                    authCode = oAuthIssuer.authorizationCode();
                }
                // 进行OAuth响应构建
                OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
                        .authorizationResponse(request, HttpServletResponse.SC_FOUND);
                // 设置授权码，存储用来下一个请求认证
                builder.setCode(authCode);
                // 得到到客户端重定向地址
                String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
                logger.info("redirectURI:" + redirectURI);
                // 构建响应
                final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
                String responceUri = response.getLocationUri();
                // 根据OAuthResponse返回ResponseEntity响应
                HttpHeaders headers = new HttpHeaders();
                try {
                    headers.setLocation(new URI(response.getLocationUri()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                responceUri = responceUri.replaceAll("http://192.168.145.203/", "http://192.168.145.203:8081/");

                return "redirect:" + responceUri;
//                http://192.168.145.203:8081/dashboard/groups92.168.145.203:8081/users/auth/Satorix/callback?code=a2f73584f9d52f2b6ac5cac6f5922305&state=5fee265c40c947b2b74eb329dd00bdca810559c59a10fb18
//            }
        } catch (Exception e) {
        }
        return null;
    }







    /**
     *
     * gitlab用
     * @param model
     * @param request
     * @return
     */
    //带code重定向
    //获取cookie,校验token
    @RequestMapping("/oauth/oauth/authorize1")
    public Object toShowUser(Model model, HttpServletRequest request) {
        logger.info("访问responseCode接口，获取状态码");

        String queryString = request.getQueryString();
        System.out.println("url:"+queryString);
        //浏览器同一个域名或者ip下面有cookie，调用次接口时会传递过来实现识别是哪个用户
        //一般是sessionid
        Cookie[] cookies1 = request.getCookies();
        System.out.println();


        String state = request.getParameter("state");

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                System.out.println("请求cookie:########  "+cookie.getName()+":"+cookie.getValue());
            }
        }


        try {
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            //1.验证clientId
            if ("oauth_client_app_id".equals(oauthRequest.getClientId())) {
                String authCode = null;
                String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
                logger.info("responseType:" + responseType);
                // ResponseType仅支持CODE和TOKEN
                if (responseType.equals(ResponseType.CODE.toString())) {
                    OAuthIssuerImpl oAuthIssuer = new OAuthIssuerImpl(new MD5Generator());
                    authCode = oAuthIssuer.authorizationCode();
                }
                // 进行OAuth响应构建
                OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
                        .authorizationResponse(request, HttpServletResponse.SC_FOUND);
                // 设置授权码，存储用来下一个请求认证
                builder.setCode(authCode);
                // 得到到客户端重定向地址
                String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
                logger.info("redirectURI:" + redirectURI);
                // 构建响应
                final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
                String responceUri = response.getLocationUri();
                // 根据OAuthResponse返回ResponseEntity响应
                HttpHeaders headers = new HttpHeaders();
                try {
                    headers.setLocation(new URI(response.getLocationUri()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                responceUri = responceUri.replaceAll("http://192.168.145.203/", "http://192.168.145.203:8081/");

                return "redirect:" + responceUri+"&redirect_uri=localhost";
//                http://192.168.145.203:8081/dashboard/groups92.168.145.203:8081/users/auth/Satorix/callback?code=a2f73584f9d52f2b6ac5cac6f5922305&state=5fee265c40c947b2b74eb329dd00bdca810559c59a10fb18
            }
        } catch (Exception e) {
        }
        return null;
    }


    /**
     * grafana
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/authorize")
    public Object toShowUser2(Model model, HttpServletRequest request) {
        logger.info("访问responseCode接口，获取状态码");

        String queryString = request.getQueryString();
        System.out.println("url:"+queryString);
        //浏览器同一个域名或者ip下面有cookie，调用次接口时会传递过来实现识别是哪个用户
        //一般是sessionid
        Cookie[] cookies1 = request.getCookies();
        System.out.println();


        String state = request.getParameter("state");

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                System.out.println("请求cookie:########  "+cookie.getName()+":"+cookie.getValue());
            }
        }


        try {
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            //1.验证clientId
//            if ("oauth_client_app_id".equals(oauthRequest.getClientId())) {
                String authCode = null;
                String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
                logger.info("responseType:" + responseType);
                // ResponseType仅支持CODE和TOKEN
                if (responseType.equals(ResponseType.CODE.toString())) {
                    OAuthIssuerImpl oAuthIssuer = new OAuthIssuerImpl(new MD5Generator());
                    authCode = oAuthIssuer.authorizationCode();
                }
                // 进行OAuth响应构建
                OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
                        .authorizationResponse(request, HttpServletResponse.SC_FOUND);
                // 设置授权码，存储用来下一个请求认证
                builder.setCode(authCode);
                // 得到到客户端重定向地址
                String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
                logger.info("redirectURI:" + redirectURI);
                // 构建响应
                final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
                String responceUri = response.getLocationUri();
                // 根据OAuthResponse返回ResponseEntity响应
                HttpHeaders headers = new HttpHeaders();
                try {
                    headers.setLocation(new URI(response.getLocationUri()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                responceUri = responceUri.replaceAll("http://192.168.145.203/", "http://192.168.145.203:8081/");

            String s = responceUri.replaceAll("http://(.*)/", "http://192.168.145.203:3002/login/");
            System.out.println(s);
            return "redirect:" + s;
//                http://192.168.145.203:8081/dashboard/groups92.168.145.203:8081/users/auth/Satorix/callback?code=a2f73584f9d52f2b6ac5cac6f5922305&state=5fee265c40c947b2b74eb329dd00bdca810559c59a10fb18
//            }
        } catch (Exception e) {
        }
        return null;
    }
}