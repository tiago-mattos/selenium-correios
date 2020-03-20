package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utils.Utility;

public class PaginaCalculoPrecoPrazo {

	WebDriver driver;

	private String urlPagina = "https://www2.correios.com.br/sistemas/precosPrazos";

	@FindBy(css = "input[id='data']")
	private WebElement dataPostagem;

	@FindBy(css = "input[name='cepOrigem']")
	private WebElement cepOrigem;

	@FindBy(css = "input[name='cepDestino']")
	private WebElement cepDestino;

	@FindBy(css = "select[name='servico']")
	private WebElement tipoServico;

	@FindBy(css = "img[class*='caixa']")
	private WebElement formatoCaixa;

	@FindBy(css = "select[name='embalagem1']")
	private WebElement tipoEmbalagem;

	@FindBy(css = "input[name='Altura']")
	private WebElement alturaEstimada;

	@FindBy(css = "input[name='Largura']")
	private WebElement larguraEstimada;

	@FindBy(css = "input[name='Comprimento']")
	private WebElement comprimentoEstimado;

	@FindBy(css = "span[id='spanMaoPropria'] > label")
	private WebElement entregueMaosPropria;

	@FindBy(css = "select[name='peso']")
	private WebElement pesoEstimado;

	@FindBy(css = "input[name='Calcular']")
	private WebElement btnClacular;

	@FindBy(css = "div[class*='ctrlcontent'] > table > tbody > tr:nth-of-type(2) > td")
	private WebElement prazoEntrega;

	@FindBy(css = "div[class*='ctrlcontent'] > table > tfoot > tr > td")
	private WebElement valorEntrega;

	public PaginaCalculoPrecoPrazo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void abrirPaginaInicial() {
		driver.get(urlPagina);
	}

	public boolean verificarCarregamentoPagina() {
		return btnClacular.isEnabled();

	}

	public void setDataPostagem() {
		dataPostagem.clear();
		dataPostagem.sendKeys(Utility.getDataAtual());

	}

	public void setDataPostagem(String data) {
		dataPostagem.clear();
		dataPostagem.sendKeys(data);

	}

	public void setCepOrigem(String cepO) {
		cepOrigem.sendKeys(cepO);
	}

	public void setCepDestino(String cepD) {
		cepDestino.sendKeys(cepD);
	}

	public void selectOptionServico(String servico) {
		Select select = new Select(tipoServico);
		select.selectByVisibleText(servico);
	}

	public void setEmbalagemCaixa() {
		formatoCaixa.click();
	}

	public void selectOptionEmbalagem(String embalagem) {
		Select select = new Select(tipoEmbalagem);
		select.selectByVisibleText(embalagem);

	}

	public void setDimensoes(int altura, int largura, int comprimento) {
		alturaEstimada.sendKeys(String.valueOf(altura));
		larguraEstimada.sendKeys(String.valueOf(largura));
		comprimentoEstimado.sendKeys(String.valueOf(comprimento));

	}

	public void selectOptionPesoEstimado(int peso) {
		Select select = new Select(pesoEstimado);
		select.selectByVisibleText(String.valueOf(peso));

	}

	public void setServicoOpcional() {
		entregueMaosPropria.click();
	}

	public void clicarCalcular() {
		btnClacular.submit();
		;
	}

	public void navigateNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		if (tabs.size() > 1) {
			driver.switchTo().window(tabs.get(1));
		}

		driver.switchTo().window(tabs.get(0));
	}

	public String getPrazoEntrega() {
		return prazoEntrega.getText().trim();
	}

	public String getValorEntrega() {
		return valorEntrega.getText().trim();
	}

	public String getTextoAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();

	}

	public void fechaAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
}
