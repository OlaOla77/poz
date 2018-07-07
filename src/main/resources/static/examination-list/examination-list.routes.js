var examinationListModule = angular.module('examination-list');

//do metody przekazujemy funkcje
examinationListModule.config(function($routeProvider) {
    $routeProvider.when('/examinations', {
        templateUrl: '/examination-list/examination-list.html',
        controller: 'ExaminationListController',
        controllerAs: 'controller'
    })
});