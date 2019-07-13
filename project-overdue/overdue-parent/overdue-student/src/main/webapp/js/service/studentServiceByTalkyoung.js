app.service('studentServiceByTalkyoung', function ($http) {
    this.findTeaAndCou = function () {
        return $http.get("/student/findTeaAndCou");
    }
    //查找教师的所有文件
    this.showFile = function (tId, courseId) {
        return $http.get("/student/showFile?tId=" + tId + "&courseId=" + courseId);
    };
    //删除留言
    this.deleteReply = function (comId) {
        return $http.get("/student/deleteReply?comId=" + comId);
    }
    //提交回复信息args（content，stuId，teaId）
    this.sendComment = function (content, teaId) {
        return $http.get("/student/sendComment?content=" + content + "&teaId=" + teaId);
    }
    //分页查询
    this.findComByPage = function (page, rows) {
        return $http.get('/student/findComByPage?page=' + page + '&rows=' + rows);
    }
    //根据当前登陆学生id查找comments内容给前端
    this.showComments = function () {
        return $http.get("/student/showComments");
    }
    //查询学生姓名
    this.getStuName = function () {
        return $http.get("/student/getStuName");
    }
    this.findAllCourse = function () {
        return $http.get('/student/findAllCourse');
    }
    //根据课程id查询所有任课教师
    this.showTeacher = function (cId) {
        return $http.get("/student/showTeacher?cId=" + cId);
    }
    //根据教师id查询改教师的视频资源
    this.showVideo = function (tId, courseId) {
        return $http.get("/student/showVideo?tId=" + tId + "&courseId=" + courseId);
    }
});