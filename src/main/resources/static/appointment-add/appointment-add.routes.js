angular.module('appointment-add')
    .config(function ($routeProvider) {
        $routeProvider.when('/appointments/add', {
            templateUrl: '/appointment-add/appointment-add.html',
            controller: 'AppointmentAddController',
            controllerAs: 'controller',
            resolve: {
                appointment: function () {
                    return undefined;
                },
                examinations: function (examinationService) {
                    return examinationService.query();
                }

            }
        })
    });