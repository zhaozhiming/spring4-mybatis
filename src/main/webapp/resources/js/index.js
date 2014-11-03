var pebms_app = angular.module('pebms', ['ngRoute']);

pebms_app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/farmer', { templateUrl: 'resources/pages/farmer.html', controller: FarmerController})
        .when('/show', { templateUrl: 'resources/pages/show.html', controller: ShowController})
        .otherwise({redirectTo: '/home'});
}]);

var transform = function (data) {
    return $.param(data);
};

var config = {
    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
    transformRequest: transform
};

menu = {};
// ready event
menu.ready = function () {
    // selector cache
    var $menuItem = $('.menu a.item');
    // alias
    var handler = {
        activate: function () {
            $(this)
                .addClass('active')
                .closest('.ui.menu')
                .find('.item')
                .not($(this))
                .removeClass('active');
        }
    };
    $menuItem.on('click', handler.activate);
};

// attach ready event
$(document).ready(menu.ready);