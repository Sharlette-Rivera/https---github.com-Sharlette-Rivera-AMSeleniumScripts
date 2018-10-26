package hibernate.dao;

import java.util.List;

import hibernate.model.TicketedRevenue;

public interface TicketedRevenueDao {
	
	void saveTicketedRevenue(TicketedRevenue ticketedRevenue);

	List<TicketedRevenue> findAllTicketedRevenue();

	void deleteAllTicketedRevenue();

	TicketedRevenue findByCarrierCode(String carrierCode);
	
	TicketedRevenue findByCarrierName(String carrierName);
	
	TicketedRevenue findByAgentGroup(String agentGroup);

	TicketedRevenue findByAgent(String agent);

	TicketedRevenue findByTransactionCode(String transactionCode);
	
	TicketedRevenue findByComponent(String component);
	
	TicketedRevenue findByCategory(String category);
	
	TicketedRevenue findByStates(String states);
		
	TicketedRevenue findByCabinName(String cabinName);
	
	TicketedRevenue findByFareBasis(String fareBasis);

	TicketedRevenue findByYear(String year);

	void updateTicketedRevenue(TicketedRevenue ticketedRevenue);
	
}
