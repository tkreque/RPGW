angular.module('missaoModule', ['rpgApp']).
    controller('missaoController', function($scope, $http){
	
	$scope.missao = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.missao = angular.copy(obj);
	};

	$scope.excluir = function (missao) {
            $http.delete($scope.urlAtual + 'rest/Missao/' +  missao.codigo).success(function (data) {
                $scope.fields = data;
                $scope.todasMissoes();
            });
	};

	$scope.salvarEdicao = function () {
            $http({
                method: 'PUT',
                data: $scope.missao,
                url: $scope.urlAtual + 'rest/Missao',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.excluir($scope.missao);    
                $scope.todasMissoes();
            }).error(function (data, status, headers, config) {
                $scope.todasMissoes();
            });            
            $scope.editarRegistro = false;	
	};

	$scope.cancelarEdicao = function () {
            $scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
            $http({
                method: 'POST',
                data: $scope.fields,
                url: $scope.urlAtual + 'rest/Missao',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.todasMissoes();
            }).error(function (data, status, headers, config) {
                $scope.todasMissoes();
            });
            $scope.redir('/missao-lista');
	};
        
        $scope.todasMissoes = function() {
            $http.get($scope.urlAtual +'rest/Missao').success(function (data) {
                $scope.listaMissoes = data;                
            });
        };

        $scope.consultarMissao = function(missao) {
            $http.get($scope.urlAtual + 'rest/Missao/' + missao.codigo).success(function (data) {
                $scope.fields = data;
            });
        };
});