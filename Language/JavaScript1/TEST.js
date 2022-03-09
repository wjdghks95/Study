const inch = prompt('inch를 입력해주세요.','')
let cm = inch * 2.54
alert(`${inch}inch는 ${cm}cm입니다.`)

const input = prompt('원의 반지름을 입력해주세요.','반지름')
let area = 3.14 * input * input
let round = 2 * 3.14 * input
alert(`반지름이 ${input}인 원의 넓이는 ${area}이고 둘레는 ${round}입니다.`)

const input = prompt('달러단위의 금액을 입력해주세요.','')
const dollar = Number(input)
let output = ''
output += `달러: ${dollar}\n`
output += `-> 원화: ${dollar * 1207}`
alert(output)

const input = prompt('금액을 입력해주세요.','금액')
let output = Number(input / 6000)
alert(`국밥 ${output}그릇`)



const a = Number(prompt('첫 번째 숫자', ''))
const b = Number(prompt('두 번째 숫자', ''))

if (a > b){
    alert('첫 번째 숫자가 더 큽니다.')
}   else if (a === b){
    alert('두 숫자가 같습니다.')
}   else{
    alert('두 번째 숫자가 더 큽니다.')
}

const x = Number(prompt('숫자를 입력해주세요.'))
if (x > 10 && x < 28){
    alert('조건에 맞습니다.')
} else {
    alert('조건에 맞지 않습니다.')
}

const a = Number(prompt('숫자를 입력해주세요.',''))
if (a > 0){
    alert('양수 입니다.')
}   else if (a === 0){
    alert('0입니다.')
}   else {
    alert('음수 입니다.')
}

const a = Number(prompt('숫자를 입력해주세요.',''))
if (a % 2 === 0){
    alert('짝수 입니다.')
}   else {
    alert('홀수 입니다.')
}

const a = Number(prompt('월를 입력해주세요.',''))
if (a <= 2 || a == 12){
    alert('겨울 입니다.')
}   else if(a <= 5) {
    alert('봄 입니다.')
}   else if(a <= 8) {
    alert('여름 입니다.')
}   else{
    alert('가을 입니다.')
}

const result = (100 > 200) ? prompt('값을 입력해주세요.','') : confirm('버튼을 클릭해주세요.')
alert(result)

const input = prompt('연도를 입력해 주세요.','')
const year = Number(input)
const e = year % 12

let result
switch (e) {
    case 0 : result = '원숭이'
    break
    case 1 : result = '닭'
    break
    case 2 : result = '개'
    break
    case 3 : result = '돼지'
    break
    case 4 : result = '쥐'
    break
    case 5 : result = '소'
    break
    case 6 : result = '호랑이'
    break
    case 7 : result = '토끼'
    break
    case 8 : result = '용'
    break
    case 9 : result = '뱀'
    break
    case 10 : result = '말'
    break
    case 11 : result = '양'
    break
}
alert(`${year}년도에 태어났다면 ${result}띠 입니다.`)


const input = prompt('년도를 입력해주세요.','')
const year = Number(input)

let 간
let e = year % 10
if(e === 0){간 = '경'}
else if (e === 1){간 = '신'}
else if (e === 2){간 = '임'}
else if (e === 3){간 = '계'}
else if (e === 4){간 = '갑'}
else if (e === 5){간 = '을'}
else if (e === 6){간 = '병'}
else if (e === 7){간 = '정'}
else if (e === 8){간 = '무'}
else if (e === 9){간 = '기'}

let 띠
let tti = year % 12
if(tti === 0){띠 = '신'}
else if (tti === 1){띠 = '유'}
else if (tti === 2){띠 = '술'}
else if (tti === 3){띠 = '해'}
else if (tti === 4){띠 = '자'}
else if (tti === 5){띠 = '축'}
else if (tti === 6){띠 = '인'}
else if (tti === 7){띠 = '묘'}
else if (tti === 8){띠 = '진'}
else if (tti === 9){띠 = '사'}
else if (tti === 10){띠 = '오'}
else if (tti === 11){띠 = '미'}

alert(`${year}년은 ${간}${띠}년 입니다.`)


let output = ''
for(let i = 0; i < 10; i++){
    for(let k = 0; k < 10 - i; k++){
        output += ' '
    }
    for(let j = 0; j < 2 * i + 1; j++){
        output += '*'
    }
    output += '\n'
}



const array = ['사과', '배', '귤', '바나나']

for (const i in array){
    console.log(`${array[i]}`)
}
for (const j of array){
    console.log(j)
}

const array = []
for (let i = 0; i < 3; i++){
    array.push((i + 3) * 3)
}
console.log(array)

let output = 1
for(let i = 1; i <= 100; i++){
    output *= i
}
alert(`1부터 100까지 모두 곱한 값은 ${output}입니다.`)



const multiplyAll = function(a, b){
    let output = 1
    for(let i = a; i <= b; i++){
        output *= i
    }
    return output
}

console.log(multiplyAll(1, 2))
console.log(multiplyAll(1, 3))


const max = function(array){
    let output = array[0]
    for(i of array){
        if(output < i){
            output = i
        }
    }
    return output
}

console.log(max([1, 2, 3, 4]))


const max = function(첫번째요소, ...나머지){
    if(Array.isArray(첫번째요소)){
        let output = 첫번째요소[0]
        for(const 값 of 첫번째요소){
            if(output < 값){
                output = 값
            }
        }
    return output
    } else {
        let output = 첫번째요소
        for(const 값 of 나머지){
            if(output < 값){
                output = 값
            }
        }
    return output        
    }
}

console.log(max([1, 2, 3, 4]))
console.log(max(1, 2, 3, 4))


let number = [273, 25, 75, 52, 103, 32, 57, 24, 76]

number = number.filter((value) => value % 2 === 1)
console.log(number)
number = number.filter((value) => value <= 100)
console.log(number)
number = number.filter((value) => value % 5 === 0)
console.log(number)

const array = ['사과', '배', '귤', '바나나']
array.forEach(function(value, index, array){
    console.log(index)
})




String.prototype.contain = function(data){
    return this.indexOf(data) >= 0
}
Array.prototype.contain = function(data){
    return this.indexOf(data) >= 0
}

