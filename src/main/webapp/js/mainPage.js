function sendPost(url, params){
	const form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', url);
	form.setAttribute('contentType', 'application/json');
	for(const key in params){
		const hiddenField = document.createElement('input');
		hiddenField.setAttribute('type', 'hidden');
		hiddenField.setAttribute('name', key);
		hiddenField.setAttribute('value', params[key]);
		form.appendChild(hiddenField);
	}
	document.body.appendChild(form);
	form.submit();
}

function createRoom()
{
	//로그인이 안되어있는경우
		//게스트 번호 조회 -> 없는번호 생성 -> 닉네임으로 지정
		//방만들기에 필요한 정보 전송
	/*do{
		userid = "guest#";
		userid += str(Math.floor(Math.random() * 99999999));
	}while();//DB체크해서 같은거 있는지 보기.*/
	let userid = "guest#";
	userid += String(Math.floor(Math.random() * 99999999));
	alert(userid);
	let url = window.location.protocol + "//" + window.location.host + "/createRoom";
	let params = {'userid':userid}
	sendPost(url, params);
	//window.location.href = window.location.protocol + "//" + window.location.host + "/roomCreate";
 
	 //로그인이 되어있는경우
	 	//아이디 가져오기
	 	//방만들기 필요한 정보 전송
}