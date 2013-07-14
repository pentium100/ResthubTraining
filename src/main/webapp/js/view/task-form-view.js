define(
		['backbone', 'resthub', 'hbs!template/task-form', 'backbone-validation'],
		function(Backbone, Resthub, taskFormTemplate) {

			var TaskFormView = Resthub.View.extend({
						template : taskFormTemplate,
						tagName : 'form',
						events : {
							submit : 'save',
							'click .cancel' : 'cancel',
							'click .delete' : 'delete2'
						},
						initialize : function() {
							Backbone.Validation.bind(this);
						},
						save : function() {

							this.populateModel();
							if (this.model.isValid(true)) {
								this.model.save();
								// this.model.save({
								// title : this.$('.title-field')
								// .val(),
								// description : this.$('.desc-field')
								// .val()

								// });
							}
							return false;
						},
						cancel : function() {
							this.model.trigger('change');
						},
						delete2 : function() {
							this.model.destroy();
							return false;
						}
					});

			return TaskFormView;

		});