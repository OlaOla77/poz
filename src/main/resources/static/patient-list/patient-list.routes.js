var patientListModule = angular.module('patient-list');

//do metody przekazujemy funkcje
patientListModule.config(function($routeProvider) {
    $routeProvider.when('/patients', {
        templateUrl: '/patient-list/patient-list.html',
        controller: 'PatientListController',
        controllerAs: 'controller'
    })
});