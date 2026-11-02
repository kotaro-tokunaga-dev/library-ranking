package com.example.demo.application.usecase;

import com.example.demo.application.dto.RankingDto;
import com.example.demo.application.dto.RankingItemDto;
import com.example.demo.domain.repository.RankingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RankingUseCase {
  private final RankingRepository rankingRepository;

  public RankingUseCase(RankingRepository rankingRepository) {
    this.rankingRepository = rankingRepository;
  }

  public RankingDto execute(String type) {
    List<RankingItemDto> items;

    // パラメータに応じて呼び出すメソッドを切り替え
    if ("purchase".equals(type)) {
      items = rankingRepository.getPurchaseRanking();
    } else {
      items = rankingRepository.getIntroducerRanking();
      type = "intro"; // デフォルト値
    }

    // 順位を計算（同率は同じ順位）
    int rank = 1;
    for (int i = 0; i < items.size(); i++) {
      if (i > 0 && items.get(i).getCount() < items.get(i - 1).getCount()) {
        rank = i + 1;
      }
      items.get(i).setRank(rank);
    }

    RankingDto dto = new RankingDto();
    dto.setType(type);
    dto.setRankingList(items);
    return dto;
  }
}
