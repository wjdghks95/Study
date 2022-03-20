const sum = function(limit){
    let output = 0
    for(let i = 0; i < limit; i++){
        output += i
    }
    return output
}
console.log(`합은 ${sum(30)}`)
console.log(`합은 ${sum(50)}`)
console.log(`합은 ${sum(100)}`)