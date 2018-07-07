angular.module('examination-add')
    .config(function($routeProvider) {
        $routeProvider.when('/examinations/add', {
            templateUrl: '/examination-add/examination-add.html',
            controller: 'ExaminationAddController',
            controllerAs: 'controller'
        });
    });