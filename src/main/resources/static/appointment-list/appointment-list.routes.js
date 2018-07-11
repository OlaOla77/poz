var appointmentListModule = angular.module('appointment-list');

//do metody przekazujemy funkcje
appointmentListModule.config(function($routeProvider) {
    $routeProvider.when('/appointments/:patientId', {
        templateUrl: '/appointment-list/appointment-list.html',
        controller: 'AppointmentListController',
        controllerAs: 'controller',
        resolve: {
            appointment: function () {
                return undefined;
            },
            patient: function(patientService, $route) {
                return patientService.get($route.current.params.patientId);
            }

        }
    })
});