package com.technath.einventory.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    String readBookmarks() {
        return "hello :" + "test";
    }
}
