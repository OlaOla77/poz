angular.module('appointment-list')
    .controller('AppointmentListController', function(appointmentService, $location) {
        var controller = this;

        controller.searchAppointments = search;
        controller.viewAppointment = view;
        controller.deleteAppointment = remove;
        controller.goToAddAppointments = goToAddAppointments;

        search();

        function search() {
            appointmentService.query().then(function(response) {
                controller.appointmentList = response;
            });
        }

        function view(id) {
            $location.path('/appointments/view/' + id);   // location pozwala przejsc do innej strony
        }

        function remove(id) {
            appointmentService.remove(id).then(function () {
                search();  //odswiezanie listy po usunieciu
            })
        }

        function goToAddAppointments() {
            $location.path('/appointments/add');
        }

    });

