# language: pt
Funcionalidade: Rastreamento por objeto ou CPF/CNPJ
  Como usuário do sistema, 
  Eu quero consultar as informações sobre uma entrega do correio
  Para que eu possa acompanhar o andamento da entrega

  Cenario: Rastreamento por objeto postado
    Dado que acesso o site dos Correios
    Quando clico no link "Busca CEP"
    Entao deveria visualizar "CEP por localidade | Logradouro"
    Quando clico no link "CEP por localidade | Logradouro"
    Entao deveria visualizar "Busca CEP - Localidade / Logradouro"
    Quando seleciono "CE" no campo UF
    E digito "Fortaleza" no campo Localidade
    E seleciono "Rua" no campo Tipo
    E digito "Senador Pompeu" no campo Logradouro
    E digito "2508" no campo Numero
    E clico no botao Buscar
    Entao deveria visualizar "Condomínio Liege"
