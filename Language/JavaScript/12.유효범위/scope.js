let vscope = 'global';
function fscope(){
    let vscope = 'local'
    alert(vscope)
}

fscope(); // 함수 안에 있는 local 호출
alert(vscope); // 함수 밖에 있는 global 호출

let vscope = 'global';
function fscope(){
    vscope = 'local'
    alert(vscope)
}

fscope(); // local 호출
alert(vscope); // local 호출


function a(){
    i = 0; // 전역변수
}
for(let i = 0; i < 5; i++){   // 전역변수 i = 0 으로 인해 무한루프 발생
    a();
    console.log(i);
}

function a(){
    let i = 0; // 지역변수
}
for(let i = 0; i < 5; i++){   // 0, 1, 2, 3, 4 출력
    a();
    console.log(i);
}