package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumberTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import runner.RunCucumberTest;

public class CadastroUsuarioPage extends RunCucumberTest {


    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoFazerCadastro= By.id("btnRegister");


    public void preencheNome(String email){
         getDriver().findElement(campoNome).sendKeys(email);
    }
    public void preencheEmail(String email){
         getDriver().findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha){
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public void cadastrarUsuario() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(botaoFazerCadastro));

        ((JavascriptExecutor)getDriver())
                .executeScript("arguments[0].scrollIntoView(true);",
                        getDriver().findElement(botaoFazerCadastro));

        wait.until(ExpectedConditions.elementToBeClickable(botaoFazerCadastro)).click();
    }



    public void verificaCadastroSucesso(){
        String textoLoginSucesso = getDriver().findElement(By.id("swal2-title")).getText();
        Assert.assertEquals("Os textos não são iguais!", "Cadastro realizado!", textoLoginSucesso);
    }
}
