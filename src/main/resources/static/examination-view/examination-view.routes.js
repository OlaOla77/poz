angular.module('examination-view')
    .config(function($routeProvider) {
    $routeProvider.when('/examinations/view/:examinationId', {
        templateUrl: '/examination-view/examination-view.html',
        controller: 'ExaminationViewController',
        controllerAs: 'controller',
        resolve: {
            examination: function(examinationService, $route) {
                return examinationService.get($route.current.params.examinationId);
            }
        }
    });
});