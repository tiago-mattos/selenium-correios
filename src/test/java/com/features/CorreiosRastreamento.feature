# language: pt
Funcionalidade: Rastreamento por objeto ou CPF/CNPJ
  Como usuário do sistema
  Eu quero consultar as informações sobre uma entrega do correio
  Para que eu possa acompanhar o andamento da entrega

  Cenario: Rastreamento por objeto postado
    Dado que acesso a página de rastreamento dos Correios
    Quando informo o objeto "JY183171564BR" no campo de entrada de codigos
    E clico no botao Buscar
    Entao deveria visualizar o status "Entregue 20/02/2020"

  Cenario: Rastreamento por objeto inválido
    Dado que acesso a página de rastreamento dos Correios
    Quando informo o objeto "AA123456789BR" no campo de entrada de codigos
    E clico no botao Buscar
    Entao deveria visualizar a mensagem "Aguardando postagem pelo remetente."

  Cenario: Rastreamento por objeto em branco
    Dado que acesso a página de rastreamento dos Correios
    Quando clico no botao Buscar
    Entao deveria visualizar a mensagem "Por favor, digite de um a 50 códigos de objetos, ou um CPF/CNPJ válido"

  Cenario: Rastreamento por número objeto inválido
    Dado que acesso a página de rastreamento dos Correios
    Quando clico no botao Buscar
    Entao deveria visualizar a mensagem "O(s) código(s) ou CPF/CNPJ estão inválidos"