import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;


@ManagedBean(name="citiesManagerEdit")
@SessionScoped
public class CitiesManagerEdit {

    ArrayList<Cities> list;
    private int idCity;

    private Cities city;

    @EJB
    private CitiesDAO cityDAO;

    public CitiesManagerEdit() {
    }
    @PostConstruct
    public void init() {
        city = new Cities();
    }

    public void update()
    {
        cityDAO.updateCompany(city);
    }


    public Cities getCityById() {
    	Cities city1 = cityDAO.searchCityById(idCity);
        return city1;
    }


    public ArrayList<Cities> getAllCities() {
        list = cityDAO.searchAllCities();
        return list;
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

    public void setCity(Cities city) {
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

}















