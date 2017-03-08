<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Search for Top Ranks By Date </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	               
	                

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="recDate">Date</label>
	                        <div  id="wrapper" ng-app="app" class="col-md-7">
	                               <input id="recDate" type="text" ng-model="ctrl.rank.recDate" datepicker placeholder="Enter Date."  />
	                       
	                            
	                        </div>
	                    </div>
	                </div>
	
	              

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Search" class="btn btn-primary btn-sm" >
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">'Top 5 Websites Ranking </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		            	<th>ID</th>
		                <th>Website</th>
		                <th>Date</th>
		                <th>visits</th>
		                
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="r in ctrl.getAllRanks()">
		                <td>{{r.id}}</td>
		                <td>{{r.website}}</td>
		                <td>{{r.recDate}}</td>
		                <td>{{r.visits}}</td>
		                
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>