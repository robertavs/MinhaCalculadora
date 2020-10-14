package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView expressao;
    private TextView resultado;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        expressao = findViewById(R.id.expressao);
        resultado = findViewById(R.id.resultado);
    }

    public void onClickBotao1(View v) {
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBotao2(View v) {
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBotao3(View v) {
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBotao4(View v) {
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBotao5(View v) {
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBotao6(View v) {
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBotao7(View v) {
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBotao8(View v) {
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBotao9(View v) {
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }

    public void onClickBotao0(View v) {
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClickBotaoLimpar(View v) {
        cleanFields();
    }

    public void onClickBotaoDivisao(View v) {
        if (!primeiroNumero.isEmpty()) {
            operacao = "/";
            atualizarDisplay("/");
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickBotaoMultiplicacao(View v) {
        if (!primeiroNumero.isEmpty()) {
            operacao = "x";
            atualizarDisplay("x");
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickBotaoSubtracao(View v) {
        if (!primeiroNumero.isEmpty()) {
            operacao = "-";
            atualizarDisplay("-");
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickBotaoPonto(View v) {
        atualizarNumeroDigitado(".");
        atualizarDisplay(".");
    }

    public void onClickBotaoBackSpace(View v) {
        atualizarNumeroDigitado("");
        atualizarDisplay("");
    }

    public void onClickAdicao(View v) {
        if (!primeiroNumero.isEmpty()) {
            operacao = "+";
            atualizarDisplay("+");
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickIgual(View v) {
        int total = 0;
        int numero1 = primeiroNumero.isEmpty() ? 0 : Integer.parseInt(primeiroNumero);
        int numero2 = segundoNumero.isEmpty() ? 0 : Integer.parseInt(segundoNumero);

        switch (operacao) {
            case "+":
                total = numero1 + numero2;
                resultado.setText(String.valueOf(total));
                this.primeiroNumero = String.valueOf(total);
                break;
            case "-":
                total = numero1 - numero2;
                resultado.setText(String.valueOf(total));
                this.primeiroNumero = String.valueOf(total);
                break;
            case "x":
                total = numero1 * numero2;
                resultado.setText(String.valueOf(total));
                this.primeiroNumero = String.valueOf(total);
                break;
            case "/":
                if (numero1 != 0 && numero2 != 0) {
                    total = numero1 / numero2;
                    resultado.setText(String.valueOf(total));
                    this.primeiroNumero = String.valueOf(total);
                } else {
                    Toast.makeText(MainActivity.this, "Divisão por 0 não suportada", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_LONG).show();
                break;


        }
    }

    private void atualizarDisplay(String texto) {
        String textoDisplay = expressao.getText().toString();
        textoDisplay = textoDisplay + texto;
        expressao.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero) {
        if (operacao.isEmpty()) {
            primeiroNumero = numero;
        } else {
            segundoNumero = numero;
        }
    }

    private void cleanFields() {
        primeiroNumero = "";
        segundoNumero = "";
        operacao = "";
        expressao.setText("");
        resultado.setText("");
    }
}
