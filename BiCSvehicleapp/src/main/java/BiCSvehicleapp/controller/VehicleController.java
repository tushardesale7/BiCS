package BiCSvehicleapp.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import BiCSvehicleapp.dao.VehicleDao;
import BiCSvehicleapp.model.Vehicle;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		m.addAttribute("vehicles", vehicles);
		return "home"; //return Home Page... Starting point of our Application 
	}
	
	//show add Vehicle from
	@RequestMapping("/add-vehicle")
	public String addVehicle(Model m) {
		m.addAttribute("title","ADD VEHICLE");
		return "add_vehicle_from";
	}
	
	//handle add vehicle from
	@RequestMapping(value="/handle-vehicle", method = RequestMethod.POST)
	public RedirectView handleVehicle(@ModelAttribute Vehicle vehicle, HttpServletRequest request) {
		System.out.println(vehicle);
		vehicleDao.createVehicle(vehicle);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	
	//Delete handler
	@RequestMapping("/delete/{vehicleId}")
	public RedirectView deleteVehicle(@PathVariable("vehicleId") int vehicleId,  HttpServletRequest request) {
		this.vehicleDao.deleteVehicle(vehicleId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping("/update/{vehicleId}")
	public String updateForm(@PathVariable("vehicleId") int pid, Model model) {
		Vehicle vehicle = this.vehicleDao.getVehicle(pid);
		model.addAttribute("vehicle", vehicle);
		return "update_form";
	}
	
	@RequestMapping("/wheelers/{wheels}")
	public String wheelers(@PathVariable("wheels") int wheels,  HttpServletRequest request, Model m) {
		
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		List<Vehicle> result = new ArrayList<Vehicle>() ;

        for (Vehicle vehicle: vehicles) {

            if (vehicle.getNo_of_wheels() == wheels ) {

                result.add(vehicle);
            }
        }
		m.addAttribute("vehicles", result);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return "home";
	}
	@RequestMapping("/asce")
	public String asce(HttpServletRequest request, Model m) {
		
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle v1, Vehicle v2) {
		        return v1.getName().toUpperCase().compareTo(v2.getName().toUpperCase());
		    }
		});
       
		m.addAttribute("vehicles", vehicles);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return "home";
	}
	@RequestMapping("/asceBySpeed")
	public String asceBySpeed(HttpServletRequest request, Model m) {
		
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle v1, Vehicle v2) {
		    	String n1 = v1.getName().toUpperCase();
		    	String n2 = v2.getName().toUpperCase();
		    	return n1.compareTo(n2);
		    }
		});
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle v1, Vehicle v2) {
		    	String n1 = v1.getName().toUpperCase();
		    	String n2 = v2.getName().toUpperCase();
		    	if (n1 == n2) {
		    		int s1 = (int) v1.getMax_speed();
			    	int s2 = (int) v2.getMax_speed();
			    	 return s1-s2;
		    	}else
		    		 return n1.compareTo(n2);
		    }
		});
       
		m.addAttribute("vehicles", vehicles);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return "home";
	}
	
	
	//filter result by date range
		@RequestMapping("/dateRange/{dateFrom}/{dateTo}")
		public String dateRange(@PathVariable String dateFrom, @PathVariable String dateTo, HttpServletRequest request, Model m) {
			List<Vehicle> vehicles = vehicleDao.getVehicles();
			String from = dateFrom.replace('-', '0');
			String to = dateTo.replace('-', '0');
			List<Vehicle> result = new ArrayList<Vehicle>() ;

	        for (Vehicle vehicle: vehicles) {
	        	int date = Integer.parseInt(vehicle.getManufactured_date().replace('-', '0'));
	            if (date >= Integer.parseInt(from) && date <= Integer.parseInt(to)) {

	                result.add(vehicle);
	            }
	        }
			m.addAttribute("vehicles", result);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/");
			return "home";
		}

		//binary search
		@RequestMapping("/search/{search}")
		public String search(@PathVariable String search, HttpServletRequest request, Model m) {
			List<Vehicle> vehicles = vehicleDao.getVehicles();
			
			List<Vehicle> result = new ArrayList<Vehicle>() ;
			String companyName[]= new String[100];
			
			
			
			/*
			for (int a=0; a<vehicles.size(); a++) {
				companyName[a] = vehicles.get(a).getCompany_name();
	            }
	        
				int low = 0;
				int high = companyName.length - 1;
				int index=-1;

		     while (low <= high) {

		      int mid = (low + high) / 2;
		      int res = search.compareTo(companyName[mid]);
		      if (res == 0) {
		    	  index = mid;
		      } else if  (res > 0) {
		    	  low = mid + 1; 
		      } else {
		    	  high = mid - 1;
		    	  }
		     }
		     result.add(vehicles.get(index));
			
			
			*/
			
			
			
	        for (Vehicle vehicle: vehicles) {
	        	
	            if (vehicle.getCompany_name().contains(search)) {

	                result.add(vehicle);
	            }
	        }
	        
			m.addAttribute("vehicles", result);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/");
			return "home";
		}

}
