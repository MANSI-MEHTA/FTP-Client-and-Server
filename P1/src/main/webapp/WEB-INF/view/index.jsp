<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">


    <title>Semantic Web Application Development | Home</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Generate Model</a>
        <a href="/get-author-names" class="navbar-brand">Find relationship between 2 given authors</a>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to Semantic Web Application</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_TASKS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Sparql Query Results!!</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>COI (Conflict-of-Interest) between two authors</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="relation" items="${relations}">
                        <tr>
                            <td>${relation}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <kbd> Degree of COI: ${degreeOfCOI}</kbd>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_NEW'}">
        <div class="container text-center">
            <h3>Add Author Names</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="/find-author-relationship">

                <div class="form-group">
                    <label class="control-label col-md-3">First Author Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="first_author" value="${author.first_author}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Second Author Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="second_author" value="${author.second_author}"/>
                    </div>
                </div>

                <div class=" form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>