<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/18/21
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    ​<!-- Bootstrap CSS -->
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
      nav #hover div ul li a:hover {
        color: #1e7e34;
      }
    </style>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <div>
      <img src="/assert/anh_furama/banner.png">
    </div>
    <div class="nav_bar border">
      <nav class="navbar navbar-expand-lg" style="background-color: #0f6674" id="hover">
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="padding-left: 15px">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#" style="color: white">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="/nhanvien?action=shownhanvien" style="color: white">Employee<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#" style="color: white">Customer<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#" style="color: white">Service<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#" style="color: white">Contract<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="navbar-nav mr-auto" style="padding-left:200px">
            <li class="nav-item">
              <input name="action" value="search" hidden>
              <input type="text" placeholder="Search" name="#">
              <input type="submit" value="Search">
            </li>
          </ul>
          <ul class="navbar-nav mr-auto" >
            <li class="nav-item">
              <a class="nav-link" href="#" style="color: white">Sign in
                <i class="fa fa-user-circle" aria-hidden="true"></i>
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="font border">
      <img src="/assert/anh_furama/font1.png">
    </div>
  </div>
  </body>
</html>
