package serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import service.IOService;

public class IOServiceImpl implements IOService{
	
	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		File f = new File(userId + "_" + fileName);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
		return "OK";
	}

	@Override
	public File[] readFileList(String userId,String projectName) {
		// TODO Auto-generated method stub
		File userChoosenProject=new File("project/"+userId+"/"+projectName);
		return userChoosenProject.listFiles();
	}

	@Override
	public File[] readProjectList(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		File userProjects=new File(userId);
		return userProjects.listFiles();
	}
	
}
