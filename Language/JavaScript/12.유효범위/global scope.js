MYAPP = {}  //  객체 전역변수
MYAPP.calculator = {
    'left' : null,
    'right' : null
}
MYAPP.coordinate = {
    'left' : null,
    'right' : null
}
 
MYAPP.calculator.left = 10;    //  객체 속성 관리
MYAPP.calculator.right = 20;   //  객체 속성 관리
function sum(){
    return MYAPP.calculator.left + MYAPP.calculator.right;
}
document.write(sum());


(function(){
    var MYAPP = {}
    MYAPP.calculator = {
        'left' : null,
        'right' : null
    }
    MYAPP.coordinate = {
        'left' : null,
        'right' : null
    }
    MYAPP.calculator.left = 10;
    MYAPP.calculator.right = 20;
    function sum(){
        return MYAPP.calculator.left + MYAPP.calculator.right;
    }
    document.write(sum());
}())   // 익명 함수 호출