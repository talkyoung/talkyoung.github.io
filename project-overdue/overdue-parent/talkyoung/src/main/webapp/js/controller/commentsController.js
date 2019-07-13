app.controller("commentsController", function ($scope, $controller, commentsService) {
    $controller('baseController', {$scope: $scope});//继承
    // $scope.couList = {"1": "ssm", "2": "bigData", "3": "java", "4": "离散数学", "5": "大学语文"};
    // $scope.teaList = {"1": "1", "2": "talkyoung", "3": "张三", "4": "李四", "5": "王五", "6": "老六"};
    // $scope.stuList = {"1": "11111", "2": "talkyoung", "3": "zhangsan", "4": "1"};

    $scope.textContent = "请选择回复对象后在这里给对应的学生进行答疑(点击回复按钮，对象为该留言对应的学生)。";
    //查找教师的分配详情
    $scope.findAssignDetail = function () {
        commentsService.findAssignDetail().success(function (response) {
            $scope.assignDetails = response;
        })
    };
    //删除留言
    $scope.deleteReply = function (comId) {
        commentsService.deleteReply(comId).success(
            function (response) {
                if (response.success) {
                    alert(response.message);
                    $scope.reloadList();
                } else {
                    alert(response.message);
                    $scope.reloadList();
                }
            })
    }

    //当点击回复时，将text里面的文本清空
    $scope.replay = function (stuId,stuName) {
        $scope.stuName = stuName;
        $scope.stuId = stuId;
        $scope.textContent = null;
    }

    //保存教师的留言回复
    $scope.sendComment = function (textContent, stuId) {
        if (stuId == null){
            alert("请选择一个回复对象后再进行回复 !（点击回复按钮）");
            return;
        }
        commentsService.sendComment(textContent, stuId).success(function (response) {
            if (response.success) {
                alert(response.message);
                $scope.stuId = null;
                $scope.textContent = "请选择回复对象后在这里给对应的学生进行答疑(点击回复按钮，对象为该留言对应的学生)。";
                $scope.reloadList();
            } else {
                alert(response.message);
                $scope.stuId = null;
                $scope.reloadList();
            }
        });
    }

    //分页查询教师的comments
    $scope.findComByPage = function (page, rows) {
        commentsService.findComByPage(page, rows).success(function (response) {
            $scope.comments = response.rows;
            $scope.paginationConf.totalItems = response.total;
        });
    }

    //查询当前登陆教师姓名
    $scope.findTeaName = function () {
        commentsService.findTeaName().success(function (response) {
            $scope.name = response;
        });
    }
});