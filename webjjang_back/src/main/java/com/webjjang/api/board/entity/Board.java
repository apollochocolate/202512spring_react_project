package com.webjjang.api.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
// 날짜 자동 생성
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false, length = 300)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 30)
    private String writer;

    @CreatedDate
    @Column(updatable = false) // 한번 등록하면 변경하지 않는다.
    private LocalDateTime writedDate;

    // 최근 수정일 - 자동 변경 : 단, JPA Factory 를 사용하면 적용 안됨 -> 별도
    // JPA
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private Long hit = 0L;

    @Column(nullable = false)
    private String pw;
}
