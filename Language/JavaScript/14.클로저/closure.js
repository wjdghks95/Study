function outter(){
    var title = 'coding everybody';  
    function inner(){        
        alert(title);
    }
    inner();
}
outter();


function outter(){
    var title = 'coding everybody';  
    return function(){
        alert(title);
    }
}
var inner = outter();
inner();



