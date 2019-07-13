app.controller('uploadController', function ($scope, uploadService, $sce) {
    $scope.test = [{"id": 1}, {"id": 2}];
    $scope.courseList = [{"id": 1}, {"id": 2}];
    $scope.courseId = 0;
    $scope.courseName = null;
    $scope.judgeVorF = 0;
    //处理html5中video标签的src属性出现访问域限制问题
    $scope.videoUrl = function (url) {
        return $sce.trustAsResourceUrl(url);
    };
    $scope.findFileByCouId = function (courseId, courseName) {
        uploadService.findFileByCouId(courseId).success(function (response) {
            $scope.judgeVorF = 2;
            $scope.courseId = courseId;
            $scope.courseName = courseName;
            $scope.filesByCourse = response;
        })
    };
    $scope.findVideoByCouId = function (courseId, courseName) {
        $scope.courseName = courseName;
        $scope.courseId = courseId;
        uploadService.findVideoByCouId(courseId).success(function (response) {
            $scope.judgeVorF = 1;
            $scope.videosByCourse = response;
        })
    };
    $scope.pushCourseId = function (courseId) {
        $scope.courseId = courseId;
    };
    $scope.findAssignDetail = function () {
        uploadService.findAssignDetail().success(function (response) {
            $scope.assignDetails = response;
        })
    };
    //根据couId查询资料
    //查询当前登陆教师姓名
    $scope.findTeaName = function () {
        uploadService.findTeaName().success(function (response) {
            $scope.name = response;
        });
    };

    //上传代码
    $scope.uploadFile = function () {
        uploadService.uploadFile().success(function (response) {
            if (response.success) {//如果上传成功，取出url
                alert("上传成功");
            } else {
                alert(response.message);
            }
        }).error(function () {
            alert("上传发生错误");
        });
    };
    //video格式
    $scope.videoList = [{'tId': '', 'vId': '', 'vName': ''}];
    //当页面首次加载时查找所有的文件
    $scope.findAllFile = function () {
        uploadService.findAllFile().success(function (response) {
            $scope.fileList = response;
            $scope.findTeaName();
        });
    };
    //查找当前教师拥有的所有视频并返回给videoList
    $scope.findAllVideo = function () {
        uploadService.findAllVideo().success(function (response) {
            $scope.videoList = response.videoList;
            $scope.findTeaName();
        })
    };
    //根据单个id删除file
    $scope.deleteFileById = function (fId) {
        uploadService.deleteFileById(fId).success(function (response) {
            if (response.success) {
                // $scope.findFileByCouId(courseId, courseName);
                $scope.findAllFile();
                alert(response.message);
            } else {
                alert(response.message);
            }
        })
    };
    //根据单个id删除video
    $scope.deleteVideoById = function (vId) {
        uploadService.deleteVideoById(vId).success(function (response) {
            if (response.success) {
                $scope.findAllVideo();
                alert(response.message);
            } else {
                alert(response.message);
            }
        })
    };

    $scope.selectIds = [];//选中的ID集合

    //更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//如果是被选中,则增加到数组
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    };

    //批量删除video
    $scope.deleMultiVodeo = function () {
        //获取选中的复选框
        uploadService.deleMultiVodeo($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.selectIds = [];
                    alert(response.message);
                }
            }
        );
    };
    //批量删除file
    $scope.deleMultiFile = function () {
        //获取选中的复选框
        uploadService.deleMultiFile($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.selectIds = [];
                    alert(response.message);
                }
            }
        );
    };

    // $scope.flag = false;
    //当点击首个复选框时默认选择所有，否则取消所有
    $scope.selectAllCheck = function () {
        //当选中时，所有子复选框全部选中，并且添加到selectIds里面
        //                              不会！！！！！！！！！！！！！
        //当取消选中，子复选框也取消，并将selectIds清空
    }
});