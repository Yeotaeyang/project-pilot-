let $ = function(cssSelector, message){
    let htmlElements = this.document.querySelectorAll(cssSelector);

    if(message){
        htmlElements.forEach(e => {e.innerHTML += message + '<br>'});
    }

    if(htmlElements.length == 1) return htmlElements[0];
    return htmlElements;
}


let createElement = (tag, props) => {
    let res = document.createElement(tag);

    if(!props) return res;

    for(key in props.prop){
        res[key] = props.prop[key];
    }

    for(key in props.style){
        res.style[key] = props.style[key];
    }

    if(props.text){
        let textNode = document.createTextNode(props.text);
        res.appendChild(textNode);
    }

    return res;
}

let getElementIndex = element => {
    let eIdx = 0;
    let parent = element.parentElement;
    let sibeling = Array.prototype.slice.call(parent.children);
    
    sibeling.forEach((e,i)=>{
        if(e === element){
            eIdx = i;
        }
    })

    return eIdx;
}

let getQueryString = params => {
    let tmp = [];

    for(key in params){
        tmp.push(`${key}=${params[key]}`);
    }

    return tmp.join('&');
}

let findFromLocalStorage = key => {
    return JSON.parse(localStorage.getItem(key));
}

let setToLocalStorage = (key,data) => {
    localStorage.setItem(key, JSON.stringify(data));
}

let findFromSessionStorage = key => {
    return JSON.parse(sessionStorage.getItem(key));
}

let setToSessionStorage = (key,data) => {
    sessionStorage.setItem(key, JSON.stringify(data));
}

let dataToATagWithPost = (url,data)=>{
    let form = createElement('form', {});
    console.dir("deleteTodo");
    form.action = url;
    form.method='post';
    let input = document.createElement("input");
    input.setAttribute("type","hidden");
    input.setAttribute('name', "todo");
    input.setAttribute('id', "todo");
    input.setAttribute("value", data);
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();

}
