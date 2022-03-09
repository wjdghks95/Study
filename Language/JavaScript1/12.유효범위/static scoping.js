var i = 5;

function a(){
    var i = 10;
    b();
}

function b(){
    document.write(i);
}

a(); // 5 출력