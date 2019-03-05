package com.wallace.learning.test.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 13:39
 */
public class ConfigMap {
    private Map<String, String> configMap;

    public ConfigMap() {
        this.configMap = new HashMap<>();
        configMap.put("host", "127.0.0.1");
        configMap.put("port", "6379");
        configMap.put("user", "root");
        configMap.put("password", "122334");
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, String> configMap) {
        this.configMap = configMap;
    }
}
