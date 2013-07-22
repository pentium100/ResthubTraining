define(['backbone', 'model/menu'], function(Backbone, Menu) {
			var Menus = Backbone.Collection.extend({
						url : 'api/menu',
						model : Menu,
						parse : function(resp, xhr) {
							return resp.content;
						}
					});
			return Menus;
		});
