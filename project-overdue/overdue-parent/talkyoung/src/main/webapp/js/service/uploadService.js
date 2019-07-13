app.service("uploadService", function ($http) {
    this.findFileByCouId = function (courseId) {
        return $http.get("/teacher/findFileByCouId?courseId=" + courseId);
    };
    this.findVideoByCouId = function (courseId) {
        return $http.get("/teacher/findVideoByCouId?courseId=" + courseId);
    };
    this.findAssignDetail = function () {
        return $http.get("/teacher/findAssignDetail");
    };
    this.findTeaName = function () {
        return $http.get("/teacher/findTeaName");
    };
    this.uploadFile = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);
        var courseId = document.getElementById("courseId").value;
        var videoDetail = document.getElementById("videoDetail").value;
        // var videoDetail = document.getElementsByClassName("videoDetail").item(0);

        formData.append("videoDetail", videoDetail);
        formData.append("courseId", courseId);
        return $http({
            method: 'POST',
            url: "/upload.do",
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
            /* anjularjs对于post和get请求默认的Content-Type header 是application/json。通过设置‘Content-Type’:
                 undefined，这样浏览器会帮我们把Content-Type 设置为 multipart/form-data.*/
        });
    }
    this.uploadFile1 = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);
        return $http({
            method: 'POST',
            url: "/upload.do",
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
            /* anjularjs对于post和get请求默认的Content-Type header 是application/json。通过设置‘Content-Type’:
                 undefined，这样浏览器会帮我们把Content-Type 设置为 multipart/form-data.*/
        });
    }
    //当页面首次加载时查找所有的文件
    this.findAllFile = function () {
        return $http.get("/teacher/findAllFile.do");
    }
    this.findAllVideo = function () {
        return $http.get("/teacher/findAllVideo.do");
    }
    this.deleteFileById = function (fId) {
        return $http.get("/teacher/deleteFileById.do?fId=" + fId);
    }
    this.deleteVideoById = function (vId) {
        return $http.get("/teacher/deleteVideoById.do?vId=" + vId);
    }
    this.deleMultiVodeo = function (selectIds) {
        return $http.get("/teacher/deleteMultiVideo.do?ids=" + selectIds);
    }
    this.deleMultiFile = function (selectIds) {
        return $http.get("/teacher/deleteMultiFile.do?ids=" + selectIds);
    }
});