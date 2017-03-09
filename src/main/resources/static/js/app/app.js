var app = angular.module('rankApp',['ui.router','ngStorage']);
var host = "http://"+window.location.hostname;
if(host.includes("localhost")){
	host="http://"+window.location.hostname+":8080";
	
}
app.constant('urls', {
    BASE: host+'/RanksApp',
    RANK_SERVICE_API : host+'/RanksApp/api/rank/',
   
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
        .state('home',{
            url:'/',
            templateUrl: 'partials/home',
            
               
            })
        .state('upload',{
            url:'/upload',
            templateUrl: 'partials/upload',
                           
            })    
        .state('top5',{
            url:'/top5',
            templateUrl: 'partials/top5',
            controller:'SearchController',
            	controllerAs:'ctrl',
                resolve: {
                    ranks: function ($q, RankService) {
                        console.log('Load top5 ranks');
                        var deferred = $q.defer();
                        RankService.loadAllRanks().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            }).state('admin', {
                url: '/admin',
                templateUrl: 'partials/list',
                controller:'RankController',
                controllerAs:'ctrl',
                resolve: {
                    ranks: function ($q, RankService) {
                        console.log('Load all ranks');
                        var deferred = $q.defer();
                        RankService.loadAllRanks().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
  


}]);

app.directive("datepicker", function () {
	  return {
	    restrict: "A",
	    require: "ngModel",
	    link: function (scope, elem, attrs, ngModelCtrl) {
	      var updateModel = function (dateText) {
	        scope.$apply(function () {
	          ngModelCtrl.$setViewValue(dateText);
	        });
	      };
	      var options = {
	        dateFormat: "mm-dd-yy",
	        onSelect: function (dateText) {
	          updateModel(dateText);
	        }
	      };
	      elem.datepicker(options);
	    }
	  }
	});
