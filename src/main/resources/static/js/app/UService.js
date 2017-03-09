'use strict';
 
angular.module('rankApp').factory('RankService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            		uploadFile: uploadFile,
            };

            return factory;

            function uploadFile() {
            	 console.log('uploading file');
                 var file = document.getElementById("ufile").files[0];
                 var formData = new FormData();
                 formData.append('file', file);
                 var deferred = $q.defer();
                 $http.get(urls.RANK_SERVICE_API +"/upload"+formData, {
                     headers: { 
                         'Content-Type': undefined,
                     },
                     transformRequest: angular.identity,
                 	})
                     .then(
                         function (response) {
                             console.log('File Upload Success');
                             $localStorage.ranks = response.data;
                             deferred.resolve(response);
                         },
                         function (errResponse) {
                             console.error('File Upload Failed');
                             deferred.reject(errResponse);
                         }
                     );
                 return deferred.promise;
            }

           
          
            


      

        }
    ]);