define(['collection/menus', 'w2ui'], function(Menus) {


			var pstyle = '';

			$('#mainLayout').w2layout({
						name : 'layout',
						panels : [{
									type : 'top',
									size : 50,
									resizable : true,
									style : pstyle,
									content : 'top'
								}, {
									type : 'left',
									size : 200,
									resizable : true,
									style : pstyle,
									content : ''
								}, {
									type : 'main',
									style : pstyle + 'border-top: 0px;',
									content : 'tab1',
									tabs : {
										active : 'tab1',
										tabs : [{
													id : 'tab1',
													caption : 'Tab 1'
												}, {
													id : 'tab2',
													caption : 'Tab 2'
												}, {
													id : 'tab3',
													caption : 'Tab 3'
												}],
										onClick : function(target, data) {
											this.owner.content('main', target);
										}
									}
								}]
					});

			$().w2sidebar({
						name : 'sidebar',
						img : null,
						nodes : []
					});

			var menus = new Menus();
			menus.fetch({

						url : menus.url + '/parent/0',
						success : function(collection, response, options) {

							response.forEach(function(menu) {
										var img = 'icon-folder';
										if (menu.isLeaf) {
											img = 'icon-page';
										}

										w2ui['sidebar'].add([{
													id : 'mainSidebar-'
															+ menu.id,
													text : menu.text,
													img : img,
													menu : menu
												}]);

									});

						}
					});

			w2ui['sidebar'].on('click', function(target, data) {
						console.log('Event: ' + data.type + ' Target: '
								+ target);
						console.log(data);
						var menu = w2ui['sidebar'].get(target);
						if (menu.menu.isLeaf ) {

							
							return;
						}
						
						if ( menu.nodes.length > 0){
							w2ui['sidebar'].toggle(target);
							return;
						}
						menus.fetch({

									url : menus.url + '/parent/' + menu.menu.id,
									success : function(collection, response,
											options) {

										response.forEach(function(node) {
													var img = 'icon-folder';
													if (node.isLeaf) {
														img = 'icon-page';
													}

													w2ui['sidebar'].insert(
															target, null, [{
																id : 'mainSidebar-'
																		+ node.id,
																text : node.text,
																img : img,
																menu : node
															}]);

												});

									}
								});

					});
			w2ui['layout'].content('left', w2ui['sidebar']);

		});