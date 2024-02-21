<%@page contentType="text/html; charset=UTF-8" %>
<%
String name = "김경호";
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		/*
		 함수정의
		   - 윈도객체에소속된 함수가된다.
		 */
		let name = 'block scope <%=name%>';
		let msg = 'block scope msg';
		function head_function() {
			window.document.write('head_function() ' + msg + '<br>');
			return;
		}
		function hello1() {
			let name = "local scope name";
			let msg = "local scope msg";
			document.write(name + " " + msg + '[hello1()]<br>');
		}
		/* function argument */
		function hello2(msg) {
			/*
			메서드 파라미터 선언 시 let 키워드를 사용하지 않음
			*/
			document.write(name + "(전역) " + msg + "(지역) [hello2(msg)]<br>")
		}
		function hello3(name, msg) {
			document.write(name + "(지역) " + msg + "(지역) [hello3(name, msg)]<br>")
		}
		function hello4(name, msg, count) {
			if (count == undefined) {
				count = 1;
			}
			for (let i = 0; i < count; i++) {
				document.write(name + "님 " + msg + " [hello4(name, msg, count)]<br>")
			}
		}
		
		/* function return */
		function add(a, b) {
			return a + b;
		}
		function sub(a, b) {
			return a - b;
		}
		function mul(a, b) {
			return a * b;
		}
		function div(a, b) {
			return a / b;
		}
		
		function alert(msg) { // 재정의
			document.write("<i>내가 만든 경고: ", msg, "</i>");
		}
		
	</script>

</head>

<body>
	<h1>자바스크립트함수</h1>
	<hr>
	<div>함수기반언어이다</div>
	<script type="text/javascript">
		//함수호출
		window.head_function();
		head_function();
		hello1();
		hello2("뭐하세요");
		hello2("안녕하세요");
		hello3("이효리", "머함");
		hello4("이소라", "ㅎㅇ", 10);
		hello4("김태희", "비"); // count가 undefined
		let result = add(1, 2);
		document.write('add(1, 2): ', result, "<br>");
		document.write('sub(1, 2): ', sub(1, 2), "<br>");
		document.write('mul(1, 2): ', mul(1, 2), "<br>");
		document.write('div(1, 2): ', div(1, 2), "<br>");
		window.alert("경고 메세지");
	</script>

	<script type="text/javascript">
		function body_end_function() {
			document.write("body_end_function()<br>");
		}
	</script>
</body>

</html>