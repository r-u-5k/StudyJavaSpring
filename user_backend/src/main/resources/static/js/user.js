import { UserMainComponent } from './UserMainComponent.js';
import { UserViewComponent } from './UserViewComponent.js';
import { UserWriteFormComponent } from './UserWriteFormComponent.js';
import { UserModifyFormComponent } from './UserModifyFormComponent.js';
import { UserLoginFormComponent } from './UserLoginFormComponent.js';
import { UserLeftMenuComponent } from './UserLeftMenuComponent.js';

/********* path *********
#/user_login_form
#/user_write_form
#/user_logout_action
#/user_view
#/user_main
#/user_write_action
#/user_login_action
#/user_modify_form
#/user_delete_action
**************************/

const navigate = (hash) => {
	if (hash == '#/user_main') {
		UserMainComponent();
	} else if (hash == '#/user_write_form') {
		UserWriteFormComponent();
	} else if (hash == '#/user_login_form') {
		UserLoginFormComponent();
	} else if (hash.startsWith('#/user_view')) {
		UserViewComponent(hash.substring(hash.lastIndexOf('/') + 1));
	} else if (hash.startsWith('#/user_modify_form')) {
		UserModifyFormComponent(hash.substring(hash.lastIndexOf('/') + 1));
	}
};

window.addEventListener('hashchange', () => {
	const hash = window.location.hash;
	navigate(hash);
});

window.addEventListener('click', (e) => {
	if (e.target.matches('[data-navigate]')) {
		location.hash = e.target.dataset.navigate;
	}
});

window.addEventListener('load', () => {
	let hash = window.location.hash;
	if (hash == null || hash == '') {
		hash = '#/user_main';
	}
	navigate(hash);
	UserLeftMenuComponent();
});
