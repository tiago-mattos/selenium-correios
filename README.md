
# Excecução

Clonar repositório
```bash
git clone https://github.com/tiago-mattos/selenium-correios.git
```
Executar comando:

```bash
mvn clean install
```

# Entregáveis
#### Cenários BDD
```bash
./src/test/java/com/features
```

#### Scripts Testes Automatizados (Selenium)
```bash
./src/test/java/com/selenium/demo/FuncionalTests.java
```

#### SOAP Testes
```bash
./soap/Calculo-Preco-Prazo-soapui-project.xml
```
# Cenários

```bash
#Funcionalidade: Rastreamento por objeto ou CPF/CNPJ
  Como usuário do sistema
  Eu quero consultar as informações sobre uma entrega do correio
  Para que eu possa acompanhar o andamento da entrega

#Cenario: Rastreamento por objeto postado
    Dado que acesso a página de rastreamento dos Correios
    Quando informo o objeto "JY183171564BR" no campo de entrada de codigos
    E clico no botao Buscar
    Entao deveria visualizar o status "Entregue 20/02/2020"

#Cenario: Rastreamento por objeto inválido
    Dado que acesso a página de rastreamento dos Correios
    Quando informo o objeto "AA123456789BR" no campo de entrada de codigos
    E clico no botao Buscar
    Entao deveria visualizar a mensagem "Aguardando postagem pelo remetente."

#Cenario: Rastreamento por objeto em branco
    Dado que acesso a página de rastreamento dos Correios
    Quando clico no botao Buscar
    Entao deveria visualizar a mensagem "Por favor, digite de um a 50 códigos de objetos, ou um CPF/CNPJ válido"

#Cenario: Rastreamento por número objeto inválido
    Dado que acesso a página de rastreamento dos Correios
    Quando clico no botao Buscar
    Entao deveria visualizar a mensagem "O(s) código(s) ou CPF/CNPJ estão inválidos"




#Funcionalidade: Cálculo de preços e prazos de entrega
  Como usuário do sistema
  Eu quero consultar as informações sobre prazo e custo de uma entrega
  Para que eu possa decidir qual a melhor forma de envio de um produto

#Cenario: Cálculo de preço e prazo de entrega com dados válidos
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "34006-056" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar "Dia da Postagem + 7 dias úteis" no campo Prazo de entrega
    E deveria visualizar "R$ 53,30" no campo Valor total

#Cenario: Cálculo de preço e prazo de entrega com dados válidos
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "34006-056" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar "Dia da Postagem + 7 dias úteis" no campo Prazo de entrega
    E deveria visualizar "R$ 53,30" no campo Valor total
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "10101010" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar amensagen de alerta "CEP de origem não encontrado na base de dados dos Correios (-1)."

```

