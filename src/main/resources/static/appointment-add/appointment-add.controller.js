angular
    .module('appointment-add')
    .controller('AppointmentAddController',
        function (appointmentService, $location, appointment, examinations) {

            var controller = this;

            // controller.appointment = {};

            controller.appointment = appointment ? appointment : {
                examinations: []
            };

            controller.examinations = examinations;

            controller.save = save;
            controller.addExamination = addExamination;

            function save() {
                appointmentService.create(controller.appointment).then(function () {
                    $location.path('/appointments')
                });
            }

            function addExamination() {
                controller.appointment.examinations.push(controller.selectedExamination);
            }

        }
    );