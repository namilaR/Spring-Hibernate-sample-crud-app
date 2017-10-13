package hibernateassignment;

public class Role {
	private int roleId;
	private String title;
	
	public Role(){
		
	}
	
	public Role(String title) {
		super();
		this.title = title;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", title=" + title + "]";
	}
	
	
}
