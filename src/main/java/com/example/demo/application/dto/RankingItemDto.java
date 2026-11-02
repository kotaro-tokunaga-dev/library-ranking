package com.example.demo.application.dto;

import lombok.Data;

@Data
public class RankingItemDto {
  private String name; // ユーザー名
  private int count; // 紹介数 または 購入数
  private int rank; // ランキング順位
}
