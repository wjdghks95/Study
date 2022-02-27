# Megabox_site

### [[Demo]](https://wjdghks95.github.io/Study/Projects/Megabox%20site/index.html)

## 개발목표
메가박스 클론사이트 제작

## 사용기술
HTML, CSS, JavaScript

## Advanced Feature
Youtube API를 이용한 동영상 재생
```
// YouTube API를 이용해 iframe을 생성
function setPlayer(id) {
    player.obj = new YT.Player("trailer", {
        width: 480,
        height: 282,
        videoId: id,
        playerVars: player.query
    });

    // 처음 플레이어 크기 설정
    resizePlayer();

    // 리사이즈 화면 회전 시 플레이어 크기 재설정
    $(window).on('resize orientationchange', () => {
        resizePlayer();
    });
};
```

## 개선사항
배너 슬라이드 pagination 버튼 활성화
