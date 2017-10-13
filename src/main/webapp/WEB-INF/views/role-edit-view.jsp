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
				<form role="form" method="post" action="/EadTutorial/update-role">					 
					<div class="form-group">
						<label>Role Title</label> 
						<input class="form-control" value="${data['role'].getTitle()}" name="roleTitle">
						<p class="help-block">Example : Project Manager</p>
					</div>
					<button type="submit" class="btn btn-warning">Save Role</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>





<%@ include file="./components/footer.jsp"%>