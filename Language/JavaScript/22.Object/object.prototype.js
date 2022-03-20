var o = {'name':'egoing', 'age':20, 'city':'seoul'}
Object.keys(o);

var o = {}
o.toString();

var a = [1,2,3];
a.toString();
// Object.prototype.toString




Object.prototype.contain = function(needle){
    for(var name in this){
        if(this[name] === needle){
            return true
        }
    }
    return false
}

var o = {'name':'egoing', 'city':'seoul'}
console.log(o.contain('graphittie'));
var a = ['egoing','leezche','grapittie'];
console.log(a.contain('leezche'));

for(var name in o){
    console.log(name);  
}
for(var name in o){
    if(o.hasOwnProperty(name))
        console.log(name);  
}