package com.example.schedulerapp.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity //JPA에서 해당 클래스가 DB 테이블과 매핑되는 엔티티임을 나타냄 (반드시 @Id(기본키) 필드 포함, 기본생성자 필수)
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 가동 생성 어노테이션 (DB의 AUTO_INCREMENT 기능을 활용)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext") //VARCHAR 보다 훨씬 긴 텍스트 저장 가능
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setUser(User user) { //작성자 추가
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setContents(String contents) {
        this.contents = contents;
    }
}
