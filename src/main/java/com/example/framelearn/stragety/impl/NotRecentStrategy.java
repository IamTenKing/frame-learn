package com.example.framelearn.stragety.impl;

import com.example.framelearn.stragety.BaseUserDTO;
import com.example.framelearn.stragety.PasswordPolicyMap;
import com.example.framelearn.stragety.PasswordPolicyType;
import com.example.framelearn.stragety.PasswordStrategy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Iterator;
import java.util.List;

/**
 * @author jt
 * @date 2020-6-9
 */
public class NotRecentStrategy implements PasswordStrategy {
    private static final String ERROR_MESSAGE = "error.password.policy.notRecent";
    public static final String TYPE=PasswordPolicyType.NOT_RECENT.getValue();;
    private static final BCryptPasswordEncoder ENCODER =new BCryptPasswordEncoder();
//    private BasePasswordHistoryMapper passwordHistoryMapper;

//    public NotRecentStrategy(BasePasswordHistoryMapper passwordHistoryMapper) {
//        this.passwordHistoryMapper = passwordHistoryMapper;
//    }

    @Override
    public Object validate(PasswordPolicyMap policyMap, BaseUserDTO userDTO, String password) {
        Integer recentPasswordCount = (Integer)policyMap.getPasswordConfig().get(TYPE);
        if (recentPasswordCount > 0) {
//            List<String> passwordHistoryList = this.passwordHistoryMapper.selectPasswordByUser(userDO.getId());
            int count = 0;
//            Iterator var7 = passwordHistoryList.iterator();

//            while(var7.hasNext()) {
//                String recentPassword = (String)var7.next();
//                if (ENCODER.matches(password, recentPassword)) {
//                    throw new RuntimeException("error.password.policy.notRecent");
//                }
//
//                ++count;
//                if (count >= recentPasswordCount) {
//                    break;
//                }
//            } while(var7.hasNext()) {
//                String recentPassword = (String)var7.next();
//                if (ENCODER.matches(password, recentPassword)) {
//                    throw new RuntimeException("error.password.policy.notRecent");
//                }
//
//                ++count;
//                if (count >= recentPasswordCount) {
//                    break;
//                }
//            }
        }

        return null;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Object parseConfig(Object value) {
        return null;
    }
}

