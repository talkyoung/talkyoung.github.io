app.controller('baseController' ,function($scope){
	
    //重新加载列表 数据
    $scope.reloadList=function(){
		$scope.findTeaName();
        $scope.findAssignDetail();
    	//切换页码
    	$scope.findComByPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 5,
         perPageOptions: [5, 10, 15, 20, 25],
         onChange: function(){
        	 $scope.reloadList();//重新加载
     	 }
	};

});