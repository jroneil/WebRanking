<!DOCTYPE html>

<html lang="en" ng-app="rankApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        <link href="css/jquery-ui.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        
		 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="js/lib/jquery-ui-1.12.1.custom/jquery-ui.js" ></script>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/RankService.js"></script>
        <script src="js/app/RankController.js"></script>
        <script src="js/app/SearchController.js"></script>
        
    </body>
</html>