angular.module('missaoModule', ['rpgApp']).
    controller('missaoController', ['$scope', function($scope){
	
	$scope.missao = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.missao = angular.copy(obj);
	};

	$scope.excluir = function (key) {
            for (var i = 0; i < $scope.listaMissoes.length; i++) {
                if($scope.listaMissoes[i].id===key) {
                    $scope.listaMissoes.splice(i, 1);
                    $scope.pesquisa = '';
                }
            }		
	};

	$scope.salvarEdicao = function () {
            $scope.excluir($scope.missao.id);

            $scope.missao.id = $scope.getFakeID();
            $scope.listaMissoes.push($scope.missao);
            $scope.editarRegistro = false;	
	};

	$scope.cancelarEdicao = function () {
            $scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
            $scope.missao.id = $scope.getFakeID();
            $scope.listaMissoes.push($scope.missao);
            $scope.redir('/missao-lista');
	};
}]);