angular.module('appointment')
    .service('appointmentService', function ($resource) {
        var service = this;
        var resource = $resource('http://localhost:8082/appointments/:appointmentId', {}, {
            update: {
                method: 'PUT'
            }
        });

        service.query = function () {
            return resource.query().$promise;
        }

        service.create = function (appointment) {
            return resource.save(null, appointment).$promise;
        }

        service.get = function(id){
            return resource.get({appointmentId:id}).$promise;
        }

        service.update = function (appointment) {
            return resource.update({appointmentId:appointment.id}, appointment).$promise;
        }

        service.remove = function (id) {
            return resource.remove({appointmentId:id}).$promise;
        }

    });