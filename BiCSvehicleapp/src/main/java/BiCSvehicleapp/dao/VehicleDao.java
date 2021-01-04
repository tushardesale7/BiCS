package BiCSvehicleapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import BiCSvehicleapp.model.Vehicle;

@Component
public class VehicleDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createVehicle(Vehicle vehicle) {

		this.hibernateTemplate.saveOrUpdate(vehicle);
	}

	// get All Vehicle
	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicles = this.hibernateTemplate.loadAll(Vehicle.class);
		return vehicles;
	}

	// delete the single Vehicle
	@Transactional
	public void deleteVehicle(int pid) {
		Vehicle p = this.hibernateTemplate.load(Vehicle.class, pid);
		this.hibernateTemplate.delete(p);
	}

	// get the single vehicle
	public Vehicle getVehicle(int pid) {
		return this.hibernateTemplate.get(Vehicle.class, pid);
	}

	// get All Vehicle by Wheels
	/*
	 * public List<Vehicle> getWheelers(int wheels) { List<Vehicle> vehicles =
	 * this.hibernateTemplate.loadAll(Vehicle.class); List<Vehicle> result = new
	 * ArrayList<Vehicle>();
	 * 
	 * 
	 * for (Vehicle vehicle: vehicles) {
	 * 
	 * if (vehicle.getNo_of_wheels() == wheels ) {
	 * 
	 * result.add(vehicle);
	 * 
	 * }
	 * 
	 * } return result; }
	 */

}

	