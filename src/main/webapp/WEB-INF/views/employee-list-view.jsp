<%@ include file="./components/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Employees</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Add New Employee</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" method="post" action="insert-employee">
					<div class="form-group">
						<label>Employee Name</label> <input class="form-control"
							name="employeeName">
						<p class="help-block">Example : Jhone</p>
					</div>
					<div class="form-group">
						<label>Assign Role</label> <select class="form-control"
							name="role">
							<option value="0">Please Select</option>
							<c:forEach items="${data['roles']}" var="role">
								<option value="${role.getRoleId()}">${role.getTitle()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Assign Task</label> <select class="form-control"
							id="task-selector" name="multiselect[]" multiple="multiple">
							<c:forEach items="${data['tasks']}" var="task">
								<option value="${task.getTaskId()}">${task.getDescription()}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-success">Add Employee</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Employee List View</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Employee ID</th>
							<th>Employee Name</th>
							<th>Employee Role</th>
							<th>No of Tasks</th>
							<th>Edit Employee</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data['employees']}" var="employee">
							<tr>
								<td>${employee.getEmployeeId()}</td>
								<td>${employee.getName()}</td>
								<td>${employee.getRole().getTitle()}</td>
								<td>${employee.getTasks().size()}</td>
								<td><a href="emp-edit-view/${employee.getEmployeeId()}">
										<button class="btn btn-warning btn-sm">Edit Employee</button>
								</a></td>


							</tr>
						</c:forEach>



					</tbody>
				</table>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>



<%@ include file="./components/footer.jsp"%>