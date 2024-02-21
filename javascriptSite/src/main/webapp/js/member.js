
	function join_form_validation_submit_button() {
		/*
		DOM Tree에있는 form엘레멘트객체에 접근하는방법
			1. window.document.form태그의name속성값
			   ex> window.document.joinForm
			2. window.document.forms배열객체[index]
			   ex> window.document.forms[0]
			3. document객체의 getElementById()메쏘드를 사용해서 form객체검색
			   ex> document.getElementById("form태그id속성값");
				 - HTML Tag
					 <form id='joinForm'>
					 </form>
					 (엘레멘트의 아이디는 HTML파일안에서 유일해야됩니다.)
				 - javascript
					  let joinFormObject = document.getElementById('joinForm');
					 (DOM Tree에서 id가 joinForm인 엘레멘트객체를반환) 
			   
		form객체안에있는 input엘레멘트객체접근방법
			1.form객체.input태그의이름
			   ex> window.document.joinForm.id
		*/
		let joinForm = document.getElementById("joinForm");
		if (joinForm.id.value == null || joinForm.id.value == '') {
			alert('아이디를 입력하세요');
			document.joinForm.id.focus();
			return false;
		}
		if (joinForm.password.value == null || joinForm.password.value == '') {
			alert('패스워드를 입력하세요');
			document.joinForm.password.focus();
			return false;
		}
		if (joinForm.repassword.value == null || joinForm.repassword.value == '') {
			alert('패스워드 확인을 입력하세요');
			document.joinForm.repassword.focus();
			return false;
		}
		if (!isSame(joinForm.password.value, joinForm.repassword.value)) {
			alert('패스워드와 패스워드 확인이 일치하지 않습니다');
			document.joinForm.password.select();
			return false;
		}
		if (joinForm.name.value == null || joinForm.name.value == '') {
			alert('이름을 입력하세요');
			document.joinForm.name.focus();
			return false;
		}
		if (joinForm.address.value == null || joinForm.address.value == '') {
			alert('주소를 입력하세요');
			document.joinForm.address.focus();
			return false;
		}
		
		/*
		1.아이디는 5~10자여야한다
		2.영문알파벳대문자,소문자,숫자만 가능
		3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
		*/
		return true;
	}
	

	function join_form_validation_button() {
		// validation
		if (!join_form_validation_submit_button()) {
			return;
		}
		document.joinForm.submit();
		/*
		1.아이디는 5~10자여야한다
		2.영문알파벳대문자,소문자,숫자만 가능
		3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
		*/
		
	}