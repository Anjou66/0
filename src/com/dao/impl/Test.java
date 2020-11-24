package com.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class Test {
	public static void main(String[] args){
		AllusersDaoimpl a=new AllusersDaoimpl();
		Integer t=2;
//		System.out.print(a.selectByPrimaryKey(t));
		Map<String, Object> d=new HashMap<String, Object>();
		d.put("username", "hsg");
		System.out.print(a.quchongAllusers(d));
	}
}  
