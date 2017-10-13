<%@ include file="./components/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Roles</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Create New Role</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" method="post" action="insert-role">
					<div class="form-group">
						<label>Role Name</label> <input class="form-control"
							name="roleName">
						<p class="help-block">Example : Project Manager</p>
					</div>
					<button type="submit" class="btn btn-success">Create Role</button>
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
			<div class="panel-heading">DataTables Advanced Tables</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Role ID</th>
							<th>Role Title</th>
							<th>Edit Role</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roles}" var="role">
							<tr>
								<td>${role.getRoleId()}</td>
								<td>${role.getTitle()}</td>
								<td>
									<a href="role-edit-view/${role.getRoleId()}">
											<button class="btn btn-warning btn-sm">Edit Role</button>
									</a>
								</td>


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