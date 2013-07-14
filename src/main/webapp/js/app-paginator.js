define(['model/task', 'collection/tasks-paginator', 'view/tasks-grid-view'],
		function(Task, Tasks, TasksGridView) {

			var $datagrid = $('#tasks');
			window.Task = Task;
			window.tasks = new Tasks();

			tasks.fetch();
			var tasksGridView = new TasksGridView({
						collection : tasks

					});

			
			tasksGridView.renderIt($datagrid);
			// $datagrid.append(tasksGridView.el);

	});