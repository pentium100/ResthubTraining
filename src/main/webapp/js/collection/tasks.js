define(['backbone', 'model/task'], function(Backbone, Task) {
			var Tasks = Backbone.Collection.extend({
						url : 'api/task',
						model : Task,
						parse : function(resp, xhr) {
							return resp.content;
						}
					});
			return Tasks;
		});
