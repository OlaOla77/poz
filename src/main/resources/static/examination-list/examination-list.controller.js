angular.module('examination-list')
    .controller('ExaminationListController', function(examinationService, $routeParams, $route, $location) {
        var controller = this;

        controller.searchExaminations = search;
        controller.viewExamination = view;
        controller.deleteExamination = remove;
        controller.searchByParam = searchByParam;

        controller.params = $routeParams

        search();

        function search() {
            examinationService.query(controller.params).then(function(response) {
                controller.examinations = response;
            });
        }

        function view(id) {
            $location.path('/examinations/view/' + id);   // location pozwala przejsc do innej strony
        }

        function remove(id) {
            examinationService.remove(id).then(function () {
                search();  //odswiezanie listy po usunieciu
            })
        }

        function searchByParam() {
            $route.updateParams(controller.params);
            $route.reload();
        }
    });

