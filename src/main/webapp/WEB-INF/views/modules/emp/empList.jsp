<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>员工信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/emp/emp/">员工信息列表</a></li>
		<shiro:hasPermission name="emp:emp:edit"></shiro:hasPermission>
		<li><a href="${ctx}/emp/emp/form">员工信息添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="emp" action="${ctx}/emp/emp/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>员工姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>员工姓名</th>
				<shiro:hasPermission name="emp:emp:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="emp">
			<tr>
				<td><a href="${ctx}/emp/emp/form?id=${emp.id}">
					${emp.name}
				</a></td>
				<shiro:hasPermission name="emp:emp:edit"></shiro:hasPermission>
				<td>
    				<a href="${ctx}/emp/emp/form?id=${emp.id}">修改</a>
					<a href="${ctx}/emp/emp/delete?id=${emp.id}" onclick="return confirmx('确认要删除该员工信息吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>