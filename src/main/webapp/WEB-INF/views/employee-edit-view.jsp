<%@ include file="./components/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Edit Employees</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Edit Employee</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" method="post" action="/EadTutorial/update-employee">
					<input type="hidden" value="${data['employee'].getEmployeeId()}" name="empId">
					<div class="form-group">
						<label>Employee Name</label> 
						<input class="form-control" value="${data['employee'].getName()}" name="employeeName">
						<p class="help-block">Example : Jhone</p>
					</div>
					<div class="form-group">
						<label>Assign Role</label>
						 <select class="form-control"  name="role">
							<option selected value="${data['employee'].getRole().getRoleId()}">${data['employee'].getRole().getTitle()}</option>
							<c:forEach items="${data['roles']}" var="role">								
								<option value="${role.getRoleId()}">${role.getTitle()}</option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-warning">Save Employee</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>





<%@ include file="./components/footer.jsp"%>