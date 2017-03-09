import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless
@Local
public class CitiesDAO {

    @PersistenceContext(unitName = "LAB1")
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addCity(Cities city){
            em.persist(city);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateCompany(Cities city){
            em.merge(city);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cities searchCityById(int city_id){
        if(em.find(Cities.class, city_id)!=null) {
            Query query = em.createQuery("SELECT o FROM Cities o WHERE o.city_id=:city_id").setParameter("city_id", city_id);
            Cities city = (Cities) query.getSingleResult();
            return city;
        }
        else return null;
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cities searchCityByName(String name){
    	Cities city = new Cities();
        Query query = em.createQuery("SELECT o FROM Company o WHERE o.name=:name").setParameter("name", name);
        city = (Cities) query.getSingleResult();
        return city;

    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public ArrayList searchCitiesWithCheckboxes(String str){
        Query Query = em.createQuery(str);
        ArrayList<Cities> list = new ArrayList<Cities>();
        list.addAll(Query.getResultList());
        return list;
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public ArrayList searchAllCities(){
        Query Query = em.createQuery("SELECT o from Company o");
        ArrayList<Cities> list = new ArrayList<Cities>();
        list.addAll(Query.getResultList());
        return list;
    }

    public void deleteCityById(int company_id){
        em.remove(find(company_id));
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cities find(int id) {
        return em.find(Cities.class, id);
    }
}
