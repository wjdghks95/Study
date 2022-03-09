const dog = {
    name: '구름',
    age: 7,
    color: '갈색'
}

console.log(dog.name)
console.log(dog.age)
console.log(dog.color)

console.log(dog.status)

//과거(1)
dog.status = dog.status !== undefined ? dog.status : '이상없음'
dog.status = dog.status === undefined ? '이상없음' : dog.status

//과거(2)
dog.status = dog.status ? dog.status : '이상없음'

//과거(3)
dog.status = dog.status || '이상 없음'

//현대(1)
const newDog = {
    status : '이상없음'
    ...dog
}

//현대(2)
const test = function({
    name, 
    age, 
    color, 
    status = '이상 없음'
}) {
    return `${name} : ${age} : ${color} : ${status}`
}

console.log(test({
    name: '구름',
    age: 7,
    color : '갈색'
}))


//참고
const test = function(object) {
    const { name, age, color, status } = {status: '이상 없음, ...object'}
    return `${name} : ${age} : ${color} : ${status}`
}

console.log(test({
    name: '구름',
    age: 7,
    color : '갈색'
}))