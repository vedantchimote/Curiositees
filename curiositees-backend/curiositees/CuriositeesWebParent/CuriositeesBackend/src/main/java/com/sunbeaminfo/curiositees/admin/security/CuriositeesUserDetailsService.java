/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 * @Time : 11:46 am
 **/

package com.sunbeaminfo.curiositees.admin.security;

import com.curiositees.common.entity.User;
import com.sunbeaminfo.curiositees.admin.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 **/

public class CuriositeesUserDetailsService implements UserDetailsService {

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
