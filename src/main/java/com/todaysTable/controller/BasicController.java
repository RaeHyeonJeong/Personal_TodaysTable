package com.todaysTable.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.todaysTable.service.StoreService;
import com.todaysTable.vo.StoreVO;

@Controller
public class BasicController {

	//검색결과페이지 -> 매장상세페이지 이동
	@RequestMapping(value = "storeDetail_wej.do")
	public ModelAndView basicstoreDetail() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC1");
		modelAndView.setViewName("WEB-INF/views/storeDetail_wej");

		return modelAndView;
	}

	@RequestMapping(value = "bookStore.do")
	public ModelAndView basicbookStore() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC2");
		modelAndView.setViewName("WEB-INF/views/bookStore");

		return modelAndView;
	}

	@RequestMapping(value = "review.do")
	public ModelAndView basicreview() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC3");
		modelAndView.setViewName("WEB-INF/views/review");

		return modelAndView;
	}
	
	@RequestMapping(value = "search.do")
	public ModelAndView basicsearch() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC3");
		modelAndView.setViewName("WEB-INF/views/store_search");

		return modelAndView;
	}
	
	@RequestMapping(value = "searchResult.do")
	public ModelAndView basicsearchResult() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC3");
		modelAndView.setViewName("WEB-INF/views/searchResult");

		return modelAndView;
	}
	
	@RequestMapping(value = "main.do")
	public ModelAndView basicMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "HelloSpringMVC3");
		modelAndView.setViewName("WEB-INF/views/index");

		return modelAndView;
	}

	
	//index.jsp 매장리스트 랜덤출력용
	@Inject
	StoreService storeService;
	@RequestMapping(value="storeRandomlist.do")
	@ResponseBody
	public List<StoreVO> storeRandomList() {
		return storeService.storeRandomList();
	}
	
	//searchResult.jsp 매장리스트 출력용
	@RequestMapping(value="storelist.do")
	@ResponseBody
	public List<StoreVO> storeList() {
		return storeService.storelist();
	}
	
	@RequestMapping(value = "mapone.do")
	public ModelAndView basicmapone() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/views/kakaomapApi/maptest1");

		return modelAndView;
	}
	@RequestMapping(value = "maptwo.do")
	public ModelAndView basicmaptwo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/views/kakaomapApi/maptest2");

		return modelAndView;
	}
	@RequestMapping(value = "mapthree.do")
	public ModelAndView basicmapthree() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/views/kakaomapApi/maptest3");

		return modelAndView;
	}
	
	@RequestMapping(value = "mapfour.do")
	public ModelAndView basicmapfour() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/views/kakaomapApi/maptest4");

		return modelAndView;
	}
	

}
