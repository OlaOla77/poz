angular.module('examination')
    .service('examinationService', function ($resource) {
        var service = this;
        var resource = $resource('http://localhost:8082/examinations/:examinationId', {}, {
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

        service.create = function (examination) {
            return resource.save(null, examination).$promise;
        }

        service.get = function(id){
            return resource.get({examinationId:id}).$promise;
        }
        
        service.update = function (examination) {
            return resource.update({examinationId:examination.id}, examination).$promise;
        }

        service.remove = function (id) {
            return resource.remove({examinationId:id}).$promise;
        }

    });