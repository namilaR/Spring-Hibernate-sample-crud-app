<%@ include file="./components/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tasks</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Create New Task</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" method="post" action="insert-task">
					<div class="form-group">
						<label>Task Name</label> <input class="form-control"
							name="taskDescription">
						<p class="help-block">Example : Development</p>
					</div>

					<div class="form-group">
						<label>Assign Employee</label> <select class="form-control"
							name="employee">
							<option value="0">Please Select</option>
							<c:forEach items="${data['employees']}" var="emp">
								<option value="${emp.getEmployeeId()}">${emp.getName()}</option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-success">Create Task</button>
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
			<div class="panel-heading">Task List</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Task ID</th>
							<th>Task Description</th>
							<th>Assign To</th>
							<th>Edit Task</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data['tasks']}" var="task">
							<tr>
								<td>${task.getTaskId()}</td>
								<td>${task.getDescription()}</td>
								<td>${task.getEmployee().getName()}</td>
								<td><a href="task-edit-view/${task.getTaskId()}">
										<button class="btn btn-warning btn-sm">Edit Task</button>
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