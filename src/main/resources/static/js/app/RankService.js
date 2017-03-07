'use strict';
 
angular.module('rankApp').factory('RankService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllRanks: loadAllRanks,
                getAllRanks: getAllRanks,
                loadSearch: loadSearch,
                getSearch: getSearch,
                getRank: getRank,
                createRank: createRank,
                updateRank: updateRank,
                removeRank: removeRank
            };

            return factory;

            function loadAllRanks() {
                console.log('Fetching all ranks');
                var deferred = $q.defer();
                $http.get(urls.RANK_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all ranks');
                            $localStorage.ranks = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading ranks');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllRanks(){
                return $localStorage.ranks;
            };
            
            function loadSearch(recDate) {
                console.log('searching ranks',recDate);
                var deferred = $q.defer();
                $http.get(urls.RANK_SERVICE_API +"search?recDate="+recDate)
                    .then(
                        function (response) {
                            console.log('Fetched successfully search ranks');
                            $localStorage.ranks = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Search ranks');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            };

            function getSearch(recDate){
            	console.log('searching ranks',recDate);
                var deferred = $q.defer();
                $http.get(urls.RANK_SERVICE_API +"search?recDate="+recDate)
                    .then(
                        function (response) {
                            console.log('Fetched successfully search ranks');
                            $localStorage.ranks = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Search ranks');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            };
            function loadTop10Ranks(recDate) {
                console.log('Fetching Top10 ranks');
                var deferred = $q.defer();
                $http.get(urls.RANK_SERVICE_API +"/top10"+recDate)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Top 10 ranks');
                            $localStorage.ranks = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Top 10 ranks');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            };

            function getTop10Ranks(){
                return $localStorage.ranks;
            };

            function getRank(id) {
                console.log('Fetching Rank with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.RANK_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Rank with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading rank with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createRank(rank) {
                console.log('Creating Rank');
                var deferred = $q.defer();
                $http.post(urls.RANK_SERVICE_API, rank)
                    .then(
                        function (response) {
                            loadAllRanks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Rank : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateRank(rank, id) {
                console.log('Updating Rank with id '+id);
                var deferred = $q.defer();
                $http.put(urls.RANK_SERVICE_API + id, id)
                    .then(
                        function (response) {
                            loadAllRanks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Rank with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeRank(id) {
                console.log('Removing Rank with Website '+id);
                var deferred = $q.defer();
                $http.delete(urls.RANK_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllRanks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Rank with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);