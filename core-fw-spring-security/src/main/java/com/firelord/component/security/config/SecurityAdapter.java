package com.firelord.component.security.config;

import com.firelord.component.security.SecurityService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * SecurityAdapter
 */
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    //#region Fields

    @Autowired
    @Getter
    private SecurityService securityService;

    @Autowired
    @Getter
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //#endregion

    //#region configure

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.securityService).passwordEncoder(this.bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**", "/static/**",
                "/css/**", "/js/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry handler = initHttpSecurity(http);
        this.securityService.config(handler);
        afterHttpSecurity(handler);
    }

    private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry initHttpSecurity(HttpSecurity http)
            throws Exception {
        return http.authorizeRequests()
                .antMatchers("/signin").permitAll()
                .antMatchers("/signup").permitAll();

    }

    private void afterHttpSecurity(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry handler)
            throws Exception {
        handler.anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/signin")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
                .logoutSuccessUrl("/").
                and()
                .exceptionHandling();
    }

    //#endregion
}
