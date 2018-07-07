angular.module('patient-add')
    .config(function($routeProvider) {
        $routeProvider.when('/patients/add', {
            templateUrl: '/patient-add/patient-add.html',
            controller: 'PatientAddController',
            controllerAs: 'controller'
        });
    });