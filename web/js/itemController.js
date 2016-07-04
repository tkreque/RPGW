angular.module('itemModule', ['rpgApp']).
    controller('itemController', function($scope, $http){
	
        $scope.item = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;
        
        $scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.item = angular.copy(obj);
	};

	$scope.excluir = function (item) {
            $http.delete($scope.urlAtual + 'rest/Item/' + item.id).success(function (data) {
                $scope.item = data;
                $scope.todosItens();
            });	
	};

	$scope.salvarEdicao = function () {            
            $http({
                method: 'PUT',
                data: $scope.item,
                url: $scope.urlAtual + 'rest/Item',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.excluir($scope.item);    
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
                url: $scope.urlAtual + 'rest/Item',
                headers: {'Content-Type': 'application/json'}
            }).success(function (data, status, headers, config) {
                $scope.redir('/item-lista');
            }).error(function (data, status, headers, config) {
                console.log(data);
            });
	};
        
        $scope.todosItens = function() {
            $http.get($scope.urlAtual +'rest/Item').success(function (data) {
                $scope.listaItens = data;                 
            });
        };

        $scope.consultarItem = function(item) {
            $http.get($scope.urlAtual + 'rest/Item/' + item.id).success(function (data) {
                $scope.fields = data;
            });
        };
        
        
});