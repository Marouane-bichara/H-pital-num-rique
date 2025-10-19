<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Doctor - Akidital System</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-gray-100">
<div class="flex h-screen">
    <jsp:include page="./layout/sidebar.jsp" />

    <main class="flex-1 overflow-y-auto">
        <jsp:include page="./layout/header.jsp" />

        <div class="p-6">
            <div class="mb-6">
                <div class="flex items-center justify-between">
                    <div>
                        <h1 class="text-3xl font-bold text-gray-800">
                            <i class="fas fa-user-md text-green-600"></i> Add New Doctor
                        </h1>
                        <p class="text-gray-600 mt-2">Fill in the information below to register a new doctor</p>
                    </div>
                    <a href="<%= request.getContextPath() %>/admin/doctors"
                       class="bg-gray-500 hover:bg-gray-600 text-white px-6 py-3 rounded-lg transition-colors">
                        <i class="fas fa-arrow-left mr-2"></i> Back to Doctors
                    </a>
                </div>
            </div>

            <!-- Form Card -->
            <div class="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto">
                <form action="<%= request.getContextPath() %>/admin/doctors/new" method="post" class="space-y-6">

                    <!-- Personal Information Section -->
                    <div>
                        <h2 class="text-xl font-bold text-gray-800 mb-4 pb-2 border-b-2 border-green-500">
                            <i class="fas fa-user-circle text-green-600"></i> Personal Information
                        </h2>
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <!-- First Name -->
                            <div>
                                <label for="nom" class="block text-sm font-medium text-gray-700 mb-2">
                                    First Name <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-user text-gray-400"></i>
                                    </div>
                                    <input type="text"
                                           id="nom"
                                           name="nom"
                                           required
                                           class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors"
                                           placeholder="Enter first name">
                                </div>
                            </div>

                            <!-- Last Name -->
                            <div>
                                <label for="prenom" class="block text-sm font-medium text-gray-700 mb-2">
                                    Last Name <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-user text-gray-400"></i>
                                    </div>
                                    <input type="text"
                                           id="prenom"
                                           name="prenom"
                                           required
                                           class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors"
                                           placeholder="Enter last name">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Account Information Section -->
                    <div>
                        <h2 class="text-xl font-bold text-gray-800 mb-4 pb-2 border-b-2 border-green-500">
                            <i class="fas fa-lock text-green-600"></i> Account Information
                        </h2>
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <!-- Email -->
                            <div>
                                <label for="email" class="block text-sm font-medium text-gray-700 mb-2">
                                    Email Address <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-envelope text-gray-400"></i>
                                    </div>
                                    <input type="email"
                                           id="email"
                                           name="email"
                                           required
                                           class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors"
                                           placeholder="doctor@example.com">
                                </div>
                            </div>

                            <!-- Password -->
                            <div>
                                <label for="motDePasse" class="block text-sm font-medium text-gray-700 mb-2">
                                    Password <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-key text-gray-400"></i>
                                    </div>
                                    <input type="password"
                                           id="motDePasse"
                                           name="motDePasse"
                                           required
                                           minlength="6"
                                           class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors"
                                           placeholder="Enter password (min. 6 characters)">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Professional Information Section -->
                    <div>
                        <h2 class="text-xl font-bold text-gray-800 mb-4 pb-2 border-b-2 border-green-500">
                            <i class="fas fa-briefcase text-green-600"></i> Professional Information
                        </h2>
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <!-- Speciality -->
                            <div>
                                <label for="specialite" class="block text-sm font-medium text-gray-700 mb-2">
                                    Speciality <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-stethoscope text-gray-400"></i>
                                    </div>
                                    <select id="specialite"
                                            name="specialite"
                                            required
                                            class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors">
                                        <option value="">Select a speciality</option>
                                        <option value="Cardiology">Cardiology</option>
                                        <option value="Neurology">Neurology</option>
                                        <option value="Pediatrics">Pediatrics</option>
                                        <option value="Orthopedics">Orthopedics</option>
                                        <option value="Dermatology">Dermatology</option>
                                        <option value="General Medicine">General Medicine</option>
                                        <option value="Surgery">Surgery</option>
                                        <option value="Psychiatry">Psychiatry</option>
                                        <option value="Radiology">Radiology</option>
                                        <option value="Emergency Medicine">Emergency Medicine</option>
                                    </select>
                                </div>
                            </div>

                            <!-- Department ID -->
                            <div>
                                <label for="departementId" class="block text-sm font-medium text-gray-700 mb-2">
                                    Department ID <span class="text-red-500">*</span>
                                </label>
                                <div class="relative">
                                    <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                                        <i class="fas fa-building text-gray-400"></i>
                                    </div>
                                    <input type="number"
                                           id="departementId"
                                           name="departementId"
                                           required
                                           min="1"
                                           class="block w-full pl-10 pr-3 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-green-500 transition-colors"
                                           placeholder="Enter department ID">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Form Actions -->
                    <div class="flex items-center justify-end space-x-4 pt-6 border-t">
                        <a href="<%= request.getContextPath() %>/admin/doctors"
                           class="px-6 py-3 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50 transition-colors">
                            <i class="fas fa-times mr-2"></i> Cancel
                        </a>
                        <button type="reset"
                                class="px-6 py-3 bg-gray-500 hover:bg-gray-600 text-white rounded-lg transition-colors">
                            <i class="fas fa-redo mr-2"></i> Reset
                        </button>
                        <button type="submit"
                                class="px-6 py-3 bg-green-600 hover:bg-green-700 text-white rounded-lg transition-colors shadow-lg hover:shadow-xl">
                            <i class="fas fa-save mr-2"></i> Add Doctor
                        </button>
                    </div>
                </form>
            </div>

            <!-- Information Card -->
            <div class="bg-blue-50 border-l-4 border-blue-500 rounded-lg p-6 mt-6 max-w-4xl mx-auto">
                <div class="flex items-start">
                    <div class="flex-shrink-0">
                        <i class="fas fa-info-circle text-blue-500 text-2xl"></i>
                    </div>
                    <div class="ml-3">
                        <h3 class="text-sm font-medium text-blue-800">Important Information</h3>
                        <div class="mt-2 text-sm text-blue-700">
                            <ul class="list-disc list-inside space-y-1">
                                <li>All fields marked with <span class="text-red-500">*</span> are required</li>
                                <li>Email address must be unique and will be used for login</li>
                                <li>Password must be at least 6 characters long</li>
                                <li>Doctor will be assigned to the selected department</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>