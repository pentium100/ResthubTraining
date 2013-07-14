define(['model/task', 'collection/tasks', 'view/tasks-grid-view'], function(
				Task, Tasks, TasksGridView) {

			var $datagrid = $('#tasks');
			window.Task = Task;
			window.tasks = new Tasks();

			var tasksGridView = new TasksGridView({
						collection : tasks

					});
			tasks.fetch();
	
			tasksGridView.renderIt($datagrid);
			//$datagrid.append(tasksGridView.el);

		});