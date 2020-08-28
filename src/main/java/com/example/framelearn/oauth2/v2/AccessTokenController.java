package com.example.framelearn.oauth2.v2;

/**
 * @author jt
 * @date 2020-8-16
 */

import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.issuer.UUIDValueGenerator;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccessTokenController {

    private static Logger logger = LoggerFactory.getLogger(AccessTokenController.class);

    // 获取客户端的code码，向客户端返回access token
    @RequestMapping(value = "/oauth/oauth/token",method = RequestMethod.POST)
    @ResponseBody
    public Object token(HttpServletRequest request) {
        logger.info("访问responseAccessToken接口        获取access_token");
        OAuthIssuer oauthIssuerImpl = null;
        OAuthResponse response = null;
        // 构建OAuth请求
        try {
            OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
            // 1.验证authcode
            String authCode = oauthRequest.getParam(OAuth.OAUTH_CODE);

            // 2.验证clientSecret
            String clientSecret = oauthRequest.getClientSecret();
            logger.info("clientSecret:" + clientSecret);

            // 3.生成Access Token
            oauthIssuerImpl = new OAuthIssuerImpl(new UUIDValueGenerator());
            final String accessToken = oauthIssuerImpl.accessToken();
            Map<String,String> resultMap = new HashMap<String,String>();
            resultMap.put("access_token", accessToken);
            System.out.println(accessToken);
            resultMap.put("expires_in", "0");
            return resultMap;
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        } catch (OAuthProblemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
