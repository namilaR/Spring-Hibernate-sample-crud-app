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
				<form role="form" method="post" action="/EadTutorial/update-task">
					<div class="form-group">
						<label>Task Name</label> 
						<input class="form-control" value="${data['task'].getDescription()}" name="taskDescription">
						<p class="help-block">Example : Development</p>
					</div>

					<div class="form-group">
						<label>Assign Employee</label> 
						<select class="form-control" name="employee">
							<option selected="selected" value="${data['task'].getEmployee().getEmployeeId()}">${data['task'].getEmployee().getName()}</option>
							<c:forEach items="${data['employees']}" var="emp">
								<option value="${emp.getEmployeeId()}">${emp.getName()}</option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-warning">Save Task</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>


<%@ include file="./components/footer.jsp"%>