//服务层
app.service('courseService', function ($http) {
    //监管学生
    this.findStuProcess = function () {
        return $http.get("/secretary/findStuProcess");
    }
    //分配任务
    this.assignTask = function (teacherId, couId, studentId) {
        return $http.get("/secretary/assignTask?teacherId=" + teacherId + "&couId=" + couId + "&studentId=" + studentId);
    }
    //查找所有学生
    this.findStudent = function (courseId) {
        return $http.get("/secretary/findStudent?courseId=" + courseId);
    };
    this.judgePro = function (courseId, proId, teaId) {
        return $http.get("/secretary/judgePro?courseId=" + courseId + "&proId=" + proId + "&teaId=" + teaId);
    }
    this.findAllProf = function (courseId) {
        return $http.get("/secretary/findAllProf?courseId=" + courseId);
    }
    //根据课程id查询所有任课教师
    this.showTeacher = function (cId) {
        return $http.get("/secretary/showTeacher?cId=" + cId);
    }
    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../course/findAll.do');
    }
    //分页
    this.findPage = function (page, rows) {
        return $http.get('../course/findPage.do?page=' + page + '&rows=' + rows);
    }
    //查询实体
    this.findOne = function (id) {
        return $http.get('../course/findOne.do?id=' + id);
    }
    //增加
    this.add = function (entity) {
        return $http.post('../course/add.do', entity);
    }
    //修改
    this.update = function (entity) {
        return $http.post('../course/update.do', entity);
    }
    //删除
    this.dele = function (ids) {
        return $http.get('../course/delete.do?ids=' + ids);
    }
    //搜索
    this.search = function (page, rows, searchEntity) {
        return $http.post('../course/search.do?page=' + page + "&rows=" + rows, searchEntity);
    }
});
