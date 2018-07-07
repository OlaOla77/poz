angular.module('patient-add')
    .controller('PatientAddController', function (patientService, $location) {

        var controller = this;

        controller.patient = {};

        controller.save = save;

        function save() {
            patientService.create(controller.patient).then(function () {
                $location.path('/patients')
            });
        }
    });