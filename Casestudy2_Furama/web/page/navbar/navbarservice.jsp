<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/22/21
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav_bar border">
    <nav class="sticky-top navbar navbar-expand-lg" style="background-color: #0f6674">
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="padding-left: 15px">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/" style="color: white">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="employee" style="color: white">Employee<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="customer" style="color: white">Customer<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="service" style="color: white">Service<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="contract" style="color: white">Contract<span class="sr-only">(current)</span></a>
                </li>
                <li>
                    <div class="dropdown">
                    <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" style="color: white">Create Service<span class="sr-only">(current)</span></button>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/service?action=create&serviceTypeId=1">Create Villa</a>
                        <a class="dropdown-item" href="/service?action=create&serviceTypeId=2">Create House</a>
                        <a class="dropdown-item" href="/service?action=create&serviceTypeId=3">Create Room</a>
                    </div>
                    </div>
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
