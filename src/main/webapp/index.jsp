<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Akidital System - Welcome</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-50">
<!-- Navbar -->
<nav class="bg-white shadow-lg">
    <div class="container mx-auto px-6 py-4">
        <div class="flex justify-between items-center">
            <!-- Logo -->
            <a href="<%= request.getContextPath() %>/" class="text-2xl font-bold text-blue-600 flex items-center">
                <i class="fas fa-hospital mr-2"></i>
                Akdital System
            </a>

            <!-- Login & Register Buttons -->
            <div class="flex gap-4">
                <a href="<%= request.getContextPath() %>/login"
                   class="text-blue-600 hover:text-blue-700 px-6 py-2 rounded-lg border-2 border-blue-600 hover:bg-blue-50 transition-colors font-medium">
                    <i class="fas fa-sign-in-alt mr-2"></i>Login
                </a>
                <a href="<%= request.getContextPath() %>/register"
                   class="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded-lg transition-colors font-medium">
                    <i class="fas fa-user-plus mr-2"></i>Register
                </a>
            </div>
        </div>
    </div>
</nav>

<!-- Hero Section -->
<section class="relative bg-gradient-to-br from-blue-600 via-blue-700 to-indigo-800 text-white">
    <div class="container mx-auto px-6 py-32">
        <div class="max-w-4xl mx-auto text-center">
            <!-- Icon -->
            <div class="mb-8">
                <i class="fas fa-hospital-alt text-8xl text-blue-200"></i>
            </div>

            <h1 class="text-6xl font-bold mb-6">
                Welcome to Akdital
            </h1>

            <p class="text-2xl text-blue-100 mb-8">
                Modern Hospital Management System
            </p>

            <p class="text-lg text-blue-200 mb-12 max-w-2xl mx-auto">
                Streamline your healthcare operations with our comprehensive management platform.
                Manage patients, doctors, departments, and consultations all in one place.
            </p>

            <div class="flex gap-6 justify-center">
                <a href="<%= request.getContextPath() %>/register"
                   class="bg-white text-blue-600 hover:bg-blue-50 px-8 py-4 rounded-lg text-lg font-semibold transition-colors shadow-lg">
                    <i class="fas fa-rocket mr-2"></i>Get Started
                </a>
                <a href="<%= request.getContextPath() %>/admin/dashboard"
                   class="bg-transparent border-2 border-white text-white hover:bg-white hover:text-blue-600 px-8 py-4 rounded-lg text-lg font-semibold transition-colors">
                    <i class="fas fa-sign-in-alt mr-2"></i>Sign in
                </a>
            </div>
        </div>
    </div>

</section>

<!-- Features Section (Optional - can remove if you want only hero) -->
<section class="py-20 bg-gray-50">
    <div class="container mx-auto px-6">
        <div class="grid grid-cols-1 md:grid-cols-3 gap-12">
            <!-- Feature 1 -->
            <div class="text-center">
                <div class="w-20 h-20 bg-blue-100 rounded-full flex items-center justify-center mx-auto mb-4">
                    <i class="fas fa-users text-4xl text-blue-600"></i>
                </div>
                <h3 class="text-xl font-bold text-gray-800 mb-2">Patient Management</h3>
                <p class="text-gray-600">Efficiently manage patient records and medical history</p>
            </div>

            <!-- Feature 2 -->
            <div class="text-center">
                <div class="w-20 h-20 bg-green-100 rounded-full flex items-center justify-center mx-auto mb-4">
                    <i class="fas fa-user-md text-4xl text-green-600"></i>
                </div>
                <h3 class="text-xl font-bold text-gray-800 mb-2">Doctor Scheduling</h3>
                <p class="text-gray-600">Organize doctor schedules and appointments seamlessly</p>
            </div>

            <!-- Feature 3 -->
            <div class="text-center">
                <div class="w-20 h-20 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-4">
                    <i class="fas fa-hospital text-4xl text-purple-600"></i>
                </div>
                <h3 class="text-xl font-bold text-gray-800 mb-2">Department Control</h3>
                <p class="text-gray-600">Manage all hospital departments from one dashboard</p>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-gray-800 text-white py-8">
    <div class="container mx-auto px-6 text-center">
        <p class="text-gray-400">
            &copy; 2024 Akidital System. All rights reserved.
        </p>
    </div>
</footer>
</body>
</html>