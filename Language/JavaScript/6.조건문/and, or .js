a = 1;
if(a === 1){
    alert(1);
}

let id = prompt('아이디를 입력해주세요');
if(id === 'egoing'){
    let password = prompt('비밀번호를 입력해주세요.')
    if(password === '123456'){
        alert('로그인 하셨습니다.'+id+'님 반갑습니다.');    
    } else {
        alert('비밀번호가 다릅니다.')
    }
} else{
    alert('아이디가 일치하지 않습니다.');
}


let id = prompt('아이디를 입력해주세요');
let password = prompt('비밀번호를 입력해주세요.');
if(id === 'egoing' && password === '123456'){
    alert('로그인 하셨습니다.'+id+'님 반갑습니다.');    // --> '+id+' = `${id}`
    }   else{
        alert('아이디가 일치하지 않습니다.');
    }


let id = prompt('아이디를 입력해주세요');
if(id === 'egoing' || id === 'k8805' || id === 'sorialgi'){
    alert('인증했습니다.');    
    }   else{
        alert('인증에 실패 했습니다.');
    }



let id = prompt('아이디를 입력해주세요');
let password = prompt('비밀번호를 입력해주세요');
if((id === 'egoing' || id === 'k8805' || id === 'sorialgi') && password === '123456'){
    alert('인증했습니다.');    
    }   else{
        alert('인증에 실패 했습니다.');
    }


let number = prompt('숫자를 입력해주세요.','');
if(number % 2 === 0){
    alert('짝수입니다.');
}   else{
    alert('홀수입니다.');
}    