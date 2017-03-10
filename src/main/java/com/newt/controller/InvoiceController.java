package com.newt.controller;

import java.util.List;
import java.util.Map;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.entity.Invoice;
import com.newt.exception.InvoiceException;
import com.newt.service.InvoiceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Invoice> getAllInvoice(){
		return invoiceService.findAll();
	}	
	@RequestMapping(value="/ById/{invoiceId}",method=RequestMethod.GET)
	@ApiOperation(value="Getting Invoice by ID")
	@ApiResponses(value={@ApiResponse(code=200,message="Invoice getting success"),
			@ApiResponse(code=404,message="Invoice does not exists"),
			@ApiResponse(code=400, message = "Invalid request")})
	public ResponseEntity getInvoiceById(@PathVariable("invoiceId")int id){
		String code=null;
		String msg=null;
		Map resMap =null;
		Invoice invoiceResponse=null;
		String error="Invalid request";
		try{
			invoiceResponse=invoiceService.findByInvoiceId(id);
			if(invoiceResponse!=null){
				resMap =  new HashMap<String,Invoice>();
				resMap.put("result", invoiceResponse);
				
			}else{
				
				resMap = new HashMap();
				resMap.put("result", id +" invoiceId doesn't exist");
			}
			
		}catch(InvoiceException e){
			code=e.getErrCode();
			msg=e.getMessage();
		}
		return new ResponseEntity(resMap,HttpStatus.OK);
		//return invoiceResponse;
	}
	@RequestMapping(value="addInvoice",method=RequestMethod.POST)
	@ApiOperation(value="Adding Invoice Details")
	@ApiResponses(value={@ApiResponse(code=200,message="Invoice added success"),
			@ApiResponse(code=400, message = "Invalid request")})
	public ResponseEntity addInvoice(@RequestBody Invoice invoice){
		String code=null;
		String msg=null;
		Map resMap =null;
		Invoice invoiceResponse=null;
		try{
		
			invoiceResponse=invoiceService.addInvoice(invoice);
			if(invoiceResponse!=null){
				resMap=new HashMap<>();
				resMap.put("success", "Invoice Added successfully!");
			}
			else{
				resMap=new HashMap<>();
				resMap.put("fail", "Invalid request Entity");
			}
		}catch(InvoiceException e){
			code=e.getErrCode();
			msg=e.getMessage();
		}
		return new ResponseEntity(resMap,HttpStatus.OK);
	}
	@RequestMapping(value="/{invoiceId}",method=RequestMethod.DELETE)
	@ApiOperation(value="deleting Invoice")
	@ApiResponses(value={@ApiResponse(code=200,message="Invoice delete success"),
			@ApiResponse(code=404,message="Invoice does not exists"),
			@ApiResponse(code=400, message = "Invalid request")})
	public Map<String,String> deleteInvoice(@PathVariable("invoiceId")int id){
		String code=null;
		String msg=null;
		String result=null;
		Map<String,String> resMap=null;
		try{
	
		result= invoiceService.deleteInvoice(id);
		if(result!=null){
			resMap=new HashMap<String ,String>();
			resMap.put("success", id +" Invoice deleted successfully");
		}
		else{
			resMap=new HashMap<String ,String>();
			resMap.put("failed", id +" Invalid invoice ID or Invoice does not exists!!");
		}
		}catch(InvoiceException e){
			code=e.getErrCode();
			msg=e.getMessage();
			
		}
		return resMap;
	}
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="updating Invoice Details")
	@ApiResponses(value={@ApiResponse(code=200,message="Invoice added success"),
			@ApiResponse(code=400, message = "Invalid request")})
	public ResponseEntity updateInvoice(@RequestBody Invoice invoice){
		String code=null;
		String msg=null;
		Invoice invoiceResponse=null;
		Map<String,String> resMap=null;
		try {
			
			invoiceResponse= invoiceService.updateInvoice(invoice);
			if(invoiceResponse!=null){
				resMap=new HashMap<>();
				resMap.put("success", "Invoice Added successfully!");
			}
			else{
				resMap=new HashMap<>();
				resMap.put("fail", "Invalid request Entity");
			}
		} catch (InvoiceException e) {
			code=e.getErrCode();
			msg=e.getMessage();
		}
		return new ResponseEntity(resMap,HttpStatus.OK);
		
	}
	@RequestMapping(value="/ByProId/{productId}",method=RequestMethod.GET)
	@ApiOperation(value="Getting Invoice by Product-ID")
	@ApiResponses(value={@ApiResponse(code=200,message="Invoice getting success"),
			@ApiResponse(code=404,message="Invoice does not exists"),
			@ApiResponse(code=400, message = "Invalid request")})
	public ResponseEntity getInvoiceByProductId(@PathVariable("productId")int id){
		String code=null;
		String msg=null;
		Map resMap =null;
		Invoice invoiceResponse=null;
		try{
			invoiceResponse=invoiceService.findByProductId(id);
			if(invoiceResponse!=null){
				resMap =  new HashMap<String,Invoice>();
				resMap.put("result", invoiceResponse);
			}else{
				resMap = new HashMap();
				resMap.put("result"," invoice doesn't exist for Product ID "+ id);
			}
			
		}catch(InvoiceException e){
			code=e.getErrCode();
			msg=e.getMessage();
		}
		return new ResponseEntity(resMap,HttpStatus.OK);
	}
}
