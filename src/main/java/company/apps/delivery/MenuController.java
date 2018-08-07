package company.apps.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import company.apps.delivery.model.Delivery;
import company.apps.delivery.model.DeliveryRepository;

@Controller
public class MenuController {

	@Autowired
	private DeliveryRepository repository;
	
	
	public MenuController (DeliveryRepository deliveryRepository) {
		this.repository = deliveryRepository;
	}
	
	@RequestMapping("/")
	@ResponseBody
	List<Delivery>  home () {
		//return this.repository.findAll();
		return this.repository.findAllByOrderByIdAsc();
	}
}
