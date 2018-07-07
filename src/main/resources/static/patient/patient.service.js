angular.module('patient')
    .service('patientService', function ($resource) {
        var service = this;
        var resource = $resource('http://localhost:8082/patients/:patientId', {}, {
            update: {
                method: 'PUT'
            }
        });

        service.query = function (params) {
            return resource.query(params).$promise;
        }

        // service.query = function () {
        //     return resource.query().$promise;
        // }

        service.create = function (patient) {
            return resource.save(null, patient).$promise;
        }

        service.get = function(id){
            return resource.get({patientId:id}).$promise;
        }
        
        service.update = function (patient) {
            return resource.update({patientId:patient.id}, patient).$promise;
        }

        service.remove = function (id) {
            return resource.remove({patientId:id}).$promise;
        }

    });