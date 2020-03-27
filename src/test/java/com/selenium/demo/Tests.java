package com.selenium.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.PaginaCalculoPrecoPrazo;
import com.pages.PaginaRastreamento;
import com.utils.Utility;

public class Tests {
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

	}

	@Test
	@Order(2)
	@DisplayName("Cenário 2: Rastreamento por objeto inválido(falha)")
	void rastreamentoObjetoFalha() {
		paginaRastreamento = new PaginaRastreamento(driver);
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("AA123456789BR");
		paginaRastreamento.clicarBuscar();

		// Utility.getScreenshotDate(driver, "Cenário_2");

		try {
			assertEquals("Aguardando postagem pelo remetente.", paginaRastreamento.getMensagemAlert(), "Teste");
			System.out.println("Sucesso");
		} catch (AssertionError e) {
			fail("Falhou" + e.getMessage());
		}

	}

	@Test
	@Order(2)
	@DisplayName("Cenário 2: Rastreamento por objeto inválido(sucesso)")
	void rastreamentoObjetoSuceso() {
		paginaRastreamento = new PaginaRastreamento(driver);
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("AA123456789BR");
		paginaRastreamento.clicarBuscar();

		// Utility.getScreenshotDate(driver, "Cenário_2");

		try {
			assertEquals("Aguardando postagem pelo remetente.", paginaRastreamento.getMensagemAlert(), "Teste");
			System.out.println("Sucesso");
		} catch (AssertionError e) {
			System.out.println("Erro; " + e.getMessage());
		}

	}

	@AfterEach
	void setAfter() {
		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
