function func(){
    if(window === this){
        document.write('window === this');
    }
}
func(); // 전역객체(window)에서의 호출


var o = {
    func : function(){
        if(o === this){
            document.write('o === this');
        }
    }
}
func(); // 메소드에서의 호출


var funcThis = null; 
 
function Func(){
    funcThis = this;
}
var o1 = Func();
if(funcThis === window){
    document.write('window <br />');
}
 
var o2 = new Func();
if(funcThis === o2){
    document.write('o2 <br />'); // 생성자 안에서의 호출
}



var o = {}
var p = {}
function func(){
    switch(this){
        case o:
            document.write('o<br />');
            break;
        case p:
            document.write('p<br />');
            break;
        case window:
            document.write('window<br />');
            break;          
    }
}
func();
func.apply(o);
func.apply(p);