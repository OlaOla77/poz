var app = angular.module('app', ['ngRoute', 'patient-list', 'patient-add',
    'patient-view', 'appointment-add', 'appointment-list', 'examination-add',
    'examination-list', 'examination-view']);

app.config(function($routeProvider) {
    $routeProvider
        .otherwise({
            redirectTo: '/'
        });
});