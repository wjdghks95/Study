var persom = {
    'name' : 'egoing',
    'intrduce' : function(){
        return 'My name is' +this.name;
    }
}

function person(){}
var p = new person();
p.name = 'egoing'
p.introduce = function(){
    return 'My name is' +this.name;
}
document.write(p.introduce())


function Person(name){
    this.name = name;
    this.introduce = function(){
        return 'My name is '+this.name; 
    }   
}
var p1 = new Person('egoing');
document.write(p1.introduce()+"<br />");
 
var p2 = new Person('leezche');
document.write(p2.introduce());