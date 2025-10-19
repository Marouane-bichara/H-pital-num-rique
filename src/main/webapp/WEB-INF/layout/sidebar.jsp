<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String currentPage = (String) request.getAttribute("currentPage");
    if (currentPage == null) currentPage = "";
%>
<aside class="w-64 bg-gradient-to-b from-blue-600 to-blue-800 text-white shadow-2xl">
    <div class="p-6 text-center border-b border-blue-500">
        <h2 class="text-2xl font-bold">
            <i class="fas fa-hospital"></i> Akdital
        </h2>
    </div>

    <nav class="mt-6">
        <a href="<%= request.getContextPath() %>/admin/dashboard"
           class="flex items-center px-6 py-3 <%= "dashboard".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-chart-line w-5"></i>
            <span class="ml-3">Dashboard</span>
        </a>
        <a href="<%= request.getContextPath() %>/admin/patients/"
           class="flex items-center px-6 py-3 <%= "patients".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-users w-5"></i>
            <span class="ml-3">Patients</span>
        </a>
        <a href="<%= request.getContextPath() %>/admin/doctors"
           class="flex items-center px-6 py-3 <%= "doctors".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-user-md w-5"></i>
            <span class="ml-3">Doctors</span>
        </a>
        <a href="<%= request.getContextPath() %>/admin/rooms/"
           class="flex items-center px-6 py-3 <%= "rooms".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-door-open w-5"></i>
            <span class="ml-3">Rooms</span>
        </a>
        <a href="<%= request.getContextPath() %>/admin/consultations/"
           class="flex items-center px-6 py-3 <%= "consultations".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-calendar-check w-5"></i>
            <span class="ml-3">Consultations</span>
        </a>
        <a href="<%= request.getContextPath() %>/admin/departments/"
           class="flex items-center px-6 py-3 <%= "departments".equals(currentPage) ? "bg-blue-700 border-l-4 border-white" : "hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white" %>">
            <i class="fas fa-building w-5"></i>
            <span class="ml-3">Departments</span>
        </a>

        <div class="border-t border-blue-500 mt-6 pt-6">
            <a href="<%= request.getContextPath() %>/logout"
               class="flex items-center px-6 py-3 hover:bg-blue-700 transition-colors border-l-4 border-transparent hover:border-white">
                <i class="fas fa-sign-out-alt w-5"></i>
                <span class="ml-3">Logout</span>
            </a>
        </div>
    </nav>
</aside>