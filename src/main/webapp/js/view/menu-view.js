define(	['backbone', 'w2ui', 'resthub', 'collection/menus',
				'backbone-validation'],
		function(Backbone, w2ui, Resthub, Menus) {
			var TasksGridView = Resthub.View.extend({

						initialize : function() {

							this.columns = [{
										field : 'id',
										caption : 'ID',
										size : '4%',
										sortable : true,
										editable : false
									}, {
										field : 'text',
										caption : 'Text',
										size : '20%',
										sortable : true,
										editable : {
											type : 'text',
											inTag : 'maxlength=30'
										}
									}, {
										field : 'controller',
										caption : 'Controller',
										size : '20%',
										sortable : true,
										editable : {
											type : 'text',
											inTag : 'maxlength=30'
										}
									},{
										field : 'viewer',
										caption : 'Viewer',
										size : '20%',
										sortable : true,
										editable : {
											type : 'text',
											inTag : 'maxlength=30'
										}
									},{
										field : 'param',
										caption : 'Init.Param',
										size : '20%',
										sortable : true,
										editable : {
											type : 'text',
											inTag : 'maxlength=30'
										}
									},{
										field : 'Parent',
										caption : 'Parent Menu',
										size : '20%',
										sortable : true,
										editable : {
											type : 'text',
											inTag : 'maxlength=30'
										}
									}];
							

							Backbone.Validation.bind(this);

						},

						renderIt : function(el) {

						}

					});
			return TasksGridView;

		});