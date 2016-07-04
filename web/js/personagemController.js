angular.module('personagemModule', ['rpgApp']).
    controller('personagemController', function($scope, $http){
	
	$scope.personagem = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.personagem = angular.copy(obj);
	};

	$scope.excluir = function (personagem) {
            console.log(personagem);
             $http.delete($scope.urlAtual + 'rest/Personagem/' + personagem.id).success(function (data) {
                $scope.personagem = data;
                $scope.todosPersonagens();
            });	
	};

	$scope.salvarEdicao = function () {
            $http({
                method: 'PUT',
                data: $scope.personagem,
                url: $scope.urlAtual + 'rest/Personagem',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.excluir($scope.personagem);    
                $scope.editarRegistro = false;
            }).error(function (data, status, headers, config) {
                console.log(data);
            });	
	};

	$scope.cancelarEdicao = function () {
            $scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
            $http({
                method: 'POST',
                data: $scope.fields,
                url: $scope.urlAtual + 'rest/Personagem',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.redir('/personagem-lista');
            }).error(function (data, status, headers, config) {
                console.log(data);
            });
	};
        
        $scope.todosPersonagens = function() {
            $http.get($scope.urlAtual +'rest/Personagem').success(function (data) {
                $scope.listaPersonagens = data;                
            });
        };

        $scope.consultarPersonagem = function(personagem) {
            $http.get($scope.urlAtual + 'rest/Personagem/' + personagem.codigo).success(function (data) {
                $scope.fields = data;
            });
        };
        
       $scope.setMod = function(valor){
       var mod = 0 ; 
       if (valor<8 && valor>=6)
            mod=-2;
        else if (valor<10 && valor>=8)
            mod=-1;
        else if (valor<12 && valor>=10)
            mod=0;
        else if (valor<14 && valor>=12)
            mod=+1;
        else if (valor<16 && valor>=14)
            mod=+2;
        else if (valor<18 && valor>=16)
            mod=+3;
        else if (valor<20 && valor>=18)
            mod=+4;
        else if (valor<22 && valor>=20)
            mod=+5;
        else if (valor<24 && valor>=22)
            mod=+6;
        else if (valor<26 && valor>=24)
            mod=+7;
        else if (valor>=26)
            mod=+8;
        
        return mod;
    };
});