angular.module('appointment-list')
    .controller('AppointmentListController', function(appointmentService, $location, patient) {
        var controller = this;

        controller.patient = patient;

        controller.searchAppointments = search;
        controller.viewAppointment = view;
        controller.deleteAppointment = remove;
        controller.goToAddAppointments = goToAddAppointments;

        search();

        function search() {
            appointmentService.query({
                patientId: patient.id
            }).then(function(response) {
                controller.appointmentList = response;
            });
        }

        function view(id) {
            $location.path('/appointments/view/' + id); // location pozwala przejsc do innej strony
        }

        function remove(id) {
            appointmentService.remove(id).then(function () {
                search();  //odswiezanie listy po usunieciu
            })
        }

        function goToAddAppointments() {
            $location.path('/appointments/add/' + patient.id);
        }

    });
