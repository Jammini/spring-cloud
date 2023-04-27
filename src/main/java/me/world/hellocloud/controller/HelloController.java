package me.world.hellocloud.controller;

import jakarta.servlet.http.HttpServletRequest;
import me.world.hellocloud.dto.HelloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    Map<String, Integer> map = new HashMap<>();
//    List<Hello2DTO> list = new ArrayList<>();

    @GetMapping("/mission1")
    public HelloDTO mission1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloDTO("Hello " + name);
    }

    @GetMapping("/mission3")
    public String mission3(@RequestParam(value = "name", defaultValue = "World") String name) {
        int count = 0;
        String ip = "";
        try {
            ip = getUserIp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        map.put(ip, map.getOrDefault(ip, 1) + 1);
        return "Hello " + name + map.get(ip);
    }

    public String getUserIp() throws Exception {

        String ip = null;
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-RealIP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
