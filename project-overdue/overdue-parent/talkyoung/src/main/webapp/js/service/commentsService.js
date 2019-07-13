app.service("commentsService", function ($http) {
    this.findAssignDetail = function () {
        return $http.get("/teacher/findAssignDetail");
    };
    //删除留言
    this.deleteReply = function (comId) {
        return $http.get("/teacher/deleteReply?comId=" + comId);
    };
    //提交教师的留言回复
    this.sendComment = function (textContent, stuId) {
        return $http.get("/teacher/sendComment?textContent=" + textContent + "&stuId=" + stuId);
    };
    //分页查询教师的留言
    this.findComByPage = function (page, rows) {
        return $http.get("/teacher/findComByPage?page=" + page + "&rows=" + rows);
    };
    this.findTeaName = function () {
        return $http.get("/teacher/findTeaName");
    }
});