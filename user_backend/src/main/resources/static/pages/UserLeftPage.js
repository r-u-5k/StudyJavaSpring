import * as userApi from '../api/userApi.js';
import * as responseStatusCode from '../api/responseStatusCode.js';

const UserLeftPage = async () => {
    /******로그아웃함수 ***********/
    const userLogoutAction = async (e) => {
        console.log('>>>>>>>>>>>');
        const responseJsonObject = await userApi.userLogoutAction();
        //page reloading
        location.replace('index.html');
        e.preventDefault();
    };

    const responseJsonObject = await userApi.userLoginCheck();
    const loginUser = responseJsonObject.status == responseStatusCode.LOGIN_SUCCESS ? responseJsonObject.data : {};
    const template = ` 
		    <p>
		      <strong>메뉴</strong>
		    </p>
		    <ul>
			${
                responseJsonObject.status == responseStatusCode.LOGIN_SUCCESS
                    ? `
			<!-- 로그인후 -->
			<li><a href="#/user_view/${loginUser.userId}">${loginUser.userId}님</a></li>
			<li><a href="#/user_view/${loginUser.userId}">내정보</a></li>
			<li><a href="#" id="a_user_logout">로그아웃</a></li>
		    `
                    : `
			<!-- 로그인전 -->
			<li><a href="#/user_login_form">로그인</a></li>
			<li><a href="#/user_write_form">회원가입</a></li>
			`
            }
		   <li><a href='http://192.168.15.31:8080/swagger-ui/index.html' target='_blank'>Swagger</a></li>
		</ul>`;
    const pageObject = {
        template: template,
        render: () => {
            document.querySelector('#navigation').innerHTML = template;
            if (responseJsonObject.status == responseStatusCode.LOGIN_SUCCESS) {
                document.querySelector('#a_user_logout').addEventListener('click', userLogoutAction);
            }
        },
    };
    return pageObject;
};
export { UserLeftPage };
