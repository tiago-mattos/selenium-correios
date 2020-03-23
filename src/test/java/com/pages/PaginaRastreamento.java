package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaRastreamento {
	WebDriver driver;

	private String urlPagina = "https://www2.correios.com.br/sistemas/rastreamento/default.cfm";

	@FindBy(id = "objetos")
	private WebElement textareaObjeto;

	@FindBy(id = "btnPesq")
	private WebElement btnBuscar;

	@FindBy(css = "div.info.alert")
	private WebElement alertInfo;

	@FindBy(css = "div.info.error")
	private WebElement alertError;

	@FindBy(id = "btnClose")
	private WebElement btnCloseAlert;

	@FindBy(id = "DataEntrega")
	private WebElement dataEntrega;

	public PaginaRastreamento(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void abrirPaginaInicial() {
		driver.get(urlPagina);
	}

	public boolean verificarCarregamentoPagina() {
		return btnBuscar.isEnabled();

	}

	public void informarObjeto(String objeto) {
		textareaObjeto.sendKeys(objeto);

	}

	public void clicarBuscar() {
		btnBuscar.click();

	}

	public String getDataEntrega() {
		return dataEntrega.getText();

	}

	public String getMensagemAlert() {
		return alertInfo.getText();
	}
}
