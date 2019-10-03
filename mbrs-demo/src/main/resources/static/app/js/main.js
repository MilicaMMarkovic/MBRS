var wafepaApp = angular.module("wafepaApp", ['ngRoute']);

wafepaApp.controller("homeCtrl", function($scope){
	
	$scope.message = "Hello JWD 31";
	
});

//wafepaApp.controller("activitiesCtrl", function($scope, $http, $location){
//	
//	var baseUrl = "/api/activities";
//	
//	$scope.activities = [];
//	
//	var getActivities = function(){
//		
//		var promise = $http.get(baseUrl);
//		promise.then(
//			function success(res){
//				$scope.activities = res.data;
//			},
//			function error(res){
//				alert("Couldn't get activities");
//			}
//		);
//		
//		//console.log("Poruka");
//	}
//	
//	getActivities();
//	
//	$scope.goToEdit = function(id){
//		$location.path("/activities/edit/" + id);
//	}
//	
//	$scope.goToAdd = function(){
//		$location.path("/activities/add");
//	}
//	
//	$scope.doDelete = function(id){
//		var promise = $http.delete(baseUrl + "/" + id);
//		promise.then(
//			function success(){
//				getActivities();
//			},
//			function error(){
//				alert("Couldn't delete activity.");
//			}
//		);
//	}
//});

wafepaApp.controller("takmicenjesCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/takmicenjes";
	
	$scope.taks = [];
	
	var getTakmicenjes = function(){
		
		var promise = $http.get(baseUrl);
		promise.then(
			function success(res){
				$scope.taks = res.data;
				console.log(res.data);
			},
			function error(res){
				alert("Couldn't get takmicenjes");
			}
		);		
		//console.log("Poruka");
	}
	
	getTakmicenjes();
	
	$scope.goToEdit = function(id){
		$location.path("/takmicenjes/edit/" + id);
	}
	
	$scope.goToAdd = function(){
		$location.path("/takmicenjes/add");
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getTakmicenjes();
			},
			function error(){
				alert("Couldn't delete takmicenje.");
			}
		);
	}
});



wafepaApp.controller("editTakmicenjeCtrl", function($scope, $routeParams, $http, $location){
	
	var url = "/api/takicenjes/" + $routeParams.aid;
	
	$scope.takmicenje = {};
	$scope.takmicenje.naziv = "";
	$scope.takmicenje.kontakt = "";
	$scope.takmicenje.datum = "";
	$scope.takmicenje.organizator = "";
	
	var getTakmicenje = function(){
		$http.get(url).then(
			function success(res){
				$scope.takmicenje = res.data;
			},
			function error(){
				alert("Couldn't get activity.");
			}
		);
	}
	
	getTakmicenje();
	
	$scope.doEdit = function(){
		$http.put(url, $scope.takmicenje).then(
			function success(){
				$location.path("/takmicenjes");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
});

wafepaApp.controller("trkasCtrl", function($scope, $http, $location){

	var baseUrl = "/api/trkas";

	$scope.trkas = [];

	var getTrkas = function(){
		
		var promise = $http.get(baseUrl);
		promise.then(
			function success(res){
				$scope.trkas = res.data;
			},
			function error(res){
				alert("Couldn't get takmicars");
			}
		);
		
		//console.log("Poruka");
	}

	getTrkas();

	$scope.goToEdit = function(id){
		$location.path("/trkas/edit/" + id);
	}

	$scope.goToAdd = function(){
		$location.path("/trkas/add");
	}

	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getTrkas();
			},
			function error(){
				alert("Couldn't delete activity.");
			}
		);
	}
	});

