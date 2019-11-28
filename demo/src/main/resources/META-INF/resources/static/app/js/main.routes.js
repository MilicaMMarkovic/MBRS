var demoApp = angular.module('demoApp.routes', ['ngRoute']);

demoApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
                .when('/takmicenjeList', {
            templateUrl : '/static/app/html/partial/takmicenjeList.html',
            controller : 'TakmicenjeController'
        })
        .when('/takmicenjeList/add', {
            templateUrl : '/static/app/html/partial/addEditTakmicenje.html',
            controller : 'TakmicenjeController'
        })
        .when('/takmicenjeList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditTakmicenje.html',
            controller : 'TakmicenjeController'
        })
        .when('/takmicenjeList/:id', {
            templateUrl : '/static/app/html/partial/viewTakmicenje.html',
            controller : 'TakmicenjeController'
        })
        .when('/trkaList', {
            templateUrl : '/static/app/html/partial/trkaList.html',
            controller : 'TrkaController'
        })
        .when('/trkaList/add', {
            templateUrl : '/static/app/html/partial/addEditTrka.html',
            controller : 'TrkaController'
        })
        .when('/trkaList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditTrka.html',
            controller : 'TrkaController'
        })
        .when('/trkaList/:id', {
            templateUrl : '/static/app/html/partial/viewTrka.html',
            controller : 'TrkaController'
        })
        .when('/takmicarList', {
            templateUrl : '/static/app/html/partial/takmicarList.html',
            controller : 'TakmicarController'
        })
        .when('/takmicarList/add', {
            templateUrl : '/static/app/html/partial/addEditTakmicar.html',
            controller : 'TakmicarController'
        })
        .when('/takmicarList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditTakmicar.html',
            controller : 'TakmicarController'
        })
        .when('/takmicarList/:id', {
            templateUrl : '/static/app/html/partial/viewTakmicar.html',
            controller : 'TakmicarController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
