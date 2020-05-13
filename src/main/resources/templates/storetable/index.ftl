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
                    <form role="form" method="post" action="/sell/seller/storetable/save">
                        <div class="form-group">
                            <label>桌号</label>
                            <input name="tableNo" type="text" class="form-control" value="${(storeTable.tableNo)!''}"/>
                        </div>
                        <input hidden type="text" name="categoryId" value="${(storetable.tableId)!''}">
                        <input hidden type="text" name="storeId" value="${(storeId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>