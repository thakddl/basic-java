/**
 * 
 */
function proc1(){
	//리터럴 방식으로 배열 생성
	let fruit = ["딸기","수박",100, 12.55,"복숭아",true];
	
	print(fruit, "d1");
}

proc2=function(){
	let fruit = new Array("참외","바나나","망고");
	
	print(fruit, "d2");
}

proc3=function(){
	let fruit = new Array();
	fruit[0] = "자두";
	fruit[1] = "배";
	fruit[2] = "파인애플";
	fruit[3] = "샤인머스캣";
	fruit[4] = "포도";
	
	print(fruit, "d3");
}

//중복코드를 함수로 만들어 사용
function print(f,d){
	let str = "";
	for(i=0; i<f.length; i++){
		str += f[i] + " ";
	}
	document.getElementById(d).innerText = str;	
}



