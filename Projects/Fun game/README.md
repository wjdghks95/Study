# Fun game

### [[Demo]](https://wjdghks95.github.io/Study/Projects/Fun%20game/index.html)

## 개발목표
JavaScript를 기능별로 모듈화하여 미니게임 제작

## 사용기술
HTML, CSS, JavaScript

## Advanced Feature
빌더패턴을 사용하여 함수 호출
``
const game = new gameBuilder()
    .withCarrotCount(3)
    .withBugCount(1)
    .withGameDuration(3)
    .build();
``

## 개선사항
반응형
