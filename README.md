# flex-module-sample
---

이 프로젝트는 flex team 에서 componentScan 으로 결합하는 단일 모듈을 벗어난 프로젝트 구조를 제안하기 위해 만든 예제 입니다.

구조적인 표현을 위해 필요한 최소한의 코드만 포함하고 있습니다.

공감이 어려운 부분이나 표현이 부족하다고 생각이 되신다면, 저희 discord community를 통해 논의를 나눠보면 좋을 것 같습니다. 

![Discord Banner 1](https://discord.com/api/guilds/1377214678945759252/widget.png?style=banner1)
[디스코드 채널 들어가기](https://discord.gg/szEeNZ3C)

---

## 실행 안내

1. [sdkman 설치](https://sdkman.io/install/)를 권장합니다.
2. 실행에는 docker 환경이 필요합니다. gradle check 태스크는 integrationTest를 포함하고 있으며, integrationTest는 testcontainers를 이용하고 있습니다.
   1. [mac](https://docs.docker.com/desktop/setup/install/mac-install/)
   2. [windows](https://docs.docker.com/desktop/setup/install/windows-install/)
   3. [linux(ubuntu)](https://docs.docker.com/desktop/setup/install/linux/ubuntu/)
3. IDE는 JetBrains의 [IntelliJ Community 버전](https://www.jetbrains.com/help/idea/installation-guide.html)을 권장합니다. Ultimate도 무방합니다.
4. `./gradlew check` 를 통해 검증이 가능합니다.
5. `./gradlew bootRun` 을 실행하시면 8080 port를 이용해 서버가 기동됩니다. 
6. [swagger-ui](http://localhost:8080/swagger-ui.html) 를 통해 api 호출을 확인해보실 수 있습니다.  
