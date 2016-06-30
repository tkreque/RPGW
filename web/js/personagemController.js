angular.module('personagemModule', ['rpgApp']).
    controller('personagemController', ['$scope', function($scope){
	
	$scope.personagem = {};
	$scope.pesquisa = '';
	$scope.editarRegistro = false;

	$scope.editar = function (obj) {
            $scope.editarRegistro = true;
            $scope.personagem = angular.copy(obj);
	};

	$scope.excluir = function (key) {
            for (var i = 0; i < $scope.listaPersonagens.length; i++) {
                if($scope.listaPersonagens[i].id===key) {
                    $scope.listaPersonagens.splice(i, 1);
                    $scope.pesquisa = '';
                }
            }		
	};

	$scope.salvarEdicao = function () {
            $scope.excluir($scope.personagem.id);

            $scope.personagem.id = $scope.getFakeID();
            $scope.listaPersonagens.push($scope.personagem);
            $scope.editarRegistro = false;	
	};

	$scope.cancelarEdicao = function () {
            $scope.editarRegistro = false;	
	};

	$scope.salvar = function () {
            $scope.personagem.id = $scope.getFakeID();
            $scope.listaPersonagens.push($scope.personagem);
            $scope.redir('/personagem-lista');
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
}]);