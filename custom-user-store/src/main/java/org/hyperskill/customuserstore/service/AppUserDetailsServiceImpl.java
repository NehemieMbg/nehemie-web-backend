package org.hyperskill.customuserstore.service;

import org.hyperskill.customuserstore.model.AppUser;
import org.hyperskill.customuserstore.repository.AppUserRepository;
import org.hyperskill.customuserstore.security.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository repository;
    
    public AppUserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        AppUser user = repository
                .findAppUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));
        
        return new AppUserAdapter(user);
    }
}
