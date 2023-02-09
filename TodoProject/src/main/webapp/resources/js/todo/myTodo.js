/**
 * 
 */
 
let todoList;

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
   
    console.dir("버튼누름");
    if(!todo.value) return;
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

let renderTodo = ()=>{
  
  $('.todo-list').innerHTML="";
  let todos = JSON.parse(localStorage.getItem('todo'));
  if(!todos) return;
  todos = JSON.parse(localStorage.getItem('todo'))[0];
    createItems(todos);


}


let createItems = (todos)=>{

  todos.items.forEach((e,i)=>{
      let item = createElement('li', {prop:{className:'item', innerText:`${e}`}});
      let div = createElement('div',{prop:{className:'form-check'}})
      let label = createElement('label',{prop:{className:'form-check-label'}})
      let input = createElement('input',{prop:{className:'checkbox',type:'checkbox'}})
      let ihelper = createElement('i',{prop:{className:'input-helper'}})
      let iremove = createElement('i',{prop:{className:'remove mdi mdi-close-circle-outline'}})
     
      
      item.prepend(div);
      div.prepend(label);
      label.prepend(ihelper);
      label.prepend(input);
      item.append(iremove)
      input.addEventListener('click',ev=>{
        if(item.className!='completed') item.className='completed';
        else item.className='item';

      })

      iremove.addEventListener('click',ev=>{
        todos.items.splice(i,1);
        let todo = [{items:todos.items}];
        localStorage.setItem('todo', JSON.stringify(todo));
        renderTodo();
       
      })

      $('.todo-list').append(item);
  })
  
}

renderTodo();
todo.addEventListener('keyup', addTodo);
btAdd.addEventListener('click',addTodoBybutton);
// todoList.innerHTML = '';