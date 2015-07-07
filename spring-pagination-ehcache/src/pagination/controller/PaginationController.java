package pagination.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import pagination.dao.ItemDao;

public class PaginationController extends MultiActionController {
	private final Log logger = LogFactory.getLog(getClass());
	protected ApplicationContext springAppContext = null;
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		springAppContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		ModelAndView mav = new ModelAndView("paging");
		
		// get data
		ItemDao dao = (ItemDao) springAppContext.getBean("itemDao");
		List searchResults = dao.getAllItems();
		
		// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
		PagedListHolder pagedListHolder = new PagedListHolder(searchResults);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		mav.addObject("pagedListHolder", pagedListHolder);
		
		return mav;
	}
}
