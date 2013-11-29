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
//		Hospital hospital1 = new Hospital("华西医院", "妇女科", setDoctors1());
//		Hospital hospital2 = new Hospital("华西医院", "儿童科", setDoctors2());
//		Hospital hospital3 = new Hospital("中医医院", "精神科", setDoctors3());
//		Hospital hospital4 = new Hospital("中医医院", "五官科", setDoctors4());
		Hospital hospital1 = new Hospital("华西医院");
		Hospital hospital2 = new Hospital("中医医院");
		hospital1.setDepartments("妇女科", setDoctors1());
		hospital1.setDepartments("儿童科", setDoctors2());
		hospital2.setDepartments("精神科", setDoctors3());
		hospital2.setDepartments("五官科", setDoctors4());
		
		hospitals.add(hospital1);
		hospitals.add(hospital2);
	}
	
	private List<Doctor> setDoctors1(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("刘备", "主任医生");
		Doctor doctor2 = new Doctor("关羽", "副主任医生");
		Doctor doctor3 = new Doctor("张飞", "副主任医生");
		Doctor doctor4 = new Doctor("赵云", "专家");
		Doctor doctor5 = new Doctor("马超", "专家");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}
	
	private List<Doctor> setDoctors2(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("刘玄德", "主任医生");
		Doctor doctor2 = new Doctor("关云长", "副主任医生");
		Doctor doctor3 = new Doctor("张翼德", "副主任医生");
		Doctor doctor4 = new Doctor("赵子华", "专家");
		Doctor doctor5 = new Doctor("马孟起", "专家");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

	private List<Doctor> setDoctors3(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("曹操", "主任医生");
		Doctor doctor2 = new Doctor("张辽", "副主任医生");
		Doctor doctor3 = new Doctor("乐进", "副主任医生");
		Doctor doctor4 = new Doctor("于禁", "专家");
		Doctor doctor5 = new Doctor("徐晃", "专家");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

	private List<Doctor> setDoctors4(){
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor("曹孟德", "主任医生");
		Doctor doctor2 = new Doctor("张文远", "副主任医生");
		Doctor doctor3 = new Doctor("乐文谦", "副主任医生");
		Doctor doctor4 = new Doctor("于文则", "专家");
		Doctor doctor5 = new Doctor("徐公明", "专家");
		list.add(doctor1);
		list.add(doctor2);
		list.add(doctor3);
		list.add(doctor4);
		list.add(doctor5);
		return list;
	}

}
