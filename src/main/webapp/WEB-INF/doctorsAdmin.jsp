<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.digitalhospital.entities.Docteur" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Doctors - Akidital System</title>
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
                            <i class="fas fa-user-md text-green-600"></i> Manage Doctors
                        </h1>
                        <p class="text-gray-600 mt-2">View, add, edit, and manage all doctors</p>
                    </div>
                    <a href="<%= request.getContextPath() %>/admin/doctors/new"
                       class="bg-green-600 hover:bg-green-700 text-white px-6 py-3 rounded-lg transition-colors shadow-lg">
                        <i class="fas fa-plus mr-2"></i> Add New Doctor
                    </a>
                </div>
            </div>

            <% String successMessage = (String) session.getAttribute("successMessage");
                if (successMessage != null) { %>
            <div class="bg-green-50 border-l-4 border-green-500 p-4 mb-6 rounded-lg">
                <div class="flex items-center">
                    <i class="fas fa-check-circle text-green-500 text-xl mr-3"></i>
                    <p class="text-green-700"><%= successMessage %></p>
                </div>
            </div>
            <% session.removeAttribute("successMessage");
            } %>

            <% String errorMessage = (String) session.getAttribute("errorMessage");
                if (errorMessage != null) { %>
            <div class="bg-red-50 border-l-4 border-red-500 p-4 mb-6 rounded-lg">
                <div class="flex items-center">
                    <i class="fas fa-exclamation-circle text-red-500 text-xl mr-3"></i>
                    <p class="text-red-700"><%= errorMessage %></p>
                </div>
            </div>
            <% session.removeAttribute("errorMessage");
            } %>

            <div class="grid grid-cols-1 md:grid-cols-3 gap-6 mb-6">
                <div class="bg-white rounded-lg shadow-lg p-6">
                    <div class="flex items-center justify-between">
                        <div>
                            <p class="text-gray-600 text-sm uppercase">Total Doctors</p>
                            <h3 class="text-3xl font-bold text-gray-800 mt-2">
                                <%= request.getAttribute("totalDoctors") != null ? request.getAttribute("totalDoctors") : 0 %>
                            </h3>
                        </div>
                        <div class="bg-green-100 rounded-full p-4">
                            <i class="fas fa-user-md text-3xl text-green-600"></i>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bg-white rounded-lg shadow-lg overflow-hidden">
                <div class="p-6 border-b border-gray-200">
                    <h2 class="text-xl font-bold text-gray-800">
                        <i class="fas fa-list text-green-600"></i> All Doctors
                    </h2>
                </div>

                <div class="overflow-x-auto">
                    <table class="w-full">
                        <thead class="bg-gray-50 border-b border-gray-200">
                        <tr>
                            <th class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                            <th class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                            <th class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Email</th>
                            <th class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Speciality</th>
                            <th class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Department</th>
                            <th class="px-6 py-4 text-center text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
                        </tr>
                        </thead>
                        <tbody class="bg-white divide-y divide-gray-200">
                        <%
                            List<Docteur> docteurs = (List<Docteur>) request.getAttribute("docteurs");
                            if (docteurs != null && !docteurs.isEmpty()) {
                                for (Docteur docteur : docteurs) {
                        %>
                        <tr class="hover:bg-gray-50 transition-colors">
                            <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                                #<%= docteur.getId() %>
                            </td>
                            <td class="px-6 py-4 whitespace-nowrap">
                                <div class="flex items-center">
                                    <div class="bg-green-100 rounded-full w-10 h-10 flex items-center justify-center mr-3">
                                        <i class="fas fa-user-md text-green-600"></i>
                                    </div>
                                    <div>
                                        <p class="text-sm font-medium text-gray-900">
                                            <%= docteur.getPrenom() %> <%= docteur.getNom() %>
                                        </p>
                                    </div>
                                </div>
                            </td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-600">
                                <i class="fas fa-envelope text-gray-400 mr-2"></i>
                                <%= docteur.getEmail() %>
                            </td>
                            <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="px-3 py-1 inline-flex text-xs leading-5 font-semibold rounded-full bg-blue-100 text-blue-800">
                                        <%= docteur.getSpecialite() %>
                                    </span>
                            </td>
                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-600">
                                <i class="fas fa-building text-gray-400 mr-2"></i>
                                <%= docteur.getDepartement() != null ? docteur.getDepartement().getNom() : "N/A" %>
                            </td>
                            <td class="px-6 py-4 whitespace-nowrap text-center text-sm font-medium">
                                <div class="flex items-center justify-center space-x-2">
                                    <a href="<%= request.getContextPath() %>/admin/doctors?action=edit&id=<%= docteur.getId() %>"
                                       class="bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded-lg transition-colors"
                                       title="Edit">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                    <button onclick="confirmDelete(<%= docteur.getId() %>, '<%= docteur.getPrenom() %> <%= docteur.getNom() %>')"
                                            class="bg-red-500 hover:bg-red-600 text-white px-3 py-2 rounded-lg transition-colors"
                                            title="Delete">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="6" class="px-6 py-8 text-center text-gray-500">
                                <i class="fas fa-user-md text-4xl text-gray-300 mb-3"></i>
                                <p class="text-lg">No doctors found</p>
                                <a href="<%= request.getContextPath() %>/admin/doctors/new"
                                   class="text-green-600 hover:text-green-700 mt-2 inline-block">
                                    <i class="fas fa-plus mr-1"></i> Add your first doctor
                                </a>
                            </td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
</div>

<div id="deleteModal" class="hidden fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full z-50">
    <div class="relative top-20 mx-auto p-5 border w-96 shadow-lg rounded-lg bg-white">
        <div class="mt-3">
            <div class="flex items-center justify-center w-12 h-12 mx-auto bg-red-100 rounded-full mb-4">
                <i class="fas fa-exclamation-triangle text-red-600 text-2xl"></i>
            </div>
            <h3 class="text-lg font-bold text-gray-900 text-center mb-2">Delete Doctor</h3>
            <p class="text-sm text-gray-500 text-center mb-4">
                Are you sure you want to delete <strong id="doctorName"></strong>?<br>
                This action cannot be undone.
            </p>
            <div class="flex items-center justify-center space-x-4 mt-6">
                <button onclick="closeModal()"
                        class="px-4 py-2 bg-gray-300 hover:bg-gray-400 text-gray-800 rounded-lg transition-colors">
                    Cancel
                </button>
                <form id="deleteForm" method="post" class="inline">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="doctorIdToDelete">
                    <button type="submit"
                            class="px-4 py-2 bg-red-600 hover:bg-red-700 text-white rounded-lg transition-colors">
                        <i class="fas fa-trash mr-2"></i> Delete
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function confirmDelete(id, name) {
        document.getElementById('doctorName').textContent = name;
        document.getElementById('doctorIdToDelete').value = id;
        document.getElementById('deleteModal').classList.remove('hidden');
    }

    function closeModal() {
        document.getElementById('deleteModal').classList.add('hidden');
    }

    document.getElementById('deleteModal').addEventListener('click', function(e) {
        if (e.target === this) {
            closeModal();
        }
    });
</script>
</body>
</html>