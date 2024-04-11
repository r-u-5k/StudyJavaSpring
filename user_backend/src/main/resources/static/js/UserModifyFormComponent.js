import * as FetchUser from './FetchUser.js';
import * as ResponseStatusCode from "./ResponseStatusCode.js";


export const UserModifyFormComponent = async (userId) => {
	const userModifyAction = async () => {
		if (document.f.password.value == "") {
			alert("비밀번호를 입력하세요.");
			document.f.password.focus();
			return false;
		}
		if (document.f.password2.value == "") {
			alert("비밀번호 확인을 입력하세요.");
			document.f.password2.focus();
			return false;
		}
		if (document.f.name.value == "") {
			alert("이름을 입력하세요.");
			document.f.name.focus();
			return false;
		}
		if (document.f.email.value == "") {
			alert("이메일 주소를 입력하세요.");
			document.f.email.focus();
			return false;
		}
		if (document.f.password.value != f.password2.value) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			document.f.password.focus();
			document.f.password.select();
			return false;
		}
		const sendJsonObject = {
			userId: document.f.userId.value,
			password: document.f.password.value,
			name: document.f.name.value,
			email: document.f.email.value,
		};
		const responseJsonObject = await FetchUser.userModifyAction(sendJsonObject, userId);
		if (responseJsonObject.status == ResponseStatusCode.UPDATE_USER) {
			location.hash = `#/user_view/${userId}`;
		}
	}
	const responseJsonObject = await FetchUser.userView(userId);
	const user = responseJsonObject.data;

	const template = `
    <table border="0" cellpadding="0" cellspacing="0">
        <tbody>
            <tr>
                <td>
                    <!--contents--> <br>
                    <table style="padding-left: 10px" border="0" cellpadding="0"
                        cellspacing="0">
                        <tbody>
                            <tr>
                                <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 -
                                        사용자수정</b></td>
                            </tr>
                        </tbody>
                    </table> <!-- update Form  -->
                    <form name="f" method="post">
                        <input type="hidden" name="userId" value="guard1">
                        <table border="0" cellpadding="0" cellspacing="1" width="590"
                            bgcolor="BBBBBB">
                            <tbody>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">사용자
                                        아이디</td>
                                    <td width="490" bgcolor="ffffff" style="padding-left: 10px"
                                        align="left">${user.userId}</td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호</td>
                                    <td width="490" bgcolor="ffffff" style="padding-left: 10px"
                                        align="left"><input type="password" style="width: 150px"
                                        name="password" value="${user.password}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호
                                        확인</td>
                                    <td width="490" bgcolor="ffffff" style="padding-left: 10px"
                                        align="left"><input type="password" style="width: 150px"
                                        name="password2" value="${user.password}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
                                    <td width="490" bgcolor="ffffff" style="padding-left: 10px"
                                        align="left"><input type="text" style="width: 150px"
                                        name="name" value="${user.name}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">이메일
                                        주소</td>
                                    <td width="490" bgcolor="ffffff" style="padding-left: 10px"
                                        align="left"><input type="text" style="width: 150px"
                                        name="email" value="${user.email}"></td>
                                </tr>
                            </tbody>
                        </table>
                    </form> <br>

                    <table width="590" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                            <tr>
                                <td align="center"><input type="button" id="btn_user_modify" value="수정"> &nbsp;</td>
                            </tr>
                        </tbody>
                    </table>

                </td>
            </tr>
        </tbody>
    </table>
    `;

	document.querySelector('#content').innerHTML = template;
	document.querySelector('#btn_user_modify').onclick = userModifyAction;

};
