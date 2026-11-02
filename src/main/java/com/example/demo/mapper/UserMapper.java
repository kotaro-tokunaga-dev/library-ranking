package com.example.demo.mapper;

import com.example.demo.entity.UserTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  /** ユーザーIDでユーザーを1件取得 */
  UserTable selectByUserId(String userId);
}
