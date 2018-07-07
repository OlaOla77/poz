angular.module('patient-view')
    .config(function($routeProvider) {
    $routeProvider.when('/patients/view/:patientId', {
        templateUrl: '/patient-view/patient-view.html',
        controller: 'PatientViewController',
        controllerAs: 'controller',
        resolve: {
            patient: function(patientService, $route) {
                return patientService.get($route.current.params.patientId);
            }
        }
    });
});