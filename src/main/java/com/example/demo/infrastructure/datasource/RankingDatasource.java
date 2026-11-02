package com.example.demo.infrastructure.datasource;

import com.example.demo.application.dto.RankingItemDto;
import com.example.demo.domain.repository.RankingRepository;
import com.example.demo.mapper.RankingMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RankingDatasource implements RankingRepository {
  private final RankingMapper rankingMapper;

  public RankingDatasource(RankingMapper rankingMapper) {
    this.rankingMapper = rankingMapper;
  }

  @Override
  public List<RankingItemDto> getIntroducerRanking() {
    return rankingMapper.selectIntroducerRanking();
  }

  @Override
  public List<RankingItemDto> getPurchaseRanking() {
    return rankingMapper.selectPurchaseRanking();
  }
}
