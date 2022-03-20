const 함수 = function(a, b, c){
    console.log(a, b, c)
}

const a = [1, 2, 3]
함수(a[0], a[1], a[2])
함수(...a)

// 전개 연산자