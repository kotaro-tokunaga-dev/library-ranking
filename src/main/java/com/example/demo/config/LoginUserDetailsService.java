package com.example.demo.config;

import com.example.demo.entity.UserTable;
import com.example.demo.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** ログイン時に、DBからユーザーを探して Spring Security に渡す */
@Service
public class LoginUserDetailsService implements UserDetailsService {
  private final UserMapper userMapper;

  public LoginUserDetailsService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    UserTable user = userMapper.selectByUserId(userId);
    if (user == null) {
      throw new UsernameNotFoundException("ユーザーが見つかりません: " + userId);
    }
    return User.withUsername(user.getUserId())
        .password(user.getPassword())
        .roles("USER")
        .build();
  }
}
