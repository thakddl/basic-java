/**
 * 
 */
/*유효성검증 결과 표현 메소드*/
function okProc(ele){
	let vs = $(ele).parents('.form-group').find('.sp');
	$(vs).empty();
	$('<img>',{
		'src' : '../images/check.png',
		'width' : '25px',
		'height' : '25px'
	}).appendTo(vs);
}
function noProc(ele, str){
	let vs = $(ele).parents('.form-group').find('.sp');
	$(vs).html(str).css('color','red');
//	$(ele).attr('autofocus', true);
}