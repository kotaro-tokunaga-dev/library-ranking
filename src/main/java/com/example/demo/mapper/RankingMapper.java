package com.example.demo.mapper;

import com.example.demo.application.dto.RankingItemDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RankingMapper {
  /** 紹介数ランキングを取得 */
  List<RankingItemDto> selectIntroducerRanking();

  /** 購入数ランキングを取得 */
  List<RankingItemDto> selectPurchaseRanking();
}
