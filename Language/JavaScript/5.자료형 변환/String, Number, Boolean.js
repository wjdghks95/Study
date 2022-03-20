prompt('message','') // 문자열 입력
confirm('수락하시겠습니까?') //불 입력

const a = prompt('숫자를 입력해주세요','')
console.log(a)

const b = confirm('수락하시겠습니까?')
console.log(b)


Number('555') // 555
Number('안녕') // NaN
Number(true) // 1
Number(false) // 0

String(555) //'555'
String(true) // 'true'

Boolean('안녕') // true
Boolean('123') // true
Boolean(0) // false
