package org.hyperskill.signlepageapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @PostMapping("/public")
    public String postPublic() {
        return "Access to 'POST /public' granted";
    }
    
    @GetMapping("public")
    public String getPublic() {
        return "Access to 'GET /public' granted";
    }
    
    @GetMapping("/secured")
    public String secured() {
        return "Access to '/secured' granted";
    }
    
    @GetMapping("/user")
    public String user() {
        return "Access to '/user' granted";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "Access to '/admin' granted";
    }
}
