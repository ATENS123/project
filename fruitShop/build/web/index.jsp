<%-- 
    Document   : index
    Created on : Feb 13, 2025, 2:58:28 PM
    Author     : ACER
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fruit Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/main.css">
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Fruit Shop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                    <li class="nav-item">
                    <li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Login</a></li>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="loginModalLabel">Login</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <%
                        String err = (String) request.getAttribute("err");
                        if (err != null && !err.isEmpty()) {
                    %>
                    <p style="color: red;"><%= err%></p>
                    <%
                        }
                    %>
                    <div class="modal-body">
                        <form action="LoginServlet" method="POST">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="text" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="pw" name="pw" required>
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="remember" name="remember" value="OFF">
                                <label class="form-check-label" for="remember">Remember Me</label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Banner Section -->
        <section class="jumbotron text-center">
            <img src="images/fruitshop.jpg" class="card-img-top" width="1000px" height="500px" alt="Apple">
            <h1>Welcome to Fruit Shop</h1>
            <p>Fresh and delicious fruits delivered to your doorstep!</p>
        </section>



        <%
            ArrayList<Customer> listC = (ArrayList<Customer>) request.getAttribute("lUser");
            if (listC != null && !listC.isEmpty()) {
        %>

        <div class="table-form">
            <table class="content_table" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Registration Date</th>
                    </tr>
                </thead>
                <tbody>
                <tbody>
                    <c:forEach var="customer" items="${requestScope.lUser}">
                        <% request.setAttribute("customer", pageContext.getAttribute("customer")); %>
                        <jsp:useBean id="customer" class="Model.Customer" scope="request"/>
                        <tr>
                            <td><jsp:getProperty name="customer" property="id"/></td>
                            <td><jsp:getProperty name="customer" property="fname"/></td>
                            <td><jsp:getProperty name="customer" property="lname"/></td>
                            <td><jsp:getProperty name="customer" property="email"/></td>
                            <td><jsp:getProperty name="customer" property="address"/></td>
                            <td><jsp:getProperty name="customer" property="phone"/></td>
                            <td><jsp:getProperty name="customer" property="rdate"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%}%>




        <!-- Product Listings Section -->
        <div class="container">
            <div class="row">
                <%
                    ArrayList<Fruit> list = (ArrayList<Fruit>) request.getAttribute("listF");
                    if (list == null) {
                        list = (ArrayList<Fruit>) session.getAttribute("listF"); // Lấy từ session nếu request không có
                    }

                    if (list != null && !list.isEmpty()) {
                        for (Fruit f : list) {
                %>
                <div class="col-md-4">
                    <div class="card">
                        <img src="<%= f.getImage().replace('\\', '/').replaceFirst("^/", "")%>" class="card-img-top" height="356pt" alt="<%= f.getCategory()%>">
                        <div class="card-body">
                            <h5 class="card-title"><%= f.getProductName()%></h5>
                            <p class="card-text"><%= f.getDescription()%></p>
                            <p class="card-text">Price: <%= f.getPrice()%>/kg</p>
                            <a href="#" class="btn btn-primary">Add to Cart</a>
                        </div>
                    </div>
                </div>
                <%
                    }
                } else {
                %>
                <p>No products available.</p>
                <%
                    }
                %>
            </div>
        </div>



        <!-- Footer Section -->
        <footer class="bg-light text-center">
            <p>&copy; 2023 Fruit Shop</p>
        </footer>

        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
