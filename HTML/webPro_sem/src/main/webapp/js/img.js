/**
 * 
 */
let a = "";
function appendImg(){
	a = setInterval(function(){
	  $('#d1').append($('#d1 img').first());
	},1000);
	
	//버튼 감추기 또는 비활성화
	$('#btn1').hide();
//	$('#btn1').prop('disabled',true);
}
function stopImg(){
	clearInterval(a);

	//버튼 나타내기 또는 활성화
	$('#btn1').show();
//	$('#btn1').prop('disabled',false);
}