app.service('loginService',function($http){
    //读取登录人名称
    this.loginName=function(){
        return $http.get('/login/name.do');
    }
   /* this.toStudentLogin=function(){
        return $http.get("/student/");
    }*/
});