var wafepaApp = angular.module("wafepaApp", ['ngRoute']);

wafepaApp.controller("homeCtrl", function($scope){
	
	$scope.message = "University project";
	
});

wafepaApp.controller("takmicenjesCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/takmicenjes";
	
	$scope.takmicenje = {};
	$scope.takmicenje.naziv = "";
	$scope.takmicenje.datum = "";
	$scope.takmicenje.kontakt="";
	$scope.takmicenje.organizator="";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	$scope.takmicenjes = [];
	
	var getTakmicenjes = function(){
		
		var config = { params: {}};
		
		config.params.pageNum = $scope.pageNum;
		
		var promise = $http.get(baseUrl);
		promise.then(
			function success(res){
				$scope.takmicenjes = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(res){
				alert("Couldn't get takmicenjes");
			}
		);
	}
	
	getTakmicenjes();
	
	$scope.goToEdit = function(id){
		$location.path("/takmicenjes/edit/" + id);
	}
	
	$scope.doAdd = function(){
		var prom = $http.post(baseUrl, $scope.takmicenje);
		console.log($scope.takmicenje);
		prom.then(
			function success(){
				getTakmicenjes();
				$scope.takmicenje = {};
				$scope.takmicenje.naziv = "";
				$scope.takmicenje.datum = "";
				$scope.takmicenje.kontakt = "";
				$scope.takmicenje.organizator = "";
			},
			function error(){
				alert("Couldn't post takmicenje.");
			}
		);
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
	
	var url = "/api/takmicenjes/" + $routeParams.id;
	
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
				alert("Couldn't get takmicenje.");
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
	
	var trkasUrl = "/api/trkas";
	var takmicenjesUrl = "/api/takmicenjes";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	$scope.trka = {};
	$scope.trka.naziv = "";
	$scope.trka.cena = "";
	$scope.trka.duzinaKm = "";
	$scope.trka.nazivTakmicenja = "";
	$scope.trka.takmicenjeId = "";
	
	$scope.trkas = [];
	
	var getTrkas = function(){
		
		var config = { params: {}};
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(trkasUrl, config).then(
			function success(res){
				$scope.trkas = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Something went wrong!");
			}
		);
	}
	
	getTrkas();
		
	$scope.takmicenjes = [];	
	var getTakmicenjes = function(){
		$http.get(takmicenjesUrl).then(
			function success(res){
				$scope.takmicenjes = res.data;
			},
			function error(){
				alert("Couldn't fetch takmicenjes");
			}
		);
	}	
	getTakmicenjes();
	
	$scope.doAdd = function(){
		var prom = $http.post(trkasUrl, $scope.trka);
		console.log($scope.trka);
		prom.then(
			function success(){
				getTrkas();
				$scope.trka = {};
				$scope.trka.naziv = "";
				$scope.trka.cena = "";
				$scope.trka.duzinaKm = "";
				$scope.trka.nazivTakmicenja = "";
				$scope.trka.takmicenjeId = "";
			},
			function error(){
				alert("Couldn't post trka.");
			}
		);
	}
	
	// ////////////
	$scope.goToEdit = function(id){
		$location.path("/trkas/edit/" + id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getTrkas();
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(trkasUrl + "/" + id);
		promise.then(
			function success(){
				getTrkas();
			},
			function error(){
				alert("Couldn't delete takmicenje.");
			}
		);
	}
});

wafepaApp.controller("editTrkaCtrl", function($scope, $routeParams, $http, $location){
	
	var trkaUrl = "/api/trkas/" + $routeParams.id;
	var takmicenjesUrl = "/api/takmicenjes";

	$scope.trka = {};
	$scope.trka.naziv = "";
	$scope.trka.cena = "";
	$scope.trka.duzinaKm = "";
	$scope.trka.takmicenjeId = "";
	$scope.trka.nazivTakmicenja = "";	
	
	$scope.takmicenjes = [];

	var getTakmicenjes = function(){
		$http.get(takmicenjesUrl).then(
			function success(res){
				$scope.takmicenjes = res.data;
				getTrka();
			},
			function error(){
				alert("Couldn't fetch takmicenjes");
			}
		);
	}
	
	var getTrka = function(){
		$http.get(trkaUrl).then(
			function success(res){
				$scope.trka = res.data;
			},
			function error(){
				alert("Couldn't fetch trka.");
			}
		);
	}

	getTakmicenjes();

	$scope.doEdit = function(){
		$http.put(trkaUrl, $scope.trka).then(
			function success(){
				$location.path("/trkas");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
});

wafepaApp.controller("takmicarsCtrl", function($scope, $http, $location){
	
	var takmicarsUrl = "/api/takmicars";
	var trkasUrl = "/api/trkas";

	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	$scope.takmicar = {};
	$scope.takmicar.imeIPrezime = "";
	$scope.takmicar.jmbg = "";
	$scope.takmicar.kontakt = "";
	$scope.takmicar.pol = "";	
	$scope.takmicar.trkaId = "";
	$scope.takmicar.nazivTrke = "";
	
	$scope.takmicars = [];
	
	var getTakmicars = function(){
		
		var config = { params: {}};
				
		config.params.pageNum = $scope.pageNum;
		
		$http.get(takmicarsUrl, config).then(
			function success(res){
				$scope.takmicars = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Something went wrong!");
			}
		);
	}
	
	getTakmicars();
		
	$scope.trkas = [];	
	var getTrkas = function(){
		$http.get(trkasUrl).then(
			function success(res){
				$scope.trkas = res.data;
			},
			function error(){
				alert("Couldn't fetch activities");
			}
		);
	}
	
	getTrkas();
	
	$scope.doAdd = function(){
		var prom = $http.post(takmicarsUrl, $scope.takmicar);
		console.log($scope.takmicar);
		prom.then(
			function success(){
				getTakmicars();
				$scope.takmicar = {};
				$scope.takmicar.imeIPrezime = "";
				$scope.takmicar.jmbg = "";
				$scope.takmicar.kontakt = "";
				$scope.takmicar.pol = "";	
				$scope.takmicar.trkaId = "";
				$scope.takmicar.nazivTrke = "";
			},
			function error(){
				alert("Couldn't post takmicar.");
			}
		);
	}
	
	// ////////////
	$scope.goToEdit = function(id){
		$location.path("/takmicars/edit/" + id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getTakmicars();
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(takmicarsUrl + "/" + id);
		promise.then(
			function success(){
				getTakmicars();
			},
			function error(){
				alert("Couldn't delete takmicar.");
			}
		);
	}	
});

wafepaApp.controller("editTakmicarCtrl", function($scope, $http, $routeParams, $location){
	
	var takmicarUrl = "/api/takmicars/" + $routeParams.id;
	var trkasUrl = "/api/trkas";
	
	$scope.takmicar = {};
	$scope.takmicar.imeIPrezime = "";
	$scope.takmicar.jmbg = "";
	$scope.takmicar.kontakt = "";
	$scope.takmicar.pol = "";	
	$scope.takmicar.trkaId = "";
	$scope.takmicar.nazivTrke = "";	
	
	$scope.trkas = [];
	
	var getTrkas = function(){
		$http.get(trkasUrl).then(
			function success(res){
				$scope.trkas = res.data;
				getTakmicar();
			},
			function error(){
				alert("Couldn't fetch trkas");
			}
		);
	}
	
	var getTakmicar = function(){
		$http.get(takmicarUrl).then(
			function success(res){
				$scope.takmicar = res.data;
			},
			function error(){
				alert("Couldn't fetch takmicar.");
			}
		);
	}
	
	getTrkas();
	
	$scope.doEdit = function(){
		$http.put(takmicarUrl, $scope.takmicar).then(
			function success(){
				$location.path("/takmicars");
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
		.when('/takmicenjes', {
			templateUrl : '/app/html/takmicenjes.html'
		})
		.when('/trkas', {
			templateUrl : '/app/html/trkas.html'
		})
		.when('/takmicars', {
			templateUrl : '/app/html/takmicars.html'
		})
		.when('/takmicars/edit/:id', {
			templateUrl : '/app/html/edit-takmicar.html'
		})
		.when('/takmicenjes/edit/:id', {
			templateUrl : '/app/html/edit-takmicenje.html'
		})
		.when('/trkas/edit/:id', {
			templateUrl : '/app/html/edit-trka.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);