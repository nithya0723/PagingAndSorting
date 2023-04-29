package com.example.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.mobile.model.Mobile;
import com.example.mobile.repository.MobileRepository;


@Service
public class MobileService {
	@Autowired
	MobileRepository mob;
	
	//Get
	public List<Mobile> GetMobileDetails(){
		return mob.findAll();
	}
	//Save
	public Mobile SaveMobileDetails(Mobile no) {
		return mob.save(no);
	}
	//Update
	public Mobile UpdateMobileDetailsById(Mobile ui)
	{
		return mob.save(ui);
	}
	public Mobile PutMobile(Mobile s,int sno)
	{
		Optional<Mobile> optional = mob.findById(sno);
		Mobile obj = null;
		if(optional.isPresent())
		{
			obj = optional.get();
			mob.save(s);
		}
		return obj;
	}
	//Delete
	public void DeleteMobileDetailsById(int z)
	{
		mob.deleteById(z);
	}
	//FindById
	public Mobile FindMobileDetailsById(int o)
	{
		return mob.findById(o).orElse(null);
	}
	//Sort - ASC
	public List<Mobile> SortByMobileDetailsAsc(String field)
	{
		return mob.findAll(Sort.by(field));
	}
	//Sort - DESC
	public List<Mobile> SortByMobileDetailsDesc(String field)
	{
		return mob.findAll(Sort.by(Direction.DESC,field));
	}
	//Pagination - list
	public List<Mobile> ListOfMobile(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<Mobile> to = mob.findAll(paging);
		List<Mobile> b = to.getContent();
		return b;
	}
	//Pagination - page
	public Page<Mobile> pagingMobile(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<Mobile> c = mob.findAll(paging);
		return c;
	}
	//Pagination - list - sorting
	public List<Mobile> SortListMobile(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Mobile> to = mob.findAll(paging);
		List<Mobile> b = to.getContent();
		return b;
	}
	//Pagination - page - sorting
	public Page<Mobile> SortPageMobile(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Mobile> c = mob.findAll(paging);
		return c;
	}
	//BrandStartingWith
	public List<Mobile> fetchMobileByBrandPrefix(String prefix)
	{
		return mob.findByBrandStartingWith(prefix);
	}
	//BrandEndingWith
	public List<Mobile> fetchMobileByBrandSuffix(String suffix)
	{
		return mob.findByBrandEndingWith(suffix);
	}
	//SearchByModel
	public List<Mobile> fetchMobileByModel(String model)
	{
		return mob.findByModel(model);
	}
//	//PositionalParameter
//	public List<Mobile> getPositionalParameter(String brand,String colour)
//	{
//		return mob.fetchPositionalParameter(brand,colour);
//	}
//	//NamedParameter
//	public List<Mobile> getNamedParameter(String brand)
//	{
//		return mob.fetchNamedParameter(brand);
//	}
//	//DMLDeleteQuery
//	public List<Mobile> deleteByModel(String model)
//	{
//		return mob.deleteCarByModel(model);
//	}
}
