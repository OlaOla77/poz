angular.module('appointment-add')
    .config(function ($routeProvider) {
        $routeProvider.when('/appointments/add/:patientId', {
            templateUrl: '/appointment-add/appointment-add.html',
            controller: 'AppointmentAddController',
            controllerAs: 'controller',
            resolve: {
                examinations: function(examinationService) {
                    return examinationService.query();
                },
                patient: function (patientService, $route) {
                    return patientService.get($route.current.params.patientId);
                }
            }
        })
    });