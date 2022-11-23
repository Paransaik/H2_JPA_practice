# JpaApisProject
H2_JPA_Practice

## 1. 과제개요

요구 사항 항목을 참고하여 `spring-web-mvc`, `spring-data-jpa` 기반 계좌 관리 API 서버를 개발한다.

- 라이브러리 추가를 위해 `build.gradle` 파일을 수정할 수 있음
- `com.szs.account.api.ApisTest`의 모든 테스트(총 24개)를 통과해야 함
    - 테스트 실행 명령: gradle clean test
    - 기존 24개 테스트케이스 외에 응시자가 자유롭게 테스트 추가 가능함
- 개발에 필요한 데이터베이스 스키마 및 샘플 데이터가 준비되어 있음
    - In-Memory 경량 RDBMS H2가 사용되며 **프로젝트를 재시작 할 때마다 데이터가 초기화 됨**
    - 스키마: resources/schema-h2.sql
    - 데이터: resources/data-h2.sql
    - 스키마 및 샘플 데이터 수정 없이 채점을 위한 모든 테스트 통과가 가능함 (샘플 데이터 수정시 일부 테스트가 실패 할수 있음에 주의)

> `greeting 테이블`, `Greeting.java`, `GreetingRepository.java`, `GreetingService.java` 그리고 `GET /api/greeting/{greetingId}` API 구현은 샘플 코드이며, 과제 구현과는 전혀 관계없다. (삭제해도 무방함)

## 2. 요구사항

본 요구사항 항목에 따라 기존 부분을 수정하거나 새롭게 개발한다.

- [추가 요구사항 상세 보러가기→](https://github.com/Paransaik/JpaApisProject/tree/master/src/main/resources)

## 3. Directory Structure

![image](https://user-images.githubusercontent.com/30463982/203468251-4916d1f7-d6fc-42c0-865a-8a47964f0851.png)

## 4. Result JUnit Test

![image](https://user-images.githubusercontent.com/30463982/203468243-655df046-7039-492f-8598-762e6d88ff74.png)
