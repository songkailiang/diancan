<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
        <button type="button" class="btn btn-default"   onclick="window.location.href = '/sell/seller/store/index'" >添加门店</button>
        </div>
        <#--<input name="add" type="button" id="add1" title="添加" value="添加"  onclick="location.href='链接写这里'" />-->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>门店id</th>
                            <th>门店名称</th>
                            <th>门店地址</th>
                            <th>门店电话</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list storePageList.content as store>
                        <tr>
                            <td>${store.storeId}</td>
                            <td>${store.storeName}</td>
                            <td>${store.storeAddress}</td>
                            <td>${store.storeMobile}</td>
                            <td>${store.createTime}</td>
                            <td>${store.updateTime}</td>
                            <td><a href="/sell/seller/store/index?storeId=${store.storeId}">修改</a>
                                <a href="/sell/seller/store/delete?storeId=${store.storeId}">删除</a>
                                <a href="/sell/seller/category/list?storeId=${store.storeId}">门店菜品类别</a>
                                <a href="/sell/seller/product/list?storeId=${store.storeId}">门店菜品</a>
                                <a href="/sell/seller/storetable/list?storeId=${store.storeId}">门店桌位信息</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>

        <#--分页-->
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                <#if currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                    <li><a href="/sell/seller/store/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                </#if>

                <#list 1..storePageList.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/store/list?page=${index}&size=${size}">${index}</a></li>
                    </#if>
                </#list>

                <#if currentPage gte storePageList.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                    <li><a href="/sell/seller/store/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                </#if>
                </ul>
            </div>
        </div>
    </div>

</div>
</body>
</html>