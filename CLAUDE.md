# Hexagonal Modular Monolith Sample

## 프로젝트 개요
ComponentScan 없이 모듈 경계를 **Gradle 서브모듈로 물리적으로 강제**하는 Hexagonal Architecture 샘플.
도메인 간 직접 참조가 컴파일 타임에 차단되므로, AI 에이전트의 코드 변경 영향 범위가 자동으로 제한된다.

## 모듈 구조

각 도메인(corehr, payroll)은 동일한 8개 서브모듈로 구성된다:

```
domain/
├── model/              # 순수 도메인 모델 (외부 의존성 없음)
├── service/            # UseCase 구현 (In-Port), model + infrastructure 참조
├── infrastructure/     # Out-Port 인터페이스 정의, model만 참조
├── repository-jdbc/    # JDBC Adapter (Out-Port 구현체)
├── api/                # REST Controller (Primary Adapter), service만 참조
├── application-api/    # 조립 모듈 (api + repository-jdbc + schema 통합)
├── exception/          # 도메인 예외
└── schema/             # DB 스키마 (Flyway 마이그레이션)
```

## 의존성 규칙 (Gradle이 컴파일 타임에 강제)

| 모듈 | 허용된 의존성 |
|------|-------------|
| model | 없음 (순수 도메인) |
| service | model, infrastructure, exception |
| infrastructure | model |
| repository-jdbc | infrastructure, model |
| api | service, model |
| application-api | api, repository-jdbc, schema |
| exception | 없음 |
| schema | 없음 |

### 금지 규칙
- **api → repository-jdbc 직접 참조 금지** (반드시 service를 경유)
- **도메인 간 직접 참조 금지** (corehr ↔ payroll 직접 import 불가)
- 도메인 간 통신은 **infrastructure의 Port 인터페이스**를 통해서만 가능

## 모듈 간 통신 패턴

payroll에서 corehr의 데이터가 필요한 경우:

1. `payroll/infrastructure`에 Out-Port 인터페이스 정의 (예: `EmployeeProvider`)
2. `payroll/service`에서 해당 Port를 주입받아 사용
3. 실제 구현체(Adapter)는 `application-api`에서 조립 시 주입

이 패턴으로 payroll은 corehr의 구현 세부사항을 전혀 알지 못한 채 필요한 데이터만 조회한다.

## 새 모듈 추가

Build Recipe가 모듈명의 **타입 접미사**로 설정을 자동 적용한다:

| 접미사 | 자동 적용 설정 |
|-------|--------------|
| (기본 kotlin) | Kotlin JVM, 테스트 설정 |
| `-boot` | Spring Boot 플러그인 |
| `-mvc` | Spring Web MVC 의존성 |
| `-jdbc` | Spring JDBC, DataSource 설정 |
| `-application` | Spring Boot Application 조립 |

새 도메인 추가 시 `settings.gradle.kts`에 서브모듈을 등록하면 Build Recipe가 나머지를 처리한다.

## 빌드 & 테스트

```bash
# 전체 검증 (unit + integrationTest)
./gradlew check

# 단위 테스트만
./gradlew test

# 통합 테스트만 (Docker 필요 - TestContainers)
./gradlew integrationTest

# 애플리케이션 실행
./gradlew bootRun
```

## API 문서

- Swagger UI: `http://localhost:8080/swagger-ui.html`

## 코드 스타일

- KtLint + Detekt 적용 (`./gradlew check` 시 자동 검증)
- Kotlin strict JSR305, KotlinJVM defaults 활성화
