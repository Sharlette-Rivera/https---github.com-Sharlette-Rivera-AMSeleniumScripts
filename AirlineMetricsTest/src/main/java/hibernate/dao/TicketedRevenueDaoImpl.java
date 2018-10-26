package hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import hibernate.model.TicketedRevenue;

@Repository("ticketedRevenueDao")
public class TicketedRevenueDaoImpl extends AbstractDao implements TicketedRevenueDao{

	private static final Logger logger = LoggerFactory.getLogger(TicketedRevenueDaoImpl.class);
	
	public void saveTicketedRevenue(TicketedRevenue ticketedRevenue) {
		persist(ticketedRevenue);
	}

	@SuppressWarnings("unchecked")
	public List<TicketedRevenue> findAllTicketedRevenue() {
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		return (List<TicketedRevenue>) criteria.list();
	}

	public void deleteAllTicketedRevenue() {
		Query query = getSession().createSQLQuery("truncate table from TicketedRevenue");
		query.executeUpdate();
	}
	
	public TicketedRevenue findByCarrierCode(String carrierCode){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("carrierCode",carrierCode));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByCarrierName(String carrierName){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("carrierName",carrierName));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByAgentGroup(String agentGroup){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("agentGroup",agentGroup));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByAgent(String agent){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("agent",agent));
		return (TicketedRevenue) criteria.uniqueResult();
	}

	public TicketedRevenue findByTransactionCode(String transactionCode){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("transactionCode",transactionCode));
		return (TicketedRevenue) criteria.uniqueResult();
	}

	public TicketedRevenue findByComponent(String component){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("component",component));
		return (TicketedRevenue) criteria.uniqueResult();
	}

	public TicketedRevenue findByCategory(String category){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("category",category));
		return (TicketedRevenue) criteria.uniqueResult();
	}

	public TicketedRevenue findByStates(String states){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("states",states));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByCabinName(String cabinName){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("cabinName",cabinName));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByFareBasis(String fareBasis){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("fareBasis",fareBasis));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public TicketedRevenue findByYear(String year){
		Criteria criteria = getSession().createCriteria(TicketedRevenue.class);
		criteria.add(Restrictions.eq("year",year));
		return (TicketedRevenue) criteria.uniqueResult();
	}
	
	public void updateTicketedRevenue(TicketedRevenue ticketedRevenue){
		getSession().update(ticketedRevenue);
	}
	
}
