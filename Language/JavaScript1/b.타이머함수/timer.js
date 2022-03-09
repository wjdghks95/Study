setTimeout() // 특정한 시간 후에 한 번
setInterval() // 특정한 시간마다

const a = setTimeout(function(){
    console.log('setTimeout 함수입니다.')
}, 1000)

const b = setInterval(function(){
    console.log('setTimeout 함수입니다.')
}, 1000);

console.log(a, b)

clearTimeout(a)
clearInterval(b)


