package by.bsu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * Created by Mikhail on 17.12.2017.
 */
@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = {"by.bsu"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String REMEMBER_ME_KEY = "rememberme_key";

    @Autowired
    private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/index.html", "/login.html",
                "/partials/**", "/", "/error/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs").hasAnyAuthority("admin")
                .antMatchers("/users/**").hasAnyAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .formLogin()
                .loginProcessingUrl("/authenticate")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .rememberMe()
                .key(REMEMBER_ME_KEY)
                .and();
    }
}
