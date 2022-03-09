for(let i = 0; i < 10; i++){
    console.log(`${i}번째 반복입니다.`);
}

for(let i = 0; i < 10; i++){
    if(i === 5){
        break;
    }    
    console.log(`${i}번째 반복입니다.`);
}

for(let i = 0; i < 10; i++){
    if(i === 5){
        continue;
    }    
    console.log(`${i}번째 반복입니다.`);
}

for(let i = 0; i < 10; i++){
    for(let j = 0; j < 10; j++){
        console.log(`${i}${j}번째 반복입니다.`);
    }
}

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
console.log(output)