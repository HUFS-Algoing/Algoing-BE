package com.hufs.algoing.snapshot.entity;

import com.hufs.algoing.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 가독성 점수
    @Column(name="readbility")
    private Long readbility;

    // 최적화 점수
    @Column(name="optimization")
    private Long optimization;

    // 중복성 점수
    @Column(name="duplicate")
    private Long duplicate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

}
