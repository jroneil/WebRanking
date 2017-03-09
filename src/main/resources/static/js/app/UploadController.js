'use strict';
 
angular.module('rankApp').controller('UploadController',
    ['UploadService', '$scope',  function( UploadService, $scope) {

        var self = this;
       
        self.submit = submit;
        

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        function submit() {
        	  console.log('UploadFile');
              var deferred = $q.defer();
              $http.get(urls.RANK_SERVICE_API +"/uploadCsv")
                  .then(
                      function (response) {
                          console.log('Fetched successfully Top 10 ranks');
                          deferred.resolve(response);
                      },
                      function (errResponse) {
                          console.error('Error while loading Top 10 ranks');
                          deferred.reject(errResponse);
                      });
        
        }

       



    ]);