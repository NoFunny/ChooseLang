package ru.project.chooselang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

import javax.sql.DataSource;

/**
 * WebSecurityConfig class adding and limit rights for users that asks
 * access to methods and web-pages
 * @author skwardlow, NoFunny
 * @version 1.0
 * @see WebSecurityConfigurerAdapter
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Wired dataSource bean used for configuring
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Creating passwordencoder object for Security authentication
     */
    Md4PasswordEncoder md4PasswordEncoder = new Md4PasswordEncoder();

    /**
     * This method is limit rights for users, that request something from server.
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/js/**", "/css/**", "/add_user", "/getSalary", "/content/**").permitAll()
                .antMatchers("/profile/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/getUsers", "/deleteUser", "/updateSalary").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    /**
     * This method configuring default datasource
     * no params expected. running automatically
     * @param auth
     * @throws Exception
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(md4PasswordEncoder)
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select username, roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
    }
}
