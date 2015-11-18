package com.phd.quesans.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phd.quesans.Service.SearchEngineService;
import com.phd.quesans.entity.DTO.SearchEngineDTO;

@Controller
public class AdminSearchEngineController {

	
	
		
		@Autowired
		private SearchEngineService searchEngineService;
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView saveEmployee(@ModelAttribute("searchEngine") SearchEngineDTO searchEngineBean, 
				BindingResult result) {
			SearchEngineDTO searchEngine = searchEngineBean;
			searchEngineService.addSearchEngine(searchEngine);
			return new ModelAndView("redirect:/add.html");
		}

		@RequestMapping(value="/employees", method = RequestMethod.GET)
		public ModelAndView listEmployees() {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchEngineList",  searchEngineService.getSearchEngineList());
			return new ModelAndView("addSearchEngine", model);
		}

		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public ModelAndView addEmployee(@ModelAttribute("searchEngine")  SearchEngineDTO searchEngineBean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchEngineList",  searchEngineService.getSearchEngineList());
			return new ModelAndView("addSearchEngine", model);
		}
		
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public ModelAndView welcome() {
			return new ModelAndView("redirect:/add.html");
		}
		
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(@ModelAttribute("searchEngine")  SearchEngineDTO searchEngineBean,
				BindingResult result) {
			
			searchEngineService.deleteSearchEngine(searchEngineBean);
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("searchEngineList",  searchEngineService.getSearchEngineList());
			return new ModelAndView("addSearchEngine", model);
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView editEmployee(@ModelAttribute("searchEngine")  SearchEngineDTO searchEngineBean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchEngine", searchEngineService.getSearchEngine(searchEngineBean.getSearchEngineId()));
			model.put("searchEngineList",  searchEngineService.getSearchEngineList());
			return new ModelAndView("addSearchEngine", model);
		}
		
		/*private Employee prepareModel(EmployeeBean employeeBean){
			Employee employee = new Employee();
			employee.setEmpAddress(employeeBean.getAddress());
			employee.setEmpAge(employeeBean.getAge());
			employee.setEmpName(employeeBean.getName());
			employee.setSalary(employeeBean.getSalary());
			employee.setEmpId(employeeBean.getId());
			employeeBean.setId(null);
			return employee;
		}
		
		private List<EmployeeBean> prepareListofBean(List<Employee> employees){
			List<EmployeeBean> beans = null;
			if(employees != null && !employees.isEmpty()){
				beans = new ArrayList<EmployeeBean>();
				EmployeeBean bean = null;
				for(Employee employee : employees){
					bean = new EmployeeBean();
					bean.setName(employee.getEmpName());
					bean.setId(employee.getEmpId());
					bean.setAddress(employee.getEmpAddress());
					bean.setSalary(employee.getSalary());
					bean.setAge(employee.getEmpAge());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		private EmployeeBean prepareEmployeeBean(Employee employee){
			EmployeeBean bean = new EmployeeBean();
			bean.setAddress(employee.getEmpAddress());
			bean.setAge(employee.getEmpAge());
			bean.setName(employee.getEmpName());
			bean.setSalary(employee.getSalary());
			bean.setId(employee.getEmpId());
			return bean;
		}
	}*/

		
}
