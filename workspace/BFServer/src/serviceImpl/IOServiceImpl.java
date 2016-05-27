package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		File theChoosenFile=new File("project/"+userId+"/"+fileName);
		FileReader fileReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		try {
			fileReader=new FileReader(theChoosenFile);
			bufferedReader=new BufferedReader(fileReader);
			String string;
			while ((string=bufferedReader.readLine())!=null) {
				stringBuffer.append(string);
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
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return stringBuffer.toString();
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
		File userProjects=new File("project/"+userId);
		return userProjects.listFiles();
	}

	@Override
	public boolean creatNewProject(String userId, String projectName) throws RemoteException {
		// TODO Auto-generated method stub
		File userProject=new File("project/"+userId);
		File[] projects=userProject.listFiles();
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].getName().equals(projectName)) {
				return false;
			}
		}
		File newProject=new File("project/"+userId+"/"+projectName);
		newProject.mkdirs();
		return true;
	}
	
}
