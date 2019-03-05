package com.wallace.learning.test.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 13:40
 */
public class CityList {
    private List<String> list;

    public CityList() {
        this.list = new ArrayList<>();
        list.add("Beijing");
        list.add("Shanghai");
        list.add("Nanjing");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
