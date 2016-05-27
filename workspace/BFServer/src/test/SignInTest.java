package test;

import java.rmi.RemoteException;

import serviceImpl.*;
public class SignInTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserServiceImpl userServiceImpl=new UserServiceImpl();
		try {
			
			System.out.println(userServiceImpl.signin("hello", "hello"));
			System.out.println(userServiceImpl.signin("xiaoming", "ggg"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println(userServiceImpl.login("xiaoming", "xxx"));
//			System.out.println(userServiceImpl.login("xiaoming", "ggg"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
