angular
    .module('appointment-add')
    .controller('AppointmentAddController',
        function (appointmentService, $location, patient, examinations) {

            var controller = this;

            controller.appointment = {
                examinations: [],
                patient: patient
            };

            controller.examinations = examinations;
            controller.patient = patient;

            controller.save = save;
            controller.addExamination = addExamination;

            function save() {
                appointmentService.create(controller.appointment).then(function() {
                    $location.path('/appointments')
                });
            }

            function addExamination() {
                controller.appointment.examinations.push(controller.selectedExamination);
            }

        }
    );