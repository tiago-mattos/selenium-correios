package com.selenium.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.pages.PaginaCalculoPrecoPrazo;
import com.pages.PaginaRastreamento;
import com.utils.Utility;

@SpringBootTest
public class FuncionalTests {

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
	@DisplayName("Cenário 1: Rastreamento por objeto postado")
	@Disabled
	void rastreamentoObjetoValido() {
		paginaRastreamento = new PaginaRastreamento(driver);
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("JY183171564BR");
		paginaRastreamento.clicarBuscar();

		assertEquals("Entregue\n" + "20/02/2020", paginaRastreamento.getDataEntrega());
	}

	@Test
	@DisplayName("Cenário 2: Rastreamento por objeto inválido")
	@Disabled
	void rastreamentoObjetoInvalido() {
		paginaRastreamento = new PaginaRastreamento(driver);
		paginaRastreamento.abrirPaginaInicial();
		paginaRastreamento.verificarCarregamentoPagina();
		paginaRastreamento.informarObjeto("AA123456789BR");
		paginaRastreamento.clicarBuscar();

		assertEquals("Aguardando postagem pelo remetente.", paginaRastreamento.getMensagemAlert());
		Utility.getScreenshot(driver);
	}

	@Test
	@DisplayName("Cenário 3:  Cálculo de preço e prazo de entrega com dados válidos")
	@Disabled
	void calculoPrecoPrazoDadosValidos() {
		paginaCalculoPrecoPrazo = new PaginaCalculoPrecoPrazo(driver);
		paginaCalculoPrecoPrazo.abrirPaginaInicial();
		paginaCalculoPrecoPrazo.verificarCarregamentoPagina();
		paginaCalculoPrecoPrazo.setDataPostagem();
		paginaCalculoPrecoPrazo.setCepOrigem("34006-056");
		paginaCalculoPrecoPrazo.setCepDestino("04711-130");
		paginaCalculoPrecoPrazo.selectOptionServico("SEDEX");
		paginaCalculoPrecoPrazo.setEmbalagemCaixa();
		paginaCalculoPrecoPrazo.selectOptionEmbalagem("Outra Embalagem");
		paginaCalculoPrecoPrazo.setDimensoes(9, 18, 27);
		paginaCalculoPrecoPrazo.selectOptionPesoEstimado(2);
		paginaCalculoPrecoPrazo.setServicoOpcional();
		paginaCalculoPrecoPrazo.clicarCalcular();
		paginaCalculoPrecoPrazo.navigateNewTab();

		assertAll("Prazo/Preço",
				() -> assertEquals("Dia da Postagem + 7 dias úteis", paginaCalculoPrecoPrazo.getPrazoEntrega()),
				() -> assertEquals("R$ 53,30", paginaCalculoPrecoPrazo.getValorEntrega()));

	}

	@Test
	@DisplayName("Cenário 4:  Cálculo de preço e prazo de entrega com Cep de origem inválido")
	void calculoPrecoPrazoDadosInvalidos() {
		paginaCalculoPrecoPrazo = new PaginaCalculoPrecoPrazo(driver);
		paginaCalculoPrecoPrazo.abrirPaginaInicial();
		paginaCalculoPrecoPrazo.verificarCarregamentoPagina();
		paginaCalculoPrecoPrazo.setDataPostagem();
		paginaCalculoPrecoPrazo.setCepOrigem("10101010");
		paginaCalculoPrecoPrazo.setCepDestino("04711-130");
		paginaCalculoPrecoPrazo.selectOptionServico("SEDEX");
		paginaCalculoPrecoPrazo.setEmbalagemCaixa();
		paginaCalculoPrecoPrazo.selectOptionEmbalagem("Outra Embalagem");
		paginaCalculoPrecoPrazo.setDimensoes(9, 18, 27);
		paginaCalculoPrecoPrazo.selectOptionPesoEstimado(2);
		paginaCalculoPrecoPrazo.setServicoOpcional();
		paginaCalculoPrecoPrazo.clicarCalcular();
		paginaCalculoPrecoPrazo.navigateNewTab();

		System.out.println(paginaCalculoPrecoPrazo.getTextoAlert());
		
		paginaCalculoPrecoPrazo.fechaAlert();

	}

	@AfterEach
	void setAfter() {
		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
