package com.example.demo.controllers;

import com.example.demo.application.dto.RankingDto;
import com.example.demo.application.usecase.RankingUseCase;
import com.example.demo.entity.UserTable;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RankingController {
    private final RankingUseCase rankingUseCase;

    public RankingController(RankingUseCase rankingUseCase) {
        this.rankingUseCase = rankingUseCase;
    }

    @GetMapping("/ranking")
    public String showRanking(
            @RequestParam(name = "type", required = false, defaultValue = "intro") String type,
            HttpSession session,
            Model model) {

        // 未ログインユーザーへの対応
        UserTable loginUser = (UserTable) session.getAttribute("loginUser");

        // UseCaseを実行してデータを取得
        RankingDto rankingDto = rankingUseCase.execute(type);

        // HTML（Thymeleaf）にデータを渡す
        model.addAttribute("rankingList", rankingDto.getRankingList());
        model.addAttribute("type", rankingDto.getType());
        model.addAttribute("loginUser", loginUser);

        // templates/ranking/index.html を表示
        return "ranking/index";
    }
}
