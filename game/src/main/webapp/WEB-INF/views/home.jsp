<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Number Guess Game</title>
    <jsp:include page="bootstrap-header.jsp"/>
</head>
<body>
<p/>
<div class="container" role="main">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Game Console</h3>
        </div>
        <div class="panel-body">
            <c:url var="actionUrl" value="/action/play"/>
            <form action="${actionUrl}" method="post">
                <div class="form-group">
                    <label for="guess">Guess</label>
                    <input type="text"
                           class="form-control"
                           id="guess"
                           value="${param.guess}"
                           name="guess"/>
                    <button class="btn btn-success">Play</button>
                </div>
                <c:if test="${not empty console.errorMessage}">
                    <div class="form-group">
                        <span class="alert alert-danger">${console.errorMessage}</span>
                    </div>
                </c:if>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Game Statistics</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                <tr>
                    <th>Guess</th>
                    <th>Message</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${game.moves}" var="move">
                    <tr>
                        <td>${move.guess}</td>
                        <td>${move.message}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="form-group">
                <label for="wins">Wins</label>
                <span id="wins" class="badge">${statistics.wins}</span>
            </div>
            <div class="form-group">
                <label for="loses">Loses</label>
                <span id="loses" class="badge">${statistics.loses}</span>
            </div>
            <div class="form-group">
                <label for="total">Total</label>
                <span id="total" class="badge">${statistics.total}</span>
            </div>
            <div class="form-group">
                <label for="avgMoves">Average Moves</label>
                <span id="avgMoves" class="badge">${statistics.avgWinMoves}</span>
            </div>
            <div class="form-group">
                <label for="avgWinsTime">Average Wins Time</label>
                <span id="avgWinsTime" class="badge">${statistics.avgWinTime}</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>