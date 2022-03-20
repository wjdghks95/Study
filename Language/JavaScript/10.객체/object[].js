const grades = {'egoing':10, 'k8805':6, 'sorialgi':80};

grades['egoing'];
grades['k88' + '05'];
grades['sorialgi'];

grades.egoing;
grades.egoing = 20;


//속성(property)
//메서드(method)
const dog = {
    name : '구름', 
    age : 7, 
    bark : function(){
        console.log(`${this.name}이/가 짖습니다.`)
    },
    sleep : () => {
        console.log(`${dog.name}이/가 잡니다.`) // this x
    } 
}
dog.bark()
dog.sleep()


const pet = {
    name : '구름',
    age : 8
} // 정적으로 생성
pet.color = 'brown' // 동적으로 생성

delet pet.color // 동적으로 제거