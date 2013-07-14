define(	['backbone', 'backgrid', 'resthub', 'collection/tasks',
				'backgrid-paginator', 'backbone-validation'], function(Backbone, Backgrid, Resthub,
				Tasks, BackgridPaginator) {
			var TasksGridView = Resthub.View.extend({

						initialize : function() {

							this.columns = [{
										name : "id",
										label : "ID",
										editable : false,
										cell : Backgrid.IntegerCell.extend({
													orderSeparator : ''
												})
									}, {
										name : "title",
										label : "TITLE",
										editable : true,
										cell : 'string'

									}, {
										name : "description",
										label : "DESCRIPTION",
										editable : true,
										cell : 'string'

									}];
							this.grid = new Backgrid.Grid({

										paginated : true,
										columns : this.columns,
										collection : this.collection

									});
							this.paginator = new BackgridPaginator({
										collection : this.collection
									});

							Backbone.Validation.bind(this);

						},

						renderIt : function(el) {
							// TasksView.__super__.render.apply(this);
							el.append(this.grid.render().$el);
							el.append(this.paginator.render().$el);

						}

					});
			return TasksGridView;

		});