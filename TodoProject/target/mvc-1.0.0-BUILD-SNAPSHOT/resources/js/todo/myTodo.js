/**
 * 
 */
 
 

let addTodo = ev=>{

  if(ev.keyCode==13){
    if(!inp.value) return;

    console.dir(inp.value);


  }
}

inp.addEventListener('keyup', addTodo);