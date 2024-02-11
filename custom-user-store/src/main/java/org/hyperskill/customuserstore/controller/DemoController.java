package org.hyperskill.customuserstore.controller;

import org.hyperskill.customuserstore.model.AppUser;
import org.hyperskill.customuserstore.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    public DemoController(AppUserRepository repository,
                          PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        var user = new AppUser();
        user.setUsername(request.username);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setAuthority(request.authority);
        
        repository.save(user);
        
        return "New user successfully registered";
    }
    
    @GetMapping("/test")
    public String test() {
        return "Access to '/test' granted";
    }
    
    record RegistrationRequest(String username, String password, String authority) {}
}
