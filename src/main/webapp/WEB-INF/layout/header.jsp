<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pageTitle = (String) request.getAttribute("pageTitle");
    if (pageTitle == null) pageTitle = "Dashboard";
%>
<header class="bg-white shadow-md p-6 sticky top-0 left-0 z-50">
    <div class="flex justify-between items-center">
        <div>
            <h1 class="text-3xl font-bold text-gray-800"><%= pageTitle %></h1>
            <p class="text-gray-600 mt-1">Welcome back, Admin!</p>
        </div>
        <div class="flex items-center gap-4">
            <span class="text-gray-600">
                <i class="far fa-calendar"></i>
                <%= java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MMMM dd, yyyy")) %>
            </span>

        </div>
    </div>
</header>