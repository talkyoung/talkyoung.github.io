<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>学生积欠系统 ——后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
</head>
<body>
<div class="modal-body">
    <table class="table table-bordered table-striped">
        <tr>
            <td>商品图片</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <input type="file" id="file"/>
                            <button class="btn btn-primary" type="button" ng-click="uploadFile()">
                                上传
                            </button>
                        </td>
                        <td>
                            <img src="{{image_entity.url}}" width="200px" height="200px">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
</html>