
 <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width">
  <link href="${context}/resources/css/todo/calendar.css" rel="stylesheet"> 
  <!--  link rel="stylesheet" href="assets/styles/index.css"-->
  <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
  
<script defer src="/resources/js/todo/calendarDate.js"></script>
<script defer src="/resources/js/todo/calendarMove.js"></script>
<script defer src="/resources/js/todo/calendarTodo.js"></script>
<script defer src="/resources/js/todo/calendarCheck.js"></script>

  
</head>
<body>

  <div class="main">
    <div class="content-wrap">
      <div class="content-left">
        <div class="main-wrap">
          <div id="main-day" class="main-day"></div>
          <div id="main-date" class="main-date"></div>
        </div>
        <div class="todo-wrap">
          <div class="todo-title">Todo List</div>
          <div class="input-wrap">
            <input type="text" placeholder="please write here!!" id="input-box" class="input-box">
            <button type="button" id="input-data" class="input-data">INPUT</button>
            <div id="input-list" class="input-list"></div>
          </div>
        </div>
      </div>
      <div class="content-right">
        <table id="calendar" align="center">
          <thead>
            <tr class="btn-wrap clearfix">
              <td>
                <label id="prev">
                    &#60;
                </label>
              </td>
              <td align="center" id="current-year-month" colspan="5"></td>
              <td>
                <label id="next">
                    &#62;
                </label>
              </td>
            </tr>
            <tr>
                <td class = "sun" align="center">Sun</td>
                <td align="center">Mon</td>
                <td align="center">Tue</td>
                <td align="center">Wed</td>
                <td align="center">Thu</td>
                <td align="center">Fri</td>
                <td class= "sat" align="center">Sat</td>
              </tr>
          </thead>
          <tbody id="calendar-body" class="calendar-body"></tbody>
        </table>
        <%-- 날짜 정보 넘기기 --%>
        <form action="/todo/calendarTodo" method="post">
          userId: <input type="text" name="userId" />
          regDate: <input type="text" name="regDate" />
          <button type="submit">전송</button>
        </form>


      </div>
    </div>
  </div>
</body>
</html>