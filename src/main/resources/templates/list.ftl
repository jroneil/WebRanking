<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Rank </span><span class="floatRight"><a ng-href="/RanksApp/#/home">Home</a></span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.rank.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="website">Website</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.rank.website" id="website" class="form-control input-sm" placeholder="Enter Website." required />
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="lastupdate">Last Update</label>
	                        <div  id="wrapper" ng-app="app" class="col-md-7">
	                               <input type="text" ng-model="ctrl.rank.recDate" datepicker placeholder="Enter Last Update." required />
	                       
	                            
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="visits">Visits</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.rank.visits" if="visits" class="form-control input-sm" placeholder="Enter Visits." required ng-pattern="ctrl.onlyNumbers"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.rank.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" >Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Ranks </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		            	<th>ID</th>
		                <th>Website</th>
		                <th>Date</th>
		                <th>visits</th>
		                <th width="100"></th>
                        <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="r in ctrl.getAllRanks()">
		                <td>{{r.id}}</td>
		                <td>{{r.website}}</td>
		                <td>{{r.recDate}}</td>
		                <td>{{r.visits}}</td>
		                
		                <td><button type="button" ng-click="ctrl.editRank(r.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeRank(r.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>
