<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | MyApp</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

<div class="bg-white shadow-2xl rounded-2xl w-full max-w-md p-8">
    <h1 class="text-3xl font-bold text-center text-gray-800 mb-6">Welcome Back 👋</h1>

    <%-- Display error message if login failed --%>
    <% String error = (String) request.getAttribute("errorMessage");
        if (error != null) { %>
    <div class="bg-red-100 text-red-600 text-sm p-3 rounded mb-4 text-center">
        <%= error %>
    </div>
    <% } %>

    <form action="login" method="post" class="space-y-5">

        <!-- User Role Selection -->
        <div>
            <label for="typeRole" class="block text-sm font-medium text-gray-700 mb-1">Login as</label>
            <select id="typeRole" name="typeRole" required
                    class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none bg-white">
                <option value="" disabled selected>Select your role</option>
                <option value="patient">Patient</option>
                <option value="docteur">Doctor</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <!-- Email Field -->
        <div>
            <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
            <input type="email" id="email" name="email" required
                   class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none">
        </div>

        <!-- Password Field -->
        <div>
            <label for="password" class="block text-sm font-medium text-gray-700 mb-1">Password</label>
            <input type="password" id="password" name="password" required
                   class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none">
        </div>

        <!-- Submit Button -->
        <button type="submit"
                class="w-full bg-blue-600 text-white font-medium py-2 rounded-lg hover:bg-blue-700 transition duration-200">
            Login
        </button>

        <p class="text-center text-sm text-gray-600 mt-4">
            Don’t have an account?
            <a href="register.jsp" class="text-blue-600 hover:underline">Sign up</a>
        </p>
    </form>
</div>

</body>
</html>
