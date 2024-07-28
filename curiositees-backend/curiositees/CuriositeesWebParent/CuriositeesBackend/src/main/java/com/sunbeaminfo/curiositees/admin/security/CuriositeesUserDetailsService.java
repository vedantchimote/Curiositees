/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 * @Time : 11:46 am
 **/

package com.sunbeaminfo.curiositees.admin.security;

import com.curiositees.common.entity.User;
import com.sunbeaminfo.curiositees.admin.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 **/

@Component
public class CuriositeesUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(email);
        if (user != null) {
            return new CuriositeesUserDetails(user);
        }
        throw new UsernameNotFoundException("Could not find user with email: " + email);
    }
}
