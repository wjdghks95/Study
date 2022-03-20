function numbering() {
    console.log(1);
}
numbering();
numbering();
numbering();
numbering();

function numbering() {
    i = 0;
    while(i < 10){
        console.log(i);
        i += 1;
    }
}
numbering();
numbering();
numbering();
numbering();


function numbering() {
    let i = 0;
    while(i < 3){
        console.log(i);
        i += 1;
    }
}
for(let i = 0; i < 3; i++){
    numbering();
}


numbering = function() {
    let i = 0;
    while(i < 10){
        console.log(i);
        i += 1;
    }
}
numbering();


(function (){
    let i = 0;
    while(i < 10){
        console.log(i);
        i += 1;
    }
})();
// 익명함수