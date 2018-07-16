angular.module('patient-view')
    .controller('PatientViewController', function (patient, patientService, $location) {

    var controller = this;

    controller.patient = patient;

    controller.update = update;

    function update() {
        patientService.update(controller.patient).then(function () {
            $location.path('/patients');
        });
    }
});