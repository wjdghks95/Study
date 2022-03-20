const 테스트 = function(콜백함수){
    콜백함수(10)
}
const 함수 = function(콜백함수의_매개변수){
    console.log(`${콜백함수의_매개변수}번째 안녕하세요`)
}
테스트(함수)


let number = [20, 10 , 9, 15, 7, 6, 17, 4, 3, 2, 1];
let sortfunc = function(a, b){
    console.log(a, b);
    if(a > b){
        return 1;
    } else if (a < b){
        return -1;
    } else {
        return 0;
    }
}
console.log(number.sort(sortfunc));


let number = [20, 10 , 9, 8, 7, 6, 5, 4, 3, 2, 1];
let sortfunc = function(a, b){
    return a - b;
}
console.log(number.sort(sortfunc));
