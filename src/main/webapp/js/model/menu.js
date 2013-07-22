define(['backbone', 'resthub', 'backbone-relational'], function(Backbone,
		Resthub) {

	var Menu = Backbone.RelationalModel.extend({

				className : 'com.liwei.resthub.training.jpa_webservice.model.Menu',

				relations : [{
							type : Backbone.HasOne,
							key : 'parent',
							relatedModel : 'Menu',
							collectionType : 'Menus'
						}]

			});
	Resthub.Validation.synchronize(Menu);

	return Menu;

});