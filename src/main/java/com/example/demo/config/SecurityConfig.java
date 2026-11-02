package com.example.demo.config;

import com.example.demo.entity.UserTable;
import com.example.demo.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, UserMapper userMapper) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login", "/ranking", "/error", "/css/**", "/js/**", "/images/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("userId")
            .passwordParameter("password")
            .successHandler((request, response, authentication) -> {
              // ランキング画面が読む "loginUser" をセッションに入れる（ハッシュは入れない）
              UserTable user = userMapper.selectByUserId(authentication.getName());
              user.setPassword(null);
              request.getSession().setAttribute("loginUser", user);
              response.sendRedirect("/ranking");
            })
            .failureUrl("/login?error")
            .permitAll())
        .logout(logout -> logout.logoutSuccessUrl("/login?logout"));
    return http.build();
  }
}
