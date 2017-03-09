import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;


    @ManagedBean(name="companyManager")
    @SessionScoped
    public class CitiesManager {

        ArrayList<Cities> list;
        private int idCity;
        private String nameOfCity;

        private Cities city;

        @EJB
        private CitiesDAO cityDAO;


        public CitiesManager() {
        }
        @PostConstruct
        public void init() {
            city = new Cities();
        }

        public void add()
        {
            cityDAO.addCity(city);
        }

        public void update(Cities city)
        {
        	cityDAO.updateCompany(city);
        }

        public CitiesManagerEdit getCompanyEdit()
        {
        	CitiesManagerEdit citiesManagerEdit = new CitiesManagerEdit();
            citiesManagerEdit.setCity(cityDAO.find(idCity));
            citiesManagerEdit.setCityDAO(cityDAO);
            return citiesManagerEdit;
        }

        public void delete()
        {
            cityDAO.deleteCityById(city.getCity_id());
        }

        public Cities getCityById() {
        	Cities city1 = cityDAO.searchCityById(idCity);
            return city1;
        }
        public String getCityPage(int id){
            this.idCity=id;
            return "pageCity?faces-redirect=true";
        }
        public String getCompanyContentPage(int id){
            this.idCity=id;
            return "pageCityContent?faces-redirect=true";
        }

        public Cities getCityBYId(){
            EntityManager em = PersistenceManager.getEntityManager();
            return em.find(Cities.class, idCity);
        }

        public ArrayList<Cities> getAllCities() {
            list = cityDAO.searchAllCities();
            return list;
        }

        public Cities getCitiesBYName() {
        	Cities city;
            city = cityDAO.searchCityByName(nameOfCity);
            return city;
        }
        public String redirectToResultSearchCityById(){
            return "resultSearchCityById?faces-redirect=true";
        }

        public void setList(ArrayList<Cities> list) {
            this.list = list;
        }


        public ArrayList<Cities> getList() {
            return list;
        }

        public Cities getCity() {
            return city;
        }

        public void setCompany(Cities city) {
            this.city = city;
        }

        public CitiesDAO getCityDAO() {
            return cityDAO;
        }

        public void setCityDAO(CitiesDAO cityDAO) {
            this.cityDAO = cityDAO;
        }


        public int getIdCity() {
            return idCity;
        }

        public void setIdCity(int idCity) {
            this.idCity = idCity;
        }

        public String getNameOfCity() {
            return nameOfCity;
        }

        public void setNameOfCity(String nameOfCity) {
            this.nameOfCity = nameOfCity;
        }
    }







