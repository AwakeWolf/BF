package serviceImpl;
/**
 * 保存用户信息
 * @author Dell
 *
 */
public class UserInformation {

	private String name;
	private String password;
	public UserInformation(String name,String password) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
}