wafepaApp.controller("editTrkaCtrl", function($scope, $routeParams, $http, $location){
	
	var url = "/api/trkas/" + $routeParams.aid;
	
	$scope.trka = {};
	$scope.trka.cena = "";
	$scope.trka.duzinaKm = "";
	$scope.trka.naziv = "";
	$scope.trka.nazivTakmicenja = "";
	$scope.trka.takmicenjeId = "";
	
	var getTrka = function(){
		$http.get(url).then(
			function success(res){
				$scope.trka = res.data;
			},
			function error(){
				alert("Couldn't get takmicenje.");
			}
		);
	}
	
	getTrka();
	
	$scope.doEdit = function(){
		$http.put(url, $scope.trka).then(
			function success(){
				$location.path("/trkas");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
});


wafepaApp.controller("addTrkaCtrl", function($scope, $http, $location){
	
	var url = "/api/trkas";
	
	$scope.trka = {};
	$scope.trka.cena = "";
	$scope.trka.duzinaKm = "";
	$scope.trka.naziv = "";
	$scope.trka.nazivTakmicenja = "";
	$scope.trka.takmicenjeId = "";
	
	$scope.doAdd = function(){
		$http.post(url, $scope.trka).then(
			function uspeh(){
				$location.path("/trkas");
			},
			function neuspeh(){
				alert("Pisi na srpskom.");
			}
		);
	}
	
	
});


////////// $location
wafepaApp.controller("recordsCtrl", function($scope, $http, $location){
	
	var recordsUrl = "/api/records";
	var activitiesUrl = "/api/activities";
	var usersUrl = "/api/users";
	
	$scope.searchParams = {};
	$scope.searchParams.activity = "";
	$scope.searchParams.minimalDuration = "";
	$scope.searchParams.intensity = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	$scope.record = {};
	$scope.record.time = "";
	$scope.record.duration = "";
	$scope.record.intensity = "";
	$scope.record.userId = "";
	$scope.record.activityId = "";
	
	
	$scope.records = [];
	
	var getRecords = function(){
		
		var config = { params: {}};
		
		if($scope.searchParams.activity != ""){
			config.params.activityName = $scope.searchParams.activity;
		}
		
		if($scope.searchParams.minimalDuration != ""){
			config.params.minDuration = $scope.searchParams.minimalDuration;
		}
		
		if($scope.searchParams.intensity != ""){
			config.params.intensity = $scope.searchParams.intensity;
		}
				
		config.params.pageNum = $scope.pageNum;
		
		$http.get(recordsUrl, config).then(
			function success(res){
				$scope.records = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Something went wrong!");
			}
		);
	}
	
	getRecords();
	
	
	$scope.activities = [];	
	var getActivities = function(){
		$http.get(activitiesUrl).then(
			function success(res){
				$scope.activities = res.data;
			},
			function error(){
				alert("Couldn't fetch activities");
			}
		);
	}
	
	getActivities();
	
	
	$scope.users = [];
	var getUsers = function(){
		$http.get(usersUrl).then(
			function success(res){
				$scope.users = res.data;
			},
			function error(){
				alert("Couldn't fetch users.");
			}
		);
	}
	
	getUsers();
	
	$scope.doAdd = function(){
		var prom = $http.post(recordsUrl, $scope.record);
		prom.then(
			function success(){
				getRecords();
			},
			function error(){
				alert("Couldn't post record.");
			}
		);
	}
	
	//////////////
	$scope.goToEdit = function(id){
		$location.path("/records/edit/" + id);
	}
	
	$scope.doSearch = function(){
		//console.log($scope.searchParams);
		$scope.pageNum = 0;
		getRecords();
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getRecords();
	}
	
});

///////
wafepaApp.controller("editRecordCtrl", function($scope, $http, $routeParams, $location){
	
	var recordUrl = "/api/records/" + $routeParams.id;
	var activitiesUrl = "/api/activities";
	var usersUrl = "/api/users";
	
	$scope.record = {};
	$scope.record.time = "";
	$scope.record.duration = "";
	$scope.record.intensity = "";
	$scope.record.userId = "";
	$scope.record.activityId = "";	
	
	
	$scope.activities = [];
	$scope.users = [];
	
	
	
	var getActivities = function(){
		$http.get(activitiesUrl).then(
			function success(res){
				$scope.activities = res.data;
				getUsers();
			},
			function error(){
				alert("Couldn't fetch activities");
			}
		);
	}
	
	var getUsers = function(){
		return $http.get(usersUrl).then(
			function success(res){
				$scope.users = res.data;
				getRecord();
			},
			function error(){
				alert("Couldn't fetch users.");
			}
		);
	}
	
	var getRecord = function(){
		$http.get(recordUrl).then(
			function success(res){
				$scope.record = res.data;
			},
			function error(){
				alert("Couldn't fetch record.");
			}
		);
	}
	
	//getUsers();
	getActivities();
	//getRecord();
	// Pogledati promise chaining kako bi se ovo odradilo na kraci nacin
	// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then#Chaining
	// https://javascript.info/promise-chaining
	
	$scope.doEdit = function(){
		$http.put(recordUrl, $scope.record).then(
			function success(){
				$location.path("/records");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
});

wafepaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: 'homeCtrl'
		})
		.when('/activities', {
			templateUrl : '/app/html/activities.html'
		})
		.when('/takmicenjes', {
			templateUrl : '/app/html/takmicenjes.html'
		})
		.when('/trkas', {
			templateUrl : '/app/html/trkas.html'
		})
		.when('/takmicars', {
			templateUrl : '/app/html/takmicars.html'
		})
		.when('/activities/add', {
			templateUrl : '/app/html/add-activity.html'
		})
		.when('/takmicenjes/add', {
			templateUrl : '/app/html/add-takmicenje.html'
		})
		.when('/trkas/add', {
			templateUrl : '/app/html/add-trka.html'
		})
		.when('/takmicars/add', {
			templateUrl : '/app/html/add-takmicar.html'
		})
		.when('/activities/edit/:aid', {
			templateUrl : '/app/html/edit-activity.html'
		})
		.when('/records', {
			templateUrl : '/app/html/records.html'
		})
		.when('/records/edit/:id', {
			templateUrl : '/app/html/edit-record.html'
		})
		
		.otherwise({
			redirectTo: '/'
		});
}]);