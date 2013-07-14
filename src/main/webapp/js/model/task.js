define(['backbone', 'resthub'], function(Backbone, Resthub) {

	var Task = Backbone.Model.extend({

				className : 'com.liwei.resthub.training.jpa_webservice.model.Task',

				idAttribute : "id",
				initialize : function(attributes) {

					this.id = attributes['_id'] || attributes['id'];
					this.on("backgrid:edited", this.saveIt, this);

				},
				saveIt : function(e) {
					if (this.hasChanged()) {
						this.save({}, {
									url : this.url + "/" + this.id
								});
					}
				}
			});
	Resthub.Validation.synchronize(Task);

	return Task;

});