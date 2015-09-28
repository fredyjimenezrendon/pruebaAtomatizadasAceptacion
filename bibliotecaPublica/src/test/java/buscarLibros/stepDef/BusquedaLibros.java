package buscarLibros.stepDef;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Libro;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Format;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusquedaLibros {
	
	static WebDriver driver;
	List<Libro> listaLibrosRetornados;
	
	public void setDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new HtmlUnitDriver();
		
	}
	
	@Before
	public void setUp(){
		setDriver();
	}
	
	@Given("^El usuario busca libros publicados entre (\\d+) y (\\d+)$")
	public void buscarLibrosPorFechaPublicacion(@Format("yyyy") final Date fechaDesde, @Format("yyyy") final Date fechaHasta) {
		
		driver.navigate().to("http://localhost:7777/bibliotecaPublica/html/buscadorLibros.html");
		
		Calendar fechaDesdeCalendar = Calendar.getInstance();
		fechaDesdeCalendar.setTime(fechaDesde);
		Calendar fechaHastaCalendar = Calendar.getInstance();
		fechaHastaCalendar.setTime(fechaHasta);
		
		WebElement fechaDesdeElement = driver.findElement(By.id("fechaDesde"));
		fechaDesdeElement.sendKeys(String.valueOf(fechaDesdeCalendar.get(Calendar.YEAR)));
		WebElement fechaHastaElement = driver.findElement(By.id("fechaHasta"));
		fechaHastaElement.sendKeys(String.valueOf(fechaHastaCalendar.get(Calendar.YEAR)));
		
	}

	@When("^El usuario presiona el boton buscar$")
	public void presionarBotonBuscar() {
		
		WebElement botonBuscarElement = driver.findElement(By.id("buscar"));
		botonBuscarElement.click();

	}

	@Then("^Aparecen (\\d+) libros en la lista de resultados$")
	public void retornaLibrosEncontrados(final int librosEncontrados) {
		
		WebElement resultados = driver.findElement(By.id("resultado"));
		List<WebElement> registros = resultados.findElements(By.tagName("tr"));
		
		Assert.assertEquals(librosEncontrados, registros.size());

	}

	@And("^El libro (\\d+) debe tener el titulo '(.+)'$")
	public void libro1(final int posicionLibro, final String nombreLibro) {
		
		WebElement resultados = driver.findElement(By.id("resultado"));
		List<WebElement> registros = resultados.findElements(By.tagName("td"));

		
		Assert.assertEquals(nombreLibro, registros.get(posicionLibro -1 ).getText());

	}

}