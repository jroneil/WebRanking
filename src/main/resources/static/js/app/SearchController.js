'use strict';
 
angular.module('rankApp').controller('SearchController',
    ['RankService', '$scope',  function( RankService, $scope) {

        var self = this;
        self.rank = {};
        self.ranks=[];

        self.submit = submit;
        self.getAllRanks=getAllRanks;
        self.getSearch = getSearch;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
        	 if (self.rank.recDate === undefined || self.rank.recDate === null) {
                 console.log('do nothing');
                 getAllRanks();
             } else {
            	 getSearch(self.rank.recDate);
                 console.log('Search ', self.rank.recDate);
             }
        
        }

        function getAllRanks(){
            return RankService.getAllRanks();
        }
        
        function getSearch(recDate){
        	console.log('----getSearch ',recDate);
        	 console.log('About to create rank');
        	 RankService.getSearch(recDate)
                 .then(
                     function (response) {
                         console.log('Rank created successfully');
                         self.successMessage = 'Top 5 records for '+recDate;
                         self.errorMessage='';
                         self.done = true;
                         self.rank={};
                         $scope.myForm.$setPristine();
                     },
                     function (errResponse) {
                         console.error('Error getting top 5 records');
                         self.errorMessage = 'Error getting top 5 records: ' + errResponse.data.errorMessage;
                         self.successMessage='';
                     }
                 );
        	   
        }
       
   
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.rank={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);