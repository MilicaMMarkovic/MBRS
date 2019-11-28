var demoApp = angular.module('demoApp.services', []);

demoApp.service('takmicenjeService', function($http) {
	
	this.url = 'api/takmicenjeList';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		return $http.get(this.url, { params: {'name': name, 'page': page}});
	};
	
	
	this.save = function(takmicenje) {
		if (takmicenje.id) {
			return $http.put(this.url + '/' + takmicenje.id, takmicenje);
		} else {
			return $http.post(this.url, takmicenje);
		}
	};
});
demoApp.service('trkaService', function($http) {
	
	this.url = 'api/trkaList';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		return $http.get(this.url, { params: {'name': name, 'page': page}});
	};
	
	this.getAllByTakmicenje = function(id) {
		return $http.get(this.url + "/filterByTakmicenje/" + id);
	};
	
	this.save = function(trka) {
		if (trka.id) {
			return $http.put(this.url + '/' + trka.id, trka);
		} else {
			return $http.post(this.url, trka);
		}
	};
});
demoApp.service('takmicarService', function($http) {
	
	this.url = 'api/takmicarList';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		return $http.get(this.url, { params: {'name': name, 'page': page}});
	};
	
	this.getAllByTrka = function(id) {
		return $http.get(this.url + "/filterByTrka/" + id);
	};
	
	this.save = function(takmicar) {
		if (takmicar.id) {
			return $http.put(this.url + '/' + takmicar.id, takmicar);
		} else {
			return $http.post(this.url, takmicar);
		}
	};
});
