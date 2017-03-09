<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Upload Website Ranks</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	        <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	           
	           <form name="uploadForm" ng-submit="ctrl.submit()">
                 <input id="ufile" ng-model='file' type="file"/>
                 <input type="submit" value='Submit'/>
               </form>
    	    </div>
		</div>	
    </div>
    
</div>