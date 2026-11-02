package com.example.demo.application.dto;

import java.util.List;
import lombok.Data;

@Data
public class RankingDto {
  private String type; // ランキング種別（intro or purchase）
  private List<RankingItemDto> rankingList; // ランキングデータのリスト
}
