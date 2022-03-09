const 배열 = [273, 52, 103, 32, 57]
배열.forEach(function(value, index){
    console.log(`${index}번째의 값은${value}`)
})

let 배열 = [273, 52, 103, 32, 57]
배열 = 배열.filter(function(value, index){
    return value % 2 === 0
})
console.log(배열)

let 배열 = [273, 52, 103, 32, 57]
배열 = 배열.map(function(value, index){
    return value + "!!"
})
console.log(배열)


let 배열 = [273, 52, 103, 32, 57]
배열 = 배열.filter((value, index) => {
    return value % 2 === 0
})
console.log(배열)

let 배열 = [273, 52, 103, 32, 57]
배열 = 배열.filter((value, index) => value % 2 === 0)
console.log(배열)


