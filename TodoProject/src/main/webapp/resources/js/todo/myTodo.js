/**
 * 
 */
 
let todoList;

// todoItem 관련
let addTodo = ev=>{
  
  if(ev.keyCode==13){
    if(!inp.value) return;

    let localTodo = JSON.parse(localStorage.getItem('todo'));
    if(!localTodo){
      let localItemTodo = [{items:[todo.value]}];
      localStorage.setItem('todo', JSON.stringify(localItemTodo));
      // todo.value = '';
      renderTodo();
      return;
    }
    localTodo[0].items.push(todo.value);
    localStorage.setItem('todo', JSON.stringify(localTodo));
   // todo.value="";
    renderTodo();

  }
}

let addTodoBybutton = ev=>{

    ev.preventDefault();
    
    console.dir(new FormData(document.querySelector('#test123')));
    var testForm = new FormData(document.querySelector('#test123'));
    asyncAddTodo(testForm.get('todo'));
    console.dir(testForm.get('todo'));
   
    if(!todo.value) return;
    let localTodo = JSON.parse(localStorage.getItem('todo'));
    if(!localTodo){
      let localItemTodo = [{items:[todo.value]}];
      localStorage.setItem('todo', JSON.stringify(localItemTodo));
      todo.value = '';
      renderTodo();
      return;
    }
    localTodo[0].items.push(todo.value);
    localStorage.setItem('todo', JSON.stringify(localTodo));
    todo.value="";

    renderTodo();

}


let createItems = (todos)=>{

  todos.items.forEach((e,i)=>{
      let item = createElement('li', {prop:{className:'item', innerText:`${e}`,id:`${e}`}});
      let div = createElement('div',{prop:{className:'form-check'}})
      let label = createElement('label',{prop:{className:'form-check-label'}})
      let input = createElement('input',{prop:{className:'checkbox',type:'checkbox'}})
      let ihelper = createElement('i',{prop:{className:'input-helper'}})
      let iremove = createElement('a',{prop:{className:'remove mdi mdi-close-circle-outline',}})
      iremove.href="#";     
      
      item.prepend(div);
      div.prepend(label);
      label.prepend(ihelper);
      label.prepend(input);
      item.append(iremove)
      input.addEventListener('click',ev=>{
        if(item.className!='completed') item.className='completed';
        else item.className='item';

      })
      
 //     console.dir(iremove.parentElement.innerText);
      iremove.addEventListener('click',ev=>{
        console.dir(iremove.parentElement.innerText);
        // dataToATagWithPost('/todo/deleteTodo',iremove.parentElement.innerText);
        asyncDelTodo(iremove.parentElement.innerText);



        todos.items.splice(i,1);
        let todo = [{items:todos.items}];
        localStorage.setItem('todo', JSON.stringify(todo));
        renderTodo();
       
      })
      

      $('.todo-list').append(item);
  })
  
}

async function asyncDelTodo(item){
  
  let url = "http://localhost:8081/todo/deleteTodo";
  let data = {todo:item};
  console.dir(JSON.stringify(data));
  const response = await fetch(url,{
    method:'post',
    headers:{'Content-Type': 'application/json'},
    body: JSON.stringify(data)
  })
  // .then((response) => response.json())
  // .then((data) => {
  //   console.log('Success:', data);
  // })
  // .catch((error) => {
  //   console.error('Error:', error);
  // });
  // console.dir(response.json());
}

async function asyncAddTodo(item){
  
  let url = "http://localhost:8081/todo/addTodo";
  let data = {todo:item};
  console.dir(JSON.stringify(data));
  const response = await fetch(url,{
    method:'post',
    headers:{'Content-Type': 'application/json'},
    body: JSON.stringify(data)
  })
}




// 화면에 뿌려지는것 -> 여기서 DB에서 받아서 뿌려야함 그것을 비동기로 해야할 듯함
let renderTodo = ()=>{
  
  $('.todo-list').innerHTML="";
  let todos = JSON.parse(localStorage.getItem('todo'));
  if(!todos) return;
  todos = JSON.parse(localStorage.getItem('todo'))[0];
    createItems(todos);


}


// 시간 지나가는것
let renderTime = () => {

  setInterval(() => {

      let now = new Date();
      let hour = now.getHours();
      let minute = now.getMinutes();
      let second = now.getSeconds();

      hour = hour > 9 ? hour:'0'+hour;
      minute = minute > 9 ? minute:'0'+minute;
      second = second > 9 ? second:'0'+second;

      let timeText = `${hour} : ${minute} : ${second}`;
      nowTime.innerHTML = timeText;

  }, 1000);
}

renderTime();
renderTodo();
todo.addEventListener('keyup', addTodo);
btAdd.addEventListener('click',addTodoBybutton);
// todoList.innerHTML = '';