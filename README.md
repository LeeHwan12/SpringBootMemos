# Spring Boot + Thymeleaf Memo (Practice)

간단한 메모 웹앱으로 Spring Boot/Thymeleaf 기본기를 연습합니다.  
목록 조회, 추가, 완료/취소 토글, 삭제를 지원합니다. (인메모리 저장소)

## ✨ 기능
- `/memos` 목록 보기
- 메모 추가 (폼 전송)
- 완료/취소 토글
- 삭제
- PRG 패턴(POST → Redirect → GET)

## 🧱 기술 스택
- Java 17 (또는 21)
- Spring Boot 3.5.x
- Spring MVC, Thymeleaf
- Lombok, DevTools
- (선택) Actuator

## 📦 요구 사항
- JDK 17+ (IntelliJ의 Gradle JVM도 동일 버전 권장)
- Gradle Wrapper 포함 (`gradlew`, `gradlew.bat`)

## 🚀 빠른 시작
```bash
# 1) 클론
git clone <YOUR_REPO_URL>
cd <PROJECT_DIR>

# 2) 실행
# Windows
gradlew.bat bootRun
# macOS/Linux
./gradlew bootRun
