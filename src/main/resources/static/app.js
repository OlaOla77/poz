var app = angular.module('app', ['ngRoute', 'patient-list', 'patient-add',
    'patient-view', 'appointment-add', 'appointment-list', 'appointment-view', 'examination-add',
    'examination-list', 'examination-view']);

app.config(function($routeProvider) {
    $routeProvider
        .otherwise({
            redirectTo: '/'
        });
});