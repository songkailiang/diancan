<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <button type="button" class="btn btn-default"   onclick="window.location.href = '/sell/seller/storetable/index?storeId='+${storeId}" >添加桌位</button>
        </div>
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>桌位ID</th>
                            <th>桌号</th>
                            <th>桌名</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list storeTableList as storetable>
                        <tr>
                            <td>${storetable.tableId}</td>
                            <td>${storetable.tableNo}</td>
                            <td>${storetable.tableName}</td>
                            <td>${storetable.createTime}</td>
                            <td>${storetable.updateTime}</td>
                            <td><a href="/sell/seller/storetable/index?tableId=${storetable.tableId}&storeId=${storeId}">修改</a>
                                <a href="/sell/seller/storetable/qrCode?tableId=${storetable.tableId}&storeId=${storeId}">下载二维码</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>