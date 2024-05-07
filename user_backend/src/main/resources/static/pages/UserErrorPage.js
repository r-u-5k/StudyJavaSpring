function UserErrorPage() {
    const template = `
        <img src='image/404-error.png' width="540" height="350px" style="margin: 10px" />
        `;
    const pageObject = {
        template: template,
        render: () => {
            document.querySelector("#content").innerHTML = template;
        },
    };
    return pageObject;
}

export {UserErrorPage};