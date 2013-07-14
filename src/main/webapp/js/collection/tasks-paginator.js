define(['backbone', 'model/task', 'backbone-pageable', 'underscore'], function(
				Backbone, Task, PageableCollection) {
			var Tasks = PageableCollection.extend({

				model : Task,
				url : 'api/task',
				state : {
					pageSize : 3
				},

				queryParams : {
					currentPage : "page",
					pageSize : "size",
					totalPages : "totalPages",
					totalRecords : "totalElements",
					sortKey : "direction",
					order : "order",
					directions : {
						"-1" : "ASC",
						"1" : "DESC"
					}
				},
				mode : 'server',

				parseState : function(resp, queryParams, state, options) {

					var newState = _.clone(state);

					newState.lastPage = resp[queryParams.totalPages];
					newState.currentPage = resp.number + 1;

					// newState.currentPage = Math.floor(newState.currentPage);

					newState.totalPages = resp[queryParams.totalPages];
					newState.totalRecords = resp[queryParams.totalRecords];
					return newState;

				},
				parseRecords : function(resp, options) {
					return resp.content;
				}

					// ,
					// parse : function(resp) {
					// return resp.content;
					// }
				});
			return Tasks;
		});
