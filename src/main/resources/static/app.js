$(document).ready(function() {
    // Fetch the tasks when the page loads
    fetchTasks();

    // Handle form submission
    $("#taskForm").submit(function(e) {
        e.preventDefault();
        const description = $("#description").val();
        const dateTime = $("#dateTime").val();

        if (description && dateTime) {
            // Call the backend to add the task
            addTask(description, dateTime);
        }
    });

    // Fetch tasks from the backend using jQuery's AJAX
    function fetchTasks() {
        $.ajax({
            url: "http://localhost:8080/tasks/list",
            method: "GET",
            success: function(tasks) {
                $("#taskList").empty(); // Clear the task list
                tasks.forEach(function(task) {
                    const taskItem = `
                        <div class="task-item">
                            <strong>Description:</strong> ${task.description}<br>
                            <strong>Date & Time:</strong> ${task.dateTime}
                        </div>
                    `;
                    $("#taskList").append(taskItem);
                });
            },
            error: function(error) {
                console.error("Error fetching tasks:", error);
            }
        });
    }

    // Add a task by sending a POST request to the backend using jQuery's AJAX
    function addTask(description, dateTime) {
        $.ajax({
            url: "http://localhost:8080/tasks/add",
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            data: {
                description: description,
                dateTime: dateTime
            },
            success: function(data) {
                // After adding the task, fetch the updated list
                fetchTasks();
                $("#taskForm")[0].reset(); // Reset the form
            },
            error: function(error) {
                console.error("Error adding task:", error);
            }
        });
    }
});
