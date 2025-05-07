package com.hufs.algoing.recommendation.algorithm;

import com.hufs.algoing.aisolved.entity.AISolved;
import com.hufs.algoing.review.entity.Review;
import com.hufs.algoing.user.entity.User;
import com.hufs.algoing.problem.entity.Problem;
import com.hufs.algoing.recommendation.dto.WeaknessRecommedDTO;

import java.util.List;
import java.util.stream.Collectors;

public class WeaknessRecommendAlgorithm {

    //가중치 관리
    private static final double W_readScore = 0.25;
    private static final double W_optimizeScore = 0.25;
    private static final double W_duplicateScore = 0.25;
    private static final double W_UserTier = 0.15;
    private static final double W_UserSolvedType = 0.1;

    private static final int MAX_TIER_DIFF = 2; //티어 차이 최대 2까지
    private static final int MAX_SCORE_DIFF = 20; //점수 차이 최대 20점까지
    //problem
    //유저가 리뷰 받은 문제- AI 리뷰 문제(리뷰 테이블) 추천 리스트 만듦
    public static List<WeaknessRecommedDTO> recommend(User user, List<AISolved> aisolveds, List<Review> userReviewProblem) {

    return(null);

    }



    //리뷰 테이블: 모든 문제 가독성 점수 , 최적화, 중복성 점수 평균값?
    //반환받은 리뷰review테이블 난이도와 비슷한 레벨의 aisolved 테이블 난이도 문제 선택


}
