package com.example.framelearn;

import io.codearte.props2yaml.Props2YAML;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jt
 * @date 2020-8-14
 */
public class proptoyaml {
    public static void main(String[] args) {
        Map<String, String> configs = new HashMap<>();
        configs.put("config.connect", "testset");
        configs.put("config.token",  "testset");
        configs.put("config.clusterId",  "testset");
        configs.put("config.choerodonId",  "testset");
        configs.put("rbac.create", "true");
        String convert = Props2YAML.fromContent(propertiesToString(configs)).convert();
        System.out.println(convert);
    }

    public static String propertiesToString(Map<String, String> map) {
        StringBuilder res = new StringBuilder();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            res.append(key);
            res.append("=");
            res.append(map.getOrDefault(key, ""));
            res.append("\n");
        }
        return res.toString();
    }

}
