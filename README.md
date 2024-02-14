## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

PS. fork 후 commit history 추적이 어려워 clone으로 진행

2024/02/05 ~ 2024/02/09 : </br>
학습 테스트 및 기본 연산자 테스트 </br></br>
2024/02/13 : </br>
문자열 계산기 연산자 문자로 하드코딩, static 메서드를 이용하여 Util 클래스로 구현</br></br>
2024/02/14 : </br>
1. Util 클래스는 절차 지향적 개념 > 문자열 계산기 객체화 및 캡슐화.</br>
2. 문자열로 된 연산자 Enum으로 변경 및 추상 메서드 이용하여 각 연산자별 연산 메서드 구현
