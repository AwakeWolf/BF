package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;

import service.UserService;

public class UserServiceImpl implements UserService{

	ArrayList<UserInformation> userList=new ArrayList<UserInformation>();
	
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
		
		//登陆时对于用户名和密码保存，用于核对信息
		File user=new File("user_information");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(user);
			bufferedReader=new BufferedReader(fileReader);
			String information;
			while ((information=bufferedReader.readLine())!=null) {
				String[] spilt=information.split(" ");
				userList.add(new UserInformation(spilt[0],spilt[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Override
	public boolean login(String username, String password) throws RemoteException {
		for (int i = 0; i < userList.size(); i++) {
			if (username.equals(userList.get(i).getName())) {
				if (password.equals(userList.get(i).getPassword())) {
					
					return true;
				}
				break;
			}
		}
		return false;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		return true;
	}

	@Override
	public boolean signin(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		File f = new File("user_information");
		for (int i = 0; i < userList.size(); i++) {
			if (username.equals(userList.get(i).getName())) {
				return false;
			}
		}
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(username+" "+password+"\n");
			fw.flush();
			fw.close();
			
			File newUserLibrary=new File("project/"+username);
			newUserLibrary.mkdir();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
