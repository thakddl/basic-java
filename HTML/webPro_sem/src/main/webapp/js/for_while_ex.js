/**
 * 
 */
//1부터 10까지의 합
function proc1(){
  let sum = 0;
  for(i=0; i<=10; i++){
	sum += i;
  }
  document.getElementById('d1').textContent = sum;
}

//1부터 200까지 짝수의 합
proc2=function(){
  let sum = 0;
  //방식1
  /*
  for(i=2; i<=200; i+=2){
	sum += i;
  }
  */
  //방식2
  /*
  for(i=1; i<=200; i++){
	if(i%2==0) sum += i;
  }
  */
  //방식3
  for(i=1; i<=200; i++){
	if(i%2!=0) continue;
	sum += i;
  }
  document.getElementById('d2').textContent = sum;
}

//입력 값을 더하고 0입력시 출력
function proc3(){
	
	let sum = 0;
	let str = "";
	while(true){
		let a = parseInt(prompt("값을 입력하세용"));
		if(a==0) break;
		sum += a;
		str += a + " ";
	}
	let rst = `입력한 값 : ${str} <br>`;
	rst += `합 : ${sum}`;
	document.getElementById('d3').innerHTML = rst;
}

//각각 1~10까지 더한 합이 3의 배수인 값
function proc4(){
	let rst = "";
	for(i=1; i<=10; i++){
		for(j=1; j<=10; j++){
			if((i+j)%3!=0) continue;
			rst += `${i} + ${j} = ${i+j} <br>`;
		}
	}
	document.getElementById('d4').innerHTML = rst;
}

//1~100까지 2와 3의 배수인 값
proc5=function(){
	let rst = "";
	for(i=1; i<=100; i++){
		if(i%2==0 && i%3==0) rst += i + " ";
	}
	document.getElementById('d5').innerHTML = rst;
}

//두수의 합이 100이상 일 때 출력
function proc6(){
	let str1 = "두수의 합이 100이하인 값 들 <br>";
	let str2 = `두수의 합이 100이상인 값 들 <br>`;
	while(true){
		let a = parseInt(prompt("첫번째 수 입력"));
		let b = parseInt(prompt("두번째 수 입력"));
		
		if(a==0 && b==0) break;
		
		let sum = a + b;
		if(sum < 100){
			str1 += a + " + " + b + " = " + (a+b) + "<br>";
			continue;
		}
		str2 += `${a} + ${b} = ${a+b} <br>`;
	}
	document.getElementById('d6').innerHTML = str1;
	document.getElementById('d6').innerHTML += str2;
	
}






















