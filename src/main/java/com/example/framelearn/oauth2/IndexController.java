//package com.example.framelearn.oauth2;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.oltu.oauth2.client.OAuthClient;
//import org.apache.oltu.oauth2.client.URLConnectionClient;
//import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
//import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
//import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
//import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
//import org.apache.oltu.oauth2.common.OAuth;
//import org.apache.oltu.oauth2.common.message.types.GrantType;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.PreDestroy;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.logging.Logger;
//
///**
// * @author jt
// * @date 2020-8-15
// */
//@Controller
//@Slf4j
//public class IndexController {
////    protected transient final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Value("${oauth2.server.url}")
//    private String gitlabServerUrl;
//    @Value("${oauth2.server.url.authorize.path:/oauth/authorize}")
//    private String authorizePath;
//    @Value("${oauth2.server.url.token.path:/oauth/token}")
//    private String tokenPath;
//
//    @Value("${oauth2.client.id:260f7b273e13b9264b22bba3c5f1db53d55c8cb86fe3d02d7c11725ea52b0fe7}")
//    private String clientId;
//    @Value("${oauth2.client.secret:15cebdce7a671fee9a7929b5a2c2bca006bb5afa92b36352586ccb6089004765}")
//    private String clientSecret;
//    @Value("${oauth2.client.callback.url:http://localhost:8080/callback}")
//    private String callbackUrl;
//
//    @Autowired
//    TokenRepository tokenRepository;
//
//    OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
//
//    String currentUserMock = "yunshi";
//
//    @PreDestroy
//    public void cleanUp() {
//        oAuthClient.shutdown();
//    }
//
//    @RequestMapping("/main")
//    @ResponseBody
//    public String main() {
//        if (tokenRepository.getTokenOf(currentUserMock).isPresent()) {
//            return "authorization is done, you are good to go with access token: " + tokenRepository.getTokenOf(currentUserMock).get();
//        } else {
//            return "no authority.";
//        }
//    }
//
//    @RequestMapping("/")
//    public String index(HttpServletRequest req, HttpServletResponse response) throws Throwable {
//        if (tokenRepository.getTokenOf(currentUserMock).isPresent()) {
//            log.info("query user information with access token...");
//            OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(gitlabServerUrl + "/api/v3/user").setAccessToken(tokenRepository.getTokenOf(currentUserMock).get()).buildQueryMessage();
//            OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
//            log.info("user information: " + resourceResponse.getBody());
//            return "redirect:/main";
//        } else {
//            log.info("first login, build oauth request >..");
//            OAuthClientRequest request = OAuthClientRequest
//                    .authorizationLocation(gitlabServerUrl + authorizePath)
//                    .setClientId(clientId)
//                    .setRedirectURI(callbackUrl)
//                    .setResponseType("code")
//                    .buildQueryMessage();
//
//            String gitlabAuthUrl = request.getLocationUri();
//
//            log.info("redirect to : " + gitlabAuthUrl);
//            return "redirect:" + gitlabAuthUrl;
//        }
//    }
//
//
//    @RequestMapping("/callback")
//    public String callback(@RequestParam(value = "code", required = false) String code,
//                           @RequestParam(value = "error", required = false) String error,
//                           @RequestParam(value = "error_description", required = false) String errorDescription) throws Throwable {
//
//        if (StringUtils.hasLength(error)) {
//            log.error("authorization fails with error={} and error description={}", error, errorDescription);
//        } else {
//            log.info("callback request receives with code={}", code);
//
//            OAuthClientRequest request = OAuthClientRequest
//                    .tokenLocation(gitlabServerUrl + tokenPath)
//                    .setGrantType(GrantType.AUTHORIZATION_CODE)
//                    .setClientId(clientId)
//                    .setClientSecret(clientSecret)
//                    .setRedirectURI(callbackUrl)
//                    .setGrantType(GrantType.AUTHORIZATION_CODE)
//                    .setCode(code)
//                    .buildQueryMessage();
//
//            log.info("build authorize request with code:{} and client secret", code);
//
//            OAuthJSONAccessTokenResponse response = oAuthClient.accessToken(request);
//            String accessToken = response.getAccessToken();
//            log.info("access token got: {}", accessToken);
//
//            // save access token for further use, then redirect user to another url in our own application.
////            tokenRepository.store(currentUserMock, accessToken);
//        }
//
//        return "redirect:/main";
//    }
//    // ...
//}
