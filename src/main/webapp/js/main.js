// Set the require.js configuration for your application.
require.config({

	shim : {
		'underscore' : {
			exports : '_'
		},
		'underscore-string' : {
			deps : ['underscore']
		},
		'handlebars-orig' : {
			exports : 'Handlebars'
		},
		'backbone' : {
			deps : ['underscore', 'underscore-string', 'jquery'],
			exports : 'Backbone'
		},
		'backbone-datagrid' : {
			deps : ['backbone'],
			exports : 'Backbone.Datagrid'
		},
		'backbone-paginator' : {
			deps : ['backbone'],
			exports : 'Backbone.Paginator'
		},

		'backbone-pageable' : {
			deps : ['backbone'],
			exports : 'Backbone.PageableCollection'
		},

		'backgrid' : {
			deps : ['backbone'],
			exports : 'Backgrid'
		},

		'backgrid-paginator' : {
			deps : ['backgrid'],
			exports : 'Backgrid.Extension.Paginator'
		},

		'bootstrap' : {
			deps : ['jquery']
		},
		'backbone-relational' : {
			deps : ['backbone']
		},
		'keymaster' : {
			exports : 'key'
		},
		'async' : {
			exports : 'async'
		},
		'w2ui' : {
			deps : ['jquery'],
			exports : 'w2ui'
		}
	},

	// Libraries
	paths : {
		jquery : 'lib/jquery',
		underscore : 'lib/underscore',
		'underscore-string' : 'lib/underscore-string',
		backbone : 'lib/backbone',
		resthub : 'lib/resthub/resthub',
		localstorage : 'lib/localstorage',
		text : 'lib/text',
		i18n : 'lib/i18n',
		pubsub : 'lib/resthub/pubsub',
		'bootstrap' : 'lib/bootstrap',
		'backbone-validation-orig' : 'lib/backbone-validation',
		'backbone-validation' : 'lib/resthub/backbone-validation-ext',
		'handlebars-orig' : 'lib/handlebars',
		'handlebars' : 'lib/resthub/handlebars-helpers',
		'backbone-queryparams' : 'lib/backbone-queryparams',
		'backbone-datagrid' : 'lib/backbone-datagrid',
		'backbone-paginator' : 'lib/backbone-paginator',
		'backbone-relational' : 'lib/backbone-relational',
		async : 'lib/async',
		keymaster : 'lib/keymaster',
		hbs : 'lib/resthub/require-handlebars',
		moment : 'lib/moment',
		template : '../template',
		json2 : 'lib/json2',
		console : 'lib/resthub/console',
		'backgrid' : 'lib/backgrid/backgrid',
		'backgrid-paginator' : 'lib/backgrid/extensions/paginator/backgrid-paginator',
		'backbone-pageable' : 'lib/backbone-pageable',
		'w2ui' : 'lib/w2ui/w2ui-1.2'
	}
});

// Load our app module and pass it to our definition function
require(['console', 'app']);
