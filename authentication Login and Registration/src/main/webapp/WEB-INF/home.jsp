<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Events Home Page</title>
    <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="home.css">
</head>
<body>
<div id = "wrapper">
    <div id = "top">
        <h3>Welcome, ${user.firstName} ${user.lastName}!</h3>
        <div id = "topright">
            <a href = "/logout">Log Out!</a>
        </div>
    </div>
    <div id = "blackline"></div>
    <div id = "main">
        <h4>Events happening in your state</h4>

        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${topevents}" var = "e">
                <tr>
                    <td><a href = "/events/${e.id}">${e.name}</a></td>
                    <td>${e.date}</td>
                    <td>${e.city}</td>
                    <td>${e.creator.firstName} ${e.creator.lastName}</td>
                    <td>
                        <c:choose>
                            <c:when test = "${e.creator.equals(user)}">
                                <a href = "events/${e.id}/edit">Edit</a>
                                <a href = "events/${e.id}/delete">Delete</a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test = "${!user.getEvents().contains(e)}">
                                        <a href = "events/${e.id}/join">Join</a>
                                    </c:when>
                                    <c:otherwise>
                                        <i>Joining</i>
                                        <a href = "events/${e.id}/cancel">Cancel</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div id = "othermain">
        <h4>Events happening in other states</h4>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>State</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${bottomevents}" var = "e">
                <tr>
                    <td><a href = "/events/${e.id}">${e.name}</a></td>
                    <td>${e.date}</td>
                    <td>${e.city}</td>
                    <td>${e.state}</td>
                    <td>${e.creator.firstName} ${e.creator.lastName}</td>
                    <td>
                        <c:choose>
                            <c:when test = "${e.creator.equals(user)}">
                                <a href = "events/${e.id}/edit">Edit</a>
                                <a href = "events/${e.id}/delete">Delete</a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test = "${!user.getEvents().contains(e)}">
                                        <a href = "events/${e.id}/join">Join</a>
                                    </c:when>
                                    <c:otherwise>
                                        <i>Joining</i>
                                        <a href = "events/${e.id}/cancel">Cancel</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id = "blackline"></div>
    <div id = "eventcreate">
        <p><c:out value = "${error}" /></p>
        <h4>Create an Event</h4>
        <form method = "POST" action = "/events/new">
            <p>Name:</p>
            <input type = "text" name = "name"/>
            <p>Date:</p>
            <input type = "date" name = "date"/>
            <p>Location:</p>
            <input type = "text" name = "city"/>
            <select name = "state" cssclass="dropdown-menu">
                <option value="AL" cssclass="dropdown-item">Alabama</option>
                <option value="CA" cssclass="dropdown-item">California</option>
                <option value="AK" cssclass="dropdown-item">Alaska</option>
                <option value="AZ" cssclass="dropdown-item">Arizona</option>
                <option value="AR" cssclass="dropdown-item">Arkansas</option>
                <option value="CO" cssclass="dropdown-item">Colorado</option>
                <option value="CT" cssclass="dropdown-item">Connecticut</option>
                <option value="DE" cssclass="dropdown-item">Delaware</option>
                <option value="DC" cssclass="dropdown-item">District Of Columbia</option>
            </select>
            <br><br>
            <button type="submit" class="btn btn-dark">Create</button>
        </form>
    </div>
</div>
</body>
</html>

