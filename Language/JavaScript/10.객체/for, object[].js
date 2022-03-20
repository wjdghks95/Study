const grades = {'egoing':10, 'k8805':6, 'sorialgi':80};

for(let key in grades){
    console.log(`key : ${key}, value : ${grades[key]}`)
}


// 객체지향
const grades = {
    'list' : {'egoing' : 10, 'k8805' : 8, 'sorialgi' : 80},
    'show' : function(){
        for(let name in this.list){
            console.log(name, this.list[name]);
        }
    }
}
grades.show();