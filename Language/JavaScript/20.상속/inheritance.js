function Person(name){
    this.name = name;
    this.introduce = function(){
        return 'My name is '+this.name; 
    }   
}
var p1 = new Person('egoing');
document.write(p1.introduce()+"<br />");
//↓

function Person(name){
    this.name = name;
}
Person.prototype.name = null;
Person.prototype.introduce = function(){
    return 'My name is '+this.name; 
}

function Programmer(name){
    this.name = name;
}
Programmer.prototype = new Person(); // person의 기능 상속
Programmer.prototype.coding = function(){
    return 'hello world'
}

function Designer(name){
    this.name = name;
}
Designer.prototype = new Person(); // person의 기능 상속
Designer.prototype.design = function(){
    return 'beautiful!'
}


var p1 = new Programmer('egoing');
document.write(p1.introduce()+'<br />');
document.write(p1.coding()+'<br />');

var p2 = new Designer('leezche');
document.write(p2.introduce()+'<br />');
document.write(p2.design()+'<br />');