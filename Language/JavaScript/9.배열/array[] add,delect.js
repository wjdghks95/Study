const li = ['a', 'b', 'c', 'd', 'e'];

li.push('f') // 배열 뒷부분에 요소 추가
li.concat('f', 'g') // 배열 뒷부분에 요소 추가 -> 리턴
li.unshift('z') // 배열 앞부분에 요소 추가
li.splice('1, 0, 'splice')
//  (index, howmany 제거, 요소추가)
li.unshift() // 배열 첫번째 요소 제거
li.pop() // 배열 끝점 요소 제거
li.sort() // 배열 정렬
li.reverse() // 배열 역순 정렬