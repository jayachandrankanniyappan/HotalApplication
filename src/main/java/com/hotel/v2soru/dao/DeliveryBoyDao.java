package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.repo.DeliveryBoyRepo;
@Repository
public class DeliveryBoyDao {
	 @Autowired
	 DeliveryBoyRepo repo;
	
	public DeliveryBoy saveDeliveryBoy(DeliveryBoy deliveryboy) {
		return repo.save(deliveryboy);
	}
	
	public DeliveryBoy findDeliveryBoy(int deliveryboyId) {
		Optional<DeliveryBoy>opdeliveryboy=repo.findById(deliveryboyId);
		if(opdeliveryboy.isPresent()) {
			return opdeliveryboy.get();
		}
		return null;
	}
	public DeliveryBoy deleteDeliveryBoy(int deliveryboyId) {
		DeliveryBoy deliveryboy=findDeliveryBoy(deliveryboyId);
		if(deliveryboy!=null) {
			repo.delete(deliveryboy);
			return deliveryboy;
		}
		return null;
	}
	
	public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryboy,int deliveryboyId) {
		DeliveryBoy exdeliveryboy=findDeliveryBoy(deliveryboyId);
		if(exdeliveryboy!=null) {
			deliveryboy.setDeliveryboyId(deliveryboyId);
			repo.save(deliveryboy);
		}
		return null;
	}
	public List<DeliveryBoy> findAllDeliveryBoy(){
		return repo.findAll();
	}


}
