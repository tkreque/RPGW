angular.module('rpgApp', ['ngRoute','personagemModule','itemModule','missaoModule'])
    .controller('rpgController', ['$scope', '$location', function($scope, $location) {
        
        $scope.urlAtual = '/RPGW/';
        
        $scope.redir = function (onde) {
            $location.path(onde);
        };
        
    }])
    .config(['$routeProvider', function ($routeProvider) {        
        $routeProvider.
            when('/personagem-novo', {
                templateUrl: 'partials/novo/personagem-novo.html',
                controller: 'personagemController'
            }).
            when('/personagem-lista', {
                templateUrl: 'partials/lista/personagem-lista.html',
                controller: 'personagemController'
            }).
            when('/item-novo', {
                templateUrl: 'partials/novo/item-novo.html',
                controller: 'itemController'
            }).
            when('/item-lista', {
                templateUrl: 'partials/lista/item-lista.html',
                controller: 'itemController'
            }).                  
            when('/missao-novo', {
                templateUrl: 'partials/novo/missao-novo.html',
                controller: 'missaoController'
            }).
            when('/missao-lista', {
                templateUrl: 'partials/lista/missao-lista.html',
                controller: 'missaoController'
            }).
            when('/', {
                templateUrl: 'partials/inicio.html',
                controller: 'rpgController'
            }).
            when('/404', {
                templateUrl: 'partials/404.html'
            }).
            otherwise({
                redirectTo: '/404'
            });
    }
    ]);      

