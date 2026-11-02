package com.example.demo.domain.repository;

import com.example.demo.application.dto.RankingItemDto;
import java.util.List;

public interface RankingRepository {
  List<RankingItemDto> getIntroducerRanking();

  List<RankingItemDto> getPurchaseRanking();
}
