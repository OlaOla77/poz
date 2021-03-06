angular.module('patient-list')
    .controller('PatientListController', function(patientService,  $routeParams, $route, $location) {
        var controller = this;

        controller.searchPatients = search;
        controller.viewPatient = view;
        controller.deletePatient = remove;
        controller.goToAppointments = goToAppointments;
        controller.searchByParam = searchByParam;

        controller.params = $routeParams;

        search();

        function search() {
            patientService.query(controller.params).then(function(response) {
                controller.patientList = response;
            });
        }

        function view(id) {
            $location.path('/patients/view/' + id);   // location pozwala przejsc do innej strony
        }

        function remove(id) {
            patientService.remove(id).then(function () {
                search();  //odswiezanie listy po usunieciu
            })
        }

        function goToAppointments(id) {
            $location.path('/appointments/' + id);
        }

        function searchByParam() {
            $route.updateParams(controller.params);
            $route.reload();
        }

    });

