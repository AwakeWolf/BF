package test;

import java.rmi.RemoteException;

import serviceImpl.IOServiceImpl;

public class TestreadProjectList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOServiceImpl ioServiceImpl=new IOServiceImpl();
		try {
			System.out.println(ioServiceImpl.readProjectList("hello"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
