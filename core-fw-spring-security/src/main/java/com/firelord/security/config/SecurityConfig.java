package com.firelord.security.config;

import com.firelord.security.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SecurityConfig
 */
@Configuration
public class SecurityConfig {
    //#region passwordEncoder

    /**
     * init BCryptPasswordEncoder bean
     *
     * @return BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    //#endregion

    //#region userDetailsService

    /**
     * init UserDetailsService bean
     *
     * @return UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new SecurityService();
    }

    //#endregion
}
