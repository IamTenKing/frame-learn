package com.example.framelearn.stragety;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author jt
 * @date 2020-6-9
 */
@AllArgsConstructor
public class PasswordPolicyManager {


    private final List<PasswordStrategy> strategyList = new ArrayList<>();
    private ApplicationContext context;



    @PostConstruct
    public void init() {
        //加载所有PasswordStrategy.class接口的实现类，可以实现类似spi的配置式插件化注入
        Map<String, PasswordStrategy> passwordStrategyMap = this.context.getBeansOfType(PasswordStrategy.class);
        Iterator<Map.Entry<String, PasswordStrategy>> iterator = passwordStrategyMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, PasswordStrategy> next = iterator.next();
            strategyList.add(next.getValue());
        }

    }




    public void passwordValidate(String password, BasePasswordPolicyDTO policy) {
        if (password == null) {
            throw new RuntimeException("error.password.null");
        } else if (policy != null) {
            PasswordPolicyMap passwordPolicyMap = PasswordPolicyMap.parse(policy);
            if (passwordPolicyMap.getEnablePassword()) {
                for (PasswordStrategy ps : strategyList) {
                    ps.validate(passwordPolicyMap,null, password);
                }
            }
        }
    }

}
