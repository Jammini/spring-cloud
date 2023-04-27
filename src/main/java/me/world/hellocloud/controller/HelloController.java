package me.world.hellocloud.controller;

import me.world.hellocloud.dto.Hello2DTO;
import me.world.hellocloud.dto.HelloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<Hello2DTO> list = new ArrayList<>();

    @GetMapping("/mission1")
    public HelloDTO mission1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloDTO("Hello " + name);
    }

    /*@GetMapping("/mission3")
    public Hello2DTO mission3(@RequestParam(value = "name", defaultValue = "World") String name) {
        list.add(new Hello2DTO("Hello " + name, list.size()));
        return list.get(list.size() - 1);
    }*/
}
