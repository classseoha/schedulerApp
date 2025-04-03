package com.example.schedulerapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //직접 엔티티가 되지 않는 부모 클래스 정의할 때 사용 (자식들이 공통으로 가질 필드 선언)
@EntityListeners(AuditingEntityListener.class) //JPA Auditing 기능 활성화 (엔티티의 생성시간, 수정시간을 자동 관리해줌)
public abstract class BaseEntity { //abstract class로 생성하면 다른 곳에서 인스턴스화해서 사용 못하기 때문에 이걸로 하는게 좋음

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
