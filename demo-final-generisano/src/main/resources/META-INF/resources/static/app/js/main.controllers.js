var demoApp = angular.module('demoApp.controllers', ['ui.bootstrap']);

demoApp.controller('TakmicenjeController', function($scope, $location, $routeParams, $uibModal,
	 
	trkaService, 
	takmicenjeService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.takmicenjeList = $scope.takmicenjeList.slice().reverse();
	}
	
	$scope.maxSize = 12;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditTakmicenjeConfirmationController',
		      size : 'sm',
		      resolve: {
		          takmicenje: function () {
		            return $scope.takmicenje;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/takmicenjeList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		takmicenjeService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.takmicenjeList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		takmicenjeService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Takmicenje with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Takmicenje with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.takmicenje = {};
		if ($routeParams.id) {  // edit stranica
			takmicenjeService.getOne($routeParams.id)
					.success(function(data) {
						$scope.takmicenje = data;
						trkaService.getAllByTakmicenje($scope.takmicenje.id)
							.success(function(data) {
								$scope.trkaList = data;
							})
							.error(function() {
								
							});
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Takmicenje with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditTakmicenjeConfirmationController', function($scope, $uibModalInstance, takmicenjeService, takmicenje) {
	
	$scope.takmicenje = takmicenje;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		takmicenjeService.save($scope.takmicenje)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('TrkaController', function($scope, $location, $routeParams, $uibModal,
	takmicenjeService,  
	
	trkaService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.trkaList = $scope.trkaList.slice().reverse();
	}
	
	$scope.maxSize = 12;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		$scope.trka.takmicenje = JSON.parse($scope.trka.takmicenje);
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditTrkaConfirmationController',
		      size : 'sm',
		      resolve: {
		          trka: function () {
		            return $scope.trka;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/trkaList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		trkaService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.trkaList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		trkaService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Trka with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Trka with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.trka = {};
			takmicenjeService.getAll()
				.success(function(data) {
						$scope.takmicenjeList = data;
					});
		if ($routeParams.id) {  // edit stranica
			trkaService.getOne($routeParams.id)
					.success(function(data) {
						$scope.trka = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Trka with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditTrkaConfirmationController', function($scope, $uibModalInstance, trkaService, trka) {
	
	$scope.trka = trka;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		trkaService.save($scope.trka)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('TakmicarController', function($scope, $location, $routeParams, $uibModal,
	trkaService,  
	
	takmicarService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.takmicarList = $scope.takmicarList.slice().reverse();
	}
	
	$scope.maxSize = 12;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		$scope.takmicar.trka = JSON.parse($scope.takmicar.trka);
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditTakmicarConfirmationController',
		      size : 'sm',
		      resolve: {
		          takmicar: function () {
		            return $scope.takmicar;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/takmicarList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		takmicarService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.takmicarList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		takmicarService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Takmicar with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Takmicar with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.takmicar = {};
			trkaService.getAll()
				.success(function(data) {
						$scope.trkaList = data;
					});
		if ($routeParams.id) {  // edit stranica
			takmicarService.getOne($routeParams.id)
					.success(function(data) {
						$scope.takmicar = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Takmicar with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditTakmicarConfirmationController', function($scope, $uibModalInstance, takmicarService, takmicar) {
	
	$scope.takmicar = takmicar;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		takmicarService.save($scope.takmicar)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
