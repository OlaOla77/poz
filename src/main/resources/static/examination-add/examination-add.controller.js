angular.module('examination-add')
    .controller('ExaminationAddController', function (examinationService, $location) {

        var controller = this;

        controller.examination = {};

        controller.save = save;

        function save() {
            examinationService.create(controller.examination).then(function () {
                $location.path('/examinations')
            });
        }
    });