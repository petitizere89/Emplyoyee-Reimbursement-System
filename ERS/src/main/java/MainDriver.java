import java.util.List;

import com.ers.dao.ReimbursementDao;
import com.ers.dao.ReimbursementDaoDB;
import com.ers.dao.RoleDao;
import com.ers.dao.StatusDao;
import com.ers.dao.TypeDao;
import com.ers.dao.UserDao;
import com.ers.dao.UserDaoDB;
import com.ers.enums.RType;
import com.ers.enums.Status;
import com.ers.enums.UserRole;
import com.ers.models.Reimbursement;
import com.ers.models.ReimbursementStatus;
import com.ers.models.ReimbursementType;
import com.ers.models.User;
import com.ers.models.UserRoles;
import com.ers.services.ReimbursementService;
import com.ers.services.UserService;


public class MainDriver {

	public static void main(String[] args) {
		
		UserDao uDao = new UserDaoDB();
		UserService uServ = new UserService(uDao);
		ReimbursementDao rDao = new ReimbursementDaoDB();
		ReimbursementService rServ = new ReimbursementService(rDao);
		RoleDao urDao = new RoleDao();
		StatusDao sDao = new StatusDao();
		TypeDao tDao = new TypeDao();
		
		UserRoles U_Employee = new UserRoles(0,UserRole.EMPLOYEE);
		urDao.insert(U_Employee);
		UserRoles U_Manager = new UserRoles(1,UserRole.MANAGER);
		urDao.insert(U_Manager);
		
		ReimbursementStatus rs1 = new ReimbursementStatus(0,Status.PENDING);
		sDao.insert(rs1);
		ReimbursementStatus rs2 = new ReimbursementStatus(1,Status.APPROVED);
		sDao.insert(rs2);
		ReimbursementStatus rs3 = new ReimbursementStatus(2,Status.DENIED);
		sDao.insert(rs3);
		
		ReimbursementType t1 = new ReimbursementType(0,RType.LODGING);
		tDao.insert(t1);
		ReimbursementType t2 = new ReimbursementType(1,RType.TRAVEL);
		tDao.insert(t2);
		ReimbursementType t3 = new ReimbursementType(2,RType.FOOD);
		tDao.insert(t3);
		ReimbursementType t4 = new ReimbursementType(3,RType.OTHER);
		tDao.insert(t4);
		
		//User blank = new User("a","a","a","a","a",UserRole.EMPLOYEE);
//		//uDao.createUser(blank);
//		
		User u1= new User("Petit","Izere","petitizere89","pettitizere89@gmail.com","password", U_Manager);
		uDao.createUser(u1);
		
		User u2 = new User("Brielle","Izere","brielleizere21","brielleizere21@mail.com","password",U_Employee);
		uDao.createUser(u2);
		
		User u3 = new User("Gisele","Izere","giselleizere95","iradukunda@gmail.com","password",U_Employee);
		uDao.createUser(u3);
		
		Reimbursement r1 = new Reimbursement(t1,10,"8/9/21","Hotel Hawai",rs1,u2);
		rDao.createReimbursement(r1);
		
		Reimbursement r2 = new Reimbursement(t2,20,"8/9/21","Hawai trip",rs1,u2);
		rDao.createReimbursement(r2);
		
		Reimbursement r3 = new Reimbursement(t3,10,"8/9/21","Hawai eaton on trip",rs1,u2);
		rDao.createReimbursement(r3);
		
		Reimbursement r4 = new Reimbursement(t4,20,"8/9/21","Luai Dance performance",rs1,u2);
		rDao.createReimbursement(r4);
		
		//uDao.updateUser(u2);
//		User u1 = uDao.getUserByUsername("Scionoftruth");
//		User u2 = uDao.getUserByUsername("Tester");
//		
//		ReimbursementStatus rst = sDao.getStatusById(4);
//		
		//Reimbursement r3 = new Reimbursement(t4,15,"8/6/21","Some Stuff",rs1,u3);
		//Reimbursement r3 = rDao.getReimbursementById(5);
		//rDao.updateReimbursement(r3);
		
		//Reimbursement r2 = new Reimbursement(RType.FOOD,20,"Today","Open","Good Food",Status.PENDING,u2);
		//Reimbursement r2 = rDao.getReimbursementById(3);
		//rDao.updateReimbursement(r2);
		
		Reimbursement r = rDao.getReimbursementById(14);
		
		//rDao.updateReimbursementByArgs(r.getId(), r.getType(), r.getAmount(), r.getSubmitteddate(), "8/7/21", r.getDescription(), rst, u2, u1);
	
		//Reimbursement test = rDao.getReimbursementById(4);
		//System.out.println(test);
		
		List<Reimbursement> aList = rDao.getAllReimbursments();
		System.out.println(aList);
		
		//System.out.println(u1);
		List<Reimbursement> auList = rDao.getAllPendingReimbursmentsForUser(u2);
		System.out.println(auList);
		
	}

}
