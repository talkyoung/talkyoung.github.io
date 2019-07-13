//控制层
app.controller('courseController', function ($scope, courseService) {
    $scope.couName = null;
    $scope.teaName = null;
    $scope.warnTeacher = "教师栏在选择课程后显示。请点击左方课程按钮!";
    $scope.warnPro = "点击教师后显示未分配专业。";
    $scope.warnPro1 = "该课程的任务已经分配完毕。";
    //监管学生
    $scope.findStuProcess = function () {
        courseService.findStuProcess().success(
            function (response) {
            $scope.stuProcessList = response;
        });
    };
    //分配任务咯
    $scope.assignTask = function (teacherId, couId, studentId) {
        if (couId == null) {
            alert("请先选择一门课程");
            return;
        }
        if (teacherId == null) {
            alert("请选择一位教师");
            return;
        }
        if (studentId == null) {
            alert("请选择一位学生");
            return;
        }
        courseService.assignTask(teacherId, couId, studentId).success(function (response) {
            if (response.success) {
                alert(response.message);
                $scope.showStudent(couId);
            } else
                alert(response.message);
        })
    }
    $scope.pushStuId = function (stuId, stuName) {
        if ($scope.teacherId == null) {
            alert("请选择一位教师");
            return;
        }
        $scope.studentId = stuId;
        $scope.studentName = stuName;
    }
    $scope.toNameTeaId = function (teaId, teaName) {
        $scope.studentId = null;
        $scope.studentName = null;
        $scope.teacherId = teaId;
        $scope.teacherName = teaName;
    }
    //根据课程Id查找所有未过的学生
    $scope.showStudent = function (courseId) {
        courseService.findStudent(courseId).success(function (response) {
            $scope.studentList = response;
        });
    };
    $scope.pushCouName = function (couName, couId) {
        $scope.couId = couId;
        $scope.couName = couName;
    }

    $scope.judgePro = function (courseId, proId, teaId) {
        if (proId == null) {
            alert("请选择一个专业进行分配");
        }
        courseService.judgePro(courseId, proId, teaId).success(function (response) {
            if (response.success) {
                $scope.proId = null;
                alert(response.message);
                $scope.findAllProf(courseId);
            } else {
                alert(response.message);
            }
        });
    }

    //根据课程id查询所有任课教师
    //返回的teacherIdList是 [] 格式
    $scope.showTeacher = function (cId) {
        $scope.professionList = null;
        courseService.showTeacher(cId).success(
            function (response) {
                $scope.studentId = null;
                $scope.studentName = null;
                $scope.teacherId = null;
                $scope.teacherName = null;
                $scope.courseId = cId;
                $scope.teacherIdList = response;
            });
    }
    //读取列表数据绑定到表单中  
    $scope.findAllCourse = function () {
        courseService.findAll().success(
            function (response) {
                $scope.courseList = response;
                $scope.couId = $scope.courseList[0].couId;
                $scope.couName = $scope.courseList[0].couName;
                $scope.showTeacher($scope.couId);
                $scope.showStudent($scope.couId);
            }
        );
    }

    //分页
    $scope.findPage = function (page, rows) {
        courseService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne = function (id) {
        courseService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }

    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = courseService.update($scope.entity); //修改
        } else {
            serviceObject = courseService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        courseService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    }

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        courseService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

});	
