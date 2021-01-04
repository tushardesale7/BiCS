package BiCSvehicleapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {


	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String model_no;
	private String manufactured_date;
	private String company_name;
	private int no_of_wheels;
	private int torque;
	private float brake_horse_power;
	private float max_speed;
	private float max_acceleration;
	private int run;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public String getManufactured_date() {
		return manufactured_date;
	}
	public void setManufactured_date(String manufactured_date) {
		this.manufactured_date = manufactured_date;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getNo_of_wheels() {
		return no_of_wheels;
	}
	public void setNo_of_wheels(int no_of_wheels) {
		this.no_of_wheels = no_of_wheels;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	public float getBrake_horse_power() {
		return brake_horse_power;
	}
	public void setBrake_horse_power(float brake_horse_power) {
		this.brake_horse_power = brake_horse_power;
	}
	public float getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(float max_speed) {
		this.max_speed = max_speed;
	}
	public float getMax_acceleration() {
		return max_acceleration;
	}
	public void setMax_acceleration(float max_acceleration) {
		this.max_acceleration = max_acceleration;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Vehicle(int id, String name, String model_no, String manufactured_date, String company_name,
			int no_of_wheels, int torque, float brake_horse_power, float max_speed, float max_acceleration, int run,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.model_no = model_no;
		this.manufactured_date = manufactured_date;
		this.company_name = company_name;
		this.no_of_wheels = no_of_wheels;
		this.torque = torque;
		this.brake_horse_power = brake_horse_power;
		this.max_speed = max_speed;
		this.max_acceleration = max_acceleration;
		this.run = run;
		this.role = role;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", model_no=" + model_no + ", manufactured_date="
				+ manufactured_date + ", company_name=" + company_name + ", no_of_wheels=" + no_of_wheels + ", torque="
				+ torque + ", brake_horse_power=" + brake_horse_power + ", max_speed=" + max_speed
				+ ", max_acceleration=" + max_acceleration + ", run=" + run + ", role=" + role + "]";
	}
	
	
	

}
