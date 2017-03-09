import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;


@ManagedBean(name="citiesManagerEdit")
@SessionScoped
public class CitiesManagerEdit {

    ArrayList<Cities> list;
    private String[] branches;
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

    public String getCompanyContentPage(int id){
        this.idCity=id;
        return "pageCompanyContent?faces-redirect=true";
    }

    public ArrayList<Cities> getCompaniesBYBranch() {
        String sqlStr = "SELECT o FROM com.vinterle.servlet.Company o WHERE o.branch IN (";
        sqlStr += "'" + branches[0] + "'";
        for (int i = 1; i < branches.length; ++i) {
            sqlStr += ", '" + branches[i] + "'";
        }
        sqlStr += ")";
        list = cityDAO.searchCitiesWithCheckboxes(sqlStr);

        return list;
    }
    public ArrayList<Cities> getAllCompanies() {
        list = cityDAO.searchAllCities();
        return list;
    }


    public String redirectToResultSearchCityById(){
        return "resultSearchCitById?faces-redirect=true";
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








