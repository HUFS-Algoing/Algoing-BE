package com.hufs.algoing.review.repository;

import com.hufs.algoing.review.entity.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hufs.algoing.review.entity.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Review getRecentReview(Long userId, Long problemNum) {
        return jpaQueryFactory
                .selectFrom(review)
                .where(review.user.userId.eq(userId))
                .where(review.problemNum.eq(problemNum))
                .orderBy(review.createdAt.desc())
                .fetchFirst();
    }

    @Override
    public List<Review> getUserReviews(Long userId) {
        return jpaQueryFactory
                .selectFrom(review)
                .where(review.user.userId.eq(userId))
                .fetch();
    }
}
