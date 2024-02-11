package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.dao.DeliveryBoyDao;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.exception.DeliveryBoyListNotFound;
import com.hotel.v2soru.exception.DeliveryBoyNotFound;
import com.hotel.v2soru.util.ResponseStructure;

@Service
public class DeliveryBoyService {
	@Autowired
	DeliveryBoyDao ddao;
	
	public ResponseEntity<ResponseStructure<DeliveryBoy>> saveDeliveryBoy(DeliveryBoy deliveryboy) {
		ResponseStructure<DeliveryBoy>structure=new ResponseStructure<DeliveryBoy>();
		structure.setMessage("DeliveryBoy save sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(ddao.saveDeliveryBoy(deliveryboy));
		return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<DeliveryBoy>> findDeliveryBoy(int deliveryboyId) {
		DeliveryBoy deliveryboy=ddao.findDeliveryBoy(deliveryboyId);
		if(deliveryboy!=null) {
			ResponseStructure<DeliveryBoy>structure=new ResponseStructure<DeliveryBoy>();
			structure.setMessage("DeliveryBoy Found ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(deliveryboy);
			return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.FOUND);	
		}
		throw new DeliveryBoyNotFound("DeliveryBoy not found in the given id");
	}
	public ResponseEntity<ResponseStructure<DeliveryBoy>> deleteDeliveryBoy(int deliveryboyId) {
		DeliveryBoy deliveryboy=ddao.findDeliveryBoy(deliveryboyId);
		if(deliveryboy!=null) {
			ResponseStructure<DeliveryBoy>structure=new ResponseStructure<DeliveryBoy>();
			structure.setMessage("DeliveryBoy delete sucess");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(ddao.deleteDeliveryBoy(deliveryboyId));
			return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.OK);
		}
		throw new DeliveryBoyNotFound("DeliveryBoy not found in the given id");
	}
	public ResponseEntity<ResponseStructure<DeliveryBoy>> updateDeliveryBoy(DeliveryBoy deliveryboy,int deliveryboyId) {
		ResponseStructure<DeliveryBoy>structure=new ResponseStructure<DeliveryBoy>();
		structure.setMessage("DeliveryBoy update sucess");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(ddao.updateDeliveryBoy(deliveryboy, deliveryboyId));
		return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<DeliveryBoy>>>findAllDeliveryBoy(){
		ResponseStructure<List<DeliveryBoy>>structure=new ResponseStructure<List<DeliveryBoy>>();
		List<DeliveryBoy>deliveryboy=ddao.findAllDeliveryBoy();
		if(!deliveryboy.isEmpty()) {
			structure.setMessage("List of DeliveryBoy");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(deliveryboy);
			return new ResponseEntity<ResponseStructure<List<DeliveryBoy>>>(structure,HttpStatus.FOUND);
		}
		throw new DeliveryBoyListNotFound("DeliveryBoy List not found");
	}

}
