/*
 * package com.ons.itadmin.managedBean;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.ocpsoft.rewrite.el.ELBeanName; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Scope; import
 * org.springframework.stereotype.Component; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.ons.itadmin.model.User; import
 * com.ons.itadmin.repository.UserRepository; import
 * com.ons.itadmin.service.UserService; import
 * com.ons.itadmin.sessionData.SessionData;
 * 
 * @Component (value = "displayBean")
 * 
 * @ELBeanName (value = "displayBean")
 * 
 * @Scope (value = "request")
 * 
 * public class DisplayBean { private List<User> list;
 * 
 * @Autowired private UserService userService;
 * 
 * @Autowired private SessionData sessionData;
 * 
 * public List<User> display() { list= new ArrayList<User>(); try{
 * list=userService.getAllUsers(); }catch (Exception e) { System.out.println(e);
 * } return list; }
 * 
 * public List<User> getList() { return list; }
 * 
 * public void setList(List<User> list) { this.list = list; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */
