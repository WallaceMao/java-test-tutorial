package com.wallace.learning.test.chapter2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 14:12
 */
public class CollectionTests {
    @Test
    void testCityList() {
        CityList list = new CityList();
        assertThat(list.getList()).containsExactlyInAnyOrder("Beijing", "Nanjing", "Shanghai");
    }

    @Test
    void testConfigMap() {
        ConfigMap map = new ConfigMap();
        assertThat(map.getConfigMap()).containsOnlyKeys("host", "port", "user", "password");
        assertThat(map.getConfigMap()).containsValues("127.0.0.1", "6379", "root", "122334");
    }
}
