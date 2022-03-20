function Ultra(){}
Ultra.prototype.ultraProp = true;
 
function Super(){}
Super.prototype = new Ultra(); // Ultra 상속
 
function Sub(){}
Sub.prototype = new Super(); // Super 상속
Sub.prototype.ultraProp = 2; // 
 
var o = new Sub();
console.log(o.ultraProp);