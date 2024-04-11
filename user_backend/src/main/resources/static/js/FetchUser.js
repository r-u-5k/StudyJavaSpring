const BACKEND_SERVER = 'http://localhost:8080';

export const userWriteAction = async (sendJsonObject) => {
	const response = await fetch(`${BACKEND_SERVER}/user`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(sendJsonObject),
	});
	const resultJsonObject = await response.json();
	return resultJsonObject;
};

export const userLoginCheck = async () => {
	const response = await fetch(`${BACKEND_SERVER}/user/login`, {
		method: 'GET'
	});
	const resultJsonObject = await response.json();
	return resultJsonObject;
}

export const userLoginAction = async (sendJsonObject) => {
	const response = await fetch(`${BACKEND_SERVER}/user/login`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(sendJsonObject),
	});
	const resultJsonObject = await response.json();
	return resultJsonObject;
};

export const userLogoutAction = async () => {
	const response = await fetch(`${BACKEND_SERVER}/user/logout`, {
		method: 'GET'
	});
	const resultJsonObject = await response.json();
	return resultJsonObject;
}

export const userView = async (userId) => {
	const response = await fetch(`${BACKEND_SERVER}/user/${userId}`);
	const resultJsonObject = await response.json();
	return resultJsonObject;
};

export const userModifyAction = async (sendJsonObject, userId) => {
	const response = await fetch(`${BACKEND_SERVER}/user/${userId}`, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(sendJsonObject),
	});
	const responseJsonObject = await response.json();
	return responseJsonObject;
};

export const userDeleteAction = async (userId) => {
	const response = await fetch(`${BACKEND_SERVER}/user/${userId}`, {
		method: 'DELETE'
	});
	const responseJsonObject = await response.json();
	return responseJsonObject;
};