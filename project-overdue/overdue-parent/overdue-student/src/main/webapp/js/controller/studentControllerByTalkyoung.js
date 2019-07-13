app.controller('studentControllerByTalkyoung', function ($scope, $controller, studentServiceByTalkyoung, $sce, $location, $anchorScroll) {
    $controller('baseController', {$scope: $scope});//继承
    $scope.textContent = "请在这里填写你的疑惑和回复。";
    $scope.judgement = false;
    $scope.teaId = null;
    $scope.teaName = null;
    $scope.judgeteaId = 1;
    //根据stuId查找tea和couId
    $scope.findTeaAndCou = function(){
        studentServiceByTalkyoung.findTeaAndCou().success(function (response) {
            $scope.teaAndCous = response;
        })
    };
    //查找教师的所有文件
    $scope.showFile = function (tId,courseId,teacherName) {
        $scope.judgeteaId = 2;
        $scope.teacherName = teacherName;
        studentServiceByTalkyoung.showFile(tId,courseId).success(function (response) {
            $scope.fileList = response;
        });
    };
    //选择教师后，将教师id添加到变量teaId中，用于学生回复留言实体的teaId字段
    $scope.changeTeaId = function (teaId) {
        $scope.teaId = teaId;
    };
    //删除留言
    $scope.deleteReply = function (comId) {
        studentServiceByTalkyoung.deleteReply(comId).success(
            function (response) {
                if (response.success) {
                    alert(response.message);
                    $scope.reloadList();
                } else {
                    alert(response.message);
                    $scope.reloadList();
                }
            })
    };
    //提交留言
    $scope.sendComment = function (content, teaId) {
        if (teaId == null) {
            alert("请选择教师后进行留言");
            return;
        }
        studentServiceByTalkyoung.sendComment(content, teaId).success(
            function (response) {
                if (response.success) {
                    alert(response.message);
                    $scope.textContent = "请在这里填写你的疑惑和回复。";
                    $scope.reloadList();
                } else {
                    alert(response.message);
                    $scope.textContent = "请在这里填写你的疑惑和回复。";
                    $scope.reloadList();
                }
            });
    };
    //分页查找comments
    $scope.findComByPage = function (page, row) {
        studentServiceByTalkyoung.findComByPage(page, row).success(
            function (response) {
                $scope.comments = response.rows;
                $scope.paginationConf.totalItems = response.total;
            })
    };
    //根据当前登陆学生id查找comments内容给前端
    $scope.showComments = function () {
        studentServiceByTalkyoung.showComments().success(
            function (response) {
                $scope.comments = response;
            });
    };
    //当点击回复时，将text里面的文本清空
    $scope.replay = function (teaId,teaName) {
        $scope.teaId = teaId;
        $scope.teaName = teaName;
        $scope.textContent = null;
    };
    //鼠标回滚的实现
    /*   $scope.gotoText = function () {
           $location.hash("message");
           $anchorScroll();
       }*/

    //查询学生姓名
    $scope.getStuName = function () {
        studentServiceByTalkyoung.getStuName().success(
            function (response) {
                $scope.name = response;
            });
    };
    //处理html5中video标签的src属性出现访问域限制问题
    $scope.videoUrl = function (url) {
        return $sce.trustAsResourceUrl(url);
    };

    /*$scope.courseList = [{}];
    $scope.test=[1,2,3,4];*/
    $scope.findAllCourse = function () {
        studentServiceByTalkyoung.findAllCourse().success(
            function (response) {
                // $scope.courseList = JSON.parse(response);
                $scope.courseList = response;
                $scope.teaId = null;
                $scope.teaName = null;
                /*alert($scope.test);
                alert($scope.courseList);
                alert($scope.courseList[1]);*/
            });
    };
    //根据课程id查询所有任课教师
    //返回的teacherIdList是 [] 格式
    // $scope.showTeacher = function (cId) {
    //     http://localhost:9202/jsp/main.jsp
    //     studentServiceByTalkyoung.showTeacher(cId).success(
    //         function (response) {
    //             if (response == null){
    //                 alert("afdasfsd");
    //                 return;
    //             }
    //             $scope.judgement = true;
    //             $scope.teacherIdList = response;
    //         });
    // }
    $scope.showTeacher = function (cId) {
        $scope.teacherIdList = null;
        studentServiceByTalkyoung.showTeacher(cId).success(
            function (response) {
                if (response.success) {
                    $scope.judgement = true;
                    $scope.teacherIdList = JSON.parse(response.message);
                    $scope.showVideo($scope.teacherIdList.teaId);
                    $scope.showFile($scope.teacherIdList.teaId);
                    $scope.teaId = $scope.teacherIdList.teaId;
                    $scope.teaName = $scope.teacherIdList.teaName;
                    $scope.fileList = null;
                } else {
                    $scope.teaId = null;
                    $scope.teaName = null;
                    $scope.judgement = true;
                    $scope.teacherIdList = null;
                    $scope.videoList = null;
                }
            });
    };
    //根据教师id查询改教师的视频资源
    $scope.showVideo = function (tId,courseId,teacherName) {
        $scope.judgeteaId = 2;
        $scope.teacherName = teacherName;
        studentServiceByTalkyoung.showVideo(tId,courseId).success(
            function (response) {
                $scope.videoList = response;
            });
    }
    $scope.showVideo1 = function(){
        $scope.judgeteaId = 2;
        $scope.videoList = null;
        alert("该课程尚未分配任务。");
    }
    $scope.showFile1 = function(){
        $scope.judgeteaId = 2;
        $scope.fileList = null;
        alert("该课程尚未分配任务。");

    }
    $scope.noTea = function(){
        alert("尚未分配教师");
        $scope.textContent = "请在这里填写你的疑惑和回复。";
        $scope.reloadList();
    }
});