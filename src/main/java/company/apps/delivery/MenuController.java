package company.apps.delivery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import company.apps.delivery.model.Delivery;
import company.apps.delivery.model.DeliveryRepository;

@Controller
public class MenuController {

	@Autowired
	private DeliveryRepository repository;

	public MenuController(DeliveryRepository deliveryRepository) {
		this.repository = deliveryRepository;
	}

	@RequestMapping("/")
	@ResponseBody
	List<Delivery> home() {
		// return this.repository.findAll();
		return this.repository.findAllByOrderByIdAsc();
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	Delivery create(String name) {
		Delivery dev = new Delivery(name);
		repository.save(dev);
		return dev;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	Delivery update(@PathVariable Long id, String name) {
		Optional<Delivery> dev = repository.findById(id);
		Delivery model = dev.get();
		model.setName(name);
		repository.save(model);
		return model;
	}
}
