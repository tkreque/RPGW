angular.module('rpgApp', ['ngRoute','personagemModule','itemModule','missaoModule'])
    .controller('rpgController', ['$scope', '$location', function($scope, $location) {
            
        $scope.listaPersonagens=[
            {id:10,nome:"Kirof",pj:"Reque",nivel:5,classe:"Ranger",raca:"Elfo",sexo:"M",str:{status:12,mod:1},dex:{status:16,mod:3},cons:{status:12,mod:1},int:{status:8,mod:-1},wis:{status:14,mod:2},cha:{status:12,mod:1}},
            {id:15,nome:"Elannis",pj:"Bruna",nivel:7,classe:"Mago",raca:"Humano",sexo:"F",str:{status:8,mod:-1},dex:{status:10,mod:0},cons:{status:10,mod:0},int:{status:18,mod:4},wis:{status:12,mod:1},cha:{status:15,mod:2}},
            {id:20,nome:"Tanakur",pj:"JP",nivel:1,classe:"Guerreiro",raca:"Meio-Orc",sexo:"M",str:{status:18,mod:4},dex:{status:14,mod:2},cons:{status:17,mod:3},int:{status:8,mod:-1},wis:{status:12,mod:1},cha:{status:8,mod:-1}}
        ];
        $scope.listaItens=[
            {id:1,nome:"Espada Curta",preco:15,peso:5,bonus:{dano:"1d6",critico:"x2"},tipo:"Cortante",categoria:"Arma"},
            {id:2,nome:"Lança",preco:10,peso:3,bonus:{dano:"1d6",critico:"x3"},tipo:"Perfurante",categoria:"Arma"},
            {id:3,nome:"Espada Bastarda",preco:30,peso:25,bonus:{dano:"2d6",critico:"x3"},tipo:"Perfurante",categoria:"Arma"},
            {id:10,nome:"Armadura de couro",preco:18,peso:10,bonus:{ca:"3",penalidade:"5%"},tipo:"Leve",categoria:"Armadura"},
            {id:11,nome:"Cota de malha",preco:25,peso:20,bonus:{ca:"5",penalidade:"12%"},tipo:"Pesada",categoria:"Armadura"},
            {id:12,nome:"Escudo grande",preco:10,peso:8,bonus:{ca:"1",penalidade:"2%"},tipo:"Escudo",categoria:"Armadura"}
        ];
        $scope.listaMissoes=[
            {id:1,nome:"A caverna de Utak!",nd:2,criaturas:["Goblins","Lobos","Orcs"],chefe:"Utak, o Orc Negro",xp:500},
            {id:2,nome:"As árvores mortas",nd:5,criaturas:["Lobos","Orcs","Elfos Negros"],chefe:"Nin, o Beholder",xp:1000},
            {id:3,nome:"A torre do mago",nd:8,criaturas:["Esqueletos","Zumbis","Gargulas"],chefe:"Kilimar, o mago louco",xp:1500}
        ];
        
        
        $scope.getFakeID = function () {
            return Math.floor((Math.random() * 10000) + 500);
        };
        
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

