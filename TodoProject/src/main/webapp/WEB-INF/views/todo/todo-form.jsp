<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'> -->
<link href="${context}/resources/css/todo/myTodo.css" rel='stylesheet'> 

<!-- <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script> -->

<%-- <script defer src="${context}/resources/js/todo/todo.js"></script> --%>


<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
<section class="">

    <div class="contents row">
        <div class="todo col">
            <div class="clock col">
                <div class="welcome"><span>Welcome!! ${sessionScope.auth.userId }</span></div>
                <div class="time row"><span id="nowTime">14 : 05 : 00</span></div>
            </div>
        </div>
    </div>








  <div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center">
            <div class="col-md-12">
                <div class="card px-3">
                    <div class="card-body">
                        <h4 class="card-title">Awesome Todo list</h4>
                        <form action="/todo/addTodo" method="get">
                     	   <div class="add-items d-flex"> <input id="todo" type="text" name="todo" class="form-control todo-list-input" placeholder="What do you need to do today?"> <button id="btAdd" class="add btn btn-primary font-weight-bold todo-list-add-btn">Add</button> </div>
                 	       <div class="list-wrapper">
                            <ul class="d-flex flex-column-reverse todo-list" id="todoList"> </ul>
           	             </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

	
</section>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<script defer src="${context}/resources/js/todo/myTodo.js"></script>

</body>
</html>