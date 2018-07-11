angular
    .module('appointment-view')
    .controller('AppointmentViewController',
        function (appointment, $location, appointmentService, examinations) {

            var controller = this;

            controller.appointment = appointment;
            controller.examinations = examinations;
            controller.addExamination = addExamination;
            controller.removeExamination = removeExamination;

            controller.update = update;

            function update() {
                appointmentService.update(controller.appointment).then(function () {
                    $location.path('/appointments')
                });
            }

            function addExamination() {
                controller.appointment.examinations.push(controller.selectedExamination);
            }

            function removeExamination(x) {
                controller.appointment.examinations.splice(x, 1);
            }

        });

