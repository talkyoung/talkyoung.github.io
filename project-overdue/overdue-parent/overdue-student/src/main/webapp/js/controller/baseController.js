 //品牌控制层 
app.controller('baseController' ,function($scope){
	$scope.reload = true;
    //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码
		$scope.findTeaAndCou();
		$scope.findAllCourse();
		$scope.getStuName();
		$scope.findComByPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

	//分页控件配置
	$scope.paginationConf = {
		currentPage: 1,
		totalItems: 10,
		itemsPerPage: 5,
		perPageOptions: [5, 10, 15, 20, 25],
		onChange: function(){
			if(!$scope.reload) {
				return;
			}
			$scope.reloadList();//重新加载 这个方法会重复调用两次
			$scope.reload = false;
			setTimeout(function() {
				$scope.reload = true;
			}, 200);
		}
	};
});	