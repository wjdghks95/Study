function get_members(){
    return ['egoing', 'k8805', 'sorialgi']
}
let members = get_members();

members[0].toUpperCase();
members[1].toUpperCase();
members[2].toUpperCase();

alert(members.length);


function get_members2(){
    return ['egoing', 'k8805', 'sorialgi'];
}
let member = get_members2();

for(let i = 0; i < member.length; i++){
    alert(member[i].toUpperCase());
}