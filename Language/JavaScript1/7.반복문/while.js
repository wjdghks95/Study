let i = 0;
while(true){    
    alert(`${i}번째 반복입니다.`);
    i = i + 1;
} // 무한 반복문 (무한루프)

let i = 0;
while(i < 10){    
    alert(`${i}번째 반복입니다.`);
    i = i + 1;
}

let i = 0;
while(confirm('수락하시겠습니까?')){
    alert(`${i}번째 반복입니다.`)
    i = i + 1
}