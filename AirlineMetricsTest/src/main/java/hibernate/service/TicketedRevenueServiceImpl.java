package hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernate.dao.TicketedRevenueDao;
import hibernate.model.TicketedRevenue;

@Service("ticketedRevenueService")
@Transactional
public class TicketedRevenueServiceImpl implements TicketedRevenueService{

	@Autowired
	private TicketedRevenueDao dao;
	
	public void saveTicketedRevenue(TicketedRevenue ticketedRevenue) {
		dao.saveTicketedRevenue(ticketedRevenue);
	}

	public List<TicketedRevenue> findAllTicketedRevenue() {
		return dao.findAllTicketedRevenue();
	}

	
	public void deleteAllTicketedRevenue() {
		dao.deleteAllTicketedRevenue();
	}
	
	public TicketedRevenue findByCarrierCode(String carrierCode) {
		return dao.findByCarrierCode(carrierCode);
	}
	
	public TicketedRevenue findByCarrierName(String carrierName) {
		return dao.findByCarrierCode(carrierName);
	}
	
	public TicketedRevenue findByAgentGroup(String agentGroup) {
		return dao.findByAgentGroup(agentGroup);
	}
	
	public TicketedRevenue findByAgent(String agent) {
		return dao.findByAgent(agent);
	}

	
	public TicketedRevenue findByTransactionCode(String transactionCode) {
		return dao.findByTransactionCode(transactionCode);
	}
	
	public TicketedRevenue findByComponent(String component) {
		return dao.findByComponent(component);
	}
	
	public TicketedRevenue findByCategory(String category) {
		return dao.findByCategory(category);
	}
	
	public TicketedRevenue findByStates(String states) {
		return dao.findByStates(states);
	}
		
	public TicketedRevenue findByCabinName(String cabinName) {
		return dao.findByCabinName(cabinName);
	}
	
	public TicketedRevenue findByFareBasis(String fareBasis) {
		return dao.findByFareBasis(fareBasis);
	}

	public TicketedRevenue findByYear(String year) {
		return dao.findByYear(year);
	}
	
	public void updateTicketedRevenue(TicketedRevenue ticketedRevenue){
		dao.updateTicketedRevenue(ticketedRevenue);
	}





	
}
