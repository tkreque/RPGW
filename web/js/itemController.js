angular.module('itemModule', ['rpgApp']).
    controller('itemController', ['$scope', function($scope){
	
	$scope.item = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.item = angular.copy(obj);
	};

	$scope.excluir = function (key) {
            for (var i = 0; i < $scope.listaItens.length; i++) {
                if($scope.listaItens[i].id===key) {
                    $scope.listaItens.splice(i, 1);
                    $scope.pesquisa = '';
                }
            }		
	};

	$scope.salvarEdicao = function () {
            $scope.excluir($scope.item.id);

            $scope.item.id = $scope.getFakeID();
            $scope.listaItens.push($scope.item);
            $scope.editarRegistro = false;	
	};

	$scope.cancelarEdicao = function () {
            $scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
            $scope.item.id = $scope.getFakeID();
            $scope.listaItens.push($scope.item);
            $scope.redir('/item-lista');
	};
}]);