package com.selenium.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.PaginaCalculoPrecoPrazo;
import com.pages.PaginaRastreamento;

public class Tests {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	PaginaRastreamento paginaRastreamento;
	PaginaCalculoPrecoPrazo paginaCalculoPrecoPrazo;

	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver.exe";

	WebDriver driver;

	@BeforeEach
	void setBefore() {

		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/* Relatório Teste */

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Rajkumar SM");
		htmlReporter.config().setDocumentTitle("Extent reports");
		// Name of the report
		htmlReporter.config().setReportName("Relatório");

	}

	@RepeatedTest(value = 3)
	@DisplayName("Rastreamento por objeto inválido")
	void rastreamentoObjetoFalha() {
		paginaRastreamento = new PaginaRastreamento(driver);
		logger = extent.createTest("Rastreamento por objeto inválido");
		logger.info("Teste Inicializado");
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("AA123456789BR");
		paginaRastreamento.clicarBuscar();

		try {
			assertEquals("Aguardando postagem pelo remetente", paginaRastreamento.getMensagemAlert(), "Falha:");
			logger.pass("Passou");
		} catch (AssertionError e) {
			logger.fail("Teste" + e.getMessage());
			System.out.println(e.getMessage());
		}

	}

	@RepeatedTest(value = 3)
	@DisplayName("Rastreamento por objeto inválido")
	void rastreamentoObjetoScuess() {
		paginaRastreamento = new PaginaRastreamento(driver);
		logger = extent.createTest("Rastreamento por objeto inválido - OK");
		logger.info("Teste Inicializado");
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("AA123456789BR");
		paginaRastreamento.clicarBuscar();

		try {
			assertEquals("Aguardando postagem pelo remetente.", paginaRastreamento.getMensagemAlert(), "Falha:");
			logger.pass("Passou");
		} catch (AssertionError e) {
			logger.fail(e.getMessage());
		}

	}

	@AfterEach
	void setAfter() {
		logger.info("Teste Finalizado");
		extent.flush();
		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
