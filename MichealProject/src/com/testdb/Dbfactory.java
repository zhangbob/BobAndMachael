package com.testdb;

import java.util.ArrayList;
import java.util.List;

public class Dbfactory {
	public static Dbfactory db;
	private List<Hospital> hospitals;
	
	private Dbfactory(){
		setHospitals();
	}
	
	public static Dbfactory getInstance(){
		if (db==null) {
			db = new Dbfactory();
		}
		return db;
	}
	
	public List<Hospital> getHospitals(){
		return hospitals;
	}
	
	public void setHospitals(){
		hospitals = new ArrayList<Hospital>();
//		Hospital hospital1 = new Hospital("����ҽԺ", "��Ů��", setDoctors1());
//		Hospital hospital2 = new Hospital("����ҽԺ", "��ͯ��", setDoctors2());
//		Hospital hospital3 = new Hospital("��ҽҽԺ", "�����", setDoctors3());
//		Hospital hospital4 = new Hospital("��ҽҽԺ", "��ٿ�", setDoctors4());
		Hospital hospital1 = new Hospital("����ҽԺ");
		Hospital hospital2 = new Hospital("��ҽҽԺ");
		hospital1.setDepartments("��Ů��", setDoctors1());
		hospital1.setDepartments("��ͯ��", setDoctors2());
		hospital2.setDepartments("�����", setDoctors3());
		hospital2.setDepartments("��ٿ�", setDoctors4());
		
		hospitals.add(hospital1);
		hospitals.add(hospital2);
	}
	
	private List<Doctor> setDoctors1(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("����", "����ҽ��");
		Doctor doctor2 = new Doctor("����", "������ҽ��");
		Doctor doctor3 = new Doctor("�ŷ�", "������ҽ��");
		Doctor doctor4 = new Doctor("����", "ר��");
		Doctor doctor5 = new Doctor("��", "ר��");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}
	
	private List<Doctor> setDoctors2(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("������", "����ҽ��");
		Doctor doctor2 = new Doctor("���Ƴ�", "������ҽ��");
		Doctor doctor3 = new Doctor("�����", "������ҽ��");
		Doctor doctor4 = new Doctor("���ӻ�", "ר��");
		Doctor doctor5 = new Doctor("������", "ר��");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

	private List<Doctor> setDoctors3(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("�ܲ�", "����ҽ��");
		Doctor doctor2 = new Doctor("����", "������ҽ��");
		Doctor doctor3 = new Doctor("�ֽ�", "������ҽ��");
		Doctor doctor4 = new Doctor("�ڽ�", "ר��");
		Doctor doctor5 = new Doctor("���", "ר��");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

	private List<Doctor> setDoctors4(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("���ϵ�", "����ҽ��");
		Doctor doctor2 = new Doctor("����Զ", "������ҽ��");
		Doctor doctor3 = new Doctor("����ǫ", "������ҽ��");
		Doctor doctor4 = new Doctor("������", "ר��");
		Doctor doctor5 = new Doctor("�칫��", "ר��");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

}
