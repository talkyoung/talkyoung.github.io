//服务层
app.service('studentService',function($http){
	this.uploadFile = function () {
		var formData = new FormData();
		formData.append("file", file.files[0]);
		return $http({
			method: 'POST',
			url: "/studentExcel/importStu.do",
			data: formData,
			headers: {'Content-Type': undefined},
			transformRequest: angular.identity
			/* anjularjs对于post和get请求默认的Content-Type header 是application/json。通过设置‘Content-Type’:
                 undefined，这样浏览器会帮我们把Content-Type 设置为 multipart/form-data.*/
		});
	}
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../student/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../student/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../student/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../student/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../student/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../student/delete.do?ids='+ids);
	}
	//搜索	
	this.search=function(page,rows,searchEntity) {
		return $http.post('../student/search.do?page='+page+"&rows="+rows,searchEntity);
	}
	
});
