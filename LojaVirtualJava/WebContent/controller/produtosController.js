var produtosModulo = angular.module("produtosModulo",['ngStorage']);

produtosModulo.controller("produtosController",function($scope, $http, $localStorage){
	
	urlProdutos = 'http://localhost:8080/LojaVirtualJava/rest/produtos';	
	$scope.listaProdutos = function(){
		$http.get(urlProdutos).success(function(produto){
			$scope.produtos = produto;
		}).error(function(erro){
			alert("Erro ao listar produtos via REST => " + erro);
		});
	}
	//executar o metodo listar
	$scope.listaProdutos();

	$scope.selecionaProduto = function(produtoSelecionado){
		$scope.produto = produtoSelecionado;
	};

	$scope.salvarProduto = function(){
		$scope.produtos.push($scope.produto);
	};

	$scope.limparCampos = function(){
		$scope.produto = "";
	};	
	//localStorage para o carrinho
	if($localStorage.carrinho != null)
	{
		 $scope.produtosCart = $localStorage.carrinho;
	}else{
		$localStorage.carrinho = [];
		$scope.produtosCart = [];
	}	

	$scope.adicionarProduto = function(produto){		
		if($scope.containsProduto(produto,$scope.produtosCart))
		{
			produto.quantidade++;
		}else{
			$scope.produtosCart.push(produto);
			$localStorage.carrinho.push(produto);
		}
	};

	$scope.removerProduto = function(index) {
        $scope.produtosCart.splice(index, 1);
        $localStorage.carrinho.splice(index, 1);
    }

     $scope.totalProduto = function(prod) {
        var total = 0;
        angular.forEach($scope.produtosCart, function() {
            total = prod.quantidade * prod.preco;
        })

        return total;
    }
 
    $scope.subtotal = function() {
        var total = 0;
        angular.forEach($scope.produtosCart, function(produto) {
            total += produto.quantidade * produto.preco;
        })

        return total;
    }

    $scope.qtdTotal = function() {
        var qtdTotal = 0;
        angular.forEach($scope.produtosCart, function(produto) {
            qtdTotal += produto.quantidade;
        })

        return qtdTotal;
    }

    $scope.containsProduto = function(obj, list) {
	    var i;
	    for (i = 0; i < list.length; i++) {
	        if (angular.equals(list[i], obj)) {
	            return true;         
	        }
	    }
	    return false;
	};

	
    /*$scope("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);*/
})
