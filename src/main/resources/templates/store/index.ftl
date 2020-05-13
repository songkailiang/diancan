<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/store/save">
                        <div class="form-group">
                            <label>门店名称</label>
                            <input name="storeName" type="text" class="form-control" value="${(store.storeName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>门店地址</label>
                            <input name="storeAddress" type="text" class="form-control" value="${(store.storeAddress)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>门店电话</label>
                            <input name="storeMobile" type="number" class="form-control" value="${(store.storeMobile)!''}"/>
                        </div>
                        <input hidden type="text" name="storeId" value="${(store.storeId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>