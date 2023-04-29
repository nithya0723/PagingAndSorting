package com.example.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.model.Mobile;
import com.example.mobile.service.MobileService;


@RestController
public class MobileController {
	@Autowired
	MobileService ni;
	
	//Get
    @GetMapping(value="/get")
    public List<Mobile> getDetails(){
   	 return ni.GetMobileDetails();
    }
    //Save
    @PostMapping(value="/save")
    public String saveDetails(@RequestBody Mobile a)
    {
    	ni.SaveMobileDetails(a);
    	return "saved";
    }
    //Update
    @PutMapping(value="/update")
    public String updateById(@RequestBody Mobile b)
    {
    	ni.UpdateMobileDetailsById(b);
    	return "updated";
    }
    //UpdateDetails
    @PutMapping(value="/updateDetails")
    public String PutMobile(@RequestBody Mobile d,@PathVariable int sno)
    {
    	ni.PutMobile(d,sno);
    	return "updated";
    }
    //Delete
    @DeleteMapping(value="/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
    	ni.DeleteMobileDetailsById(id);
    	return "deleted";
    }
    //Find
    @GetMapping(value="/find/{c}")
    public Mobile findById(@PathVariable int c)
    {
   	 return ni.FindMobileDetailsById(c);
    }
    //SortAsc
    @GetMapping("/sortMobile/{field}")
    public List<Mobile> sortCarAsc(@PathVariable String field)
    {
   	 return ni.SortByMobileDetailsAsc(field);
    }
    //SortDesc
    @GetMapping("/sortMobileDesc/{field}")
    public List<Mobile> sortCarDesc(@PathVariable String field)
    {
   	 return ni.SortByMobileDetailsDesc(field);
    }
    //List - paging
    @GetMapping("/listpagingMobile/{offset}/{pageSize}")
    public List<Mobile> listCars(@PathVariable int offset,@PathVariable int pageSize)
    {
    	return ni.ListOfMobile(offset,pageSize);
    }
    //Paging
    @GetMapping("/pagingMobile/{offset}/{pageSize}")
    public Page<Mobile> pagingCars(@PathVariable int offset,@PathVariable int pageSize)
    {
    	return ni.pagingMobile(offset,pageSize);
    }
    //Sort - list
    @GetMapping("/sortlistofMobile/{offset}/{pageSize}/{field}")
    public List<Mobile> sortListCar(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
    	return ni.SortListMobile(offset,pageSize,field);
    }
    //Sort - paging
    @GetMapping("/sortpagingofMobile/{offset}/{pageSize}/{field}")
    public Page<Mobile> sortPagingOfCar(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
    	return ni.SortPageMobile(offset,pageSize,field);
    }
    //Fetch Brand Starting With Prefix
    @GetMapping("/fetchMobileByBrandPrefix")
    public List<Mobile> fetchCarByBrandPrefix(@RequestParam String prefix)
    {
    	return ni.fetchMobileByBrandPrefix(prefix);
    }
    //Fetch Brand Ending With Suffix
    @GetMapping("/fetchMobileByBrandSuffix")
    public List<Mobile> fetchCarByBrandSufffix(@RequestParam String suffix)
    {
    	return ni.fetchMobileByBrandSuffix(suffix);
    }
    //Fetch By Model
    @GetMapping("/fetchMobileByModel")
    public List<Mobile> fetchCarByModel(@RequestParam String model)
    {
    	return ni.fetchMobileByModel(model);
    }
//    //Positional Parameter
//    @GetMapping("/getPostionalParameter/{brand}/{colour}")
//    public List<Mobile> getPositionalParameter(@PathVariable String brand,@PathVariable String colour)
//    {
//    	return ni.getPositionalParameter(brand,colour);
//    }
//    //Named Parameter
//    @GetMapping("/getNamedParameter/{brand}")
//    public List<Mobile> getNamedParameter(@PathVariable String brand)
//    {
//    	return ni.getNamedParameter(brand);
//    }
//    //DML Delete Query
//    @GetMapping("/deleteByModel/{model}")
//    public List<Mobile> deleteByModel(@PathVariable String model)
//    {
//    	return ni.deleteByModel(model);
//    }
}
