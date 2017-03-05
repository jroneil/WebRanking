'use strict';

angular.module('rankApp').controller('RankController',
    ['RankService', '$scope',  function( RankService, $scope) {

        var self = this;
        self.rank = {};
        self.ranks=[];

        self.submit = submit;
        self.getAllRanks = getAllRanks;
        self.createRank = createRank;
        self.updateRank = updateRank;
        self.removeRank = removeRank;
        self.editRank = editRank;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.rank.id === undefined || self.rank.id === null) {
                console.log('Saving New Rank', self.rank);
                createRank(self.rank);
            } else {
                updateRank(self.rank, self.rank.id);
                console.log('Rank updated with id ', self.rank.id);
            }
        }

        function createRank(rank) {
            console.log('About to create rank');
            RankService.createRank(rank)
                .then(
                    function (response) {
                        console.log('Rank created successfully');
                        self.successMessage = 'Rank created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.rank={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Rank');
                        self.errorMessage = 'Error while creating Rank: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateRank(rank, id){
            console.log('About to update rank');
            RankService.updateRank(rank, id)
                .then(
                    function (response){
                        console.log('Rank updated successfully');
                        self.successMessage='Rank updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Rank');
                        self.errorMessage='Error while updating Rank '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeRank(id){
            console.log('About to remove Rank with id '+id);
            RankService.removeRank(id)
                .then(
                    function(){
                        console.log('Rank '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing rank '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllRanks(){
            return RankService.getAllRanks();
        }
        
       


        function editRank(id) {
            self.successMessage='';
            self.errorMessage='';
            RankService.getRank(id).then(
                function (rank) {
                    self.rank = rank;
                },
                function (errResponse) {
                    console.error('Error while removing rank ' + id + ', Error :' + errResponse.data);
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