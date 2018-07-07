angular.module('examination-view')
    .controller('ExaminationViewController',
        function (examination, examinationService, $location) {

    var controller = this;

    controller.examination = examination;

    controller.update = update;

    function update() {
        examinationService.update(controller.examination).then(function () {
            $location.path('/examinations')
        });
    }
});