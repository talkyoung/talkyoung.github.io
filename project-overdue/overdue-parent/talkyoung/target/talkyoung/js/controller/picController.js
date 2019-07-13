app.controller("picController",function ($scope) {
    $scope.uploadFile=function(){
        uploadService.uploadFile().success(function(response) {
            if(response.success){//如果上传成功，取出url
                $scope.image_entity.url=response.message;//设置文件地址
            }else{
                alert(response.message);
            }
        }).error(function() {
            alert("上传发生错误");
        });
    };
});