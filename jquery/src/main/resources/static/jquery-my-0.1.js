window.jQuery = function (arg) {
    // jQuery factory함수의 가장 기본적인 동작은 도큐먼트의 일부를 선택하는 것
    if (typeof arg === 'string') {
        // css selector 문자열
        let elementNodeList = document.querySelectorAll(arg);
        let jQueryWrapperObject = {
            elementNodeList: elementNodeList,
            css: function (propertyName, propertyValue) {
                for (let i = 0; i < this.elementNodeList.length; i++) {
                    this.elementNodeList[i].style.cssText = `${propertyName}: ${propertyValue}`;
                }
                return this;
            },
            text: function (textArg) {
                if (textArg != undefined) {
                    for (let i = 0; i < this.elementNodeList.length; i++) {
                        this.elementNodeList[i].innerHTML = textArg;
                    }
                    return this;
                } else {
                    let returnText = '';
                    for (let i = 0; i < this.elementNodeList.length; i++) {
                        returnText += this.elementNodeList[i].innerHTML;
                    }
                    return returnText;
                }
            },
        };
        return jQueryWrapperObject;
    }
};
// jQuery global function
jQuery.each = (array, funcArg) => {
    for (let i = 0; i < array.length; i++) {
        funcArg(i, array[i]);
    }
};

window.$ = window.jQuery;
