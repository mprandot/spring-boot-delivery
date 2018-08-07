package company.apps.delivery.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@org.springframework.transaction.annotation.Transactional
public interface DeliveryRepository extends CrudRepository<Delivery, Long>{
	
	public Delivery findByName(String name);
	
	public Delivery findByNameIgnoreCase(String name);
	
	public Delivery findByNameAndId(String name, Long id);
	
	public List<Delivery> findAllByOrderByIdAsc();
	
	
}
