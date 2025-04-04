# Scheduler App

## 📌 프로젝트 개요

----
Scheduler App은 사용자가 개인 일정을 관리할 수 있도록 돕는 웹 애플리케이션입니다.
사용자는 일정(할 일)을 생성, 수정, 삭제할 수 있으며, 회원가입 및 로그인 기능을 통해 개인화된 서비스를 이용할 수 있습니다.
로그인 기능은 Cookie/Session을 활용하여 인증을 수행하며, 일정과 사용자 정보는 JPA를 활용하여 데이터베이스에 저장됩니다.


## 📌 개발 환경 및 기술 스택

----
### 개발 환경
* 언어: Java 17
* 프레임워크: Spring Boot 3.4.4
* 빌드 도구: Gradle
* 데이터베이스: MySQL
* ORM: Spring Data JPA
* 인증/인가: Cookie, Session
* API 테스트: Postman

### 기술 스택
* Spring Boot: REST API 및 웹 애플리케이션 개발
* Spring Data JPA: 데이터베이스와의 인터페이스 관리
* Lombok: 보일러플레이트 코드 제거 및 유지보수성 향상
* Spring Security: 인증 및 인가 처리
* Hibernate: ORM을 통한 객체-관계 매핑
* JPA Auditing: 자동으로 생성일/수정일 관리
* Validation: 입력 값 검증


## 📌 주요 기능 

----
### Lv 1. 일정 CRUD
* 일정 생성, 조회, 수정, 삭제 기능 제공
* 일정의 주요 필드: 작성 유저명, 할 일 제목, 할 일 내용, 작성일, 수정일
* JPA Auditing을 활용하여 작성일, 수정일 자동 관리

### Lv 2. 유저 CRUD
* 회원가입, 회원 조회, 회원 정보 수정, 회원 삭제 기능 제공
* 유저 필드: 유저명, 이메일, 비밀번호, 작성일, 수정일
* JPA Auditing을 활용하여 작성일, 수정일 자동 관리
* 일정과 유저 연관 관계 설정 (유저 고유 식별자를 통한 일정 작성)

### Lv 3. 회원가입
* 회원가입 시 이메일, 비밀번호, 유저명 입력
* 비밀번호는 암호화(도전 과제)

### Lv 4. 로그인 (인증)
* Cookie/Session을 활용한 로그인 기능 구현
* Spring Security와 Servlet Filter를 활용한 인증 처리
* 회원가입 및 로그인 요청은 인증 처리에서 제외
* 로그인 실패 시 401 Unauthorized 응답 반환
* 필터 기반 인증 예외 처리 및 에러 응답 포맷 지정

## 📌 API 명세서

----
https://sparta-8663.postman.co/workspace/sparta-Workspace~fc43ed61-a1fc-48a8-92c9-142420554112/collection/43163091-4229dda7-0105-476f-9577-ef5bb4da6e5f?action=share&creator=43163091


## 📌 ERD

----
<img src="https://github.com/classseoha/schedulerApp/blob/main/ERD.png?raw=true">

