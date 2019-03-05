package com.wallace.learning.test.chapter4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 14:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/query")
    public Map getUser(
            @RequestParam("id") String id
    ) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", "Wallace");
        return map;
    }
}
