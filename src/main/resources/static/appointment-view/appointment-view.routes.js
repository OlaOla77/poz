angular.module('appointment-view')
    .config(function ($routeProvider) {
        $routeProvider.when('/appointments/view/:appointmentId', {
            templateUrl: '/appointment-view/appointment-view.html',
            controller: 'AppointmentViewController',
            controllerAs: 'controller',
            resolve: {
                appointment: function (appointmentService, $route) {
                    return appointmentService.get($route.current.params.appointmentId);
                },
                examinations: function (examinationService) {
                    return examinationService.query()
                        .then(function (response) {
                            return response.content;
                        });
                },
                // patient: function(patientService, $route) {
                //     return patientService.get($route.current.params.patientId);
                // }
            }
        });
    });