import * as responseStatusCode from '../api/responseStatusCode.js';
import * as userApi from '../api/userApi.js';
import { UserErrorPage } from './pages/UserErrorPage.js';
import { UserLeftPage } from './pages/UserLeftPage.js';
import { UserLoginFormPage } from './pages/UserLoginFormPage.js';
import { UserMainPage } from './pages/UserMainPage.js';
import { UserModifyFormPage } from './pages/UserModifyFormPage.js';
import { UserViewPage } from './pages/UserViewPage.js';
import { UserWriteFormPage } from './pages/UserWriteFormPage.js';
import * as responseMessage from '../api/responseMessage.js';

function App() {
    window.addEventListener('hashchange', function () {
        const hash = window.location.hash;
        navigate(hash);
    });
    window.addEventListener('click', function (e) {
        e.target.dataset.navigate ? (location.hash = e.target.dataset.navigate) : '';
    });
    let loginStatus = { status: responseStatusCode.UNAUTHORIZED_USER };
    window.addEventListener('load', async function () {
        let hash = this.window.location.hash;
        hash = hash == null || hash == '' ? '#/user_main' : hash;
        navigate(hash);
        //(await UserLeftPage()).render();
        let loginStatus = await userApi.userLoginCheck();
        console.log('loginStatus:', loginStatus);
    });

    /*********route path *********
     #/user_main
     #/user_write_form
     #/user_login_form
     #/user_view/guard1
     #/user_modify_form/guard1
     **************************/
    let pageObject = {};
    async function navigate(hash) {
        if (loginStatus === responseStatusCode.LOGIN_SUCCESS) {
            hash = (hash === '#/user_write_form' || hash === '#/user_login_form') ? '#/user_main' : hash;
            console.log(hash);
        } else if (loginStatus === responseStatusCode.UNAUTHORIZED_USER) {
            hash = (hash.startsWith('#/user_view') || hash.startsWith('#/user_modify_form')) ? '#/user_main' : hash;
			console.log(hash);
        }
        if (hash == '#/user_main') {
            pageObject = UserMainPage();
            pageObject.render();
        } else if (hash == '#/user_write_form') {
            pageObject = UserWriteFormPage();
            pageObject.render();
        } else if (hash == '#/user_login_form') {
            pageObject = UserLoginFormPage();
            pageObject.render();
        } else if (hash.startsWith('#/user_view')) {
            pageObject = await UserViewPage(hash.substring(hash.lastIndexOf('/') + 1));
            pageObject.render();
        } else if (hash.startsWith('#/user_modify_form')) {
            pageObject = await UserModifyFormPage(hash.substring(hash.lastIndexOf('/') + 1));
            pageObject.render();
        } else {
            pageObject = UserErrorPage();
            pageObject.render();
        }
    }

    const template = ` 
  <!-- header start -->
    <div id="header">
        <!-- include_common_top.jsp start-->
        <h1>
            <a href="#/user_main">회원관리 FRONTEND 2</a>
        </h1>
        <!-- include_common_top.jsp end-->
    </div>
    <!-- header end -->
    <!-- navigation start-->
    <div id="navigation">
      <!-- include_common_left.jsp start-->
      ${(async () => {
          (await UserLeftPage()).render();
      })()}
      <!-- include_common_left.jsp end-->
    </div>
    <!-- navigation end-->
    <!-- wrapper start -->
    <div id="wrapper">
        <!-- content start -->
        <!-- include_content.jsp start-->

        <div id="content">
        
        </div>
        <!-- include_content.jsp end-->
        <!-- content end -->
    </div>
    <!--wrapper end-->
    <div id="footer">
        <!-- include_common_bottom.jsp start-->

        <p align="center">Copyright (&copy;) By Kimkyoungho.[김경호] All
            rights reserved.</p>

        <!-- include_common_bottom.jsp end-->
    </div> 
    `;
    return template;
}

export { App };
